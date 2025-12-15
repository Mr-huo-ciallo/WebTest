package com.my.controller;

import com.my.domain.Exam;
import com.my.domain.ExamStatus;
import com.my.domain.Question;
import com.my.domain.QuestionOption;
import com.my.domain.User;
import com.my.domain.UserRole;
import com.my.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/exams")
public class ExamController {
    @Autowired
    private ExamService examService;

    @GetMapping
    public ModelAndView listPublished() {
        List<Exam> exams = examService.listPublished();
        ModelAndView mv = new ModelAndView("exam-list");
        mv.addObject("exams", exams);
        return mv;
    }

    @GetMapping("/manage")
    public ModelAndView listForTeacher(HttpSession session) {
        User current = (User) session.getAttribute("currentUser");
        ModelAndView mv = new ModelAndView("admin-dashboard");
        if (current == null) {
            mv.setViewName("redirect:/auth/login");
            return mv;
        }

        List<Exam> exams;
        // 管理员可以查看所有考试，教师只能查看自己创建的考试
        if (current.getRole() == UserRole.ADMIN) {
            // 这里需要添加一个新的service方法来获取所有考试
            // 暂时使用所有已发布的考试作为替代
            exams = examService.listPublished();
        } else {
            exams = examService.listByTeacher(current.getId());
        }

        mv.addObject("exams", exams);
        mv.addObject("currentUser", current);
        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView examDetail(@PathVariable("id") Integer id) {
        Exam exam = examService.findById(id);
        List<Question> questions = examService.findQuestions(id);
        Map<Integer, List<QuestionOption>> optionsMap = new HashMap<Integer, List<QuestionOption>>();
        if (questions != null) {
            for (Question question : questions) {
                optionsMap.put(question.getId(), examService.findOptions(question.getId()));
            }
        }
        ModelAndView mv = new ModelAndView("exam-detail");
        mv.addObject("exam", exam);
        mv.addObject("questions", questions);
        mv.addObject("optionsMap", optionsMap);
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView createExamForm(HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        ModelAndView mv = new ModelAndView("create-exam");

        if (currentUser == null ||
                (currentUser.getRole() != UserRole.TEACHER && currentUser.getRole() != UserRole.ADMIN)) {
            mv.setViewName("redirect:/auth/login");
            return mv;
        }

        return mv;
    }

    @PostMapping("/create")
    public ModelAndView createExam(@RequestParam("title") String title,
            @RequestParam("description") String description,
            HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        ModelAndView mv = new ModelAndView();

        if (currentUser == null ||
                (currentUser.getRole() != UserRole.TEACHER && currentUser.getRole() != UserRole.ADMIN)) {
            mv.setViewName("redirect:/auth/login");
            return mv;
        }

        try {
            Exam exam = new Exam();
            exam.setTitle(title);
            exam.setDescription(description);
            exam.setCreatedByTeacherId(currentUser.getId());
            // 设置初始状态为未发布
            exam.setStatus(ExamStatus.DRAFT);

            examService.createExam(exam);

            mv.setViewName("redirect:/exams/manage");
            mv.addObject("message", "考试创建成功");
        } catch (Exception e) {
            mv.setViewName("create-exam");
            mv.addObject("error", "创建考试失败：" + e.getMessage());
            mv.addObject("title", title);
            mv.addObject("description", description);
        }

        return mv;
    }

    @GetMapping("/student-history")
    public ModelAndView studentExamHistory(HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        ModelAndView mv = new ModelAndView("student-exam-history");

        if (currentUser == null) {
            mv.setViewName("redirect:/auth/login");
            return mv;
        }

        return mv;
    }
}
