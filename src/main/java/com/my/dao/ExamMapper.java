package com.my.dao;

import com.my.domain.Exam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamMapper {
    Exam findById(@Param("id") Integer id);

    List<Exam> findPublished();

    List<Exam> findByTeacher(@Param("teacherId") Integer teacherId);

    int insertExam(Exam exam);
}
