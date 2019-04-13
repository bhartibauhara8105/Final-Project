<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Upload Your Resume</h2>

<%
request.getSession(false);

%>
<form action="resume/registerResume" method="post" >

<input type="hidden" name="email"  value=${userid}>

<div class="custom-file">


  <input type="file" class="custom-file-input" name="resumeFile" id="customFile">
  <label class="custom-file-label" for="customFile">Choose file</label>
</div>

<input type="submit" value="Submit Resume"/>

</form>
</body>
</html>