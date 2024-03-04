package org.vu.pskdemo.mybatis.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;
import org.vu.pskdemo.mybatis.model.StudentGroup;

@Mapper
public interface StudentGroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENTGROUP
     *
     * @mbg.generated Mon Mar 04 22:39:08 EET 2024
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENTGROUP
     *
     * @mbg.generated Mon Mar 04 22:39:08 EET 2024
     */
    int insert(StudentGroup row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENTGROUP
     *
     * @mbg.generated Mon Mar 04 22:39:08 EET 2024
     */
    StudentGroup selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENTGROUP
     *
     * @mbg.generated Mon Mar 04 22:39:08 EET 2024
     */
    List<StudentGroup> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENTGROUP
     *
     * @mbg.generated Mon Mar 04 22:39:08 EET 2024
     */
    int updateByPrimaryKey(StudentGroup row);
}