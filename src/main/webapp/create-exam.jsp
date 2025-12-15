<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>创建新考试</title>
    <link rel="stylesheet" type="text/css" href="/spring/css/style.css">
</head>
<body>
    <h2>创建新考试</h2>
    
    <% if (request.getAttribute("error") != null) { %>
        <div class="error-message">
            <%= request.getAttribute("error") %>
        </div>
    <% } %>
    
    <form action="/spring/exams/create" method="post">
        <div class="form-group">
            <label for="title">考试标题：</label>
            <input type="text" id="title" name="title" value="<%= request.getAttribute("title") != null ? request.getAttribute("title") : "" %>" required>
        </div>
        
        <div class="form-group">
            <label for="description">考试描述：</label>
            <textarea id="description" name="description" rows="5" required>
                <%= request.getAttribute("description") != null ? request.getAttribute("description") : "" %>
            </textarea>
        </div>
        
        <div class="form-actions">
            <button type="submit">创建考试</button>
            <a href="/spring/exams/manage" class="btn-cancel">取消</a>
        </div>
    </form>
</body>
</html>
