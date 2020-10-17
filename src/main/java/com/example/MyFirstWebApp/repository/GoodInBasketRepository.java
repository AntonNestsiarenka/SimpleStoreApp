package com.example.MyFirstWebApp.repository;

import com.example.MyFirstWebApp.domain.GoodInBasket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodInBasketRepository extends JpaRepository<GoodInBasket, Integer> {

    GoodInBasket findByGood_Id(int id);
}
