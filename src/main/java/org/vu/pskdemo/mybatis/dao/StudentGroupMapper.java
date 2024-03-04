package org.vu.pskdemo.mybatis.dao;

import org.mybatis.cdi.Mapper;
import org.vu.pskdemo.mybatis.model.StudentGroup;

import java.util.List;

@Mapper
public interface StudentGroupMapper {
    Long insert(StudentGroup studentGroup);

    StudentGroup selectById(Long id);

    Long update(StudentGroup studentGroup);

    Long delete(Long id);

    Long deleteAll();

    List<StudentGroup> selectAll();

    List<StudentGroup> selectByGrade(Integer grade);
}
