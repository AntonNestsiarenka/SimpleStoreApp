package com.example.MyFirstWebApp.services;

import com.example.MyFirstWebApp.domain.GoodsBaskets;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.Set;

@Component
public class BasketService {

    public BasketService() {

    }

    public BigDecimal priceRefresh(Set<GoodsBaskets> goodsInBasket)
    {
        BigDecimal price = new BigDecimal(0);
        for(GoodsBaskets goodInBasket : goodsInBasket)
        {
            price = price.add(goodInBasket.getGood().getPrice().multiply(new BigDecimal(goodInBasket.getQuantity())));
        }
        return price;
    }

}
