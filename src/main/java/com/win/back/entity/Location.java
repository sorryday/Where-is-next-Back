package com.win.back.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Location {
    @Id
    String name;
    @Column
    String latitude; // 위도
    @Column
    String longitude; // 경도
    @Column
    String address; // 주소
}

// 관광지 insert문
//insert into location values("경복궁", "37.5759", "126.9768", "서울특별시 종로구 사직로 161");
//insert into location values("청계천", "37.56907444191876", "126.97866576586092", "서울특별시 종로구 청계천로 1");
//insert into location values("덕수궁", "37.56519298871752", "126.97648800193514", "서울특별시 중구 세종대로 99");
//insert into location values("숭례문", "37.55941743594751", "126.97567492549412", "서울특별시 중구 세종대로 40");
//insert into location values("별마당 도서관", "37.51248346199536", "127.05876832232725", "서울특별시 강남구 영동대로 513 스타필드 코엑스몰 B1");
//
//insert into location values("서울N타워", "37.55114594604903", "126.98825045133734", "서울특별시 용산구 남산공원길 105");
//insert into location values("뚝섬유원지", "37.530571468148054", "127.06654927998687", "서울특별시 광진구 능동로 10");
//insert into location values("양재시민의숲", "37.47107344075643", "127.03549645197852", "서울특별시 서초구 양재2동 236");
//insert into location values("북촌 한옥마을", "37.5814640782974", "126.98488893100173", "서울특별시 종로구 계동길 37");
//insert into location values("국립중앙박물관", "37.52359432785362", "126.97902375512471", "서울특별시 용산구 서빙고로 137");
//
//insert into location values("석촌호수", "37.513042018879574", "127.10700986189529", "서울특별시 송파구 삼학사로");
//insert into location values("63스퀘어", "37.519841854348016", "126.94012864748069", "서울특별시 영등포구 63로 50");
//insert into location values("청와대", "37.58417218226159", "126.97521966646426", "서울특별시 종로구 청와대로 1");
//insert into location values("광화문 광장", "37.572937123170014", "126.97688176689995", "서울특별시 종로구 세종로 세종대로 172");
//insert into location values("홍대 걷고싶은거리", "37.5554217448475", "126.92347503610387", "서울특별시 마포구 서교동 348-66");
