package com.example.MyFirstWebApp.repository;

import com.example.MyFirstWebApp.domain.CategoryOfGood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryOfGoodRepository extends JpaRepository<CategoryOfGood, Integer> {

}
