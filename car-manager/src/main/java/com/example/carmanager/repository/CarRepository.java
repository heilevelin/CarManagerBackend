package com.example.carmanager.repository;

import com.example.carmanager.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository  extends JpaRepository<Car, Long> {
    void deleteCarById(Long id);

    Optional<Car> findCarById(Long id);
}
