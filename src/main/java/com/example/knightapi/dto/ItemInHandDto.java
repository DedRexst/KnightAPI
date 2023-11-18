package com.example.knightapi.dto;

import com.example.knightapi.models.ItemInHand;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ItemInHand}
 */
@Value
public class ItemInHandDto extends InventoryDto implements Serializable {

    public ItemInHandDto(String name, String type, float weight, float value) {
        super(name, type, weight, value);
    }

    public static ItemInHand dtoToModel(ItemInHandDto itemInHandDto){
        ItemInHand itemInHand = new ItemInHand();
        itemInHand.setName(itemInHandDto.getName());
        itemInHand.setType(itemInHandDto.getType());
        itemInHand.setWeight(itemInHandDto.getWeight());
        itemInHand.setValue(itemInHandDto.getValue());
        return itemInHand;
    }
    public static ItemInHandDto modelToDto(ItemInHand itemInHand){
        return new ItemInHandDto(itemInHand.getName(),itemInHand.getType(), itemInHand.getWeight(),itemInHand.getValue());
    }
}