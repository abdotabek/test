package com.example.projecttest.controller;

import com.example.projecttest.dto.CarDto;
import com.example.projecttest.entity.Car;
import com.example.projecttest.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/create")
    public ResponseEntity<Car> addCar(@RequestBody CarDto carDto) {
        Car car = carService.createCar(carDto);
        return ResponseEntity.ok(car);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Car>> carList() {
        List<Car> carList = carService.getAllCars();
        return ResponseEntity.ok(carList);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        carService.deleteCarById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") Long id, @RequestBody CarDto carDto) {
        Car car = carService.getCarById(id);
        carService.updateCar(id, carDto);
        return ResponseEntity.ok(car);
    }
}
