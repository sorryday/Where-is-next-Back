package com.win.back.controller;

import com.win.back.emailAuth.EmailConfig;
import com.win.back.emailAuth.EmailService;
import com.win.back.emailAuth.EmailServiceImpl;
import okhttp3.internal.http2.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
public class emailAuthController {

    @Autowired
    EmailService service;

    @PostMapping("email_service/mail_send")
    @ResponseBody
    public String emailSend(@RequestBody String userId) throws Exception {
        return  "\"" + service.sendSimpleMessage(userId) + "\"";
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