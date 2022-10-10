package com.win.back.repository;

import com.win.back.entity.Goods;
import com.win.back.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointMallRepository extends JpaRepository<Goods, String> {
}
