package com.keyin.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public Iterable<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    // Method to get airports by city
    public List<Airport> getAirportsByCity(Integer cityId) {
        return airportRepository.findByCityId(cityId);
    }
}