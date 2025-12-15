package com.my.service.impl;

import com.my.dao.ExamMapper;
import com.my.dao.QuestionMapper;
import com.my.dao.QuestionOptionMapper;
import com.my.domain.Exam;
import com.my.domain.Question;
import com.my.domain.QuestionOption;
import com.my.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionOptionMapper questionOptionMapper;

    @Override
    public Exam findById(Integer id) {
        return examMapper.findById(id);
    }

    @Override
    public List<Exam> listPublished() {
        return examMapper.findPublished();
    }

    @Override
    public List<Exam> listByTeacher(Integer teacherId) {
        if (teacherId == null) {
            return Collections.emptyList();
        }
        return examMapper.findByTeacher(teacherId);
    }

    @Override
    public void createExam(Exam exam) {
        examMapper.insertExam(exam);
    }

    @Override
    public List<Question> findQuestions(Integer examId) {
        return questionMapper.findByExamId(examId);
    }

    @Override
    public List<QuestionOption> findOptions(Integer questionId) {
        return questionOptionMapper.findByQuestionId(questionId);
    }

    @Override
    public void createQuestion(Question question) {
        questionMapper.insertQuestion(question);
    }
}
