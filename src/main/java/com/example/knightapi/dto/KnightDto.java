package com.example.knightapi.dto;

import com.example.knightapi.models.Knight;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.knightapi.models.Knight}
 */
@Value
public class KnightDto implements Serializable {
    ArmorBootsDto armorBoots;
    ArmorGlovesDto armorGloves;
    ArmorKneePadsDto armorKneePads;
    ItemInHandDto itemInRightHand;
    ItemInHandDto itemInLeftHand;
    ChestplateDto chestplate;
    public static Knight dtoToModel(KnightDto knightDto){
        Knight knight = new Knight();
        return knight;
    }
    public static KnightDto modelToDto(Knight knight){
        return new KnightDto(ArmorBootsDto.modelToDto(knight.getArmorBootsID()),
                ArmorGlovesDto.modelToDto(knight.getArmorGlovesID()),
                ArmorKneePadsDto.modelToDto(knight.getArmorKneePadsID()),
                ItemInHandDto.modelToDto(knight.getItemInRightHandID()),
                ItemInHandDto.modelToDto(knight.getItemInLeftHandID()),
                ChestplateDto.modelToDto(knight.getChestplateID())
        );
    }
}