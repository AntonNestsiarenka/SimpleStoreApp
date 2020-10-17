package com.example.MyFirstWebApp.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roles_id")
    private Integer id;
    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private TypeOfUserRights typeOfUserRights;

    public UserRole(TypeOfUserRights typeOfUserRights) {
        this.typeOfUserRights = typeOfUserRights;
    }

    public UserRole() {
        this.typeOfUserRights = TypeOfUserRights.USER;
    }

    public Integer getId() {
        return id;
    }

    public TypeOfUserRights getTypeOfUserRights() {
        return typeOfUserRights;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", typeOfUserRights=" + typeOfUserRights +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(id, userRole.id) &&
                typeOfUserRights == userRole.typeOfUserRights;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeOfUserRights);
    }

    public enum TypeOfUserRights {

        ADMIN("admin"),
        USER("user");

        private String typeOfUserRights;

        TypeOfUserRights(String typeOfUserRights) {
            this.typeOfUserRights = typeOfUserRights;
        }

        public String getTypeOfUserRights() {
            return typeOfUserRights;
        }

        @Override
        public String toString() {
            return "TypeOfUserRights{" +
                    "typeOfUserRights='" + typeOfUserRights + '\'' +
                    '}';
        }
    }
}