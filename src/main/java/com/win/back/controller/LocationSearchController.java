package com.win.back.controller;

import com.win.back.dto.SignUpDTO;
import com.win.back.entity.Location;
import com.win.back.service.LocationSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    // QR 코드 스캔 시 서버에 등록되어 있는 관광지인지 판별
    @PostMapping("confirm_location")
    @ResponseBody
    public Boolean ConfrimLocationResponse(@RequestBody String qrRequest) {
        qrRequest = qrRequest.replaceAll("\"","");

        System.out.println(locationSearchService.searchLocation(qrRequest));
        return locationSearchService.searchLocation(qrRequest);
    }
}