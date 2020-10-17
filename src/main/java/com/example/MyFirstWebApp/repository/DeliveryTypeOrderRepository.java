package com.example.MyFirstWebApp.repository;

import com.example.MyFirstWebApp.domain.DeliveryTypeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryTypeOrderRepository extends JpaRepository<DeliveryTypeOrder, Integer> {

    DeliveryTypeOrder findByDeliveryType(DeliveryTypeOrder.DeliveryType deliveryType);

}
