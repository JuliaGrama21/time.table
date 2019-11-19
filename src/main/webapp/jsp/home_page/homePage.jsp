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
    <div align="center">
        <a class="btn btn-info buttons" style="font-size: 22px;" href="listOfTeachers">Teacher</a>
        <a class="btn btn-info buttons" style="font-size: 22px;" href="listOfGroups">Group</a>
        <a class="btn btn-info buttons" style="font-size: 22px;" href="listOfRooms">Room</a>
        <a class="btn btn-info buttons" style="font-size: 22px;" href="timeTable">Lesson</a>
        <a class="btn btn-info buttons" style="font-size: 22px;" href="listOfSubject">Subject</a>
    </div>
</div>
</body>
</html>
