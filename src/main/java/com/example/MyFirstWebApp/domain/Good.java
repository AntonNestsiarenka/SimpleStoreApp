package com.example.MyFirstWebApp.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "goods")
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private BigDecimal price;
    @Column(name = "number_of_available")
    private Integer numberOfAvailable;
    @Column
    private String description;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "category")
    private CategoryOfGood categoryOfGood;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "manufacturer")
    private Manufacturer manufacturer;

    public Good()
    {

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }

    public CategoryOfGood getCategoryOfGood() {
        return categoryOfGood;
    }

    public Integer getNumberOfAvailable() {
        return numberOfAvailable;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setNumberOfAvailable(Integer numberOfAvailable) {
        this.numberOfAvailable = numberOfAvailable;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategoryOfGood(CategoryOfGood categoryOfGood) {
        this.categoryOfGood = categoryOfGood;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return Objects.equals(id, good.id) &&
                Objects.equals(name, good.name) &&
                Objects.equals(price, good.price) &&
                Objects.equals(numberOfAvailable, good.numberOfAvailable) &&
                Objects.equals(description, good.description) &&
                Objects.equals(categoryOfGood, good.categoryOfGood) &&
                Objects.equals(manufacturer, good.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, numberOfAvailable, description, categoryOfGood, manufacturer);
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", numberOfAvailable=" + numberOfAvailable +
                ", description='" + description + '\'' +
                ", categoryOfGood=" + categoryOfGood +
                ", manufacturer=" + manufacturer +
                '}';
    }
}
