package com.win.back.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class PostDTO {
    String id;
    String nickname;
    String date;
    String title;
    String contents;
    ArrayList<String> images;

    @Override
    public String toString() {
        return "PostAddDTO{" +
                "id='" + id + '\'' +
                ", nickname='" + nickname + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
