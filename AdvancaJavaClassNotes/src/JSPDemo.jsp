<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Tags Sample</title>
</head>
<body>
    <h1>Hello, JSP!</h1>

    <%-- Declaration Tag --%>
    <%!
        int number = 10;
    %>

    <%-- Scriptlet Tag --%>
    <%
        String name = "World";
        out.println("Hello, " + name + "!");
    %>

    <%-- Expression Tag --%>
    <p>The value of number is <%= number %>.</p>

    <%-- Directive Tag --%>
    <%@ include file="header.jsp" %>

    <%-- Action Tag - Use of Forward --%>
    <jsp:forward page="footer.jsp" />

    <%-- Action Tag - Use of Include --%>
    <jsp:include page="footer.jsp" />

    <%-- Action Tag - Use of Param --%>
    <jsp:param name="message" value="Hello from param!" />

    <%-- Use of UseBean and SetProperty --%>
    <jsp:useBean id="user" class="com.example.User" scope="session" />
    <jsp:setProperty name="user" property="name" value="John Doe" />

    <%-- Use of Include Directive --%>
    <%@ include file="footer.jsp" %>

    <%-- Use of Include Action --%>
    <jsp:include page="footer.jsp" />

    <%-- Use of Param Action --%>
    <jsp:param name="message" value="Hello from param!" />

    <%-- Use of UseBean and SetProperty --%>
    <jsp:useBean id="user" class="com.example.User" scope="session" />
    <jsp:setProperty name="user" property="name" value="John Doe" />
</body>
</html>
