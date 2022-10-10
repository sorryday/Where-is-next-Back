package com.win.back.repository;

import com.win.back.entity.Goods;
import com.win.back.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point, String> {
}
