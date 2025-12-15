<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="java.util.List" %>
        <%@ page import="java.util.Map" %>
            <%@ page import="com.my.domain.Exam" %>
                <%@ page import="com.my.domain.Question" %>
                    <%@ page import="com.my.domain.QuestionOption" %>
                        <!DOCTYPE html>
                        <html>

                        <head>
                            <title>考试详情</title>
                            <link rel="stylesheet" type="text/css" href="css/style.css">
                        </head>

                        <body>
                            <% Exam exam=(Exam) request.getAttribute("exam"); List questions=(List)
                                request.getAttribute("questions"); Map optionsMap=(Map)
                                request.getAttribute("optionsMap"); %>
                                <h2>
                                    <%= exam !=null ? exam.getTitle() : "考试" %>
                                </h2>
                                <% if (exam !=null) { %>
                                    <div class="exam-info">
                                        <p><strong>描述：</strong>
                                            <%= exam.getDescription() %>
                                        </p>
                                        <p><strong>时间：</strong>
                                            <%= exam.getStartTime() %> - <%= exam.getEndTime() %>
                                        </p>
                                        <p><strong>时长：</strong>
                                            <%= exam.getDurationMinutes() %> 分钟
                                        </p>
                                        <p><strong>总分：</strong>
                                            <%= exam.getTotalScore() %> 分
                                        </p>
                                        <p><strong>状态：</strong>
                                            <%= exam.getStatus() %>
                                        </p>
                                    </div>
                                    <% } %>
                                        <form action="/exams/<%= exam != null ? exam.getId() : 0 %>/submit"
                                            method="post">
                                            <ol>
                                                <% if (questions !=null) { for (Object obj : questions) { Question
                                                    q=(Question) obj; List opts=optionsMap !=null ? (List)
                                                    optionsMap.get(q.getId()) : null; %>
                                                    <li>
                                                        <p class="question-text">
                                                            <%= q.getStem() %>（<%= q.getScore() %> 分）
                                                        </p>
                                                        <% if (opts !=null && !opts.isEmpty()) { for (Object o : opts) {
                                                            QuestionOption option=(QuestionOption) o; %>
                                                            <div class="option">
                                                                <label>
                                                                    <input type="radio" name="answer_<%= q.getId() %>"
                                                                        value="<%= option.getId() %>">
                                                                    <%= option.getLabel() %>. <%= option.getContent() %>
                                                                </label>
                                                            </div>
                                                            <% } } else { %>
                                                                <textarea name="answer_<%= q.getId() %>" rows="3"
                                                                    cols="50"></textarea>
                                                                <% } %>
                                                    </li>
                                                    <% } } %>
                                            </ol>
                                            <button type="submit">提交试卷</button>
                                        </form>
                                        <a href="/exams">返回考试列表</a>
                        </body>

                        </html>