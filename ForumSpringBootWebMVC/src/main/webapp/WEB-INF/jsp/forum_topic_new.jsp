<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html lang="vn">
<head>
 <meta charset="UTF-8">
    <title>New topic</title>
    
    <style>
    .message{
    float: right;
}
.container{
    width: 70%;
    height: 500px;
    background-color: rgb(213 236 236);
    margin: auto;
    padding: 5%;
}
.input-title{
    width: 70%;
}
.input-content{
    width: 70%;
}
a{
  color: red;
}
  </style>
</head>
<body>
    <div class="container">
       <div class="message">
            Chào ${sessionScope.username}|<a href="logout">Thoát</a>
       </div>
       <br>
        <form:form action="saveTopic" method="post" modelAttribute="topic">
        
       <h4><form:label path="title">*Tiêu đề:</form:label></h4>
       <form:input class="input-title" path="title"/> <a><form:errors path="title"/></a>
       
       
       <h4><form:label path="content">*Nội dung:</form:label></h4>
       <form:textarea path = "content" rows = "5" cols = "72" /> <a><form:errors path="content"/></a>
       <br><br>
       <div class="group-button">
            <form:button>Gửi</form:button>
            <button>Hủy bỏ</button>
       </div>
       </form:form>
   </div>
</body>
</html>