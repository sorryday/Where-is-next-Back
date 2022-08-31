package com.win.back.service;

import com.win.back.entity.Location;
import com.win.back.repository.LocationSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationSearchService {
    private final LocationSearchRepository locationSearchRepository;

    public List<Location> locationList() {
        return locationSearchRepository.findAll();
    }
}