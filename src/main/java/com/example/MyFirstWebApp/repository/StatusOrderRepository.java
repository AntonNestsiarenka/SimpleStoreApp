package com.example.MyFirstWebApp.repository;

import com.example.MyFirstWebApp.domain.StatusOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusOrderRepository extends JpaRepository<StatusOrder, Integer> {

    StatusOrder findByStatus(StatusOrder.Status status);
}
