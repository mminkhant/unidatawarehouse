<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.adswarehousesem2.DecisionMakerQueriesModel" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Query 5 Results</title>

    <!-- Adding Bootstrap CSS from CDN -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h1 class="text-center mb-4">Top 3 cities with the most students</h1>

    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>City</th>
            <th>Student Count</th>
        </tr>
        </thead>
        <tbody>
        <!-- Looping through the data using JSTL -->
        <c:forEach var="data" items="${data}">
            <tr>
                <td>${data.CITY}</td>
                <td>${data.studentCount}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<!-- Adding Bootstrap JS and Popper.js from CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
