package com.win.back.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoogleUser {
    private String name;
    private String email;

    public GoogleUser(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
