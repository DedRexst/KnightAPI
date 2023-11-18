package com.example.knightapi.dto;

import com.example.knightapi.models.ArmorBoots;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ArmorBoots}
 */
@Value
public class ArmorBootsDto extends InventoryDto implements Serializable {

    public ArmorBootsDto(String name, String type, float weight, float value) {
        super(name, type, weight, value);
    }

    public static ArmorBoots dtoToModel(ArmorBootsDto armorBootsDto){
        ArmorBoots armorBoots = new ArmorBoots();
        armorBoots.setName(armorBootsDto.getName());
        armorBoots.setType(armorBootsDto.getType());
        armorBoots.setWeight(armorBootsDto.getWeight());
        armorBoots.setValue(armorBootsDto.getValue());
        return armorBoots;
    }
    public static ArmorBootsDto modelToDto(ArmorBoots armorBoots){
        return new ArmorBootsDto(armorBoots.getName(),armorBoots.getType(), armorBoots.getWeight(),armorBoots.getValue());
    }
}