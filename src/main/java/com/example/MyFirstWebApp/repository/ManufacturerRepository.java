package com.example.MyFirstWebApp.repository;

import com.example.MyFirstWebApp.domain.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {

}
