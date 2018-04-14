<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task4</title>
</head>
<body>
    <h1>Task4</h1>
    <form action="task4" method="GET">
        Company name:<input type="text" name="companyName"><br>
        <input type="submit" value="Search">
    </form>
    <table>
        <thead>
        <tr>
            <th>Company</th>
            <th>Order IDs</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="record" items="${task4}">
                <tr>
                    <td>${record.company}</td>
                    <td>${record.ids}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:if test="${not empty error}">
        <p style="color: red;"><c:out value="${error}"/></p>
    </c:if>
</body>
</html>
