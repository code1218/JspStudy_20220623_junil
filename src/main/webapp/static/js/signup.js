const usernameInput = document.querySelector(".username-input");
const usernameCheckMsg = document.querySelector(".username-check-msg");
const inputItems = document.querySelectorAll("table input");
const submitButton = document.querySelector(".submit-button");

let signupFlag = [false, false, false, false, false];

submitButton.onclick = () => {
	for(let i = 0; i < inputItems.length; i++) {
		if(isEmpty(inputItems[i].value)){
			alert((i == 0 ? "이름을" 
				: i == 1 ? "이메일을" 
				: i == 2 ? "사용자 이름을"
				: "비밀번호를")
				+ " 입력해 주세요.");
				
			signupFlag[i] = false;
			
			return;
		}
		signupFlag[i] = true;
	}
	
	if(signupFlag[4] == false){
		alert("사용자이름 중복확인이 필요합니다.");
		return;
	}
	
	
}

usernameInput.onblur = () => {
	let username = usernameInput.value;
	
	$.ajax({
		type: "get",
		url: `/check/username?username=${username}`,
		dataType: "text", //응답받을 때의 데이터 형태
		success: (response) => {
			if(response == "true"){
				signupFlag[4] = false;
				usernameCheckMsg.innerHTML = `<td colspan="2">${username}은(는) 이미 존재하는 사용자이름 입니다.</td>`;
			}else{
				signupFlag[4] = true;
				usernameCheckMsg.innerHTML = `<td colspan="2">${username}은(는) 가입 할 수 있는 사용자이름 입니다.</td>`;
			}
		},
		error: errorMessage
	});
}

function submit() {
	$.ajax({
		type: "post",
		url: "/signup",
		data: {
			name: inputItems[0].value,
			email: inputItems[1].value,
			username: inputItems[2].value,
			password: inputItems[3].value
		},
		dataType: "text",
		success: (response) => {
			
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





