package com.example.MyFirstWebApp.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "delivery_types")
public class DeliveryTypeOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "type_name")
    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;

    public DeliveryTypeOrder()
    {

    }

    public Integer getId() {
        return id;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryTypeOrder that = (DeliveryTypeOrder) o;
        return Objects.equals(id, that.id) &&
                deliveryType == that.deliveryType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deliveryType);
    }

    @Override
    public String toString() {
        return "DeliveryTypeOrder{" +
                "id=" + id +
                ", deliveryType=" + deliveryType +
                '}';
    }

    public enum DeliveryType {

        COURIER("Courier delivery"),
        PICKUP("Pickup"),
        POST("Post delivery");

        private String deliveryTypeName;

        DeliveryType(String deliveryTypeName)
        {
            this.deliveryTypeName = deliveryTypeName;
        }

        public String getDeliveryTypeName() {
            return deliveryTypeName;
        }

        public void setDeliveryTypeName(String deliveryTypeName) {
            this.deliveryTypeName = deliveryTypeName;
        }

        @Override
        public String toString() {
            return "DeliveryType{" +
                    "deliveryTypeName='" + deliveryTypeName + '\'' +
                    '}';
        }
    }
}
