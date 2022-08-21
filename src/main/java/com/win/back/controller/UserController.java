package com.win.back.controller;

import com.win.back.dto.SignUpDTO;
import com.win.back.entity.User;
import com.win.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    // 일반유저 로그인 및 소셜회원 회원가입 및 소셜회원 로그인
    @PostMapping("user_login")
    @ResponseBody
    public boolean UserLoginResponse(@RequestBody Object object) {

        Map<String, String> map = (Map<String, String>) object;
        System.out.println(object.toString());

        User user = new User();
        user.setId(map.get("id"));
        user.setPw(map.get("pw"));
        user.setPhoneNum(map.get("phone"));
        user.setNickname(map.get("nickname"));
        user.setUserEnum(map.get("userEnum"));

        return userService.userLogin(user);
    }

    // 일반 유저 회원가입
    @PostMapping("user_sign_up")
    @ResponseBody
    public Boolean UserSignUpResponse(@RequestBody Object object) {

        Map<String, String> userMap = (Map<String, String>) object;

        SignUpDTO signUpDTO = new SignUpDTO();
        signUpDTO.setId(userMap.get("id"));
        signUpDTO.setPhone(userMap.get("phone"));
        signUpDTO.setNickname(userMap.get("nickname"));
        signUpDTO.setPw(userMap.get("pw"));

        return userService.userSave(signUpDTO);
    }

    // 일반 유저 아이디 찾기
    @GetMapping("user_search_id/{phoneNum}")
    @ResponseBody
    public String GetIdResponse(@PathVariable String phoneNum) {
        phoneNum = phoneNum.replaceAll("\"","");
        String result = userService.userSearchId(phoneNum);

        if (result == null) {
            return null;
        }
        else {
            return "\"" + result + "\"";
        }
    }

    // 일반 유저 비밀번호 변경 : 가입된 회원인지 체크
    @GetMapping("user_search_pw/{id}/{phoneNum}")
    @ResponseBody
    public boolean changePwSearchUserResponse(@PathVariable String id, @PathVariable String phoneNum) {
        phoneNum = phoneNum.replaceAll("\"","");
        id = id.replaceAll("\"","");

        return userService.userSearchPw(id, phoneNum);
    }

    // 일반 유저 비밀번호 변경 : 비밀번호 변경
    @PostMapping("user_change_pw")
    @ResponseBody
    public Boolean changePwResponse(@RequestBody Object object) {

        Map<String, String> userMap = (Map<String, String>) object;

        String id = userMap.get("id").replaceAll("\"","");
        String phoneNum = userMap.get("phoneNum").replaceAll("\"","");
        String pw = userMap.get("pw").replaceAll("\"","");

        System.out.println("id = " + id);
        System.out.println("phoneNum = " + phoneNum);
        System.out.println("pw = " + pw);

        return userService.userChangePw(id, phoneNum, pw);
    }
}