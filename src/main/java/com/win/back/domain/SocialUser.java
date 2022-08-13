package com.win.back.domain;

import com.win.back.enumpack.UserEnum;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SocialUser {

    private String key;  // 소셜 로그인의 id값 ( getId() ), LoginUser의 id
    private String pw;
    private String email;
    private String name; // nickname
    private UserEnum userEnum;

    public SocialUser(String key, String pw, String email, String name, UserEnum userEnum) {
        this.key = key;
        this.pw = pw;
        this.email = email;
        this.name = name;
        this.userEnum = userEnum;
    }

    @Override
    public String toString() {
        return "SocialUser{" +
                "key='" + key + '\'' +
                ", pw='" + pw + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", userEnum=" + userEnum +
                '}';
    }
}
