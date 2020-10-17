package com.example.MyFirstWebApp.repository;

import com.example.MyFirstWebApp.domain.GoodInOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodInOrderRepository extends JpaRepository<GoodInOrder, Integer> {


}
