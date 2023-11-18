package com.example.knightapi.services;

import com.example.knightapi.dto.*;
import com.example.knightapi.models.Knight;
import com.example.knightapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KnightsManipulationService {
    private final KnightRepository knightRepository;
    private final ItemInHandRepository itemInHandRepository;
    private final ArmorBootsRepository armorBootsRepository;
    private final ArmorKneePadsRepository armorKneePadsRepository;
    private final ArmorGlovesRepository armorGlovesRepository;
    private final ChestplateRepository chestplateRepository;
    @Autowired
    public KnightsManipulationService(KnightRepository knightRepository, ItemInHandRepository itemInHandRepository, ArmorBootsRepository armorBootsRepository, ArmorKneePadsRepository armorKneePadsRepository, ArmorGlovesRepository armorGlovesRepository, ChestplateRepository chestplateRepository) {
        this.knightRepository = knightRepository;
        this.itemInHandRepository = itemInHandRepository;
        this.armorBootsRepository = armorBootsRepository;
        this.armorKneePadsRepository = armorKneePadsRepository;
        this.armorGlovesRepository = armorGlovesRepository;
        this.chestplateRepository = chestplateRepository;
    }

    public void createKnight(Knight knight) {
        knightRepository.save(knight);
    }

    public Knight addConnections(Knight knight, KnightDto knightDto) {
        knight.setArmorBootsID(armorBootsRepository.findArmorBootsByName(knightDto.getArmorBoots().getName()).get());
        knight.setChestplateID(chestplateRepository.findChestplateByName(knightDto.getChestplate().getName()).get());
        knight.setArmorGlovesID(armorGlovesRepository.findArmorGlovesByName(knightDto.getArmorGloves().getName()).get());
        knight.setItemInLeftHandID(itemInHandRepository.findItemInHandByName(knightDto.getItemInLeftHand().getName()).get());
        knight.setItemInRightHandID(itemInHandRepository.findItemInHandByName(knightDto.getItemInRightHand().getName()).get());
        knight.setArmorKneePadsID(armorKneePadsRepository.findArmorKneePadsByName(knightDto.getArmorKneePads().getName()).get());
        return knight;
    }

    public KnightDto getKnight(int id) {
        return KnightDto.modelToDto(knightRepository.getReferenceById(id));
    }

    public void patchKnight(KnightDto knightDto, int id) {
        Knight knight = knightRepository.findById(id).get();
        addConnections(knight, knightDto);
        knightRepository.save(knight);
    }
}
