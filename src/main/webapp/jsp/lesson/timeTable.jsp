<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lessons By Teacher</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/styles.css"
          media="screen"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lessonsUtils.js"></script>

</head>
<body>
<div style="width: 900px" class="container panel panel-footer">
    <h3 style="text-align: center">Time Table</h3>
    <c:if test="${lessons.size() == 0}">
        <div><em>No lessons</em></div>
    </c:if>
    <c:if test="${lessons.size() != 0}">
        <table class="table table-bordered table-responsive">
            <tr>
                <th class="col-sm-2 text-center">Time Slot</th>
                <th class="col-sm-2 text-center">Subject</th>
                <th class="col-sm-1 text-center">Group</th>
                <th class="col-sm-2 text-center">Teacher</th>
                <th class="col-sm-1 text-center">Room</th>
                <th class="col-sm-2 text-center">Lesson Type</th>
                <th class="col-sm-2 text-center">Day</th>
                <th class="col-sm-1 text-center"></th>
                <th class="col-sm-1 text-center"></th>
            </tr>
            <c:forEach items="${lessons}" var="lesson">
                <tr valign="top">
                    <td class="text-center"><span>${lesson.timeSlot}</span></td>
                    <td class="text-center"><span>${lesson.subject.name}</span></td>
                    <td class="text-center"><span>${lesson.group.number}</span></td>
                    <td class="text-center"><span>${lesson.teacher.firstName}${lesson.teacher.lastName}</span></td>
                    <td class="text-center"><span>${lesson.room.number}</span></td>
                    <td class="text-center"><span>${lesson.lessonType}</span></td>
                    <td class="text-center"><span>${lesson.day}</span></td>
                    <td class="text-center"><a class="btn btn-primary"
                                               href="editLesson?id=${lesson.id}">Edit</a>
                    </td>
                    <td>
                        <button class="deleteLesson btn btn-danger glyphicon glyphicon-trash"
                                id="${lesson.id}"></button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <a style="margin-left: 35%; margin-top: 5%" class="btn btn-primary" href="addLesson">Add lesson</a>
    <input style="margin-top: 5%" class="btn btn-default" type="button" onclick="parent.location='/home_page'"
           value="Return to home page">
</div>
</body>
</html>
