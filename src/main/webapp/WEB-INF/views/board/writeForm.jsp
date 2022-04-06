
<%@ include file="../layout/header.jsp" %>
	<div class="container">
			
	
  <form >
  <div class="form-group">
  <label for="title">Title</label>
  <div class="mb-3">
    <input type="text" class="form-control"  placeholder="Enter title"  id="title">
  </div>
  
  <div class="mb-3">
    <label for=content >Content</label>
    <textarea class="form-control summernote"  rows="5"  id="content"></textarea>
    
  </div>
  
  </div>
  </form>
  <button id="btn-board-write" class="btn btn-primary">Complete</button>
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
	
	
	
	
	