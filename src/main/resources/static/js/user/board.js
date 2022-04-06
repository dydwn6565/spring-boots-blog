let index = {
	init: function() {
		$("#btn-board-write").on("click", () => {
			this.saveBoard();
		});
		$("#btn-board-write-update").on("click", () => {
			this.boardDetailUpdate();
		});
		$("#btn-board-detail-delete").on("click", () => {
			this.boardDetailDelete();
		});
		$("#btn-reply-save").on("click", () => {
			this.replySave();
		});
	},
	saveBoard: function() {
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),

		}

		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data),
			contentType: "application/json; charset=urf-8", // type of data
			dataType: "json"
		}

		).done(function(result) {
			alert("successfully added your write");
			console.log()
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error))
		}); // ajax communication
	},

	boardDetailUpdate: function() {
		let id = $("#id").val();

		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		}

		$.ajax({
			type: "PUT",
			url: "/api/board/" + id,
			data: JSON.stringify(data),
			contentType: "application/json; charset=urf-8", // type of data
			dataType: "json"
		}

		).done(function(result) {
			alert("successfully fixed your write");
			console.log()
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error))
		}); // ajax communication
	},

	boardDetailDelete: function() {
		let id = $("#id").text();

		$.ajax({
			type: "DELETE",
			url: "/api/board/" + id,
			dataType: "json"
		}).done(function(result) {
			alert("successfully deleted detail page");
			console.log()
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error))
		});
	},

	replySave: function() {

		let data = {
			userId: $("#userId").val(),
			content: $("#reply-content").val(),
			boardId: $("#boardId").val(),
		}


		$.ajax({
			type: "POST",
			url: `/api/board/${data.boardId}/reply`,
			data: JSON.stringify(data),
			contentType: "application/json; charset=urf-8", // type of data
			dataType: "json"
		}

		).done(function(result) {
			alert("successfully added your comment");
			console.log()
			location.href = `/board/${data.boardId}`;
		}).fail(function(error) {
			alert(JSON.stringify(error))
		}); // ajax communication
	},

	replyDelete: function(boardId,replyId) {

		$.ajax({
			type: "DELETE",
			url: `/api/board/${boardId}/reply/{replyId}`,
			data: JSON.stringify(data),
			contentType: "application/json; charset=urf-8", // type of data
			dataType: "json"
		}
		).done(function(result) {
			alert("successfully added your comment");
			location.href = `/board/${boardId}`;
		}).fail(function(error) {
			alert(JSON.stringify(error))
		}); // ajax communication
	},
}


index.init();