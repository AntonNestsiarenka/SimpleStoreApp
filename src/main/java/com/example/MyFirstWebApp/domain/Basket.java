package com.example.MyFirstWebApp.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "baskets")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<GoodsBaskets> goodsBaskets;

    public Basket()
    {

    }

    public Integer getId() {
        return id;
    }

    public Set<GoodsBaskets> getGoodsBaskets() {
        return goodsBaskets;
    }

    public void setGoodsInBasket(Set<GoodsBaskets> goodsBaskets) {
        this.goodsBaskets = goodsBaskets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(id, basket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                '}';
    }
}
