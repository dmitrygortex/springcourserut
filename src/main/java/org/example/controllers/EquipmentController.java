package org.example.controllers;
import org.example.dto.EquipmentDto;
import org.example.entities.Client;
import org.example.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    @Autowired
    EquipmentService equipmentService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody EquipmentDto equipmentDto){
        return equipmentService.addEquipment(equipmentDto) ?
                ResponseEntity.ok("COMPLETED") :
                ResponseEntity.status(500).body("FAILED");
    }

    @PostMapping("/findall")
    public List<EquipmentDto> findAll(){
        return equipmentService.getAllEquipment();
    }



}
