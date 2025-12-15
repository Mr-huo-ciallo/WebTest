package com.my.domain;

public class SubmissionAnswer {
    private Integer id;
    private Integer submissionId;
    private Integer questionId;
    private String answerText;
    private String selectedOptionIds;
    private Integer scoreAwarded;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public String getSelectedOptionIds() {
        return selectedOptionIds;
    }

    public void setSelectedOptionIds(String selectedOptionIds) {
        this.selectedOptionIds = selectedOptionIds;
    }

    public Integer getScoreAwarded() {
        return scoreAwarded;
    }

    public void setScoreAwarded(Integer scoreAwarded) {
        this.scoreAwarded = scoreAwarded;
    }
}
