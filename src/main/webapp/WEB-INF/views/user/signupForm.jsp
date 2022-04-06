
<%@ include file="../layout/header.jsp" %>
	<div class="container">
	<form >
  <div class="mb-3">
    <label for="pwd" class="form-label">Username:</label>
    <input type="text" class="form-control" id="username" placeholder="Enter password" >
  </div>
  <div class="mb-3">
    <label for="pwd" class="form-label">Password:</label>
    <input type="password" class="form-control" id="password" placeholder="Enter password">
  </div>
  <div class="mb-3 mt-3">
    <label for="email" class="form-label">Email:</label>
    <input type="email" class="form-control" id="email" placeholder="Enter email">
  </div>
  
  
</form>
<button id="btn-save" class="btn btn-primary">SignUp</button>
	</div>
	
	<script src="/js/user/user.js"></script>
	<%@ include file="../layout/footer.jsp" %>