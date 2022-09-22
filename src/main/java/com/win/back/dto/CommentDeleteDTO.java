package com.win.back.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDeleteDTO {
    Long number;
    String id;

    @Override
    public String toString() {
        return "CommentDeleteDTO{" +
                "number=" + number +
                ", id='" + id + '\'' +
                '}';
    }
}
