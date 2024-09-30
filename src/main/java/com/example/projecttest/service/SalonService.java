package com.example.projecttest.service;

import com.example.projecttest.dto.SalonDto;
import com.example.projecttest.entity.Car;
import com.example.projecttest.entity.Employee;
import com.example.projecttest.entity.Salon;
import com.example.projecttest.repository.CarRepo;
import com.example.projecttest.repository.EmployeeRepo;
import com.example.projecttest.repository.SalonRepo;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalonService {
    @Autowired
    private SalonRepo salonRepo;
    @Autowired
    private CarRepo carRepo;
    @Autowired
    private EmployeeRepo employeeRepo;

    public Salon createSalon(SalonDto salonDto) {

        List<Car> cars = carRepo.findAllById(salonDto.getItemDto().getCarId().stream().toList());
        List<Employee> employees = employeeRepo.findAllById(salonDto.getItemDto().getEmployeeId().stream().toList());

        Salon salon = new Salon();
        salon.setSalonName(salonDto.getSalonName());
        salon.setCar(cars);
        salon.setEmployee(employees);
        salonRepo.save(salon);
        return salon;
    }

    public Salon updateSalon(Long id, SalonDto salonDto) {
        Salon byId = salonRepo.findById(id).orElse(null);
        byId.setSalonName(salonDto.getSalonName());
        return salonRepo.save(byId);
    }
}
