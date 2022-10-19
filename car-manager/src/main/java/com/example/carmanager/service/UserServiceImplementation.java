package com.example.carmanager.service;

import com.example.carmanager.models.Car;
import com.example.carmanager.models.ERole;
import com.example.carmanager.models.Role;
import com.example.carmanager.models.User;
import com.example.carmanager.repository.CarRepository;
import com.example.carmanager.repository.RoleRepository;
import com.example.carmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImplementation implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CarRepository carRepository;

    private String currentRegion;

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    public RoleRepository getRoleRepository() {
        return roleRepository;
    }

    @Override
    public List<Car> findCarsByRegion(){
        List<Car> regionCars = new ArrayList<>();
        for (Car car: this.findAllCars()){
            if (car.getRegion().equals(currentRegion)){
                regionCars.add(car);
            }
        }
        return regionCars;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Car updateCar(Car car){
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Long id){carRepository.deleteCarById(id);}

    @Override
    public void setCurrentRegion(String region){
        currentRegion = region;
    }

    @Override
    public String getCurrentRegion() {
        return currentRegion;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<Role> getRoleFromRoleName(String roleName){
        return roleRepository.findByName(ERole.toERole(roleName));
    }
}
