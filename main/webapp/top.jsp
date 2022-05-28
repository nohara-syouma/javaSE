<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
  <c:if test="${not empty msg}">
    <p>${msg}</p>
  </c:if>
  <p>検索条件を入力してください。  </p>
  <form action="login" method="post">
    product_name <input type="text" name="name" value="${fn:escapeXml(param.product_name)}"><br>
    price <input type="password" name="price" value="${fn:escapeXml(param.price)}"><br>
    <button type="submit">検索</button>
  </form>
</body>
</html>
