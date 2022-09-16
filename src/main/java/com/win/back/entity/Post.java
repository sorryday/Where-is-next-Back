package com.win.back.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long number;

    @Column
    String id;

    @Column
    String nickname;

    @Column
    String date;

    @Column
    String title;

    @Column
    String contents;
}
