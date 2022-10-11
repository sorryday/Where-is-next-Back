package com.win.back.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyGoodsDTO {
    String id;
    String goods_name;
    String price;
    String brand;
    String status;

    @Override
    public String toString() {
        return "BuyGoodsDTO{" +
                "id='" + id + '\'' +
                ", goods_name='" + goods_name + '\'' +
                ", price='" + price + '\'' +
                ", brand='" + brand + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
