package com.example.MyFirstWebApp.services;

import com.example.MyFirstWebApp.domain.GoodInBasket;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.List;

@Component
public class BasketService {

    public BasketService() {

    }

    public BigDecimal priceRefresh(List<GoodInBasket> goodsInBasket)
    {
        BigDecimal price = new BigDecimal(0);
        for(GoodInBasket goodInBasket : goodsInBasket)
        {
            price = price.add(goodInBasket.getGood().getPrice().multiply(new BigDecimal(goodInBasket.getNumberOfGoods())));
        }
        return price;
    }

}
