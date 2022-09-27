package com.win.back.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
public class PostUpdateDTO implements Serializable {
    String post_number;
    String id;
    String nickname;
    String date;
    String title;
    String contents;
    ArrayList<byte[]> images;

    @Override
    public String toString() {
        return "PostUpdateDTO{" +
                "post_number='" + post_number + '\'' +
                ", id='" + id + '\'' +
                ", nickname='" + nickname + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", images=" + images +
                '}';
    }
}
