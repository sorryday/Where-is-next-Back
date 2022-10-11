package com.win.back.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MyGoods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long number;

    @Column
    String id;
    @Column
    String my_goods_name;
    @Column
    String my_goods_brand;
    @Column
    String status;
}