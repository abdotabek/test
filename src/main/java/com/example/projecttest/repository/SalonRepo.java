package com.example.projecttest.repository;

import com.example.projecttest.entity.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepo extends JpaRepository<Salon, Long> {
}
