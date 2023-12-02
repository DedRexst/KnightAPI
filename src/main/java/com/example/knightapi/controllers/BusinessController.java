package com.example.knightapi.controllers;

import com.example.knightapi.dto.InventoryDto;
import com.example.knightapi.services.BusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/{id}")
public class BusinessController {
    private final BusinessService businessService;
    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping("/sort-knight-ammunition")
    public ArrayList<InventoryDto> sortKnightAmmunition(@PathVariable int id){
        return businessService.getSortedListOfKnightAmmunition(id);
    }

    @GetMapping("/get-sum-value-knight-ammunition")
    public double getSumValueKnightAmmunition(@PathVariable int id){
        return businessService.getSumValueKnightAmmunition(id);
    }

}
