package org.vu.pskdemo.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    private String title;

    @Basic(optional = false)
    private Integer capacity;

    @Basic
    private Integer grade;

    @OneToMany(mappedBy = "studentGroup")
    private List<Student> students;
}
