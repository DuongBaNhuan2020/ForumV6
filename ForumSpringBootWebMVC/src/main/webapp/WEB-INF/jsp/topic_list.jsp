
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html lang="vn">
<head>
	<meta charset="UTF-8">
    <title>List topic</title>
    
    <style>
.message{
    float: right;
}
.container{
    width: 70%;
    height: 100%;
    background-color: rgb(213 236 236);
    margin: auto;
    padding: 5%;
}
table {
  border-collapse: collapse;
  border: 1px solid #020202;
  width: 100%;
}
.subject{
    text-align: center;
    background-color: #b6b3b9;
}
td, th {
  text-align: left;
  padding: 8px;
}
.n-reply{
    text-align: center;
}
tr:nth-child(even) {
    background-color: #98dcdf;
  }
  </style>
</head>
<body>
    <div class="container">
       <div class="message">
            Chào ${sessionScope.username}|<a href="logout">Thoát</a>
       </div>
       <br>
       <h3>Diễn đàn: chuyện học phí và các chính sách hỗ trợ học tập</h3>
       <button onclick="window.location='newTopic'">Gửi bài mới</button>
    <br><br>
     
    <table>
        <tr>
        <th class="subject">Chủ đề</th>
        <th class="subject">Hồi âm</th>
        </tr>
        <c:forEach items="${listTopic}" var="topic">
        <tr>
        <td>
            <a href="detailTopic?top_id=${topic.id}">${topic.title}</a>
            <br>
            Bài viết mới nhất by <a href="#">${topic.getUser().getUserName()}</a>, <fmt:formatDate value="${topic.createdTime.time}" type="date" pattern="dd-MM-yyyy HH:mm a" />
        </td>
        <td class="n-reply">${topic.getMessagestopic().size()}</td>
        </tr>
        </c:forEach>
    </table>
    
   </div>
</body>
</html>