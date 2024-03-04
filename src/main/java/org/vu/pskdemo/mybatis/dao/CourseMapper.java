package org.vu.pskdemo.mybatis.dao;

import org.mybatis.cdi.Mapper;
import org.vu.pskdemo.mybatis.model.Course;

import java.util.List;

@Mapper
public interface CourseMapper {
    Long insert(Course course);

    Course selectById(Long id);

    Long update(Course course);

    Long delete(Long id);

    Long deleteAll();

    List<Course> selectAll();

    List<Course> selectByStudentId(Long studentId);
}
