package com.example.MyFirstWebApp.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "goods_orders")
public class GoodsOrders {

    @EmbeddedId
    private GoodOrderKey id;

    @ManyToOne
    @MapsId("goodId")
    @JoinColumn(name = "good_id")
    private Good good;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price_for_one")
    private BigDecimal priceForOne;

    public GoodsOrders()
    {

    }

    public GoodsOrders(GoodOrderKey id, Good good, Order order, Integer quantity, BigDecimal priceForOne) {
        this.id = id;
        this.good = good;
        this.order = order;
        this.quantity = quantity;
        this.priceForOne = priceForOne;
    }

    public GoodOrderKey getId() {
        return id;
    }

    public void setId(GoodOrderKey id) {
        this.id = id;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPriceForOne() {
        return priceForOne;
    }

    public void setPriceForOne(BigDecimal priceForOne) {
        this.priceForOne = priceForOne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsOrders that = (GoodsOrders) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(good, that.good) &&
                Objects.equals(order, that.order) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(priceForOne, that.priceForOne);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, good, order, quantity, priceForOne);
    }

    @Override
    public String toString() {
        return "GoodsOrders{" +
                "id=" + id +
                ", good=" + good +
                ", order=" + order +
                ", quantity=" + quantity +
                ", priceForOne=" + priceForOne +
                '}';
    }
}
