<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Reservation</title>
</head>
<body>
<h2>Complete Reservation</h2>
Airline:${flight.operatingAirlines }<br>
Departure City:${flight.departureCity }<br>
Arrival City:${flight.arrivalCity }<br>


<form action="completeReservation" method="POST">
<h2>Passenger Details</h2><br><br>
First Name:<input type="text" name="passengerFirstName"><br><br>
Last Name:<input type="text" name="passengerLastName"><br><br>
Email:<input type="email" name="passengerEmail"><br><br>
Phone:<input type="text" name="passengerPhone"><br><br>


<h2>Card Details</h2>

Name On The Card:<input type="text" name="nameOnTheCard"><br><br>
Card Number:<input type="text" name="cardNumber"><br><br>
Expiry Date:<input type="text" name="expiryDate"><br><br>
CVV:<input type="text" name="cvv"><br><br>

<input type="hidden" name="id" value="${flight.id }"/>

<input type="submit" value="Confirm"/>


</form>

</body>
</html>