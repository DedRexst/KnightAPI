package com.example.knightapi.controllers;


import com.example.knightapi.dto.KnightDto;
import com.example.knightapi.services.KnightsManipulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/knights-manipulation")
public class KnightsManipulation {
    private final KnightsManipulationService knightsManipulationService;

    @Autowired
    public KnightsManipulation(KnightsManipulationService knightsManipulationService) {
        this.knightsManipulationService = knightsManipulationService;
    }

    @PutMapping()
    public ResponseEntity<HttpStatus> createKnight(@RequestBody KnightDto knightDto, BindingResult bindingResult){
        knightsManipulationService.createKnight(knightsManipulationService.addConnections(KnightDto.dtoToModel(knightDto), knightDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public KnightDto getKnight(@PathVariable int id){
        return knightsManipulationService.getKnight(id);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> patchKnight(@PathVariable int id, @RequestBody KnightDto knightDto, BindingResult bindingResult){
        knightsManipulationService.patchKnight(knightDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
