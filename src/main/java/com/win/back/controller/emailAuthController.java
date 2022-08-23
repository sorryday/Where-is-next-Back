package com.win.back.controller;

import com.win.back.emailAuth.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class emailAuthController {

    @Autowired
    EmailService service;

    @PostMapping("email_service/sign_up_mail_send")
    @ResponseBody
    public String emailSendSignUp(@RequestBody String userId) throws Exception {
        return  "\"" + service.sendSignUpMessage(userId) + "\"";
    }

    @PostMapping("email_service/search_auth_mail_send")
    @ResponseBody
    public String emailSendSearch(@RequestBody String userId) throws Exception {
        return  "\"" + service.sendSearchMessage(userId) + "\"";
    }

    @PostMapping("email_service/mail_confirm")
    @ResponseBody
    public Boolean emailConfirm(@RequestBody String input_code) throws Exception{
        input_code = input_code.replaceAll("\"", "");

        if (service.getCode().equals(input_code)) {
            return true;
        }
        else {
            return false;
        }
    }
}