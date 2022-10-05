<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h1>게시판 글 목록</h1>
	<div>
		<p>글번호</p>
		<p>제목</p>
		<p>글쓴이</p>
	</div>
	
	<div>
		<p>${ article.no }</p>
		<p>${ article.title }</p>
		<p>${ article.writer }</p>
	</div>
	
	<div>
		<a href="/board/write">글쓰기</a>
	</div>
</body>
</html>