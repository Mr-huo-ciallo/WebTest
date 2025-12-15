package com.my.service;

import com.my.domain.Submission;
import com.my.domain.SubmissionAnswer;

import java.util.List;

public interface SubmissionService {
    Submission findById(Integer id);

    List<Submission> listByStudent(Integer studentId);

    Submission submit(Submission submission, List<SubmissionAnswer> answers);
}
