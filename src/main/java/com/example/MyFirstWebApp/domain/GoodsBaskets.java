package com.example.MyFirstWebApp.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "goods_baskets")
public class GoodsBaskets {

    @EmbeddedId
    private GoodBasketKey id;

    @ManyToOne
    @MapsId("goodId")
    @JoinColumn(name = "good_id")
    private Good good;

    @ManyToOne
    @MapsId("basketId")
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @Column(name = "quantity")
    private Integer quantity;

    public GoodsBaskets()
    {

    }

    public GoodsBaskets(GoodBasketKey id, Good good, Basket basket, Integer quantity) {
        this.id = id;
        this.good = good;
        this.basket = basket;
        this.quantity = quantity;
    }

    public GoodBasketKey getId() {
        return id;
    }

    public void setId(GoodBasketKey id) {
        this.id = id;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsBaskets that = (GoodsBaskets) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(good, that.good) &&
                Objects.equals(basket, that.basket) &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, good, basket, quantity);
    }

    @Override
    public String toString() {
        return "GoodsBaskets{" +
                "id=" + id +
                ", good=" + good +
                ", basket=" + basket +
                ", quantity=" + quantity +
                '}';
    }
}
