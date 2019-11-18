<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter Teacher info</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/styles.css"
          media="screen"/>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/lessonsUtils.js"></script>
</head>
<body>
<div style="width: 700px" class="container panel panel-footer">
    <h3 style="text-align: center">Enter information</h3>
    <form name="addLesson-form" action="addLesson" onsubmit="return validateForm();" method="post">
        <table class="table">
            <td hidden><input name="teacherId" value="${teacherId}"></td>
            <td hidden><input name="groupId" value="${groupId}"></td>
            <td hidden><input name="roomId" value="${roomId}"></td>
            <td><p>Time Slot: </p></td>
            <td>
                <p><select style="width: 30%" name="timeSlot" class="fieldTimeSlot form-control" required="true">
                    <option></option>
                    <option>FIRST</option>
                    <option>SECOND</option>
                    <option>THIRD</option>
                    <option>FOURTH</option>
                    <option>FIFTH</option>
                    <option>SIXTH</option>
                </select></p>
            </td>
            <tr class="${groupId == null ? "" : "hidden"}">
                <td ><p>Group: </p></td>
                <td><input style="width: 30%" type="text" name="groupNumber" placeholder="number" maxlength="5"
                           class="form-control" required="true"></td>
            </tr>

            <tr class="${teacherId == null ? "" : "hidden"}">
                <td ><p>Teacher: </p></td>
                <td><input style="width: 30%" type="text" name="firstName" placeholder="first name" maxlength="10" minlength="4"
                           class="form-control" required="true">
                    <input style="width: 30%" type="text" name="lastName" placeholder="last name"  maxlength="10" minlength="4"
                           class="form-control" required="true"></td>
            </tr>
            <tr class="${roomId == null ? "" : "hidden"}">
                <td><p>Room: </p></td>
                <td><input style="width: 30%" type="text" name="roomNumber" placeholder="number" maxlength="5"
                           class="form-control" required="true"></td>
                </td>
            </tr>
            <tr>
                <td><p>Lesson Type: </p></td>
                <td>
                    <p><select style="width: 30%" name="lessonType" class="fieldLessonType form-control" required="true">
                        <option></option>
                        <option>LECTURE</option>
                        <option>LAB</option>
                    </select></p>
            </tr>
            <tr>
                <td><p>Day: </p></td>
                <td>
                    <p><select style="width: 30%" name="day" class="fieldDay form-control" required="true">
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
