
<%@ include file="../layout/header.jsp" %>
	<div class="container">
	<!-- <form action="auth/user/signup" method="POST"> -->
  <form action="loginProc" method="POST">
  <div class="mb-3">
    <label for="username" class="form-label">Username:</label>
    <input type="text" class="form-control" id="username" placeholder="Enter username"  name="username">
  </div>
  <div class="mb-3">
    <label for="pwd" class="form-label">Password:</label>
    <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" >
  </div>
  
  <!--  <div class="form-check mb-3">
    <label class="form-check-label">
      <input class="form-check-input" type="checkbox" name="remember"> Remember me
    </label> -->
    <button id="btn-login" class="btn btn-primary">LogIn</button>
  </div>
   
</form>
<!-- <button id="btn-login" class="btn btn-primary">LogIn</button> -->
	</div>
	
	<!-- <script src="/js/user/user.js"></script> -->
	<%@ include file="../layout/footer.jsp" %>