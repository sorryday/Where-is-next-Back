package com.win.back.controller;

import com.win.back.domain.SocialUser;
import com.win.back.domain.LoginUser;
import com.win.back.dto.SignUpDTO;
import com.win.back.entity.User;
import com.win.back.enumpack.UserEnum;
import com.win.back.repository.UserRepository;
import com.win.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("user_login")
    @ResponseBody
    public boolean UserLoginResponse(@RequestBody Object object) {

        Map<String, String> map = (Map<String, String>) object;
        System.out.println(object.toString());

        User user = new User();
        user.setId(map.get("id"));
        user.setPw(map.get("pw"));
        user.setEmail(map.get("email"));
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
        signUpDTO.setEmail(userMap.get("email"));
        signUpDTO.setNickname(userMap.get("nickname"));
        signUpDTO.setPw(userMap.get("pw"));

        return userService.userSave(signUpDTO);
    }
}