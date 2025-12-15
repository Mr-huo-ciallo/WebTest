package com.my.dao;

import com.my.domain.SubmissionAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubmissionAnswerMapper {
    List<SubmissionAnswer> findBySubmissionId(@Param("submissionId") Integer submissionId);

    int insertAnswer(SubmissionAnswer answer);
}
