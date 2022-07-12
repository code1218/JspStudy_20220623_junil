<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div id="container">
		<h1>로그인</h1>
		<!-- action: 요청 메세지를 입력하는 곳 -->
		<form action="/signin" method="post">
			<table>
				<tr>
					<th>사용자이름</th>			
					<td><input type="text" class="username-input" name="username" value="${username}"></td>			
				</tr>
				<tr>
					<th>비밀번호</th>			
					<td><input type="password" name="password" value="${password}"></td>			
				</tr>
				<tr>
					<td colspan="2">
						<input type="checkbox" id="maintain-flag" checked="${maintain}"><label for="maintain-flag">로그인 정보 유지</label>
					</td>
				</tr>
			</table>
			<button type="button" class="submit-button">로그인</button>
			<button type="button" class="signup-button">회원가입</button>
		</form>
	</div>
	<script type="text/javascript" src="/static/js/signin.js"></script>
</body>
</html>




