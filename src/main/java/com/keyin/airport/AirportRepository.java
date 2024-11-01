package com.keyin.airport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {
    // Custom query method to find airports by city ID
    List<Airport> findByCityId(Integer cityId);
}