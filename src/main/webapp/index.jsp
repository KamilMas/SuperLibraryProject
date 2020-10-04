<%@ page import="model.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Arek
  Date: 03.10.2020
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<head>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/header.jspf"/>

<form action="/HomeServlet" method="post">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Number</th>
            <th scope="col">Title</th>
            <th scope="col">Author</th>
            <th scope="col">ISBN</th>
            <th scope="col">Category</th>
            <th scope="col">Relase Date</th>
            <th scope="col">Borrower</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${requestScope.books}" varStatus="loop">
            <tr>
                <th scope="row">${loop.index + 1}</th>
                <td>${book.title}</td>
                <td>${book.author.firstName}
                        ${book.author.lastName}
                </td>
                    <%--            <td>${book.author.firstName + " " + book.author.lastName}</td>--%>
                <td>${book.isbn}</td>
                <td>${book.category}</td>
                <td>${book.releasaDate}</td>
                <td>${book.borrows}</td>
                <td><input class="fora-check-input" type="radio" name="bookId" value="${bookId}" checked></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>


<%--<% for (Book b : (List<Book>) request.getAttribute("books")) { %>--%>
<%--<%= b.getTitle()%>--%>
<%--<%= b.getPages()%>--%>
<%--<%= b.getAuthor().getFirstName()%>--%>
<%--<%= b.getCategory()%>--%>
<%--<%= b.getIsbn()%>--%>
<%--<%= b.getReleasaDate()%>--%>
<%--<%= b.getSummary()%>--%>
<%--<br>--%>
<%--<%}%>--%>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>
<script src="webjars/bootstrap/4.0.0-2/js/bootstrap.js"></script>
</body>
</html>
