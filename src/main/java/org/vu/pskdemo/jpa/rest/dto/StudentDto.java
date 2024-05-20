package org.vu.pskdemo.jpa.rest.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDto {

    private String name;

    private String surname;

    private Integer passNumber;

    private List<String> groupName;
}