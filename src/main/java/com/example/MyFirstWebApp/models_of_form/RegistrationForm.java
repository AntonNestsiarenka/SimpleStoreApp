package com.example.MyFirstWebApp.models_of_form;

import com.example.MyFirstWebApp.domain.Basket;
import com.example.MyFirstWebApp.domain.UserRole;
import java.util.Objects;

public class RegistrationForm {

    private String login;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String tel;
    private Boolean isActive;
    private UserRole userRole;
    private Basket basket;

    public RegistrationForm()
    {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationForm that = (RegistrationForm) o;
        return Objects.equals(login, that.login) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(tel, that.tel) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(userRole, that.userRole) &&
                Objects.equals(basket, that.basket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email, password, name, surname, tel, isActive, userRole, basket);
    }

    @Override
    public String toString() {
        return "RegistrationForm{" +
                "login='" + login + '\'' +
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
