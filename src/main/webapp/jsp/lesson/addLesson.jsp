<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter Teacher info</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/styles.css"
          media="screen"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/lessonsUtils.js"></script>
</head>
<body>
<div style="width: 700px" class="container panel panel-footer">
    <h3 style="text-align: center">Enter information</h3>
    <div class="alert alert-danger ${error==null ? "hidden" : ""}" role="alert ">
        ${error}
    </div>
    <form name="addLesson-form" action="addLesson" method="post">
        <table class="table">
            <td><p>Time Slot: </p></td>
            <td>
                <p><select style="width: 60%" name="timeSlot" class="fieldTimeSlot form-control" required="true">
                    <option></option>
                    <option>FIRST</option>
                    <option>SECOND</option>
                    <option>THIRD</option>
                    <option>FOURTH</option>
                    <option>FIFTH</option>
                    <option>SIXTH</option>
                </select></p>
            </td>

            <tr>
                <td><p>Subject: </p></td>
                <td><select style="width: 60%" name="subject" class="fieldTimeSlot form-control" required="true">
                    <c:forEach items="${subjects}" var="subject">
                        <option value="${subject.name}">${subject.name}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td><p>Group: </p></td>
                <td>
                    <select style="width: 60%" name="groupNumber" class="fieldTimeSlot form-control" required="true">
                        <c:forEach items="${groups}" var="group">
                            <option value="${group.number}">${group.number}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><p>Teacher: </p></td>
                <td><select style="width: 60%" name="teacherId" class="fieldTimeSlot form-control" required="true">
                    <c:forEach items="${teachers}" var="teacher">
                        <option value="${teacher.id}">${teacher.firstName}${teacher.lastName}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td><p>Room: </p></td>
                <td><select style="width: 60%" name="roomNumber" class="fieldTimeSlot form-control" required="true">
                    <c:forEach items="${rooms}" var="room">
                        <option value="${room.number}">${room.number}</option>
                    </c:forEach>
                </select></td>
                </td>
            </tr>
            <tr>
                <td><p>Lesson Type: </p></td>
                <td>
                    <p><select style="width: 60%" name="lessonType" class="fieldLessonType form-control"
                               required="true">
                        <option></option>
                        <option>LECTURE</option>
                        <option>LAB</option>
                    </select></p>
            </tr>
            <tr>
                <td><p>Day: </p></td>
                <td>
                    <p><select style="width: 60%" name="day" class="fieldDay form-control" required="true">
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
                    <div>
                        <input style="margin-top: 5%" type="submit" name="button" class="validateForm btn btn-success"
                               value="Save"/>
                        <input style="margin-top: 5%" class="btn btn-default" type="button"
                               onclick="parent.location='/home_page'" value="Cancel">
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
