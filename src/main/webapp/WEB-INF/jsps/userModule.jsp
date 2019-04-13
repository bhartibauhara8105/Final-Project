<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>

table {
  border-collapse: collapse;
}

table, td, th {
  border: 1px solid black;
}

</style>

</head>
<body>
<h1>In User Module</h1>


<table class="table">
 <tr>
  
      <th scope="col">Job Title</th>
      <th scope="col">Job Category</th>
      <th scope="col">Job Location</th>
         <th scope="col">Job Description</th>
            <th scope="col">Experience</th>
               <th scope="col">Salary</th>
    </tr>
<c:forEach items="${jobs}" var="jobs">
<tr>      
    <td>${jobs.title}</td>
  <td>${jobs.category}</td>
      <td>${jobs.location}</td>
     <td>${jobs.description}</td>
    <td>${jobs.experience}</td>
    <td>${jobs.salary}</td> 
</tr>
</c:forEach>
</table>









</body>
</html>