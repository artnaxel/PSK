package org.vu.pskdemo.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    private Integer capacity;

    @Basic
    private Integer grade;

    @OneToMany(mappedBy = "course")
    private List<Student> students;

}
