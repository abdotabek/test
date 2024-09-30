package com.example.projecttest.dto;

import lombok.Data;

import java.util.List;

@Data
public class ItemDto {
    private List<Long> carId;
    private List<Long> employeeId;
    private List<Long> salonId;
}
