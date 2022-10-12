package com.win.back.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Heart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long number;

    @Column
    String post_number;

    @Column
    String id;
}