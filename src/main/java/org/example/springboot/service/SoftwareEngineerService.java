package org.example.springboot.service;

import org.example.springboot.dto.SoftwareEngineerDto;

import java.util.List;

public interface SoftwareEngineerService {
    List<SoftwareEngineerDto> getAllSoftwareEngineers();
}
