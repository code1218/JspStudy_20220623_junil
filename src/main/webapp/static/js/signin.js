const inputItems = document.querySelectorAll("table input");
const submitButton = document.querySelector(".submit-button");
const signupButton = document.querySelector(".signup-button");
const maintainFlag = document.querySelector("#maintain-flag");

signupButton.onclick = () => {
	location.href = "/signup";
}

submitButton.onclick = () => {
	for(let i = 0; i < inputItems.length; i++){
		if(isEmpty(inputItems[i].value)){
			alert(
				(i == 0 ? "사용자 이름을" : "비밀번호를") + " 입력해주세요."
			);
			return;
		}
	}
	
	submit();
}

function submit() {
	$.ajax({
		type: "post",
		url: "/signin",
		data: {
			username: inputItems[0].value,
			password: inputItems[1].value,
			maintain: maintainFlag.checked
		},
		dataType: "text",
		success: (response) => {
			if(response == "true"){
				alert("로그인 성공! 환영합니다.");
				location.replace("/index");
			}else{
				alert("사용자 정보를 확인해주세요.");
			}
		},
		error: errorMessage
	});
}

function errorMessage(request, status, error){
	alert("요청 실패");
	console.log(request.status);
	console.log(request.responseText);
	console.log(error);
}

function isEmpty(str) {
	return str == "" || str == null || typeof str == undefined;
}