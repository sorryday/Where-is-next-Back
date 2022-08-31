package com.win.back.controller;

import com.win.back.entity.Location;
import com.win.back.service.LocationSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationSearchController {

    @Autowired
    LocationSearchService locationSearchService;

    // 관광지 이름 리스트 반환
    @GetMapping("location_list")
    @ResponseBody
    public List<Location> getLocationResponse() {
        return locationSearchService.locationList();
    }
}
