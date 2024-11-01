package com.keyin.passenger;

import com.keyin.aircraft.Aircraft;
import com.keyin.city.City;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToMany
    @JoinTable(
            name = "passenger_aircraft",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "aircraft_id")
    )
    private List<Aircraft> aircraftList = new ArrayList<>();

    public Passenger() {}

    public Passenger(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }

    public List<Aircraft> getAircraftList() { return aircraftList; }
    public void setAircraftList(List<Aircraft> aircraftList) { this.aircraftList = aircraftList; }


    @Override
    public String toString() {
        return "Passenger{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName + "', phoneNumber='" + phoneNumber + "'}";
    }
}