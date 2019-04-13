<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page import="java.util.ArrayList" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>

#lbl{
margin-top:20px;
}

</style>

</head>
<body>
<%-- <h2>In User Module <br><% --%>

<%
int count=0;
		if (session != null) {
			if (session.getAttribute("username") != null) {
				String name = (String) session.getAttribute("username");
				Long id = (Long)session.getAttribute("userid");
				String r=session.getAttribute("resume").toString();
				count=Integer.parseInt(r);
				//out.print("Hello, " + name + "  Welcome to ur Profile ");//+id+"    "+r);
			} else {
				session.invalidate();
				response.sendRedirect("login/login.jsp");
				//out.println("session is expired");
			}
		}
 
 
	%>






 <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
              <a class="navbar-brand" href="#">JOBS</a>
              <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                  <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="Aboutus.jsp">About Us </a>
                  </li>
                  <li class="nav-item active">
                    <a class="nav-link" href="#">Services</a>
                  </li>
                  <li class="nav-item active">
                    <a class="nav-link" href="#">Contact Us</a>
                  </li>
                  
                  
               
                  
                
                 
                 
                 
                 
              </ul>
              
              
              
              
              
              
              
              
              
              
              <%
              
              if (session != null) {
      			if (session.getAttribute("username") != null) {
              
              %>

<a href="showLogout">  <button type="button" onclick="call()" class="btn btn-primary my-2 my-sm-0" >   
                    Logout
                  </button>
     
              </a>
<%

      			}
              }
              else{
%>

             <a href="showLogin">  <button type="button"  class="btn btn-primary my-2 my-sm-0" >
                    Login
                  </button>
                 </a>
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
           <a href="showReg">   <button type="button" class="btn btn-success my-2 my-sm-0" >
               Sign Up
              </button>
              </a>
              
              
              <%
              
              
              }
              %>
              
              
            </div>
          </nav>














<br><br>
  <div class="container">
              
<!--            		<p> -->
           		
<!--            		<h3>Career Advice and Tips</h3> -->
<!--            		      <div class="card "> -->
                      
<!--                       <div class="card-body"> -->
<!--                         <p>01 Work-life Balance: A tale of three regions - India, UAE and SEA (Infographic) -->
<!-- <br>Apr 2019</p> -->
<!--                       </div> -->
<form action="jobs/searchJobs" method="post">
  <div class="form-row">
     
     
  <div class="form-row align-items-center">
    <div class="col-auto my-1">
      <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="category">
        <option selected>category</option>
                        <c:forEach items="${category}" var="category">
 <option >${category}</option>
<!--  <option> Job Provider</option> -->
 </c:forEach>
      </select>
    </div>
                  
          </div>
              
              
                  
 
                  
                  
                         
                
                 <div class="form-row align-items-center">
    <div class="col-auto my-1">
      <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="location">
        <option selected>location</option>
                        <c:forEach items="${location}" var="location">
 <option >${location}</option>
<!--  <option> Job Provider</option> -->
 </c:forEach>
      </select>
    </div>
                  
          </div>
                  
                  
              
                         
                
                  
                   <div class="form-row align-items-center">
    <div class="col-auto my-1">
      <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="experience">
        <option selected>experience</option>
                        <c:forEach items="${experience}" var="experience">
 <option >${experience}</option>
<!--  <option> Job Provider</option> -->
 </c:forEach>
      </select>
    </div>
                  
          </div>
                
                  
        <input type="submit" class="btn btn-primary" value="serach" />  
     
     
      </div>
     </form>
     </div>
<!-- Button trigger modal 
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
 Search Jobs
</button>

<!-- Modal --
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
     
     
     
     <form action="jobs/searchJobs" method="post">
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="validationDefault01">Category</label>
      <input type="text" class="form-control" id="validationDefault01" placeholder="Category" name="category" required>
    </div>
    <div class="col-md-4 mb-3">
      <label for="validationDefault02">Location</label>
      <input type="text" class="form-control" id="validationDefault02" placeholder="Location" name="location" required>
    </div>
     
       <div class="col-md-4 mb-3">
      <label for="validationDefault02">Experience</label>
      <input type="text" class="form-control" id="validationDefault02" placeholder="Experience" name="experience" required>
    </div>
     
     
       <div class="col-md-4 mb-3">
      
      <input type="submit" value="serach" />
    </div>
     
     
      </div>
     </form>
    </div>
  </div>
</div>


</div>-->
<br><br><br><br>


<table class="table table-bordered ">
 <tr>
  
      <th scope="col">Job Title</th>
      <th scope="col">Job Category</th>
      <th scope="col">Job Location</th>
         <th scope="col">Job Description</th>
            <th scope="col">Experience</th>
               <th scope="col">Salary</th>
                <th scope="col">Apply Jobs</th>
    </tr>
<c:forEach items="${jobs}" var="jobs">
<tr >  
 
    <td>${jobs.title}</td>
  <td>${jobs.category}</td>
      <td>${jobs.location}</td>
     <td>${jobs.description}</td>
    <td>${jobs.experience}</td>
    <td>${jobs.salary}</td> 
    
  
    
    <form action="appliedjobs/apply" method="post" >
    <input type="hidden" name="userid" value= ${userid}/>
    <input type="hidden" name="resumeid" value=<%=count %>/>
    <input type="hidden" name="jobid" value=${jobs.id}/>
    
    
     <td><input type="submit" id=${jobs.id} value="Apply" ></td>
     

     
     
     
<!--     <td><input type="submit" value="Apply" disabled></td> -->
    
<!--     <input type="hidden" name="try" value=${flag}/> -->
<%--      <c:set var="f" value="${flag}"> </c:set> --%>
<%-- <%out.println("flag value: "); %> <c:out value='${flag}' /> ${f} --%>
<%-- <c:choose>  --%>
<%--   <c:when test="${f==''}"> --%>
<%--   <%  out.print("hi");%> --%>
<!--    <td><input type="submit" value="Apply" ></td> -->
<%--   </c:when> --%>
<%--   <c:otherwise> --%>

<%-- <% out.print("bye"); %>  --%>
<%--   </c:otherwise> --%>
<%-- </c:choose> --%>
   
    </form>
</tr>

</c:forEach>
</table>

<br><br>

<jsp:include page="../../../footer.jsp" /> 


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


</body>


<script type="text/javascript">
	function disableButton(btn){
		document.getElementById(btn.id).disabled = true;
		//alert("Button has been disabled.");
	}
</script>

</html>