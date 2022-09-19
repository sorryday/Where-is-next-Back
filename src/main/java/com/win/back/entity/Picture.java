package com.win.back.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;
import java.sql.Blob;
import java.sql.Clob;

@Entity
@Getter
@Setter
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long number_picture;

    @Column
    String number;

    @Lob
    @Column
    byte[] picture_bitmap;
}