package com.example.MyFirstWebApp.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "payment_types")
public class PaymentTypeOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "type_name")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    public PaymentTypeOrder()
    {

    }

    public Integer getId() {
        return id;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentTypeOrder that = (PaymentTypeOrder) o;
        return Objects.equals(id, that.id) &&
                paymentType == that.paymentType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentType);
    }

    @Override
    public String toString() {
        return "PaymentTypeOrder{" +
                "id=" + id +
                ", paymentType=" + paymentType +
                '}';
    }

    public enum PaymentType {

        CASH("Cash payment"),
        CARD("Card payment");

        private String paymentTypeName;

        PaymentType(String paymentTypeName)
        {
            this.paymentTypeName = paymentTypeName;
        }

        public String getPaymentTypeName() {
            return paymentTypeName;
        }

        public void setPaymentTypeName(String paymentTypeName) {
            this.paymentTypeName = paymentTypeName;
        }

        @Override
        public String toString() {
            return "PaymentType{" +
                    "paymentTypeName='" + paymentTypeName + '\'' +
                    '}';
        }
    }
}
