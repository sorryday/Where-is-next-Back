package com.win.back.service;

import com.win.back.dto.BuyGoodsDTO;
import com.win.back.entity.Goods;
import com.win.back.entity.MyGoods;
import com.win.back.entity.Point;
import com.win.back.repository.MyGoodsRepository;
import com.win.back.repository.PointMallRepository;
import com.win.back.repository.PointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PointMallService {

    private final PointMallRepository pointMallRepository;
    private final PointRepository pointRepository;
    private final MyGoodsRepository myGoodsRepository;

    // 모든 상품 반환
    public List<Goods> getAllGoods() {
        return pointMallRepository.findAll();
    }

    //  상품 구매 로직
    public boolean buyGoods(BuyGoodsDTO buyGoodsDTO) {
        Optional<Point> searched_user_point_object = pointRepository.findById(buyGoodsDTO.getId());

        String userPoint = searched_user_point_object.get().getPoint().replaceAll(",", "");
        String goodsPrice = buyGoodsDTO.getPrice().replaceAll(",", "");

        // 상품의 구매가격보다 내 현재 포인트가 더 많다면
        if (Integer.parseInt(userPoint) >= Integer.parseInt(goodsPrice)) {
            int updatePrice = Integer.parseInt(userPoint) - Integer.parseInt(goodsPrice);

            Point updatePoint = new Point();
            updatePoint.setId(buyGoodsDTO.getId());
            updatePoint.setPoint(Integer.toString(updatePrice));

            pointRepository.save(updatePoint);

            MyGoods myGoods = new MyGoods();
            myGoods.setId(buyGoodsDTO.getId());
            myGoods.setMy_goods_name(buyGoodsDTO.getGoods_name());
            myGoods.setMy_goods_brand(buyGoodsDTO.getBrand());
            myGoods.setStatus(buyGoodsDTO.getStatus());

            myGoodsRepository.save(myGoods);

            return true;
        }

        return false;
    }

    // 구매한 상품이 잇는지 체크
    public boolean isMyGoods() {
        if (myGoodsRepository.findAll().isEmpty()) {
            return false;
        }
        else {
            return true;
        }
    }

    // 구매한 상품 리스트 반환
    public List<MyGoods> getMyGoodsList(String id) {
        List<MyGoods> responseList = new ArrayList<>();

        List<MyGoods> all = myGoodsRepository.findAll();
        for (MyGoods myGoods : all) {
            if (myGoods.getId().equals(id)) {
                responseList.add(myGoods);
            }
        }
        return responseList;
    }
}
