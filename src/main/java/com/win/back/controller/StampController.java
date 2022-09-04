package com.win.back.controller;

import com.win.back.dto.AddStampDTO;
import com.win.back.entity.User;
import com.win.back.service.LocationSearchService;
import com.win.back.service.StampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
