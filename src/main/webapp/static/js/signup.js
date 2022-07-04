const usernameInput = document.querySelector(".username-input");
const usernameCheckMsg = document.querySelector(".username-check-msg");

let signupFlag = false;

usernameInput.onblur = () => {
	let username = usernameInput.value;
	$.ajax({
		type: "get",
		url: `/check/username?username=${username}`,
		dataType: "text", //응답받을 때의 데이터 형태
		success: (response) => {
			if(response == "true"){
				signupFlag = false;
				usernameCheckMsg.innerHTML = `<td colspan="2">${username}은(는) 이미 존재하는 사용자이름 입니다.</td>`;
			}else{
				signupFlag = true;
				usernameCheckMsg.innerHTML = `<td colspan="2">${username}은(는) 가입 할 수 있는 사용자이름 입니다.</td>`;
			}
		},
		error: (request, status, error) => {
			alert("요청 실패");
			console.log(request.status);
			console.log(request.responseText);
			console.log(error);
		}
	});
}







