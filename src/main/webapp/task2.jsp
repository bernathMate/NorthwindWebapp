<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task2</title>
</head>
<body>
    <h1>Task2</h1>
    <form action="task2" method="GET">
        Number of products:<input type="number" name="numberOfProducts" min="0" value="0"><br>
        <input type="submit" value="Search">
    </form>
    <table>
        <thead>
        <tr>
            <th>Company</th>
            <th>Number of products</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="record" items="${task2}">
                <tr>
                    <td>${record.company}</td>
                    <td>${record.products}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:if test="${not empty error}">
        <p style="color: red;"><c:out value="${error}"/></p>
    </c:if>
</body>
</html>
