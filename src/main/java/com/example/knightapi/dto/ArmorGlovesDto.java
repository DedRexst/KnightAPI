package com.example.knightapi.dto;

import com.example.knightapi.models.ArmorBoots;
import com.example.knightapi.models.ArmorGloves;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ArmorGloves}
 */
@Value
public class ArmorGlovesDto extends InventoryDto implements Serializable {

    public ArmorGlovesDto(String name, String type, float weight, float value) {
        super(name, type, weight, value);
    }

    public static ArmorGloves dtoToModel(ArmorGlovesDto armorGlovesDto){
        ArmorGloves armorGloves = new ArmorGloves();
        armorGloves.setName(armorGlovesDto.getName());
        armorGloves.setType(armorGlovesDto.getType());
        armorGloves.setWeight(armorGlovesDto.getWeight());
        armorGloves.setValue(armorGlovesDto.getValue());
        return armorGloves;
    }
    public static ArmorGlovesDto modelToDto(ArmorGloves armorGloves){
        return new ArmorGlovesDto(armorGloves.getName(),armorGloves.getType(), armorGloves.getWeight(),armorGloves.getValue());
    }
}