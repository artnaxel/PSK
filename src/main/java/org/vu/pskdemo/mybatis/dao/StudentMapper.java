package org.vu.pskdemo.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;
import org.vu.pskdemo.mybatis.model.Student;

import java.util.List;

@Mapper
public interface StudentMapper {
    Long insert(Student student);

    Student selectById(Long id);

    Long update(Student student);

    Long delete(Long id);

    Long deleteAll();

    List<Student> selectAll();

    List<Student> selectByGroupId(Long groupId);

}
