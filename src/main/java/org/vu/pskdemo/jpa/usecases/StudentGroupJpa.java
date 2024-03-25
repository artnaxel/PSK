package org.vu.pskdemo.jpa.usecases;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.vu.pskdemo.jpa.persistence.StudentGroupDao;
import org.vu.pskdemo.jpa.entities.StudentGroup;
import java.util.List;

@Model
public class StudentGroupJpa {

    @Inject
    private StudentGroupDao studentGroupDao;

    @Getter @Setter
    private StudentGroup studentGroup = new StudentGroup();

    @Getter
    private List<StudentGroup> allStudentGroups;

    @PostConstruct
    public void init(){
        loadAllStudentGroups();
    }

    @Transactional
    public void createStudentGroup(){
        this.studentGroupDao.persist(studentGroup);
    }

    private void loadAllStudentGroups(){
        this.allStudentGroups = studentGroupDao.loadAll();
    }
}