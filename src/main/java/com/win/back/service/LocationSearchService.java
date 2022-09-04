package com.win.back.service;

import com.win.back.entity.Location;
import com.win.back.entity.User;
import com.win.back.repository.LocationSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationSearchService {
    private final LocationSearchRepository locationSearchRepository;

    // 관광지 리스트를 반환
    public List<Location> locationList() {
        return locationSearchRepository.findAll();
    }

    // QR 스캔한 결과 값이 서버에 있는 관광지와 일치하는지를 판별
    public Boolean searchLocation(String qrRequest) {
        List<Location> all = locationSearchRepository.findAll();
        for (Location location : all) {
            if (location.getName().equals(qrRequest)) {
                return true;
            }
        }
        return false;
    }
}