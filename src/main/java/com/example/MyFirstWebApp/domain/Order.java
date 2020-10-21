package com.example.MyFirstWebApp.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "order_date_time")
    private Timestamp orderDateTime;
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<GoodsOrders> goodsOrders;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "status", nullable = false)
    private StatusOrder statusOrder;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "type_of_delivery", nullable = false)
    private DeliveryTypeOrder deliveryTypeOrder;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "type_of_payment", nullable = false)
    private PaymentTypeOrder paymentTypeOrder;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Order()
    {

    }

    public Order(Timestamp orderDateTime, BigDecimal totalPrice, StatusOrder statusOrder, DeliveryTypeOrder deliveryTypeOrder, PaymentTypeOrder paymentTypeOrder, User user) {
        this.orderDateTime = orderDateTime;
        this.totalPrice = totalPrice;
        this.statusOrder = statusOrder;
        this.deliveryTypeOrder = deliveryTypeOrder;
        this.paymentTypeOrder = paymentTypeOrder;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public Timestamp getOrderDateTime() {
        return orderDateTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Set<GoodsOrders> getGoodsOrders() {
        return goodsOrders;
    }

    public StatusOrder getStatusOrder() {
        return statusOrder;
    }

    public DeliveryTypeOrder getDeliveryTypeOrder() {
        return deliveryTypeOrder;
    }

    public PaymentTypeOrder getPaymentTypeOrder() {
        return paymentTypeOrder;
    }

    public User getUser() {
        return user;
    }

    public void setGoodsOrders(Set<GoodsOrders> goodsOrders) {
        this.goodsOrders = goodsOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(orderDateTime, order.orderDateTime) &&
                Objects.equals(totalPrice, order.totalPrice) &&
                Objects.equals(statusOrder, order.statusOrder) &&
                Objects.equals(deliveryTypeOrder, order.deliveryTypeOrder) &&
                Objects.equals(paymentTypeOrder, order.paymentTypeOrder) &&
                Objects.equals(user, order.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDateTime, totalPrice, statusOrder, deliveryTypeOrder, paymentTypeOrder, user);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDateTime=" + orderDateTime +
                ", totalPrice=" + totalPrice +
                ", statusOrder=" + statusOrder +
                ", deliveryTypeOrder=" + deliveryTypeOrder +
                ", paymentTypeOrder=" + paymentTypeOrder +
                ", user=" + user +
                '}';
    }
}
