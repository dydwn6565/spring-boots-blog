
<%@ include file="../layout/header.jsp" %>
	<div class="container">
			
	
  <form >
  <input type="hidden" id="id" value="${board.id }"/>
  <div class="form-group">
  
    <input value="${board.title }" type="text" class="form-control"  placeholder="Enter title"  id="title">
  </div>
  
  <div class="form-group">
    
    <textarea class="form-control summernote"  rows="5"  id="content">${board.content }</textarea>
    
  </div>
  <button id="btn-board-write-update" class="btn btn-primary">Completed fix</button>
  </div>
  
  </form>
  
	</div>
	
    <script>
      $('.summernote').summernote({
        placeholder: 'Hello stand alone ui',
        tabsize: 2,
        height: 300,
        toolbar: [
          ['style', ['style']],
          ['font', ['bold', 'underline', 'clear']],
          ['color', ['color']],
          ['para', ['ul', 'ol', 'paragraph']],
          ['table', ['table']],
          ['insert', ['link', 'picture', 'video']],
          ['view', ['fullscreen', 'codeview', 'help']]
        ]
      });
    </script>
    <script src="/js/user/board.js"></script>
	<%@ include file="../layout/footer.jsp" %>
	
	
	
	
	