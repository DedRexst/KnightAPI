package com.example.knightapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.beans.ConstructorProperties;

@Getter
@Setter
@AllArgsConstructor
public abstract class InventoryDto implements Comparable<InventoryDto>{
    private String name;
    private String type;
    private float weight;
    private float value;

    @Override
    public int compareTo(InventoryDto o) {
        return (int) (this.weight - o.getWeight());
    }

}
