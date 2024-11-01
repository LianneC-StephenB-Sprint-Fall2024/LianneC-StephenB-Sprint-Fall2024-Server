package com.keyin.aircraft;

import com.keyin.airport.Airport;
import com.keyin.passenger.Passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aircraft")
@CrossOrigin
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    @GetMapping
    public List<Aircraft> getAllAircraft() {
        return aircraftService.getAllAircraft();
    }

    @GetMapping("/{id}")
    public Aircraft getAircraftById(@PathVariable Integer id) {
        return aircraftService.getAircraftById(id);
    }

    @PostMapping
    public Aircraft createAircraft(@RequestBody Aircraft aircraft) {
        return aircraftService.createAircraft(aircraft);
    }

    @PutMapping("/{id}")
    public Aircraft updateAircraft(@PathVariable Integer id, @RequestBody Aircraft aircraft) {
        return aircraftService.updateAircraft(id, aircraft);
    }

    @DeleteMapping("/{id}")
    public void deleteAircraft(@PathVariable Integer id) {
        aircraftService.deleteAircraft(id);
    }

    // Additional endpoints for handling related entities

    // Get airports where the aircraft can take off and land
    @GetMapping("/{id}/airports")
    public List<Airport> getAirportsForAircraft(@PathVariable Integer id) {
        return aircraftService.getAirportsForAircraft(id);
    }

    // Get passengers who have traveled on this aircraft
    @GetMapping("/{id}/passengers")
    public List<Passenger> getPassengersForAircraft(@PathVariable Integer id) {
        return aircraftService.getPassengersForAircraft(id);
    }

    // Add an airport to an aircraft
    @PostMapping("/{id}/airports/{airportId}")
    public Aircraft addAirportToAircraft(@PathVariable Integer id, @PathVariable Integer airportId) {
        return aircraftService.addAirportToAircraft(id, airportId);
    }

    // Add a passenger to an aircraft
    @PostMapping("/{id}/passengers/{passengerId}")
    public Aircraft addPassengerToAircraft(@PathVariable Integer id, @PathVariable Integer passengerId) {
        return aircraftService.addPassengerToAircraft(id, passengerId);
    }
}