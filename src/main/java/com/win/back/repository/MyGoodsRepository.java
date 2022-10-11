package com.win.back.repository;

import com.win.back.entity.MyGoods;
import com.win.back.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyGoodsRepository extends JpaRepository<MyGoods, Long> {
}
