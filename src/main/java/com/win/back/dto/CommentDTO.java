package com.win.back.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
    String post_number;
    String comment_nickname;
    String comment_contents;

    @Override
    public String toString() {
        return "CommentDTO{" +
                "post_number='" + post_number + '\'' +
                ", comment_nickname='" + comment_nickname + '\'' +
                ", comment_contents='" + comment_contents + '\'' +
                '}';
    }
}
