package com.win.back.controller;

import com.win.back.dto.AddStampDTO;
import com.win.back.entity.Stamp;
import com.win.back.entity.User;
import com.win.back.service.LocationSearchService;
import com.win.back.service.StampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StampController {

    @Autowired
    StampService stampService;

    // QR 스캔 성공 시 스탬프 추가
    @PostMapping("add_stamp")
    @ResponseBody
    public boolean AddStampResponse(@RequestBody AddStampDTO addStampDTO) {
        return stampService.addStamp(addStampDTO);
    }

    // 유저가 획득한 스탬프 리스트를 반환
    @GetMapping("user_stamp_list/{id}")
    @ResponseBody
    public List<Stamp> getStampListResponse(@PathVariable String id) {
        id = id.replaceAll("\"","");

        return stampService.getStampList(id);
    }
}
