package com.example.projecttest.controller;

import com.example.projecttest.dto.SalonDto;
import com.example.projecttest.entity.Salon;
import com.example.projecttest.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salon")
public class SalonController {
    @Autowired
    private SalonService salonService;

    @PostMapping("/create")
    public ResponseEntity<Salon> createSalon(@RequestBody SalonDto salonDto) {
        Salon salon = salonService.createSalon(salonDto);
        return ResponseEntity.ok(salon);
    }
}
