package org.vu.pskdemo.mybatis.usecases;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.vu.pskdemo.mybatis.dao.StudentGroupMapper;
import org.vu.pskdemo.mybatis.dao.StudentMapper;
import org.vu.pskdemo.mybatis.model.Student;
import org.vu.pskdemo.mybatis.model.StudentGroup;

import java.util.List;
import java.util.Map;

@Model
public class StudentsForGroupMyBatis {
    @Inject
    private StudentMapper studentMapper;

    @Inject
    private StudentGroupMapper studentGroupMapper;

    @Getter
    private List<Student> allStudents;

    @Getter @Setter
    private Student studentToCreate = new Student();

    @Getter @Setter
    private StudentGroup studentGroup;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long studentGroupId = Long.parseLong(requestParameters.get("studentGroupId"));
        loadAllStudents(studentGroupId);
        this.studentGroup = studentGroupMapper.selectByPrimaryKey(studentGroupId);
    }

    private void loadAllStudents(Long groupId) {
        this.allStudents = studentMapper.selectByGroupId(groupId);
    }

    @Transactional
    public void createStudent() {
        studentToCreate.setStudentgroupId(this.studentGroup.getId());
        studentMapper.insert(studentToCreate);
    }

}
