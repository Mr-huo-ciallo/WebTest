package com.my.dao;

import com.my.domain.QuestionOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionOptionMapper {
    List<QuestionOption> findByQuestionId(@Param("questionId") Integer questionId);

    int insertOption(QuestionOption option);
}
