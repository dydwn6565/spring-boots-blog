let index = {
	init: function() {

		$("#btn-save").on("click", () => {
			this.save();
		});

		$("#btn-fix-user-info").on("click", () => {
			this.fixUserInfo();

		});
		/*   $("#btn-login").on("click",()=>{
			   this.login();
			   
		   });*/
	},
	save: function() {
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}

		// ajax request default is async
		$.ajax({
			type: "POST",
			url: "api/signupForm",
			data: JSON.stringify(data),
			contentType: "application/json; charset=urf-8", // type of data
			dataType: "json"
		}
		).done(function(result) {
			if (result.status === 500) {
				alert("fail to sign up")
			} else {
				alert("successfully sign up");
				location.href = "/";
			}

			
			
		}).fail(function(error) {


			alert(JSON.stringify(error))
		}); // ajax communication
	},

	fixUserInfo: function() {
		let data = {
			id: $("#updateId").val(),
			username: $("#updateUsername").val(),
			password: $("#updatePassword").val(),
			email: $("#updateEmail").val()
		}

		// ajax request default is async
		$.ajax({
			type: "PUT",
			url: "/user/info/update",
			data: JSON.stringify(data),
			contentType: "application/json; charset=urf-8", // type of data
			dataType: "json"
		}
		).done(function(result) {
			alert("successfully updated");
			console.log()
			location.href = "/";
		}).fail(function(error) {


			alert(JSON.stringify(error))
		}); // ajax communication
	},


	/*login: function(){
		let loginData ={
	username: $("#usernameLogin").val(),
	password: $("#passwordLogin").val(),
	
}

// ajax request default is async
 $.ajax({
	type:"POST",
	url:"/api/user/login",
	data: JSON.stringify(loginData),
	contentType: "application/json; charset=urf-8", // type of data
	dataType: "json" 
}
 ).done(function(result){
	alert("successfully log in");
	
	location.href="/";
}).fail(function(error){
	alert(JSON.stringify(error))
}); // ajax communication
	}
	*/

}



index.init();