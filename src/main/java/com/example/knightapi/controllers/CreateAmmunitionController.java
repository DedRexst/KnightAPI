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
    public ItemInHandDto createItemInHand(@RequestBody ItemInHandDto itemInHandDto, BindingResult bindingResult){
        return ItemInHandDto.modelToDto(createAmmunitionService.createItemInHandDto(itemInHandDto));
    }
    @PutMapping("/chestplate")
    public ResponseEntity<HttpStatus> createChestplate(@RequestBody ChestplateDto chestplateDto, BindingResult bindingResult){
        createAmmunitionService.createChestplate(chestplateDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/armor-boots")
    public ResponseEntity<HttpStatus> createArmorBoots(@RequestBody ArmorBootsDto armorBootsDto, BindingResult bindingResult){
        createAmmunitionService.createArmorBoots(armorBootsDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/armor-knee-pads")
    public ArmorKneePadsDto createArmorKneePads(@RequestBody ArmorKneePadsDto armorKneePadsDto, BindingResult bindingResult){

        return ArmorKneePadsDto.modelToDto(createAmmunitionService.createArmorKneePads(armorKneePadsDto));
    }
    @PutMapping("/armor-gloves")
    public ResponseEntity<HttpStatus> createArmorGloves(@RequestBody ArmorGlovesDto armorGlovesDto, BindingResult bindingResult){
        createAmmunitionService.createArmorGloves(armorGlovesDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
