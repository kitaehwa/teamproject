<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTL-core 라이브러리 추가 -->
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> views/member/main.jsp </h1>
	
	<!-- 로그인 성공한 사용자만 이용가능 -->
	<!-- 사용자 ID님 환영합니다 메세지 출력 -->
<%-- 	<C:if test="${sessionScope.id == null}"> --%>
	<C:if test="${empty sessionScope.id}">
		<!-- 로그인 정보가 없을 때 로그인 페이지로 이동 -->
		<C:redirect url="/member/login"/>
	</C:if>
	
	${sessionScope.id} <br>
	<h1> ${id}님 환영합니다. </h1>
	<input type="button" value="로그아웃"
		   onclick="location.href='/member/logout';">
		   
	<hr>
	
	<h2><a href="/member/info"> 회원정보 조회(info) </a></h2>
	<h2><a href="/member/update"> 회원정보 수정(update)</a></h2>
	<h2><a href="/member/delete"> 회원정보 삭제(delete)</a></h2>
	<!-- 관리자 기능(사용자 admin일때 사용가능 -->
	<C:if test="${!empty id && id.equals('admin')}">
	<h2><a href="/member/list"> 회원정보 목록(list)</a></h2>
	
	</C:if>
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>