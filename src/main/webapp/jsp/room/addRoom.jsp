<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter Room info</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/styles.css"
          media="screen"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/roomsUtils.js"></script>
</head>
<body>
<div style="width: 800px" class="container panel panel-footer">
    <h3 style="text-align: center">Enter information</h3>
    <div class="alert alert-danger ${error==null ? "hidden" : ""}" role="alert ">
        ${error}
    </div>
    <form action="addRoom" method="post">
        <table class="table">
            <tr>
                <td><p>Number Of Room: </p></td>
                <td><input style="width: 40%" type="text" name="number" maxlength="30"
                           class="form-control" required pattern="^[ 0-9]+$"></td>
            </tr>
            <tr>
                <td><p>Type Of Room: </p></td>
                <td>
                    <p><select style="width: 40%" name="roomType" class="fieldRoomType form-control" required="true">
                        <option></option>
                        <option>LECTURE_ROOM</option>
                        <option>LABORATORY</option>
                    </select></p>
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td align="right">
                    <div>
                        <input style="margin-top: 5%" type="submit" name="button" class="saveRoom btn btn-success"
                               value="Save"/>
                        <input style="margin-top: 5%" class="btn btn-default" type="button"
                               onclick="parent.location='/listOfRooms'" value="Cancel">
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
