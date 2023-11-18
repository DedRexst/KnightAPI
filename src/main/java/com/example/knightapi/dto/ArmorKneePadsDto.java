package com.example.knightapi.dto;

import com.example.knightapi.models.ArmorGloves;
import com.example.knightapi.models.ArmorKneePads;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ArmorKneePads}
 */
@Value
public class ArmorKneePadsDto extends InventoryDto implements Serializable {

    public ArmorKneePadsDto(String name, String type, float weight, float value) {
        super(name, type, weight, value);
    }

    public static ArmorKneePads dtoToModel(ArmorKneePadsDto armorKneePadsDto){
        ArmorKneePads armorKneePads = new ArmorKneePads();
        armorKneePads.setName(armorKneePadsDto.getName());
        armorKneePads.setType(armorKneePadsDto.getType());
        armorKneePads.setWeight(armorKneePadsDto.getWeight());
        armorKneePads.setValue(armorKneePadsDto.getValue());
        return armorKneePads;
    }
    public static ArmorKneePadsDto modelToDto(ArmorKneePads armorKneePads){
        return new ArmorKneePadsDto(armorKneePads.getName(),armorKneePads.getType(), armorKneePads.getWeight(),armorKneePads.getValue());
    }
}