package com.win.back.repository;

import com.win.back.entity.Comment;
import com.win.back.entity.Heart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartRepository extends JpaRepository<Heart, String> {
}
