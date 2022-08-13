package com.win.back.controller;

import com.win.back.domain.SocialUser;
import com.win.back.domain.LoginUser;
import com.win.back.entity.User;
import com.win.back.enumpack.UserEnum;
import com.win.back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("user_login")
    @ResponseBody
    public boolean UserLoginResponse(@RequestBody Object object) {

        Map<String, String> map = (Map<String, String>) object;
        System.out.println(object.toString());

        if (map.get("userEnum").equals(UserEnum.LoginUser.toString())) {         // 일반 로그인 유저
            LoginUser loginUser = new LoginUser(map.get("email"), map.get("pw"),UserEnum.LoginUser);
            System.out.println("일반 로그인 유저 로그인 성공");

            return true;
        }

        // 소셜 로그인일 때
        else if (map.get("userEnum").equals(UserEnum.GoogleUser.toString()) || map.get("userEnum").equals(UserEnum.KaKaoUser.toString())) {
            User user = new User();
            user.setId(map.get("id"));
            user.setPw(map.get("pw"));
            user.setEmail(map.get("email"));
            user.setNickname(map.get("nickname"));
            user.setUserEnum(map.get("userEnum"));

            if (userRepository.findById(user.getId()).isEmpty()) {
                userRepository.save(user);
                System.out.println("유저 등록");
            }
//            else {
//                System.out.println("이미 등록된 유저");
//            }
            return true;
        }
        else {
            return false;
        }
    }

    @PostMapping("user_sign_up")
    @ResponseBody
    public boolean UserSignUpResponse(@RequestBody Object object) {

        Map<String, String> userMap = (Map<String, String>) object;

        User user = new User();
        user.setId(userMap.get("id"));
        user.setPw(userMap.get("pw"));
        user.setEmail(userMap.get("email"));
        user.setNickname(userMap.get("nickname"));
        user.setUserEnum(UserEnum.LoginUser.toString());

        // 아이디 중복검사
        if (userRepository.findById(user.getId()).isEmpty()) {
            userRepository.save(user);
            System.out.println("유저 등록");

            return true;
        }

        else {
            return false;
        }
    }
}