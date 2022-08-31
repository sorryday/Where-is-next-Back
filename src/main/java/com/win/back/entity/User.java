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
    @Column(nullable = false)
    private String phoneNum;
    @Column(nullable = false)
    private String nickname;
    @Column(nullable = false)
    private String userEnum;
}