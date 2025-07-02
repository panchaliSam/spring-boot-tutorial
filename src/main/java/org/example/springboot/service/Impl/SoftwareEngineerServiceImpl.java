package org.example.springboot.service.Impl;

import org.example.springboot.dto.SoftwareEngineerDto;
import org.example.springboot.entity.SoftwareEngineer;
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
    public SoftwareEngineerDto createSoftwareEngineer(SoftwareEngineerDto dto) {
        SoftwareEngineer entity = dto.toEntity();
        SoftwareEngineer saved = softwareEngineerRepository.save(entity);
        return SoftwareEngineerDto.fromEntity(saved);
    }

    @Override
    public List<SoftwareEngineerDto> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll().stream()
                .map(SoftwareEngineerDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public SoftwareEngineerDto getSoftwareEngineerById(Integer id) {
        SoftwareEngineer entity = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SoftwareEngineer not found with id: " + id));
        return SoftwareEngineerDto.fromEntity(entity);
    }

    @Override
    public SoftwareEngineerDto updateSoftwareEngineer(Integer id, SoftwareEngineerDto dto) {
        SoftwareEngineer existing = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SoftwareEngineer not found with id: " + id));

        existing.setName(dto.getName());
        existing.setTechStack(dto.getTechStack());

        SoftwareEngineer updated = softwareEngineerRepository.save(existing);
        return SoftwareEngineerDto.fromEntity(updated);
    }

    @Override
    public void deleteSoftwareEngineer(Integer id) {
        SoftwareEngineer existing = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SoftwareEngineer not found with id: " + id));
        softwareEngineerRepository.delete(existing);
    }
}