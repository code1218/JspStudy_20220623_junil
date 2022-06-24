<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%!
	String[] name = new String[5];
	String[] email = new String[5];
	List<String> names = new ArrayList<String>();
	
	String madeName(String name) {
		return name + "님";
	}
	
	String madeEmail(String email) {
		return email + "@google.com";
	}
%>
<%
	names.add("김준일");
	names.add("김준일");
	names.add("김준일");
	names.add("김준일");
	names.add("김준일");
	name[0] = "김준일";
	email[0] = "skjil1218";
	name[1] = "김준이";
	email[1] = "skjil1217";
	name[2] = "김준삼";
	email[2] = "skjil1216";
	name[3] = "김준사";
	email[3] = "skjil1215";
	name[4] = "김준오";
	email[4] = "skjil1214";
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>이메일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="name1" items="${names}" >
				<tr>
					<td>${name1 }</td>
					<td>${name1 }</td>
					<td>${name1 }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>