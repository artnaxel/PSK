package org.vu.pskdemo.mybatis.usecases;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.vu.pskdemo.mybatis.dao.StudentGroupMapper;
import org.vu.pskdemo.mybatis.model.StudentGroup;

import java.util.List;

@Model
public class StudentGroupsMyBatis {
    @Inject
    private StudentGroupMapper studentGroupMapper;


    @Getter
    private List<StudentGroup> allStudentGroups;

    @Getter @Setter
    private StudentGroup studentGroup = new StudentGroup();

    @PostConstruct
    public void init() {
        this.loadAllTeams();
    }

    private void loadAllTeams() {
        this.allStudentGroups = studentGroupMapper.selectAll();
    }

    @Transactional
    public String createStudentGroup() {
        studentGroupMapper.insert(studentGroup);
        return "/myBatis/groups?faces-redirect=true";
    }

}
