package com.example.MyFirstWebApp.repository;

import com.example.MyFirstWebApp.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    UserRole findByTypeOfUserRights(UserRole.TypeOfUserRights typeOfUserRights);
}
