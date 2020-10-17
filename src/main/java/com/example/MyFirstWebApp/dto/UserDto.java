package com.example.MyFirstWebApp.dto;

import com.example.MyFirstWebApp.domain.UserRole;

import java.util.Objects;

public class UserDto {

    private Integer id;
    private String login;
    private Boolean isActive;
    private UserRole role;

    public UserDto()
    {

    }

    public UserDto(Integer id, String login, Boolean isActive, UserRole role) {
        this.id = id;
        this.login = login;
        this.isActive = isActive;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) &&
                Objects.equals(login, userDto.login) &&
                Objects.equals(isActive, userDto.isActive) &&
                Objects.equals(role, userDto.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, isActive, role);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", isActive=" + isActive +
                ", role=" + role +
                '}';
    }
}
