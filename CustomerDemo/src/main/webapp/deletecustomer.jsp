<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Customer Account Delete</h2>

    <%
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String userName = request.getParameter("uname");
    %>

    <form action="delete" method="post">
        Customer ID <input type="text" name="cusid" value="<%= id %>" readonly><br>
        Name <input type="text" name="name" value="<%= name %>" readonly><br>
        Email <input type="text" name="email" value="<%= email %>" readonly><br>
        Phone Number <input type="text" name="phone" value="<%= phone %>" readonly><br>
        Username <input type="text" name="uname" value="<%= userName %>" readonly><br>

        <input type="submit" name="submit" value="Delete My Account">
    </form>
</body>
</html>