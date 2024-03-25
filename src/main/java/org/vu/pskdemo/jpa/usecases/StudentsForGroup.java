package org.vu.pskdemo.jpa.usecases;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.vu.pskdemo.jpa.entities.Student;
import org.vu.pskdemo.jpa.entities.StudentGroup;
import org.vu.pskdemo.jpa.persistence.StudentDao;
import org.vu.pskdemo.jpa.persistence.StudentGroupDao;

// includes both @Named and @RequestScoped
@Model
public class StudentsForGroup implements Serializable {

    @Inject
    private StudentGroupDao studentGroupDAO;

    @Inject
    private StudentDao studentsDAO;

    @Getter @Setter
    private StudentGroup studentGroup;

    @Getter @Setter
    private Student studentToCreate = new Student();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long studentGroupId = Long.parseLong(requestParameters.get("studentGroupId"));
        this.studentGroup = studentGroupDAO.findOne(studentGroupId);
    }

    @Transactional
    public void createStudent() {
        List<StudentGroup> studentGroups = studentToCreate.getStudentGroup();
        this.studentGroup.getStudents().add(studentToCreate);
        studentGroups.add(this.studentGroup);
        studentsDAO.persist(studentToCreate);
    }
}