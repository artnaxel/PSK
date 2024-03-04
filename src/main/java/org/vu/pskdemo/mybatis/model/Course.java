package org.vu.pskdemo.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private Long id;

    private String title;

    private Integer capacity;

    private Integer grade;

    private List<Long> studentIds;
}
