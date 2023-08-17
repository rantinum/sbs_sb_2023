<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 리스트</title>
</head>
<body>
  <h1>게시물 리스트</h1>
  <div>
    <table border="1">
      <thead>
        <tr>
          <th>번호</th>
          <th>작성날짜</th>
          <th>수정날짜</th>
          <th>작성자</th>
          <th>제목</th>
        </tr>
      </thead>
      
      <tbody>
        <c:forEach var="article" items="${articles}">
          <tr>
            <td>${article.id}</td>
            <td>${article.regDate}</td>
            <td>${article.updateDate}</td>
            <td>${article.memberId}</td>
            <td>
               <a href="../article/detail?id=${article.id}">${article.title}</a>  
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>