package com.example.MyFirstWebApp.repository;

import com.example.MyFirstWebApp.domain.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository  extends JpaRepository<Basket, Integer> {

}
