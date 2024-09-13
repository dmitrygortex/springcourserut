package org.example.controllers;

import org.example.dto.*;
import org.example.services.BookingDomainService;
import org.example.services.StudioDomainService;
import org.example.services.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/studio")
public class StudioController {

    @Autowired
    StudioService studioService;

    @Autowired
    StudioDomainService studioDomainService;

    @Autowired
    BookingDomainService bookingDomainService;

    @GetMapping("/findall")
    public List<StudioDto> getAllStudios(){
        return studioService.getAllStudio();
    }

//    @GetMapping("/findall/{rentfee}")
//    public List<StudioDto> getAllStudios(@PathVariable int rentfee){
//        return studioService.getAllStudio();
//    }

    @GetMapping("/{id}")
    public StudioDto getStudioById(@PathVariable Integer id){
        return studioService.getStudioById(id);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addStudio(@RequestBody StudioCreateDto studioCreateDto){
        return studioService.addStudio(studioCreateDto) ? ResponseEntity.ok("COMPLETED") :
                ResponseEntity.status(500).body("FAILED");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudio(@PathVariable Integer id){
        return studioService.removeStudio(id) ? ResponseEntity.ok("COMPLETED") :
                ResponseEntity.status(500).body("FAILED");
    }
//    @PostMapping("/equipment/{equipmentId}/{studioId}")
//    boolean addEquipmentToStudio(
//            @PathVariable Integer studioId,
//            @RequestBody EquipmentCreateDto equipmentCreateDto){
//        equipmentCreateDto.setStudioDto(studioService.getStudioById(studioId));
//        studioDomainService.addEquipment(equipmentCreateDto);
//        return true;
//    }

    @PostMapping("/equipment/{studioId}")
    public ResponseEntity<String> addEquipmentToStudio(
            @PathVariable Integer studioId,
            @RequestBody EquipmentCreateDto equipmentCreateDto){
        return studioDomainService.addEquipment(equipmentCreateDto, studioId) ?
                ResponseEntity.ok("COMPLETED") :
                ResponseEntity.status(500).body("FAILED");
    }

    @PostMapping("/search")
    public List<StudioSearchDto> search(
            @RequestParam LocalDateTime startBookingDate,
            @RequestParam LocalDateTime endBookingDate,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) Integer minRentFee,
            @RequestParam(required = false) Integer maxRentFee,
            @RequestParam(required = false) String equipmentType
    ){
        return bookingDomainService.searchAvailableStudios(startBookingDate, endBookingDate, address,
                minRentFee, maxRentFee, equipmentType);
    }
}
