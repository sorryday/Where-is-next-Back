package com.win.back.controller;

import com.win.back.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    @PostMapping("usertest")
    @ResponseBody
    public User googleUserResponse(@RequestBody Object object) {
        System.out.println("전달 성공");
        System.out.println(object.toString());

        Map<String, String> map = (Map<String, String>) object;

        return new User(map.get("id"), map.get("pw"));
    }
}