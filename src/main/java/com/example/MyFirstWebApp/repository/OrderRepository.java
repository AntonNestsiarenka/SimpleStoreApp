package com.example.MyFirstWebApp.repository;

import com.example.MyFirstWebApp.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
