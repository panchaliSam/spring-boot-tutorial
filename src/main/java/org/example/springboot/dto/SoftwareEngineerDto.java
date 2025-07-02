package org.example.springboot.dto;

import org.example.springboot.entity.SoftwareEngineer;

public class SoftwareEngineerDto {
    private Integer id;
    private String name;
    private String techStack;

    // No-args constructor
    public SoftwareEngineerDto() {
    }

    // All-args constructor
    public SoftwareEngineerDto(Integer id, String name, String techStack) {
        this.id = id;
        this.name = name;
        this.techStack = techStack;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public static SoftwareEngineerDto fromEntity(SoftwareEngineer softwareEngineer) {
        return new SoftwareEngineerDto(
                softwareEngineer.getId(),
                softwareEngineer.getName(),
                softwareEngineer.getTechStack()
        );
    }
}