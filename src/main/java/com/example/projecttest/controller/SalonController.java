package com.example.projecttest.controller;

import com.example.projecttest.dto.SalonDto;
import com.example.projecttest.entity.Salon;
import com.example.projecttest.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getAll")
    public ResponseEntity<List<Salon>> getAllSalons() {
        List<Salon> allSalon = salonService.getAllSalon();
        return ResponseEntity.ok(allSalon);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Salon> updateSalon(@PathVariable("id") Long id, @RequestBody SalonDto salonDto) {
        Salon salon = salonService.updateSalon(id, salonDto);
        return ResponseEntity.ok(salon);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        salonService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Salon> getById(@PathVariable("id") Long id) {
        Salon byId = salonService.findById(id);
        return ResponseEntity.ok(byId);
    }
}
