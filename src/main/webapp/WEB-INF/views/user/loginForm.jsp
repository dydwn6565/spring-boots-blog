
<%@ include file="../layout/header.jsp" %>
	<div class="container">
	<!-- <form action="auth/user/signup" method="POST"> -->
  <form action="/auth/loginProc" method="POST">
  <div class="mb-3">
    <label for="username" class="form-label">Username:</label>
    <input type="text" class="form-control" id="usernameLogin" placeholder="Enter username"  name="username">
  </div>
  <div class="mb-3">
    <label for="pwd" class="form-label">Password:</label>
    <input type="password" class="form-control" id="passwordLogin" placeholder="Enter password" name="password" >
  </div>
  
  <!--  <div class="form-check mb-3">
    <label class="form-check-label">
      <input class="form-check-input" type="checkbox" name="remember"> Remember me
    </label> -->
    <button id="btn-login" class="btn btn-primary">LogIn</button>
    <a href="https://kauth.kakao.com/oauth/authorize?client_id=1f23b831921a9a58f1e549c6e1e18fe0&redirect_uri=http://localhost:8000/auth/kakao/callback&response_type=code"><img height="38px" src="/image/kakao_login_medium.png"/></a>
  </div>
   
</form>
<!-- <button id="btn-login" class="btn btn-primary">LogIn</button> -->
	</div>
	
	<!-- <script src="/js/user/user.js"></script> -->
	<%@ include file="../layout/footer.jsp" %>