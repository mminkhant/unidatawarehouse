<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Decision Maker Queries Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            /*background-image: url("image/images.jpg");*/
            background-color: #F5FFFA;
        }
        .container {
            margin-top: 50px;
            text-align: center;
        }
        h1 {
            font-size: 36px;
            font-weight: bold;
            color: #333333;
            margin-bottom: 30px;
        }
        p {
            font-size: 18px;
            color: #666666;
            margin-bottom: 30px;
        }
        .form-select{
            width: 500px;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Welcome to Home Page</h1>
    <div class="d-flex justify-content-center">
        <select class="form-select" id="queries" aria-label="Default select example" onchange="servletRedirect()">
            <option selected>Choose Decision Maker Query</option>
            <option value="query1" >Number of Enrolled Students per Course per Year</option>
            <option value="query2" >Total Students who Passed or Failed per Course per Year</option>
            <option value="query3" >Pass Rate for Each Course per Year</option>
            <option value="query4" >Fail Rate for Each Course per Year</option>
            <option value="query5" >Top 3 cities with the most students</option>
            <option value="query6" >Module Count for Each Course</option>
            <option value="query7" >Oldest and Youngest Students in the University</option>
            <option value="query8" >Average Pass Rate and fail rate for Each Course Over All Years</option>
            <option value="query9" >Year with the Highest Overall Pass Rate</option>
            <option value="query10" >Year with the highest Overall Fail Rate</option>

        </select>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
<script type="text/javascript">
    function servletRedirect() {
        var value = document.getElementById("queries").value;
        if (value === "query1") {
            location.href = "Query1Servlet"
        }
        if (value === "query2") {
            location.href = "Query2Servlet"
        }
        if (value === "query3") {
            location.href = "Query3Servlet"
        }
        if (value === "query4") {
            location.href = "Query4Servlet"
        }
        if (value === "query5") {
            location.href = "Query5Servlet"
        }
        if (value === "query6") {
            location.href = "Query6Servlet"
        }
        if (value === "query7") {
            location.href = "Query7Servlet"
        }
        if (value === "query8") {
            location.href = "Query8Servlet"
        }
        if (value === "query9") {
            location.href = "Query9Servlet"
        }
        if (value === "query10") {
            location.href = "Query10Servlet"
        }
    }
</script>
</body>
</html>