package com.example.knightapi.controllers;

import com.example.knightapi.dto.*;
import com.example.knightapi.services.CreateAmmunitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/create-ammunition")
public class CreateAmmunitionController {
    private final CreateAmmunitionService createAmmunitionService;

    @Autowired
    public CreateAmmunitionController(CreateAmmunitionService createAmmunitionService) {
        this.createAmmunitionService = createAmmunitionService;
    }
    @PutMapping("/item-in-hand")
    private ResponseEntity<HttpStatus> createItemInHand(@RequestBody ItemInHandDto itemInHandDto, BindingResult bindingResult){
        createAmmunitionService.createItemInHandDto(itemInHandDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/chestplate")
    private ResponseEntity<HttpStatus> createChestplate(@RequestBody ChestplateDto chestplateDto, BindingResult bindingResult){
        createAmmunitionService.createChestplate(chestplateDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/armor-boots")
    private ResponseEntity<HttpStatus> createArmorBoots(@RequestBody ArmorBootsDto armorBootsDto, BindingResult bindingResult){
        createAmmunitionService.createArmorBoots(armorBootsDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/armor-knee-pads")
    private ResponseEntity<HttpStatus> createArmorKneePads(@RequestBody ArmorKneePadsDto armorKneePadsDto, BindingResult bindingResult){
        createAmmunitionService.createArmorKneePads(armorKneePadsDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/armor-gloves")
    private ResponseEntity<HttpStatus> createArmorGloves(@RequestBody ArmorGlovesDto armorGlovesDto, BindingResult bindingResult){
        createAmmunitionService.createArmorGloves(armorGlovesDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
