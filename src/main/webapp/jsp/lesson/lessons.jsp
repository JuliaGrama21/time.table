<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lessons By Teacher</title>
    <link rel="stylesheet" type="text/css" href="resources/css/styles.css"
          media="screen"/>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/lessonsUtils.js"></script>

</head>
<body>
<div style="width: 900px" class="container panel panel-footer">
    <h3 style="text-align: center">List Lessons</h3>

    <c:if test="${lessons.size() == 0}">
        <div><em>No lessons</em></div>
    </c:if>
    <c:if test="${lessons.size() != 0}">
        <table class="table table-bordered table-responsive">
            <tr>
                <th class="col-sm-6 text-center">Time Slot</th>
                <th class="col-sm-1 text-center ${groupId == null ? "" : "hidden"}">Group</th>
                <th class="col-sm-1 text-center ${teacherId == null ? "" : "hidden"}">Teacher</th>
                <th class="col-sm-2 text-center ${teacherId == null ? "" : "hidden"}"></th>
                <th class="col-sm-1 text-center ${roomId == null ? "" : "hidden"}">Room</th>
                <th class="col-sm-2 text-center">Lesson Type</th>
                <th class="col-sm-2 text-center">Day</th>
                <th class="col-sm-2 text-center"></th>
                <th class="col-sm-2 text-center"></th>
            </tr>
            <c:forEach items="${lessons}" var="lesson">
                <tr valign="top">
                    <td class="text-center"><span>${lesson.timeSlot}</span></td>
                    <td class="text-center ${groupId == null ? "" : "hidden"}"><span>${lesson.group.number}</span></td>
                    <td class="text-center ${teacherId == null ? "" : "hidden"}"><span>${lesson.teacher.firstName}</span></td>
                    <td class="text-center ${teacherId == null ? "" : "hidden"}"><span>${lesson.teacher.lastName}</span></td>
                    <td class="text-center ${roomId == null ? "" : "hidden"}"><span>${lesson.room.number}</span></td>
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
    <a style="margin-left: 35%; margin-top: 5%" class="btn btn-primary" href="addLesson?${teacherId == null ? "" : "teacherId="}${teacherId == null ? "" : teacherId}${groupId == null ? "" : "groupId="}${groupId == null ? "" : groupId}${roomId == null ? "" : "roomId="}${roomId == null ? "" : roomId}">Add lesson</a>
    <input style="margin-top: 5%" class="btn btn-default" type="button" onclick="parent.location='/home_page'"
           value="Return to home page">
</div>
</body>
</html>
