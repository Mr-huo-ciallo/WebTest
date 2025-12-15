package com.my.dao;

import com.my.domain.ExamSubmission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamSubmissionMapper {
    int insertSubmission(ExamSubmission submission);
    List<ExamSubmission> findByExamId(@Param("examId") Integer examId);
    List<ExamSubmission> findByUserId(@Param("userId") Integer userId);
    ExamSubmission findByExamAndUser(@Param("examId") Integer examId, @Param("userId") Integer userId);
}
