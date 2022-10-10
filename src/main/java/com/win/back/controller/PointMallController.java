package com.win.back.controller;

import com.win.back.dto.AllPostDTO;
import com.win.back.entity.Goods;
import com.win.back.service.LocationSearchService;
import com.win.back.service.PointMallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PointMallController {

    @Autowired
    PointMallService pointMallService;

    // 모든 상품 정보 반환
    @GetMapping("all_goods")
    @ResponseBody
    public List<Goods> getAllGoodsResponse() {
        return pointMallService.getAllGoods();
    }
}
