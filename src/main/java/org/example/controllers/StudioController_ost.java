//package org.example.controllers;
//
//import org.example.entities.Equipment;
//import org.example.entities.Staff;
//import org.example.entities.Studio;
//import org.example.services.EquipmentService;
//import org.example.services.StaffService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/studio")
//public class StudioController_ost {
//
//    @Autowired
//    private EquipmentService equipmentService;
//
//    @Autowired
//    private StaffService staffService;
//
//    @PostMapping("/equipment")
//    public ResponseEntity<String> addEquipment(@RequestBody Equipment equipment) {
//        boolean addSuccess = equipmentService.addEquipment(equipment);
//        if (addSuccess) {
//            return ResponseEntity.ok("Equipment successfully added.");
//        } else {
//            return ResponseEntity.status(409).body("Failed to add equipment.");
//        }
//    }
//
//    @DeleteMapping("/equipment/{equipmentId}")
//    public ResponseEntity<String> removeEquipment(@PathVariable int equipmentId) {
//        boolean removeSuccess = equipmentService.removeEquipment(equipmentId);
//        if (removeSuccess) {
//            return ResponseEntity.ok("Equipment successfully removed.");
//        } else {
//            return ResponseEntity.status(409).body("Failed to remove equipment.");
//        }
//    }
//
//    @PutMapping("/equipment/{equipmentId}")
//    public ResponseEntity<String> updateEquipment(@PathVariable int equipmentId, @RequestBody Equipment equipment) {
//        equipment.setId(equipmentId);
//        boolean updateSuccess = equipmentService.updateEquipment(equipment);
//        if (updateSuccess) {
//            return ResponseEntity.ok("Equipment successfully updated.");
//        } else {
//            return ResponseEntity.status(409).body("Failed to update equipment.");
//        }
//    }
//
//    @GetMapping("/equipment")
//    public ResponseEntity<List<Equipment>> getAllEquipment() {
//        List<Equipment> equipmentList = equipmentService.getAllEquipment();
//        return ResponseEntity.ok(equipmentList);
//    }
//
//    @PostMapping("/staff")
//    public ResponseEntity<String> addStaff(@RequestBody Staff staff) {
//        staffService.addStaff(staff);
//        return ResponseEntity.ok("Staff successfully added.");
//    }
//
//    @DeleteMapping("/staff/{staffId}")
//    public ResponseEntity<String> removeStaff(@PathVariable int staffId) {
//        staffService.removeStaff(staffId);
//        return ResponseEntity.ok("Staff successfully removed.");
//    }
//
//    @PutMapping("/staff/{staffId}")
//    public ResponseEntity<String> updateStaff(@PathVariable int staffId, @RequestBody Staff staff) {
//        staff.setId(staffId);
//        staffService.updateStaff(staff);
//        return ResponseEntity.ok("Staff successfully updated.");
//    }
//
//    @GetMapping("/staff")
//    public ResponseEntity<Iterable<Staff>> getAllStaff() {
//        Iterable<Staff> staffList = staffService.getAllStaff();
//        return ResponseEntity.ok(staffList);
//    }
//
//    @GetMapping("/studios/search")
//    public ResponseEntity<List<Studio>> searchStudios(
//            @RequestParam LocalDateTime startBookingDate,
//            @RequestParam LocalDateTime endBookingDate,
//            @RequestParam(required = false) String address,
//            @RequestParam(required = false) Integer minRentFee,
//            @RequestParam(required = false) Integer maxRentFee,
//            @RequestParam(required = false) String equipmentType) {
//
//        List<Studio> availableStudios = bookingDomainService.searchAvailableStudios(
//                startBookingDate, endBookingDate, address, minRentFee, maxRentFee, equipmentType);
//        return ResponseEntity.ok(availableStudios);
//    }
//}
