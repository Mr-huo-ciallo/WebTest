package com.my.service.impl;

import com.my.dao.SubmissionAnswerMapper;
import com.my.dao.SubmissionMapper;
import com.my.domain.Submission;
import com.my.domain.SubmissionAnswer;
import com.my.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionService {
    @Autowired
    private SubmissionMapper submissionMapper;

    @Autowired
    private SubmissionAnswerMapper submissionAnswerMapper;

    @Override
    public Submission findById(Integer id) {
        return submissionMapper.findById(id);
    }

    @Override
    public List<Submission> listByStudent(Integer studentId) {
        return submissionMapper.findByStudent(studentId);
    }

    @Override
    @Transactional
    public Submission submit(Submission submission, List<SubmissionAnswer> answers) {
        submission.setSubmittedAt(LocalDateTime.now());
        submissionMapper.insertSubmission(submission);
        if (answers != null) {
            for (SubmissionAnswer answer : answers) {
                answer.setSubmissionId(submission.getId());
                submissionAnswerMapper.insertAnswer(answer);
            }
        }
        return submission;
    }
}
