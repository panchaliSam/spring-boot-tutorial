package org.example.springboot.service;

import org.example.springboot.dto.SoftwareEngineerDto;

import java.util.List;

public interface SoftwareEngineerService {
    SoftwareEngineerDto createSoftwareEngineer(SoftwareEngineerDto dto);
    List<SoftwareEngineerDto> getAllSoftwareEngineers();
    SoftwareEngineerDto getSoftwareEngineerById(Integer id);
    SoftwareEngineerDto updateSoftwareEngineer(Integer id, SoftwareEngineerDto dto);
    void deleteSoftwareEngineer(Integer id);
}