package org.example.springboot.service.Impl;

import org.example.springboot.entity.SoftwareEngineer;
import org.example.springboot.repository.SoftwareEngineerRepository;
import org.example.springboot.service.SoftwareEngineerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerServiceImpl implements SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerServiceImpl(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    @Override
    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }
}
