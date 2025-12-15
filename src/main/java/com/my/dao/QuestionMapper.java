package com.my.dao;

import com.my.domain.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {
    List<Question> findByExamId(@Param("examId") Integer examId);

    int insertQuestion(Question question);
}
