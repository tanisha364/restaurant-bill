<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Form</title>
</head>
<body>
    <h1>Order Form</h1>
    <form action="/bill" method="post">
        <label for="foodName">Food Name:</label>
        <input type="text" id="foodName" name="foodName">
        <br>
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity">
        <br>
        <input type="submit" value="Add Food">
    </form>
</body>
</html>
