package com.win.back.domain;

import com.win.back.enumpack.UserEnum;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SocialUser {

    private String id;  // 소셜 로그인의 id값 ( getId() ), LoginUser의 id
    private String pw;
    private String phone;
    private String nickname; // nickname
    private UserEnum userEnum;

    @Override
    public String toString() {
        return "SocialUser{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + nickname + '\'' +
                ", userEnum=" + userEnum +
                '}';
    }
}
