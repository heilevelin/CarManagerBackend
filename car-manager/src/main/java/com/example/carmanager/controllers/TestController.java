package com.example.carmanager.controllers;

import com.example.carmanager.models.Car;
import com.example.carmanager.models.Role;
import com.example.carmanager.models.User;
import com.example.carmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestController {
    @Autowired
    private final UserService userService;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Car> userAccess() {
        return userService.findCarsByRegion();
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public List<User> moderatorAccess() {
        return userService.findAllUsers();
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Car> adminAccess() {
        return userService.findAllCars();
    }

    @GetMapping("/edituser")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> editUser() {
        return userService.findAllUsers();
    }

    @GetMapping("/getroles")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Role> getRoles() {
        return userService.findAllRoles();
    }

    @PostMapping("/addcar")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        if (null==car.getRegion()) car.setRegion(userService.getCurrentRegion());
        Car newCar = userService.addCar(car);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }

    @PutMapping("/updatecar")
    public ResponseEntity<Car> updateCar(@RequestBody Car car){
        Car updateCar = userService.updateCar(car);
        return new ResponseEntity<>(updateCar, HttpStatus.OK);
    }

    @DeleteMapping("/deletecar/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") Long id){
        userService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateuser")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
