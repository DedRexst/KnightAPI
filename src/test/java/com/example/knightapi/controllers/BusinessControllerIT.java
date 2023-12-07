package com.example.knightapi.controllers;

import com.example.knightapi.repository.KnightRepository;
import com.example.knightapi.services.BusinessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false)
class BusinessControllerIT {
    @Autowired
    MockMvc mockMvc;




    @Test
    void sortKnightAmmunition() throws Exception {
        var requestBuilder = get("/1/sort-knight-ammunition");
        this.mockMvc.perform(requestBuilder).andExpectAll(
                status().isOk(),
                content().contentType(MediaType.APPLICATION_JSON),
                content().json("""
                        [
                  {
                    "name": "iron knee pads",
                    "type": "common",
                    "weight": 10.0,
                    "value": 44.0
                  },
                  {
                    "name": "Talaria",
                    "type": "Gods artifact",
                    "weight": 15.0,
                    "value": 44.0
                  },
                  {
                    "name": "knuckles gloves",
                    "type": "rare artifact",
                    "weight": 25.0,
                    "value": 15.0
                  },
                  {
                    "name": "Armor of Achilles",
                    "type": "Bronse chestplate",
                    "weight": 33.0,
                    "value": 46.0
                  },
                  {
                    "name": "durandal",
                    "type": "sword",
                    "weight": 55.0,
                    "value": 18.0
                  },
                  {
                    "name": "durandal",
                    "type": "sword",
                    "weight": 55.0,
                    "value": 18.0
                  }
                ]
                """)
        );
    }
    @Test
    void getSumValueKnightAmmunition() throws Exception {
        var requestBuilder = get("/1/get-sum-value-knight-ammunition");
        this.mockMvc.perform(requestBuilder).andExpectAll(
                status().isOk(),
                content().contentType(MediaType.APPLICATION_JSON),
                content().string("185.0")
        );
    }
}