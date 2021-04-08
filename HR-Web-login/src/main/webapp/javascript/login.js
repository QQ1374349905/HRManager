$(function() {
	$(":button").click(function() {
		doLogin();
	});
	$("html").die().live("keydown", function(event) {
		if (event.keyCode == 13) {
			doLogin();
		}
	});
});

function doLogin() {
	var userName = $("#userName");
	var userPassword = $("#userPassword");
	// var reg = /^\S{6,}$/;
	// if (!reg.test(userName.val())) {
	// 	userName[0].select();
	// 	$.messager.show("消息提示", "登录名格式不正确！长度必须大于6位且不能有空格！", 2000);
	// 	return false;
	// }
	// if (!reg.test(userPassword.val())) {
	// 	userPassword[0].select();
	// 	$.messager.show("消息提示", "登录密码格式不正确！长度必须大于6位且不能有空格！", 2000);
	// 	return false;
	// }

	$.ajax({
		type: "POST",
		url: "verifyLogin",
		data:{username:userName,password:userPassword},

		success : function(data){
			alert("data: " + data);
			location.href = "toPage?page=page/index";
		},
		error : function(){
			alert("系统繁忙,请稍后重试!")
		}
	})
	return false;
}