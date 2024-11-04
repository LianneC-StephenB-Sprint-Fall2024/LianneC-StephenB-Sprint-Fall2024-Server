package com.keyin;

import com.keyin.passenger.PassengerController;
import com.keyin.passenger.PassengerService;
import com.keyin.passenger.Passenger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PassengerController.class)
public class PassengerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PassengerService passengerService;

    @Test
    public void testGetAllPassengers() throws Exception {
        when(passengerService.getAllPassengers()).thenReturn(List.of(
                new Passenger("John", "Doe", "123456789"),
                new Passenger("Jane", "Smith", "987654321")
        ));

        mockMvc.perform(get("/api/passengers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].lastName").value("Doe"))
                .andExpect(jsonPath("$[0].phoneNumber").value("123456789"))
                .andExpect(jsonPath("$[1].firstName").value("Jane"))
                .andExpect(jsonPath("$[1].lastName").value("Smith"))
                .andExpect(jsonPath("$[1].phoneNumber").value("987654321"));

        verify(passengerService).getAllPassengers();
    }

    @Test
    public void testGetPassengerById() throws Exception {
        Passenger passenger = new Passenger("Alice", "Johnson", "555555555");
        when(passengerService.getPassengerById(1)).thenReturn(passenger);

        mockMvc.perform(get("/api/passengers/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value("Alice"))
                .andExpect(jsonPath("$.lastName").value("Johnson"))
                .andExpect(jsonPath("$.phoneNumber").value("555555555"));

        verify(passengerService).getPassengerById(1);
    }



    @Test
    public void testDeletePassenger() throws Exception {
        mockMvc.perform(delete("/api/passengers/1"))
                .andExpect(status().isOk());

        verify(passengerService).deletePassenger(1);
    }
}
