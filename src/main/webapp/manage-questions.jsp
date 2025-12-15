<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>管理题库</title>
            <link rel="stylesheet" type="text/css" href="/spring/css/style.css">
        </head>

        <body>
            <h2>管理题库</h2>

            <div class="admin-actions">
                <a href="/spring/exams/manage" class="btn-back">返回教师后台</a>
                <button class="btn-add" onclick="showAddQuestionForm()">添加新题目</button>
            </div>

            <div id="add-question-form" style="display: none; margin: 20px 0;">
                <h3>添加新题目</h3>
                <form action="/spring/questions/manage" method="post">
                    <div class="form-group">
                        <label for="exam-select">选择考试：</label>
                        <select id="exam-select" name="examId" required>
                            <option value="">请选择考试</option>
                            <c:forEach items="${exams}" var="exam">
                                <option value="${exam.id}">${exam.title}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="question-content">题目内容：</label>
                        <textarea id="question-content" name="stem" rows="3" required></textarea>
                    </div>

                    <div class="form-group">
                        <label for="question-type">题目类型：</label>
                        <select id="question-type" name="type" required>
                            <option value="SINGLE_CHOICE">单选题</option>
                            <option value="MULTIPLE_CHOICE">多选题</option>
                            <option value="TRUE_FALSE">判断题</option>
                            <option value="SHORT_ANSWER">简答题</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="question-score">分值：</label>
                        <input type="number" id="question-score" name="score" min="1" value="10" required>
                    </div>

                    <div class="form-group">
                        <label for="question-answer">正确答案：</label>
                        <input type="text" id="question-answer" name="correctAnswer" required>
                    </div>

                    <div class="form-group">
                        <label for="question-explanation">解析：</label>
                        <textarea id="question-explanation" name="explanation" rows="3"></textarea>
                    </div>

                    <div class="form-actions">
                        <button type="submit">保存题目</button>
                        <button type="button" onclick="hideAddQuestionForm()">取消</button>
                    </div>
                </form>
            </div>

            <h3>题目列表</h3>
            <table class="question-list">
                <thead>
                    <tr>
                        <th>题目ID</th>
                        <th>题目内容</th>
                        <th>类型</th>
                        <th>分值</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- 这里可以通过JSP循环显示题目列表 -->
                    <tr>
                        <td colspan="5" style="text-align: center; padding: 20px;">
                            暂无题目，点击"添加新题目"开始创建
                        </td>
                    </tr>
                </tbody>
            </table>

            <script>
                function showAddQuestionForm() {
                    document.getElementById('add-question-form').style.display = 'block';
                }

                function hideAddQuestionForm() {
                    document.getElementById('add-question-form').style.display = 'none';
                }
            </script>
        </body>

        </html>