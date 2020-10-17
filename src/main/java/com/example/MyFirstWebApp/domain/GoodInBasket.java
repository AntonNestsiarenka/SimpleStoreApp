package com.example.MyFirstWebApp.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "goods_in_basket")
public class GoodInBasket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "good_id", nullable = false)
    private Good good;
    @Column(name = "number_of_goods")
    private Integer numberOfGoods;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "basket_id", nullable = false)
    private Basket basket;

    public GoodInBasket()
    {

    }

    public GoodInBasket(Good good, Integer numberOfGoods, Basket basket) {
        this.good = good;
        this.numberOfGoods = numberOfGoods;
        this.basket = basket;
    }

    public Integer getId() {
        return id;
    }

    public Good getGood() {
        return good;
    }

    public Integer getNumberOfGoods() {
        return numberOfGoods;
    }

    public void setNumberOfGoods(Integer numberOfGoods) {
        this.numberOfGoods = numberOfGoods;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodInBasket that = (GoodInBasket) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(good, that.good) &&
                Objects.equals(numberOfGoods, that.numberOfGoods) &&
                Objects.equals(basket, that.basket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, good, numberOfGoods, basket);
    }

    @Override
    public String toString() {
        return "GoodInBasket{" +
                "id=" + id +
                ", good=" + good +
                ", numberOfGoods=" + numberOfGoods +
                ", basket=" + basket +
                '}';
    }
}
