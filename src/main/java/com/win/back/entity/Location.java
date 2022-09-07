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
    @Column
    String url;     // 상세 페이지 주소
}

// 관광지 insert문
//insert into location values("경복궁", "서울특별시 종로구 사직로 161", "37.5759", "126.9768", "https://korean.visitseoul.net/attractions/%EA%B2%BD%EB%B3%B5%EA%B6%81_/72"),
//("청계천", "서울특별시 종로구 청계천로 1", "37.56907444191876", "126.97866576586092", "https://www.sisul.or.kr/open_content/cheonggye/"),
//("전쟁기념관", "서울특별시 용산구 이태원로 29", "37.53663145446524", "126.97705986822956", "https://korean.visitseoul.net/attractions/%EC%A0%84%EC%9F%81%EA%B8%B0%EB%85%90%EA%B4%80_/859"),
//("숭례문", "서울특별시 중구 세종대로 40", "37.55941743594751", "126.97567492549412", "https://korean.visitseoul.net/attractions/Sungnyemun_/22888"),
//("별마당 도서관", "서울특별시 강남구 영동대로 513 스타필드 코엑스몰 B1", "37.51248346199536", "127.05876832232725", "https://korean.visitseoul.net/attractions/%EB%B3%84%EB%A7%88%EB%8B%B9-%EB%8F%84%EC%84%9C%EA%B4%80_/26558"),
//("서울N타워", "서울특별시 용산구 남산공원길 105", "37.55114594604903", "126.98825045133734", "https://korean.visitseoul.net/attractions/%EB%82%A8%EC%82%B0%EC%84%9C%EC%9A%B8%ED%83%80%EC%9B%8C_/36"),
//("뚝섬유원지", "서울특별시 광진구 능동로 10", "37.530571468148054", "127.06654927998687", "https://hangang.seoul.go.kr/archives/46661"),
//("양재시민의숲", "서울특별시 서초구 양재2동 236", "37.47107344075643", "127.03549645197852", "https://www.seocho.go.kr/site/seocho/04/10405010100002015062601.jsp"),
//("북촌 한옥마을", "서울특별시 종로구 계동길 37", "37.5814640782974", "126.98488893100173", "https://korean.visitseoul.net/attractions/%EB%B6%81%EC%B4%8C%ED%95%9C%EC%98%A5%EB%A7%88%EC%9D%84_/261"),
//("국립중앙박물관", "서울특별시 용산구 서빙고로 137", "37.52359432785362", "126.97902375512471", "https://korean.visitseoul.net/attractions/%EA%B5%AD%EB%A6%BD%EC%A4%91%EC%95%99%EB%B0%95%EB%AC%BC%EA%B4%80_/433"),
//("석촌호수", "서울특별시 송파구 삼학사로", "37.513042018879574", "127.10700986189529", "https://korean.visitseoul.net/nature/%EC%84%9D%EC%B4%8C%ED%98%B8%EC%88%98%EA%B3%B5%EC%9B%90_/1136"),
//("63스퀘어", "서울특별시 영등포구 63로 50", "37.519841854348016", "126.94012864748069", "https://korean.visitseoul.net/attractions/63%EC%8A%A4%ED%80%98%EC%96%B4_/252"),
//("청와대", "서울특별시 종로구 청와대로 1", "37.58417218226159", "126.97521966646426", "https://korean.visitseoul.net/attractions/%EC%B2%AD%EC%99%80%EB%8C%80_/5538"),
//("광화문광장", "서울특별시 종로구 세종로 세종대로 172", "37.572937123170014", "126.97688176689995", "https://korean.visitseoul.net/attractions/%EA%B4%91%ED%99%94%EB%AC%B8%EA%B4%91%EC%9E%A5_/1900"),
//("홍대 걷고싶은거리", "서울특별시 마포구 서교동 348-66", "37.5554217448475", "126.92347503610387", "https://korean.visitseoul.net/attractions/%ED%99%8D%EB%8C%80%EA%B1%B7%EA%B3%A0%EC%8B%B6%EC%9D%80%EA%B1%B0%EB%A6%AC_/33071");
