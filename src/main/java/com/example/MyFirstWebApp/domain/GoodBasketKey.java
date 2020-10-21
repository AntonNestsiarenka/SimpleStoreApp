package com.example.MyFirstWebApp.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GoodBasketKey implements Serializable {

    @Column(name = "good_id")
    private Integer goodId;

    @Column(name = "basket_id")
    private Integer basketId;

    public GoodBasketKey()
    {

    }

    public GoodBasketKey(Integer goodId, Integer basketId)
    {
        this.goodId = goodId;
        this.basketId = basketId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getBasketId() {
        return basketId;
    }

    public void setBasketId(Integer basketId) {
        this.basketId = basketId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodBasketKey that = (GoodBasketKey) o;
        return Objects.equals(goodId, that.goodId) &&
                Objects.equals(basketId, that.basketId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodId, basketId);
    }

    @Override
    public String toString() {
        return "GoodsBasketsKey{" +
                "goodId=" + goodId +
                ", basketId=" + basketId +
                '}';
    }
}