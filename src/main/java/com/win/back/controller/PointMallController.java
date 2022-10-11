package com.win.back.controller;

import com.win.back.dto.AllPostDTO;
import com.win.back.dto.BuyGoodsDTO;
import com.win.back.dto.CommentDTO;
import com.win.back.entity.Goods;
import com.win.back.entity.MyGoods;
import com.win.back.service.LocationSearchService;
import com.win.back.service.PointMallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // 상품 구매하기
    @PostMapping("buy_goods")
    @ResponseBody
    public boolean getBuyGoodsResponse(@RequestBody BuyGoodsDTO buyGoodsDTO) {
        return pointMallService.buyGoods(buyGoodsDTO);
    }

    // 구매한 상품이 있는지 체크
    @GetMapping("my_goods_check")
    @ResponseBody
    public boolean isMyGoodsResponse() {
        return pointMallService.isMyGoods();
    }

    // 구매한 상품 리스트 반환
    @GetMapping("my_goods_list/{id}")
    @ResponseBody
    public List<MyGoods> getMyGoodsListResponse(@PathVariable String id) {
        id = id.replaceAll("\"","");

        return pointMallService.getMyGoodsList(id);
    }
}
