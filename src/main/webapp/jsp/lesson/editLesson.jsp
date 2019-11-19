<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit lesson by teacher</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/styles.css"
          media="screen"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div style="width: 800px" class="container panel panel-footer">
    <h3 align="center">
        Editing a lesson
    </h3>
    <div class="alert alert-danger ${error==null ? "hidden" : ""}" role="alert ">
        ${error}
    </div>
    <form action="editLesson" method="post">
        <table class="table">
            <input type="hidden" name="id" value="${lesson.id}">
            <tr>
                <td><p>Time Slot: </p></td>
                <td>
                    <p><select style="width: 30%" name="timeSlot" class="fieldTimeSlot form-control"
                               value="${lesson.timeSlot}">
                        <option></option>
                        <option>FIRST</option>
                        <option>SECOND</option>
                        <option>THIRD</option>
                        <option>FOURTH</option>
                        <option>FIFTH</option>
                        <option>SIXTH</option>
                    </select></p>
                </td>
            </tr>
            <tr>
                <td><p>Group: </p></td>
                <td><input style="width: 30%" type="text" name="groupNumber" value="${lesson.group.number}"
                           maxlength="5"
                           class="form-control"></td>
            </tr>
            <tr>
                <td><p>Teacher: </p></td>
                <td><input style="width: 30%" type="text" name="firstName" value="${lesson.teacher.firstName}"
                           maxlength="5"
                           class="form-control">
                    <input style="width: 30%" type="text" name="lastName" value="${lesson.teacher.lastName}"
                           maxlength="5"
                           class="form-control"></td>
            </tr>
            <tr>
                <td><p>Subject: </p></td>
                <td><input style="width: 30%" type="text" name="subject" value="${lesson.subject.name}" maxlength="10"
                           class="form-control"></td>
                </td>
            </tr>
            <tr>
                <td><p>Room: </p></td>
                <td><input style="width: 30%" type="text" name="roomNumber" value="${lesson.room.number}" maxlength="5"
                           class="form-control"></td>
                </td>
            </tr>
            <tr>
                <td><p>Lesson Type: </p></td>
                <td>
                    <p><select style="width: 30%" name="lessonType" value="${lesson.lessonType}"
                               class="fieldLessonType form-control">
                        <option></option>
                        <option>LECTURE</option>
                        <option>LAB</option>
                    </select></p>
            </tr>
            <tr>
                <td><p>Day: </p></td>
                <td>
                    <p><select style="width: 30%" name="day" value="${lesson.day}" class="fieldDay form-control">
                        <option></option>
                        <option>MONDAY</option>
                        <option>TUESDAY</option>
                        <option>WEDNESDAY</option>
                        <option>THURSDAY</option>
                        <option>FRIDAY</option>
                    </select></p>
            </tr>
            <tr>
                <td>
                </td>
                <td align="right">
                    <input type="submit" name="button" class="saveRoom btn btn-success" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
