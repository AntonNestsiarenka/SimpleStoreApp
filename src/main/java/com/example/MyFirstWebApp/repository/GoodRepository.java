package com.example.MyFirstWebApp.repository;

import com.example.MyFirstWebApp.domain.CategoryOfGood;
import com.example.MyFirstWebApp.domain.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GoodRepository  extends JpaRepository<Good, Integer> {
    
    List<Good> findByCategoryOfGood_CategoryName(CategoryOfGood.Category category);
    Good findById(int id);
}
