package com.win.back.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long number;

    @Column
    String number_post;
    @Column
    String nickname;
    @Column
    String contents;
}
