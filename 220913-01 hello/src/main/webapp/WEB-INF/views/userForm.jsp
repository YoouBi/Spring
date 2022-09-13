<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 정보 입력</title>
</head>
<body>
	<!-- 해당 태그에 modelAttribute가 있는데 Controller에 적어둔 model "user" 객체 이름을 그대로 적어준다 -->
	<f:form modelAttribute="user" method="post">
		<f:errors path="name"/>
		<f:input type="text" path="name"/> <!-- name어트리뷰트를 path로 바꿈 -->
		<f:errors path="age"/>
		<f:input type="number" path="age"/> <!-- 이렇게 해두면 user 객체 안에 있는 필드값이 바인딩된다 -->
		<input type="submit" />
	</f:form>
</body>
</html>