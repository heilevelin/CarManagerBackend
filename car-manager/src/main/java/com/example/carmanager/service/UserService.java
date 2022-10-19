package com.example.carmanager.service;

import com.example.carmanager.models.Car;
import com.example.carmanager.models.Role;
import com.example.carmanager.models.User;
import com.example.carmanager.repository.RoleRepository;
import com.example.carmanager.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Car addCar(Car car);
    List<Car> findAllCars();
    List<Role> findAllRoles();
    List<User> findAllUsers();
    RoleRepository getRoleRepository();
    UserRepository getUserRepository();
    List<Car> findCarsByRegion();

    User updateUser(User user);

    Car updateCar(Car car);
    void deleteCar(Long id);

    void setCurrentRegion(String region);

    String getCurrentRegion();

    void deleteUser(Long id);

    Optional<Role> getRoleFromRoleName(String roleName);
}
