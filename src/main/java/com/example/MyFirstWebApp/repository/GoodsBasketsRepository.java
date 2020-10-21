package com.example.MyFirstWebApp.repository;

import com.example.MyFirstWebApp.domain.GoodBasketKey;
import com.example.MyFirstWebApp.domain.GoodsBaskets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsBasketsRepository extends JpaRepository<GoodsBaskets, GoodBasketKey> {

}
