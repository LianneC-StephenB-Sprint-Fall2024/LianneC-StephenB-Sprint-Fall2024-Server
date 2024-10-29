package com.keyin.Passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger getPassengerById(Integer id) {
        return passengerRepository.findById(id).orElse(null);
    }

    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(Integer id, Passenger passengerDetails) {
        Optional<Passenger> passengerOptional = passengerRepository.findById(id);

        if (passengerOptional.isPresent()) {
            Passenger existingPassenger = passengerOptional.get();
            existingPassenger.setFirstName(passengerDetails.getFirstName());
            existingPassenger.setLastName(passengerDetails.getLastName());
            existingPassenger.setPhoneNumber(passengerDetails.getPhoneNumber());
            return passengerRepository.save(existingPassenger);
        } else {
            return null; // Handle 'not found' gracefully in real scenarios
        }
    }

    public void deletePassenger(Integer id) {
        passengerRepository.deleteById(id);
    }
}