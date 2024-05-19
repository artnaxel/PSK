package org.vu.pskdemo.jpa.rest.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDto {

    private String name;

    private Integer cardNumber;

    private List<String> groupName;
}