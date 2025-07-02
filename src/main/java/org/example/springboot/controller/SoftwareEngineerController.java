package org.example.springboot.controller;

import org.example.springboot.dto.SoftwareEngineerDto;
import org.example.springboot.service.SoftwareEngineerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineerDto> getSoftwareEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoftwareEngineerDto> getSoftwareEngineerById(@PathVariable Integer id) {
        SoftwareEngineerDto dto = softwareEngineerService.getSoftwareEngineerById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<SoftwareEngineerDto> createSoftwareEngineer(@RequestBody SoftwareEngineerDto dto) {
        SoftwareEngineerDto created = softwareEngineerService.createSoftwareEngineer(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SoftwareEngineerDto> updateSoftwareEngineer(
            @PathVariable Integer id,
            @RequestBody SoftwareEngineerDto dto) {
        SoftwareEngineerDto updated = softwareEngineerService.updateSoftwareEngineer(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSoftwareEngineer(@PathVariable Integer id) {
        softwareEngineerService.deleteSoftwareEngineer(id);
        return ResponseEntity.noContent().build();
    }
}