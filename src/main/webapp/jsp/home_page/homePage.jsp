<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/styles.css"
          media="screen"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
   <title>Home Page</title>
</head>
<body>
<div class="container panel panel-footer" style="width: 100%; height: 100%">
    <h1 class="text-center">Welcome to TimeTable!</h1>

    <div class="list-group">
        <a href="listOfTeachers" class="list-group-item list-group-item-action">All teachers</a>
        <a href="listOfGroups" class="list-group-item list-group-item-action">All groups</a>
        <a href="listOfRooms" class="list-group-item list-group-item-action">All rooms</a>
        <a href="listOfSubject" class="list-group-item list-group-item-action">All subjects</a>
        <a href="timeTable" class="list-group-item list-group-item-action">Time Table</a>
    </div>
</div>
</body>
</html>
