package com.example.knightapi.services;

import com.example.knightapi.dto.*;
import com.example.knightapi.models.Knight;
import com.example.knightapi.repository.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;

@Service
public class BusinessService implements Comparator {
    private final KnightRepository knightRepository;

    @Autowired
    public BusinessService(KnightRepository knightRepository) {
        this.knightRepository = knightRepository;
    }
    private ArrayList<InventoryDto> getInventoryDtoArrayList(Knight knight){
        ArrayList<InventoryDto> arrayList = new ArrayList<>();
        arrayList.add(ArmorBootsDto.modelToDto(knight.getArmorBootsID()));
        arrayList.add(ArmorGlovesDto.modelToDto(knight.getArmorGlovesID()));
        arrayList.add(ArmorKneePadsDto.modelToDto(knight.getArmorKneePadsID()));
        arrayList.add(ItemInHandDto.modelToDto(knight.getItemInRightHandID()));
        arrayList.add(ItemInHandDto.modelToDto(knight.getItemInLeftHandID()));
        arrayList.add(ChestplateDto.modelToDto(knight.getChestplateID()));
        return arrayList;
    }

    public ArrayList<InventoryDto> getSortedListOfKnightAmmution(int id) {
        Knight knight = knightRepository.findById(id).get();
        ArrayList<InventoryDto> arrayList = getInventoryDtoArrayList(knight);

        arrayList.sort(this);
        return arrayList;

    }


    @Override
    public int compare(Object o1, Object o2) {
        InventoryDto i1 = (InventoryDto) o1;
        InventoryDto i2 = (InventoryDto) o2;
        return i1.compareTo(i2);
    }

    public double getSumValueKnightAmmunition(int id) {
        double value = 0;
        Knight knight = knightRepository.findById(id).get();
        ArrayList<InventoryDto> arrayList = getInventoryDtoArrayList(knight);
        for (InventoryDto inventoryDto:
             arrayList) {
            value += inventoryDto.getValue();
        }
        return value;
    }
}
