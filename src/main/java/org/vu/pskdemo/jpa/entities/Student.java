package org.vu.pskdemo.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private String surname;

    @ManyToMany
    @JoinTable(
                name = "Student_Group",
                joinColumns = @JoinColumn(name = "student_id"),
                inverseJoinColumns = @JoinColumn(name= "studentGroup_id"))
    private List<StudentGroup> studentGroup = new LinkedList<>();

    @ManyToMany
    @JoinTable(
            name = "Student_Course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new LinkedList<>();

}
