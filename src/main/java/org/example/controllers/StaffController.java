package org.example.controllers;


import org.example.dto.EquipmentDto;
import org.example.dto.StaffDto;
import org.example.services.EquipmentService;
import org.example.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    StaffService staffService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody StaffDto staffDto){
        return staffService.addStaff(staffDto) ?
                ResponseEntity.ok("COMPLETED") :
                ResponseEntity.status(500).body("FAILED");
    }

    @PostMapping("/findall")
    public List<StaffDto> findAll(){
        return staffService.getAllStaff();
    }
}
