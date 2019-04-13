<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="userModule">Back</a>
<br><br>



<%
int count=0;
		if (session != null) {
			if (session.getAttribute("username") != null) {
				String name = (String) session.getAttribute("username");
				Long id = (Long)session.getAttribute("userid");
				String r=session.getAttribute("resume").toString();
				count=Integer.parseInt(r);
				out.print("Hello, " + name + "  Welcome to ur Profile ");//+id+"    "+r);
			} else {
				session.invalidate();
				response.sendRedirect("login/login.jsp");
				//out.println("session is expired");
			}
		}
 
 
	%></h2>


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
<c:forEach items="${searchedList}" var="jobs1">
<tr >  
 
    <td>${jobs1.title}</td>
  <td>${jobs1.category}</td>
      <td>${jobs1.location}</td>
     <td>${jobs1.description}</td>
    <td>${jobs1.experience}</td>
    <td>${jobs1.salary}</td> 
    
  
    
    <form action="appliedjobs/apply" method="post" >
    <input type="hidden" name="userid" value= ${userid}/>
    <input type="hidden" name="resumeid" value=<%=count %>/>
    <input type="hidden" name="jobid" value=${jobs.id}/>
    
    
     <td><input type="submit" id=${jobs.id} value="Apply" ></td>
   
    </form>
</tr>

</c:forEach>
</table>









</body>
</html>