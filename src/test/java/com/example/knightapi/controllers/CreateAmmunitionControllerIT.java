package com.example.knightapi.controllers;

import com.example.knightapi.dto.*;
import com.example.knightapi.models.ArmorKneePads;
import com.example.knightapi.repository.KnightRepository;
import com.example.knightapi.services.BusinessService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false)
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
@Sql(value = {"/cleanDatabase.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class CreateAmmunitionControllerIT {
    @Autowired
    MockMvc mockMvc;

    private GreenMail smtpServer;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
            smtpServer = new GreenMail(ServerSetup.SMTP);
        smtpServer.start();
    }

    @AfterEach
    public void tearDown() {
        smtpServer.stop();
    }
    @Test
    void createItemInHandTest() throws Exception {
        ItemInHandDto itemInHandDto = new ItemInHandDto("sldfask", "Sword", 5,2);
        var requestBuilder = put("/create-ammunition/item-in-hand")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(itemInHandDto));
        this.mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(itemInHandDto.getName()));
    }
    @Test
    void createChestplateTest() throws Exception{
        ChestplateDto chestplateDto = new ChestplateDto("sldfask", "Sword", 5,2);
        var requestBuilder = put("/create-ammunition/chestplate")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(chestplateDto));
        this.mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(chestplateDto.getName()));
    }
    @Test
    void createKneePadsTest() throws Exception{
        ArmorKneePadsDto kneePadsDto = new ArmorKneePadsDto("sldfask", "Sword", 5,2);
        var requestBuilder = put("/create-ammunition/armor-knee-pads")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(kneePadsDto));
        this.mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(kneePadsDto.getName()));
    }
    @Test
    void createArmorBootsTest() throws Exception{
        ArmorBootsDto armorBootsDto = new ArmorBootsDto("sldfask", "Sword", 5,2);
        var requestBuilder = put("/create-ammunition/armor-boots")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(armorBootsDto));
        this.mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(armorBootsDto.getName()));
    }
    @Test
    void createArmorGlovesTest() throws Exception{
        ArmorGlovesDto armorGlovesDto = new ArmorGlovesDto("sldfask", "Sword", 5,2);
        var requestBuilder = put("/create-ammunition/armor-gloves")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(armorGlovesDto));
        this.mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(armorGlovesDto.getName()));
    }
}