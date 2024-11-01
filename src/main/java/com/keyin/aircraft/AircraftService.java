package com.keyin.aircraft;

import com.keyin.airport.Airport;
import com.keyin.airport.AirportRepository;
import com.keyin.passenger.Passenger;
import com.keyin.passenger.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {

    @Autowired
    private AircraftRepository aircraftRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    public List<Aircraft> getAllAircraft() {
        return aircraftRepository.findAll();
    }

    public Aircraft getAircraftById(Integer id) {
        return aircraftRepository.findById(id).orElse(null);
    }

    public Aircraft createAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    public Aircraft updateAircraft(Integer id, Aircraft aircraftDetails) {
        Optional<Aircraft> aircraftOptional = aircraftRepository.findById(id);

        if (aircraftOptional.isPresent()) {
            Aircraft existingAircraft = aircraftOptional.get();
            existingAircraft.setType(aircraftDetails.getType());
            existingAircraft.setAirlineName(aircraftDetails.getAirlineName());
            existingAircraft.setNumberOfPassengers(aircraftDetails.getNumberOfPassengers());
            return aircraftRepository.save(existingAircraft);
        } else {
            return null; // Could handle a 'not found' situation more gracefully
        }
    }

    public void deleteAircraft(Integer id) {
        aircraftRepository.deleteById(id);
    }

    // Retrieve the list of airports associated with an aircraft
    public List<Airport> getAirportsForAircraft(Integer aircraftId) {
        Aircraft aircraft = aircraftRepository.findById(aircraftId).orElse(null);
        return aircraft != null ? aircraft.getAirports() : null;
    }

    // Retrieve the list of passengers who have flown on a specific aircraft
    public List<Passenger> getPassengersForAircraft(Integer aircraftId) {
        Aircraft aircraft = aircraftRepository.findById(aircraftId).orElse(null);
        return aircraft != null ? aircraft.getPassengers() : null;
    }

    // Associate an airport with an aircraft
    public Aircraft addAirportToAircraft(Integer aircraftId, Integer airportId) {
        Optional<Aircraft> aircraftOptional = aircraftRepository.findById(aircraftId);
        Optional<Airport> airportOptional = airportRepository.findById(airportId);

        if (aircraftOptional.isPresent() && airportOptional.isPresent()) {
            Aircraft aircraft = aircraftOptional.get();
            Airport airport = airportOptional.get();
            aircraft.getAirports().add(airport);
            return aircraftRepository.save(aircraft);
        }
        return null; // Handle case when aircraft or airport not found
    }

    // Associate a passenger with an aircraft
    public Aircraft addPassengerToAircraft(Integer aircraftId, Integer passengerId) {
        Optional<Aircraft> aircraftOptional = aircraftRepository.findById(aircraftId);
        Optional<Passenger> passengerOptional = passengerRepository.findById(passengerId);

        if (aircraftOptional.isPresent() && passengerOptional.isPresent()) {
            Aircraft aircraft = aircraftOptional.get();
            Passenger passenger = passengerOptional.get();
            aircraft.getPassengers().add(passenger);
            return aircraftRepository.save(aircraft);
        }
        return null; // Handle case when aircraft or passenger not found
    }
}