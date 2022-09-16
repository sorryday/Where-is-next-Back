package com.win.back.repository;

import com.win.back.entity.Picture;
import com.win.back.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, String> {
}
