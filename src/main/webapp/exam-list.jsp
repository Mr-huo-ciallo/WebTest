<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="java.util.List" %>
        <%@ page import="com.my.domain.Exam" %>
            <!DOCTYPE html>
            <html>

            <head>
                <title>考试列表</title>
                <link rel="stylesheet" type="text/css" href="/spring/css/style.css">
            </head>

            <body>
                <h2>开放考试</h2>
                <ul>
                    <% List exams=(List) request.getAttribute("exams"); if (exams !=null) { for (Object obj : exams) {
                        Exam exam=(Exam) obj; %>
                        <li>
                            <a href="/spring/exams/<%=exam.getId()%>">
                                <%=exam.getTitle()%>
                            </a>
                            ，时间：<%=exam.getStartTime()%> - <%=exam.getEndTime()%>
                        </li>
                        <% } } %>
                </ul>
                <a href="/spring/auth/logout">退出</a>
            </body>

            </html>