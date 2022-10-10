package com.win.back.service;

import com.win.back.entity.Goods;
import com.win.back.repository.PointMallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PointMallService {

    private final PointMallRepository pointMallRepository;

    // 모든 상품 반환
    public List<Goods> getAllGoods() {
        return pointMallRepository.findAll();
    }
}
