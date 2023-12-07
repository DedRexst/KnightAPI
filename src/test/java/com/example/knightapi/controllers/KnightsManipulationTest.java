package com.example.knightapi.controllers;

import com.example.knightapi.dto.ItemInHandDto;
import com.example.knightapi.dto.KnightDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false)
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
@Sql(value = {"/Dump20231203.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/cleanDatabase.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class KnightsManipulationTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void createKnight() throws Exception {
        var requestBuilder = put("/knights-manipulation")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(
                        """
                {
                    "armorBoots": {
                    "name": "Talaria",
                            "type": "Gods artifact",
                            "weight": 1.5,
                            "value": 42.0
                    },
                    "armorGloves": {
                        "name": "knuckles gloves",
                                "type": "rare artifact",
                                "weight": 1.5,
                                "value": 42.0
                    },
                    "armorKneePads": {
                        "name": "iron knee pads",
                                "type": "common",
                                "weight": 1.5,
                                "value": 42.0
                    },
                    "itemInRightHand": {
                        "name": "durandal",
                                "type": "sword",
                                "weight": 5,
                                "value": 100
                    },
                    "chestplate": {
                        "name": "Armor of Achilles",
                                "type": "Bronse chestplate",
                                "weight": 1.5,
                                "value": 42.0
                    },
                    "itemInLeftHand": {
                        "name": "durandal",
                                "type": "sword",
                                "weight": 5,
                                "value": 100
                    }
                }
                """
                );
        this.mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }

    @Test
    void getKnight() throws Exception {
        var requestBuilder = get("/knights-manipulation/1");
        this.mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }

    @Test
    void patchKnight() {

    }
}