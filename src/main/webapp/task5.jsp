<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task5</title>
</head>
<body>
    <h1>Task5</h1>
    <form action="task5" method="GET">
        Min. unit price:<input type="number" name="minUnitPrice" min="1" value="1" step="0.01"><br>
        <input type="submit" value="Search">
    </form>
    <table>
        <thead>
        <tr>
            <th>Company</th>
            <th>Product</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="record" items="${task5}">
                <tr>
                    <td>${record.company}</td>
                    <td>${record.product}</td>
                    <td>${record.price}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:if test="${not empty error}">
        <p style="color: red;"><c:out value="${error}"/></p>
    </c:if>
</body>
</html>
