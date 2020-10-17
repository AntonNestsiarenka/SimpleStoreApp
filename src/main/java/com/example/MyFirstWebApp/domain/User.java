package com.example.MyFirstWebApp.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String login;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String tel;
    @Column(name = "is_active")
    private Boolean isActive;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "role", nullable = false)
    private UserRole userRole;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "basket")
    private Basket basket;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Order> orders;

    public User()
    {

    }

    public User(String login, String email, String password, Boolean isActive, UserRole userRole, Basket basket) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.userRole = userRole;
        this.basket = basket;
    }

    public User(String login, String email, String password, String name, String surname, String tel, Boolean isActive, UserRole userRole, Basket basket) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.tel = tel;
        this.isActive = isActive;
        this.userRole = userRole;
        this.basket = basket;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Basket getBasket() {
        return basket;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTel() {
        return tel;
    }

    public Boolean getActive() {
        return isActive;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(tel, user.tel) &&
                Objects.equals(isActive, user.isActive) &&
                Objects.equals(userRole, user.userRole) &&
                Objects.equals(basket, user.basket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, email, password, name, surname, tel, isActive, userRole, basket);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", tel='" + tel + '\'' +
                ", isActive=" + isActive +
                ", userRole=" + userRole +
                ", basket=" + basket +
                '}';
    }
}