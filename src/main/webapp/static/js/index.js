const signupBtn = document.querySelectorAll("nav ul li");

signupBtn[0].onclick = () => {
	location.href = "/signup";	
}

signupBtn[1].onclick = () => {
	location.href = "/signin";
}