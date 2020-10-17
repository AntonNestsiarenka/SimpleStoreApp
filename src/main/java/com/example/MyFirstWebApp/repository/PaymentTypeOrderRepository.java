package com.example.MyFirstWebApp.repository;

import com.example.MyFirstWebApp.domain.PaymentTypeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeOrderRepository extends JpaRepository<PaymentTypeOrder, Integer> {

    PaymentTypeOrder findByPaymentType(PaymentTypeOrder.PaymentType paymentType);
}
