package org.vu.pskdemo.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private int id;

    private String name;

    private String surname;

    private Long studentGroupId;

    private List<Long> courseIds;
}
