package com.keyin.airport;

import com.keyin.city.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
@CrossOrigin
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping
    public Iterable<Airport> getListOfAirportsInDB() {
        return airportService.getAllAirports();
    }

    // New endpoint to get airports by city
    @GetMapping("/byCity/{cityId}")
    public List<Airport> getAirportsByCity(@PathVariable Integer cityId) {
        return airportService.getAirportsByCity(cityId);
    }
}