package com.win.back.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeartCheckDTO {
    String post_number;
    String id;

    @Override
    public String toString() {
        return "HeartCheckDTO{" +
                "post_number='" + post_number + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
