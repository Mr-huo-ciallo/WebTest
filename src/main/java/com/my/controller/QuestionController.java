package com.my.controller;

import com.my.domain.Exam;
import com.my.domain.Question;
import com.my.domain.User;
import com.my.domain.UserRole;
import com.my.service.ExamService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private ExamService examService;

    @GetMapping("/manage")
    public ModelAndView manageQuestions(HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        ModelAndView mv = new ModelAndView("manage-questions");

        if (currentUser == null ||
                (currentUser.getRole() != UserRole.TEACHER && currentUser.getRole() != UserRole.ADMIN)) {
            mv.setViewName("redirect:/auth/login");
            return mv;
        }

        // 获取当前教师创建的所有考试
        List<Exam> exams = examService.listByTeacher(currentUser.getId());
        mv.addObject("exams", exams);

        return mv;
    }

    @PostMapping("/manage")
    public ModelAndView saveQuestion(@RequestParam("examId") Integer examId,
            @RequestParam("stem") String stem,
            @RequestParam("type") String type,
            @RequestParam("score") Integer score,
            @RequestParam("correctAnswer") String correctAnswer,
            @RequestParam("explanation") String explanation,
            HttpSession session) {

        User currentUser = (User) session.getAttribute("currentUser");
        ModelAndView mv = new ModelAndView("redirect:/questions/manage");

        if (currentUser == null ||
                (currentUser.getRole() != UserRole.TEACHER && currentUser.getRole() != UserRole.ADMIN)) {
            mv.setViewName("redirect:/auth/login");
            return mv;
        }

        // 创建新题目
        Question question = new Question();
        question.setExamId(examId);
        question.setStem(stem);
        question.setType(Question.QuestionType.valueOf(type));
        question.setScore(score);
        question.setCorrectAnswer(correctAnswer);
        question.setExplanation(explanation);
        question.setCreatedBy(currentUser.getId());
        question.setDifficulty("MEDIUM"); // 默认难度

        // 保存题目
        examService.createQuestion(question);

        return mv;
    }
}
