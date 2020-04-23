<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<br>
	<table border="1">
		<colgroup>
			<col width="100">
			<col width="100">
			<col width="100">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>직업</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<td colspan="3">---------등록된 게시글이 없습니다.---------</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list }" var="dto">
						<tr>
							<td>${dto.rnum }</td>
							<td>${dto.ename }</td>
							<td>${dto.job }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
				<tr>
					<td colspan="3">
			<a href="list.do?pageNum=1&count=${count }">◁◁</a>
	<a href="list.do?pageNum=${prevNum }&count=${count }">◀</a>
					
	<c:forEach var="i" begin="${groupStart }" end="${groupEnd }" step="1">
		<a href="list.do?pageNum=${i }&count=${count }">
							
		<c:choose>
			<c:when test="${page eq i }">
				<u><b>${i }</b></u>
			</c:when>
								
			<c:otherwise>
				${i }
			</c:otherwise>
		</c:choose>
							
		</a>
	</c:forEach>
						
	<a href="list.do?pageNum=${nextNum }&count=${count }">▶</a>
	<a href="list.do?pageNum=${totalpage }&count=${count }">▷▷</a>
						
					</td>
				</tr>
		</tbody>
	</table>


</body>
</html>