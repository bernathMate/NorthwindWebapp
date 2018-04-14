<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task1</title>
</head>
<body>
    <h1>Task1</h1>
    <table>
        <thead>
        <tr>
            <th>Product</th>
            <th>Company</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="record" items="${task1}">
                <tr>
                    <td>${record.product}</td>
                    <td>${record.company}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
