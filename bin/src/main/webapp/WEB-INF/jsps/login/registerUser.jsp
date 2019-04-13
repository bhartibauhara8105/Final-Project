<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
</head>
<body>
<h2>User Registration</h2>
<form action="registerUser" method="post">
First Name: <input type="text" name="firstName"/><br><br>
Last Name:<input type="text" name="lastName"/><br><br>
User Name:<input type="email" name="email"/><br><br>
Password:<input type="password" name="password"/><br><br>
Confirm Password:<input type="password" name="confirmPassword"/><br><br>
Phone:<input type="number" name="phone"/><br><br>
Role: <select name="role">
 <option >Job Seeker</option>
 <option> Job Provider</option>
 </select>
 

<input type="submit" value="register"/>
</form>
</body>
</html>