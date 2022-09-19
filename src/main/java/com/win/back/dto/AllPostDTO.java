package com.win.back.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
public class AllPostDTO implements Serializable {
    Long number;
    String id;
    String nickname;
    String date;
    String title;
    String contents;
    ArrayList<byte[]> allImages;

    @Override
    public String toString() {
        return "AllPostDTO{" +
                "number=" + number +
                ", id='" + id + '\'' +
                ", nickname='" + nickname + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", allImages=" + allImages +
                '}';
    }
}