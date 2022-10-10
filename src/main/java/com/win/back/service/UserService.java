package com.win.back.service;

import com.win.back.dto.SignUpDTO;
import com.win.back.entity.Point;
import com.win.back.entity.User;
import com.win.back.enumpack.UserEnum;
import com.win.back.repository.PointRepository;
import com.win.back.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PointRepository pointRepository;

    public Boolean userLogin(User user) {
        // 소셜 로그인일 때 : 가입이 안되있다면, 로그인 하면서 가입까지 같이 처리
        if (!user.getUserEnum().toString().equals("LoginUser")) {
            if (userRepository.findById(user.getId()).isEmpty()) {
                userRepository.save(user);

                Point point = new Point();
                point.setId(user.getId());
                point.setPoint("0");
                pointRepository.save(point);
            }
            return true;
        }

        //일반 로그인일 떄 :
        else {
            List<User> all = userRepository.findAll();
            for (User userList : all) {
                // 아이디와 비밀번호가 모두 일치할 떄.
                if (userList.getId().equals(user.getId()) && userList.getPw().equals(user.getPw())) {
                    return true;
                }
            }
            return false;
        }
    }

    // 일반유저 회원가입
    public Boolean userSave(SignUpDTO signUpDTO) {
        boolean flag = true;

        // 아이디, 닉네임, 폰번호 중복검사
        // 1.가입되있지 않고 겹치는 닉네임이 없고 겹치는 폰번호 없으면 가입
        List<User> all = userRepository.findAll();
        for (User userList : all) {
            if (userList.getId().equals(signUpDTO.getId()) || userList.getNickname().equals(signUpDTO.getNickname())
                    || userList.getPhoneNum().equals(signUpDTO.getPhone())) {
                flag = false;
            }
        }

        if (flag) {
            User user = new User();
            user.setId(signUpDTO.getId());
            user.setPw(signUpDTO.getPw());
            user.setPhoneNum(signUpDTO.getPhone());
            user.setNickname(signUpDTO.getNickname());
            user.setUserEnum(UserEnum.LoginUser.toString());

            userRepository.save(user);

            Point point = new Point();
            point.setId(user.getId());
            point.setPoint("0");
            pointRepository.save(point);

            return true;
        }
        else {
            return false;
        }
    }

    // 일반유저 아이디 찾기
    public String userSearchId(String phoneNum) {
        List<User> all = userRepository.findAll();
        for (User userList : all) {
            if (userList.getPhoneNum().equals(phoneNum)) {
                return userList.getId();
            }
        }
        return null;
    }

    // 일반유저 비밀번호 찾기 : 유저가 있는지 확인
    public boolean userSearchPw(String id, String phoneNum) {
        List<User> all = userRepository.findAll();
        for (User userList : all) {
            if (userList.getId().equals(id) && userList.getPhoneNum().equals(phoneNum)) {
                return true;
            }
        }
        return false;
    }

    // 일반유저 비밀번호 찾기 : 비밀번호 변경
    public boolean userChangePw(String id, String phoneNum, String pw) {
        List<User> all = userRepository.findAll();
        for (User userList : all) {
            if (userList.getId().equals(id) && userList.getPhoneNum().equals(phoneNum)) {
                if (userList.getPw().equals(pw)) {
                    return false;
                }
                else {
                    userList.setPw(pw);
                    userRepository.save(userList);
                    return true;
                }
            }
        }
        return false;
    }

    // 일반 유저 닉네임 반환
    public String userSearchNickName(String id) {
        List<User> all = userRepository.findAll();
        StringBuffer sb = new StringBuffer();
        for (User userList : all) {
            if (userList.getId().equals(id)) {
                return userList.getNickname();
            }
        }
        return null;
    }

    // 유저의 Enum (로그인한 타입) 반환
    public String userSearchEnum(String id) {
        String result = null;
        List<User> all = userRepository.findAll();
        for (User user : all) {
            if (user.getId().equals(id)) {
                result = user.getUserEnum();
                break;
            }
        }
        return result;
    }

    // 로그인한 유저 객체 반환
    public User userSearchUserObject(String id) {
        List<User> all = userRepository.findAll();
        for (User user : all) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    // 변경하려는 닉네임 중복 체크
    public boolean userConfirmNickName(String nickname) {
        List<User> all = userRepository.findAll();
        for (User user : all) {
            if (user.getNickname().equals(nickname)) {
                return true;
            }
        }

        return false;
    }

    // 유저 정보 업데이트
    public Boolean userUpdate(User changeUser) {
        userRepository.save(changeUser);
        return true;
    }

    // 로그인한 유저의 포인트 반환
    public String userPoint(String id) {
        Optional<Point> byId = pointRepository.findById(id);
        return byId.get().getPoint();
    }
}