package com.example.knightapi.dto;

import com.example.knightapi.models.ArmorKneePads;
import com.example.knightapi.models.Chestplate;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Chestplate}
 */
@Value
public class ChestplateDto extends InventoryDto implements Serializable {

    public ChestplateDto(String name, String type, float weight, float value) {
        super(name, type, weight, value);
    }

    public static Chestplate dtoToModel(ChestplateDto chestplateDto){
        Chestplate itemInHand = new Chestplate();
        itemInHand.setName(chestplateDto.getName());
        itemInHand.setType(chestplateDto.getType());
        itemInHand.setWeight(chestplateDto.getWeight());
        itemInHand.setValue(chestplateDto.getValue());
        return itemInHand;
    }
    public static ChestplateDto modelToDto(Chestplate chestplate){
        return new ChestplateDto(chestplate.getName(),chestplate.getType(), chestplate.getWeight(),chestplate.getValue());
    }
}