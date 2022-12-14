package com.win.back.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {
    @Id
    private String id;

    @Column
    private String pw;

    @Column
    private String phoneNum;

    @Column
    private String nickname;

    @Column
    private String userEnum;
}