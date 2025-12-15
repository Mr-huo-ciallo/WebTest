<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>个人考试历史</title>
    <link rel="stylesheet" type="text/css" href="/spring/css/style.css">
</head>
<body>
    <h2>个人考试历史</h2>
    
    <div class="student-actions">
        <a href="/spring/exams" class="btn-back">返回开放考试</a>
    </div>
    
    <h3>我的考试记录</h3>
    <table class="exam-history">
        <thead>
            <tr>
                <th>考试ID</th>
                <th>考试名称</th>
                <th>得分</th>
                <th>总分</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <!-- 这里可以通过JSP循环显示学生的考试历史 -->
            <tr>
                <td colspan="6" style="text-align: center; padding: 20px;">
                    暂无考试记录
                </td>
            </tr>
        </tbody>
    </table>
    
    <div class="stats-summary">
        <h3>考试统计</h3>
        <div class="stat-item">
            <span class="stat-label">已完成考试：</span>
            <span class="stat-value">0</span>
        </div>
        <div class="stat-item">
            <span class="stat-label">平均分数：</span>
            <span class="stat-value">0.0</span>
        </div>
        <div class="stat-item">
            <span class="stat-label">最高分：</span>
            <span class="stat-value">0</span>
        </div>
    </div>
</body>
</html>
