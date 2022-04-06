
<%@ include file="../layout/header.jsp"%>
<div class="container">

	<form>
		<input type="hidden" id="updateId" value="${principal.user.id}" />
		<div class="mb-3">
			<label for="pwd" class="form-label">Username:</label> <input type="text" value="${principal.user.username}" class="form-control" id="updateUsername" placeholder="Enter username" readonly>
		</div>

		<c:if test="${ empty principal.user.oauth }">
			<div class="mb-3">
				<label for="pwd" class="form-label">Password:</label> <input type="password" class="form-control" id="updatePassword" placeholder="Enter password" readonly>
			</div>
		</c:if>

		<div class="mb-3 mt-3">
			<label for="email" class="form-label">Email:</label> <input type="email" value="${principal.user.email}" class="form-control" id="updateEmail" placeholder="Enter email">
		</div>
		<div class="form-check mb-3"></div>

	</form>
	<button id="btn-fix-user-info" class="btn btn-primary">Fix user info</button>
</div>

<script src="/js/user/user.js"></script>
<%@ include file="../layout/footer.jsp"%>