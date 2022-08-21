package com.win.back.domain;

import com.win.back.enumpack.UserEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUser {
    private String id;
    private String pw;
    private String phone;
    private String nickname;
    private UserEnum userEnum;

    @Override
    public String toString() {
        return "LoginUser{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", phone='" + phone + '\'' +
                ", nickname='" + nickname + '\'' +
                ", userEnum=" + userEnum +
                '}';
    }
}
