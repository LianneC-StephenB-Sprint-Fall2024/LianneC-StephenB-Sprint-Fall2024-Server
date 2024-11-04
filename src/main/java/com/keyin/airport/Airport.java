package com.keyin.airport;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.keyin.city.City;
import com.keyin.aircraft.Aircraft;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String code;
    private String location;

    // Relationship with City
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    @JsonBackReference  // Uncomment if needed to avoid circular references during JSON serialization
    private City city;

    // Relationship with Aircraft
    @ManyToMany(mappedBy = "airports")
    private List<Aircraft> aircraft;

    // No-argument constructor for JPA
    public Airport() {}

    // Constructor for basic details, used in testing
    public Airport(String name, String code) {
        this.name = name;
        this.code = code;
    }

    // Full constructor including all fields
    public Airport(String name, String code, String location, City city) {
        this.name = name;
        this.code = code;
        this.location = location;
        this.city = city;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }

    public List<Aircraft> getAircraft() { return aircraft; }
    public void setAircraft(List<Aircraft> aircraft) { this.aircraft = aircraft; }
}
