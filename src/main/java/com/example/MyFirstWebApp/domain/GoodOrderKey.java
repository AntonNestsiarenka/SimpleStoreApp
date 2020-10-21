package com.example.MyFirstWebApp.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GoodOrderKey implements Serializable {

    @Column(name = "good_id")
    private Integer goodId;

    @Column(name = "order_id")
    private Integer orderId;

    public GoodOrderKey()
    {

    }

    public GoodOrderKey(Integer goodId, Integer orderId)
    {
        this.goodId = goodId;
        this.orderId = orderId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodOrderKey that = (GoodOrderKey) o;
        return Objects.equals(goodId, that.goodId) &&
                Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodId, orderId);
    }

    @Override
    public String toString() {
        return "GoodOrderKey{" +
                "goodId=" + goodId +
                ", orderId=" + orderId +
                '}';
    }
}
