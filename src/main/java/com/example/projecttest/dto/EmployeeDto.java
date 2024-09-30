package com.example.projecttest.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private String name;
    private String surname;
    private String phone;
    private ItemDto itemDto;
}
