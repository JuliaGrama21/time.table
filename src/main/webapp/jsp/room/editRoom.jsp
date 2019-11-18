<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit room</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/styles.css"
          media="screen"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div style="width: 800px" class="container panel panel-footer">
    <h3 align="center">
        Enter information
    </h3>
    <form action="editRoom" method="post">
        <input type="hidden" name="id" value="${room.id}">
        <table class="table">
            <tr>
                <td><p>Number Of Room: </p></td>
                <td><input style="width: 60%" type="text" name="number" maxlength="5" value="${room.number}"
                           class="form-control"></td>

            </tr>
            <tr>
                <td><p>Type Of Room: </p></td>
                <td><input style="width: 60%" type="text" name="roomType" maxlength="30" value="${room.roomType}"
                           class="form-control"></td>
            </tr>
            <tr>
                <td>
                </td>
                <td align="right">
                    <div>
                        <input type="submit" name="button" class="saveRoom btn btn-success" value="Save"/>
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
