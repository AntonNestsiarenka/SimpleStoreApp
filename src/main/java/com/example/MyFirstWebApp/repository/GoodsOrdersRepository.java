package com.example.MyFirstWebApp.repository;

import com.example.MyFirstWebApp.domain.GoodOrderKey;
import com.example.MyFirstWebApp.domain.GoodsOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsOrdersRepository extends JpaRepository<GoodsOrders, GoodOrderKey> {


}
