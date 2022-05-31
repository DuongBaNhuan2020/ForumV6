<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html lang="vn">
<head>
  <meta charset="UTF-8">
    <title>Login</title>
    
    <style>
.container{
    width: 603px;
    height: 200px;
    background-color: rgb(210, 216, 216);
    margin: auto;
    border: 1px solid #020202;
}
.header{
    text-align: center;
    font-size: 20px;
    width: 100%;
    height: 27px;
    background-color: rgb(93, 235, 235);
}
a{
  color: red;
}
table {
    border-collapse: collapse;
    width: 100%;
  }
  .title{
      text-align: right;
    width: 30%;
  }
  td, th {
    text-align: left;
    padding: 8px;
  }
  </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <b>Login</b>
        </div>
         <form:form action="saveuser" method="post" modelAttribute="user">
        <table>
                <tr>
                <td class="title">
                   <form:label path="userName">*Tên đăng nhập:</form:label>
                </td>
                <td> <form:input path="userName"/><a><form:errors path="userName"/></a> <a>${error}</a></td>
                </tr>
                <tr>
                <tr>
                    <td class="title">
                        <form:label path="password">*Mật khẩu:</form:label>
                    </td>
                    <td> <form:input path="password"/><a><form:errors path="password"/></a></td>
                    </tr>
                    <tr>
                <tr>
                    <td>
                      
                    </td>
                    <td><td><form:button>Đăng nhập</form:button></td></td>
                    </tr>
                    <tr>
		</table>
		</form:form>
   </div>
</body>
</html>