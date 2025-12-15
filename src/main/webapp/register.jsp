<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>考试平台 - 注册</title>
        <link rel="stylesheet" type="text/css" href="/spring/css/style.css">
    </head>

    <body>
        <h2>考试管理系统注册</h2>
        <form action="/spring/auth/register" method="post">
            <div>
                <label>用户名：</label>
                <input type="text" name="username" value="${username}" required>
            </div>
            <div>
                <label>密码：</label>
                <input type="password" name="password" required>
            </div>
            <div>
                <label>姓名：</label>
                <input type="text" name="fullName" value="${fullName}" required>
            </div>
            <div>
                <label>注册身份：</label>
                <select name="role" required>
                    <option value="">请选择身份</option>
                    <option value="STUDENT" ${role=='STUDENT' ? 'selected' : '' }>学生</option>
                    <option value="TEACHER" ${role=='TEACHER' ? 'selected' : '' }>老师</option>
                    <option value="ADMIN" ${role=='ADMIN' ? 'selected' : '' }>管理员</option>
                </select>
            </div>
            <button type="submit">注册</button>
        </form>
        <% if (request.getAttribute("error") !=null) { %>
            <p class="error">${error}</p>
            <% } %>
                <p>已有账号？<a href="/spring/auth/login">登录</a></p>
    </body>

    </html>