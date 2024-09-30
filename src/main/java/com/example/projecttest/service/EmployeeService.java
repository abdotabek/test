package com.example.projecttest.service;

import com.example.projecttest.dto.EmployeeDto;
import com.example.projecttest.entity.Car;
import com.example.projecttest.entity.Employee;
import com.example.projecttest.repository.CarRepo;
import com.example.projecttest.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private CarRepo carRepo;

    public Employee createEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setPhone(employeeDto.getPhone());

        List<Car> cars = carRepo.findAllById(employeeDto.getItemDto().getCarId());
        employee.setCar(cars);
        employeeRepo.save(employee);
        return employee;
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepo.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepo.findById(id).orElse(null);
        assert employee != null;
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setPhone(employeeDto.getPhone());
        return employeeRepo.save(employee);
    }

    public void deleteEmployeeById(Long id) {
        employeeRepo.deleteById(id);
    }

}
