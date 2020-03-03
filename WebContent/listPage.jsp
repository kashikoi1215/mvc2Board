<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
	<title> 목록보기 </title>
	<style type="text/css">
		span#pg{color:red; font-size: 22px;}
		a{text-decoration: none;}
	</style>
</head>

<body>
	<h1><a href="list.do">게시판 목록 보기</a></h1>
	<table border="1" width="600">
		<tr>
			<td colsapn="5" align="right">
				<form method="post" action="search.do">
					<select name="searchName" size="1">
						<option value="author">작성자</option>
						<option value="title">글제목</option>
					</select>
					<input type="text" name="searchValue">
					<input type="submit" value="찾기">
				</form>
			</td>
		</tr>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
			<c:if test="${page.totalCount<=0 }">
			<tr>
				<td colspan="5" align="center">입력된 데이터가 존재하지 않습니다.</td>
			</tr>
			</c:if>
			<c:if text="${page.totalCount>0 }">
				<c:forEach items="${list }" var="dto">
				<tr>
					<td>${dto.num }</td>
					<td><c:if test="${dto.repIndent>0 }">
							<img src="images/level.gif" width="${5*dto.repIndent }" height="16">
							<img src="images/re.gif">
						</c:if>
						<a href="retrieve.do?num=${dto.num }">${dto.title }</a>
					</td>
					<td>${dto.author }</td>
					<td>${dto.writeday }</td>
					<td>${dto.readcnt }</td>
				</tr>
				</c:forEach>
			</c:if>
	</table>
	<!-- page -->
	<div id="pageView">${pg }</div>
	<div id="butView"><a href="writeui.do">글쓰기</a></div>
</body>

</html>