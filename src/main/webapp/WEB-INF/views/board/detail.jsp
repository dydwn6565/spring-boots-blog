<%@ include file="../layout/header.jsp"%>

<div class="container">
	<button class="btn btn-secondary" onclick="history.back()">back</button>
	<c:if test="${board.user.id == principal.user.id }">
		<a href="/board/${board.id }/updateForm" class="btn btn-warning">fix</a>
		<button class="btn btn-danger" id="btn-board-detail-delete">delete</button>
	</c:if>

	<br /> <br />
	<div>
		write number: <span id="id"><i>${board.id}</i></span> writer : <span><i>${board.user.username}</i></span>
	</div>
	<br />
	<div class="form-group">
		<label for="title">Title</label>
		<h3>${board.title}</h3>
	</div>

	<div class="mb-3">
		<label for=content>Content:</label>
		<div>${board.content}</div>
	</div>
	<hr />

	<div class="card">
	<form>
	<input type="hidden" id="userId" value="${principal.user.id}"/>
	<input type="hidden" id="boardId" value="${board.id }"/>
	
		<div class="card-body">
			<textarea id="reply-content" class="form-control" rows="1"></textarea>
		</div>
		<div class="card-footer">
			<button type="button" id="btn-reply-save" class="btn btn-primary">Register</button>
		</div>
		</form>
	</div>
	
	<br />
	<div class="card">
	
		<div class="card-header">Comment List</div>
		<ul id="reply-box" class="list-group">
			
			<c:forEach var="reply" items="${board.replys}">
				<li id="reply-${reply.id}" class="list-group-item d-flex justify-content-between">
					<div>${reply.content}</div>
					<div class="d-flex">
						<div class="fst-italic">Writer: ${reply.user.username }</div>
						<button onClick="index.replyDelete(${board.id},${reply.id})"class="badge bg-secondary">delete</button>

					</div>
					
				</li>
			</c:forEach>

		</ul>
		<%-- ${board.toString()} --%>
	</div>
</div>

<script src="/js/user/board.js"></script>
<%@ include file="../layout/footer.jsp"%>




