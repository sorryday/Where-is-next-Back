package com.win.back.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long number;

    @Column
    String brand;

    @Column
    String type;

    @Column
    String name;

    @Column
    String price;
}

// 포인트몰 상품 insert문
//insert into goods values(null, "파파존스", "2만원 할인권(교환권)", "20,000", "외식"),
//    (null, "미스터피자", "미스터트리오L", "36,000", "외식"),
//            (null, "빕스", "기프트카드 5만원권", "50,000", "외식"),
//            (null, "올리브영", "기프트카드 3만원권", "30,000", "뷰티/생활"),
//            (null, "몽블랑", "몽블랑 레전드 EDT 30ML", "29,500", "뷰티/생활"),
//            (null, "키엘", "키엘 핸드크림 자몽 30ml", "15,000", "뷰티/생활"),
//            (null, "스타벅스", "아이스 카페 아메리카노 T", "4,500", "카페"),
//            (null, "투섬플레이스", "스트로베리 초콜릿 생크림", "6,700", "카페"),
//            (null, "탐앤탐스", "바닐라라떼 T", "5,400", "카페");
