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
    public ChestplateDto createChestplate(@RequestBody ChestplateDto chestplateDto, BindingResult bindingResult){

        return ChestplateDto.modelToDto(createAmmunitionService.createChestplate(chestplateDto));
    }
    @PutMapping("/armor-boots")
    public ArmorBootsDto createArmorBoots(@RequestBody ArmorBootsDto armorBootsDto, BindingResult bindingResult){

        return ArmorBootsDto.modelToDto(createAmmunitionService.createArmorBoots(armorBootsDto));
    }
    @PutMapping("/armor-knee-pads")
    public ArmorKneePadsDto createArmorKneePads(@RequestBody ArmorKneePadsDto armorKneePadsDto, BindingResult bindingResult){
        return ArmorKneePadsDto.modelToDto(createAmmunitionService.createArmorKneePads(armorKneePadsDto));
    }
    @PutMapping("/armor-gloves")
    public ArmorGlovesDto createArmorGloves(@RequestBody ArmorGlovesDto armorGlovesDto, BindingResult bindingResult){
        return ArmorGlovesDto.modelToDto(createAmmunitionService.createArmorGloves(armorGlovesDto));
    }
}
