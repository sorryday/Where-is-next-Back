package com.win.back.repository;

import com.win.back.entity.Post;
import com.win.back.entity.Stamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, String> {
}
