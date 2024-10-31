package com.keyin.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {

    @Autowired
    private AircraftRepository aircraftRepository;

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
}