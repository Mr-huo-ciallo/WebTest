package com.my.service;

import com.my.domain.Exam;
import com.my.domain.Question;
import com.my.domain.QuestionOption;

import java.util.List;

public interface ExamService {
    Exam findById(Integer id);

    List<Exam> listPublished();

    List<Exam> listByTeacher(Integer teacherId);

    void createExam(Exam exam);

    List<Question> findQuestions(Integer examId);

    List<QuestionOption> findOptions(Integer questionId);
    
    void createQuestion(Question question);
}
