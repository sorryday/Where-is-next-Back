package com.win.back.domain;

import com.win.back.enumpack.UserEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUser {
    private String email;
    private String pw;
    private UserEnum userEnum;

    public LoginUser(String email, String pw, UserEnum userEnum) {
        this.email = email;
        this.pw = pw;
        this.userEnum = userEnum;
    }
}
