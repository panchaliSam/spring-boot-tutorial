package org.example.springboot.service.Impl;

import org.example.springboot.dto.SoftwareEngineerDto;
import org.example.springboot.repository.SoftwareEngineerRepository;
import org.example.springboot.service.SoftwareEngineerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SoftwareEngineerServiceImpl implements SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerServiceImpl(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    @Override
    public List<SoftwareEngineerDto> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll().stream()
                .map(SoftwareEngineerDto::fromEntity)
                .collect(Collectors.toList());
    }
}