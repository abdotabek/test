package com.example.projecttest.service;

import com.example.projecttest.dto.CarDto;
import com.example.projecttest.entity.Car;
import com.example.projecttest.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepo carRepo;

    public Car createCar(CarDto carDto) {
        Car car = new Car();
        car.setModel(carDto.getModel());
        car.setPrice(carDto.getPrice());
        return carRepo.save(car);
       
    }

    public List<Car> getAllCars() {
        return carRepo.findAll();
    }

    public Car getCarById(Long id) {
        return carRepo.findById(id).orElse(null);
    }

    public void deleteCarById(Long id) {
        carRepo.deleteById(id);
    }

    public Car updateCar(Long id, CarDto carDto) {
        Car car = getCarById(id);
        car.setModel(carDto.getModel());
        car.setPrice(carDto.getPrice());
        return carRepo.save(car);
    }
}
