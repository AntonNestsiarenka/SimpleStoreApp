package com.example.MyFirstWebApp.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "statuses")
public class StatusOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "status_name")
    @Enumerated(EnumType.STRING)
    private Status status;

    public StatusOrder()
    {

    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusOrder that = (StatusOrder) o;
        return Objects.equals(id, that.id) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }

    @Override
    public String toString() {
        return "StatusOrder{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }

    public enum Status {

        COMPLETED("Completed"),
        CANCELED("Canceled"),
        PROCESSING("Processing"),
        READY_TO_SHIP("Ready to ship"),
        SHIPPING("Shipping"),
        READY_TO_ISSUE("Ready to issue");

        private String statusName;

        Status(String statusName)
        {
            this.statusName = statusName;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        @Override
        public String toString() {
            return "Status{" +
                    "statusName='" + statusName + '\'' +
                    '}';
        }
    }
}
