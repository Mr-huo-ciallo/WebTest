package com.my.dao;

import com.my.domain.Submission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubmissionMapper {
    Submission findById(@Param("id") Integer id);

    List<Submission> findByStudent(@Param("studentId") Integer studentId);

    int insertSubmission(Submission submission);
}
