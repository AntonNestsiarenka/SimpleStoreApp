package com.example.MyFirstWebApp.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "categories")
public class CategoryOfGood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private Category categoryName;
    @OneToMany(mappedBy = "categoryOfGood", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Good> goods;

    public CategoryOfGood()
    {

    }

    public Integer getId() {
        return id;
    }

    public Category getCategoryName() {
        return categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryOfGood that = (CategoryOfGood) o;
        return Objects.equals(id, that.id) &&
                categoryName == that.categoryName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName);
    }

    @Override
    public String toString() {
        return "CategoryOfGood{" +
                "id=" + id +
                ", categoryName=" + categoryName +
                '}';
    }

    public enum Category {

        MOBILE_PHONES("mobile_phones"),
        TABLETS("tablets"),
        TV("tv`s"),
        GAMING_CONSOLES("gaming_consoles"),
        MONITORS("monitors"),
        LAPTOPS("laptops"),
        CAMERAS("cameras");

        private String categoryName;

        Category(String categoryName)
        {
            this.categoryName = categoryName;
        }

        public String getCategoryName() {
            return categoryName;
        }

        @Override
        public String toString() {
            return "Category{" +
                    "categoryName='" + categoryName + '\'' +
                    '}';
        }
    }
}
