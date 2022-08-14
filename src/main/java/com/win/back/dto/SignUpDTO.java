package com.win.back.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpDTO {
    private String id;
    private String email;
    private String nickname;
    private String pw;

    @Override
    public String toString() {
        return "SignUpDTO{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }
}
