package com.example.MyFirstWebApp.models_of_form;

import com.example.MyFirstWebApp.domain.CategoryOfGood;
import com.example.MyFirstWebApp.domain.Manufacturer;
import java.math.BigDecimal;
import java.util.Objects;

public class AddGoodForm {

    private String name;
    private String description;
    private Integer numberOfAvailable;
    private BigDecimal price;
    private CategoryOfGood categoryOfGood;
    private Manufacturer manufacturer;

    public AddGoodForm()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumberOfAvailable() {
        return numberOfAvailable;
    }

    public void setNumberOfAvailable(Integer numberOfAvailable) {
        this.numberOfAvailable = numberOfAvailable;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryOfGood getCategoryOfGood() {
        return categoryOfGood;
    }

    public void setCategoryOfGood(CategoryOfGood categoryOfGood) {
        this.categoryOfGood = categoryOfGood;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddGoodForm that = (AddGoodForm) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(numberOfAvailable, that.numberOfAvailable) &&
                Objects.equals(price, that.price) &&
                Objects.equals(categoryOfGood, that.categoryOfGood) &&
                Objects.equals(manufacturer, that.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, numberOfAvailable, price, categoryOfGood, manufacturer);
    }

    @Override
    public String toString() {
        return "AddGoodForm{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", numberOfAvailable=" + numberOfAvailable +
                ", price=" + price +
                ", category=" + categoryOfGood +
                ", manufacturer=" + manufacturer +
                '}';
    }
}
