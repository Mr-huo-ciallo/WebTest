<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="com.my.domain.Submission" %>
        <%@ page import="com.my.domain.Exam" %>
            <!DOCTYPE html>
            <html>

            <head>
                <title>提交成功</title>
                <link rel="stylesheet" type="text/css" href="css/style.css">
            </head>

            <body>
                <% Submission submission=(Submission) request.getAttribute("submission"); Exam exam=(Exam)
                    request.getAttribute("exam"); %>
                    <h2>提交成功</h2>
                    <div class="exam-info">
                        <p><strong>考试名称：</strong>
                            <%= exam !=null ? exam.getTitle() : "" %>
                        </p>
                        <p><strong>提交时间：</strong>
                            <%= submission !=null ? submission.getSubmittedAt() : "" %>
                        </p>
                        <p><strong>试卷编号：</strong>
                            <%= submission !=null ? submission.getExamId() : "" %>
                        </p>
                        <p><strong>提交状态：</strong>成功</p>
                        <p><strong>温馨提示：</strong>考试成绩将在批改完成后公布，请耐心等待。</p>
                    </div>
                    <a href="/exams">返回考试列表</a>
            </body>

            </html>