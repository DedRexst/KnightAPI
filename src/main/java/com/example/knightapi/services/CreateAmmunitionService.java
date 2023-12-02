package com.example.knightapi.services;

import com.example.knightapi.dto.*;
import com.example.knightapi.models.ArmorKneePads;
import com.example.knightapi.models.ItemInHand;
import com.example.knightapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAmmunitionService {
    private final ItemInHandRepository itemInHandRepository;
    private final ArmorBootsRepository armorBootsRepository;
    private final ArmorGlovesRepository armorGlovesRepository;
    private final ArmorKneePadsRepository armorKneePadsRepository;
    private final ChestplateRepository chestplateRepository;

    @Autowired
    public CreateAmmunitionService(ItemInHandRepository itemInHandRepository, ArmorBootsRepository armorBootsRepository,
                                   ArmorGlovesRepository armorGlovesRepository, ArmorKneePadsRepository armorKneePadsRepository,
                                   ChestplateRepository chestplateRepository) {
        this.itemInHandRepository = itemInHandRepository;
        this.armorBootsRepository = armorBootsRepository;
        this.armorGlovesRepository = armorGlovesRepository;
        this.armorKneePadsRepository = armorKneePadsRepository;
        this.chestplateRepository = chestplateRepository;
    }


    public ItemInHand createItemInHandDto(ItemInHandDto itemInHandDto){
        return itemInHandRepository.save(ItemInHandDto.dtoToModel(itemInHandDto));
    }

    public void createChestplate(ChestplateDto chestplateDto) {
        chestplateRepository.save(ChestplateDto.dtoToModel(chestplateDto));
    }

    public void createArmorBoots(ArmorBootsDto armorBootsDto) {
        armorBootsRepository.save(ArmorBootsDto.dtoToModel(armorBootsDto));
    }
    public ArmorKneePads createArmorKneePads(ArmorKneePadsDto armorKneePadsDto) {
        return armorKneePadsRepository.save(ArmorKneePadsDto.dtoToModel(armorKneePadsDto));
    }
    public void createArmorGloves(ArmorGlovesDto armorGlovesDto){
        armorGlovesRepository.save(ArmorGlovesDto.dtoToModel(armorGlovesDto));
    }
}
