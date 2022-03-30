
<%@ include file="../layout/header.jsp" %>
	<div class="container">
	<form action="auth/user/api/signupForm" method="POST">
  <div class="mb-3">
    <label for="pwd" class="form-label">Username:</label>
    <input type="text" class="form-control" id="username" placeholder="Enter password" name="username">
  </div>
  <div class="mb-3">
    <label for="pwd" class="form-label">Password:</label>
    <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
  </div>
  <div class="mb-3 mt-3">
    <label for="email" class="form-label">Email:</label>
    <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
  </div>
  <div class="form-check mb-3">
    <label class="form-check-label">
      <input class="form-check-input" type="checkbox" name="remember"> Remember me
    </label>
  </div>
  
</form>
<button id="btn-save" class="btn btn-primary">SignUp</button>
	</div>
	
	<script src="/js/user/user.js"></script>
	<%@ include file="../layout/footer.jsp" %>