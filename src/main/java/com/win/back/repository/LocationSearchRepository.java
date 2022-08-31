package com.win.back.repository;

import com.win.back.entity.Location;
import com.win.back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationSearchRepository extends JpaRepository<Location, String> {
}
