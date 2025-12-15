<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="java.util.List" %>
        <%@ page import="com.my.domain.Exam" %>
            <%@ page import="com.my.domain.User" %>
                <%@ page import="com.my.domain.UserRole" %>
                    <!DOCTYPE html>
                    <html>

                    <head>
                        <title>
                            <%= (UserRole.ADMIN.equals(((User)request.getAttribute("currentUser")).getRole())) ? "管理员后台"
                                : "教师后台" %>
                        </title>
                        <link rel="stylesheet" type="text/css" href="/spring/css/style.css">
                    </head>

                    <body>
                        <% User currentUser=(User) request.getAttribute("currentUser"); List exams=(List)
                            request.getAttribute("exams"); boolean isAdmin=UserRole.ADMIN.equals(currentUser.getRole());
                            %>
                            <h2>
                                <%= isAdmin ? "管理员后台" : "教师后台" %>（<%= currentUser !=null ? currentUser.getUsername()
                                        : "" %>）
                            </h2>

                            <div class="dashboard-stats">
                                <div class="stat-card">
                                    <div class="stat-number">
                                        <%= exams !=null ? exams.size() : 0 %>
                                    </div>
                                    <div class="stat-label">
                                        <%= isAdmin ? "所有考试" : "我的考试" %>
                                    </div>
                                </div>
                                <div class="stat-card">
                                    <div class="stat-number">0</div>
                                    <div class="stat-label">已发布</div>
                                </div>
                                <div class="stat-card">
                                    <div class="stat-number">0</div>
                                    <div class="stat-label">待批改</div>
                                </div>
                                <div class="stat-card">
                                    <div class="stat-number">0</div>
                                    <div class="stat-label">已完成</div>
                                </div>
                            </div>

                            <div>
                                <h3>快捷操作</h3>
                                <ul>
                                    <li><a href="/spring/exams/create">创建新考试</a></li>
                                    <li><a href="/spring/questions/manage">管理题库</a></li>
                                    <li><a href="#">查看成绩</a></li>
                                    <li><a href="#">系统设置</a></li>

                                    <!-- 管理员特有功能 -->
                                    <% if (isAdmin) { %>
                                        <li><a href="#">管理用户</a></li>
                                        <li><a href="/spring/exams/student-history">查看学生考试历史</a></li>
                                        <% } %>
                                </ul>
                            </div>

                            <h3>
                                <%= isAdmin ? "所有考试" : "我创建的考试" %>
                            </h3>
                            <ul>
                                <% if (exams !=null) { for (Object obj : exams) { Exam exam=(Exam) obj; %>
                                    <li><a href="/spring/exams/<%= exam.getId() %>">
                                            <%= exam.getTitle() %>
                                        </a></li>
                                    <% } } %>
                            </ul>

                            <a href="/spring/exams">返回开放考试</a>
                    </body>

                    </html>