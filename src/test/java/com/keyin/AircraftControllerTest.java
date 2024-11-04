package com.keyin;

import com.keyin.aircraft.AircraftController;
import com.keyin.aircraft.AircraftService;
import com.keyin.aircraft.Aircraft;
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

@WebMvcTest(AircraftController.class)
public class AircraftControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AircraftService aircraftService;

    @Test
    public void testGetAllAircraft() throws Exception {
        when(aircraftService.getAllAircraft()).thenReturn(List.of(
                new Aircraft("Passenger", "Boeing", 200),
                new Aircraft("Passenger", "Airbus", 180)
        ));

        mockMvc.perform(get("/api/aircraft"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].type").value("Passenger"))
                .andExpect(jsonPath("$[0].airlineName").value("Boeing"))
                .andExpect(jsonPath("$[0].numberOfPassengers").value(200))
                .andExpect(jsonPath("$[1].type").value("Passenger"))
                .andExpect(jsonPath("$[1].airlineName").value("Airbus"))
                .andExpect(jsonPath("$[1].numberOfPassengers").value(180));

        verify(aircraftService).getAllAircraft();
    }


    @Test
    public void testGetAircraftById() throws Exception {
        Aircraft aircraft = new Aircraft("Passenger", "Delta", 220);
        when(aircraftService.getAircraftById(1)).thenReturn(aircraft);

        mockMvc.perform(get("/api/aircraft/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.type").value("Passenger"))
                .andExpect(jsonPath("$.airlineName").value("Delta"))
                .andExpect(jsonPath("$.numberOfPassengers").value(220));

        verify(aircraftService).getAircraftById(1);
    }


    @Test
    public void testDeleteAircraft() throws Exception {
        mockMvc.perform(delete("/api/aircraft/1"))
                .andExpect(status().isOk());

        verify(aircraftService).deleteAircraft(1);
    }
}
