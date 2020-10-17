package com.example.MyFirstWebApp.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "goods_in_order")
public class GoodInOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private BigDecimal price;
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "good_id")
    private Good good;
    @Column(name = "number_of_goods")
    private Integer numberOfGoods;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public GoodInOrder()
    {

    }

    public GoodInOrder(BigDecimal price, Good good, Integer numberOfGoods, Order order) {
        this.price = price;
        this.good = good;
        this.numberOfGoods = numberOfGoods;
        this.order = order;
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

    public Order getOrder() {
        return order;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodInOrder that = (GoodInOrder) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(price, that.price) &&
                Objects.equals(good, that.good) &&
                Objects.equals(numberOfGoods, that.numberOfGoods) &&
                Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, good, numberOfGoods, order);
    }

    @Override
    public String toString() {
        return "GoodInOrder{" +
                "id=" + id +
                ", price=" + price +
                ", good=" + good +
                ", numberOfGoods=" + numberOfGoods +
                ", order=" + order +
                '}';
    }
}
