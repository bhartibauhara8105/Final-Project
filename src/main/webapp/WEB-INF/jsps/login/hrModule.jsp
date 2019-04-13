<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
      <%
int count=0;
		if (session != null) {
			if (session.getAttribute("username") != null) {
				String name = (String) session.getAttribute("username");
				Long id = (Long)session.getAttribute("userid");
				//String r=session.getAttribute("resume").toString();
				//count=Integer.parseInt(r);
				//out.print("Hello, " + name + "  Welcome to ur Profile ");//+id+"    "+r);
			} else {
				session.invalidate();
				response.sendRedirect("login/login.jsp");
				//out.println("session is expired");
			}
		}
 
 
	%>
              
         
<jsp:include page="../../../header.jsp" />  

<br><br>






<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
  Post New Job
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Post JOB</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        
        
<%--         <%out.print(session.getAttribute("userid")); %> --%>
        
        <form action="jobs/postJobs" method="post" ModelAttribute="jobs">
        <input type="hidden" name="user" value=<%=session.getAttribute("userid") %>>
  <div class="form-group">
    <label for="exampleInputEmail1">Job Title</label>
    <input type="text" class="form-control" name="title" placeholder="Enter job title">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Job Category</label>
    <input type="text" class="form-control"  name="category" placeholder="Enter job category">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Job Location</label>
    <input type="text" class="form-control" name="location" placeholder="Enter job location">
  </div>
   <div class="form-group">
    <label for="exampleInputEmail1">Job Description</label>
   <textarea class="form-control" id="exampleFormControlTextarea1" name="description" rows="7"></textarea>
  </div>
   <div class="form-group">
    <label for="exampleInputEmail1">Experience</label>
    <input type="text" class="form-control" name="experience" placeholder="Enter experience">
  </div>
   <div class="form-group">
    <label for="exampleInputEmail1">Salary</label>
    <input type="text" class="form-control" name="salary" placeholder="Enter salary">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  <button type="reset" class="btn btn-dark">Reset</button>
</form>
        
        
        
        
        
        
        
        
        
      </div>
<!--       <div class="modal-footer"> -->
<!--         <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button> -->
<!--         <button type="button" class="btn btn-primary">Save changes</button> -->
<!--       </div> -->
    </div>
  </div>
</div>


















<a href="#">View Job</a><br>
<a href="#">Update Job</a><br>
<a href="#">Delete Job</a><br>
<a href="#">view Applied Job</a><br>
<br><br>
<jsp:include page="../../../footer.jsp" /> 
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</html>