<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit teacher</title>
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
    <div class="alert alert-danger ${error==null ? "hidden" : ""}" role="alert ">
        ${error}
    </div>
    <form action="editTeacher" method="post">
        <input type="hidden" name="id" value="${teacher.id}">
        <table class="table">
            <tr>
                <td><p>First Name: </p></td>
                <td><input style="width: 40%" type="text" name="firstName" maxlength="30" value="${teacher.firstName}"
                           class="form-control" required pattern="^[a-zA-Z]+$"></td>

            </tr>
            <tr>
                <td><p>Last Name: </p></td>
                <td><input style="width: 40%" type="text" name="lastName" maxlength="30" value="${teacher.lastName}"
                           class="form-control" required pattern="^[a-zA-Z]+$"></td>
            </tr>
            <tr>
                <td><p>Position: </p></td>
                <td><input style="width: 40%" type="text" name="position" maxlength="30" value="${teacher.position}"
                           class="form-control" required pattern="^[a-zA-Z]+$"></td>
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td align="right">
                    <div>
                        <input type="submit" name="button" class="saveLesson btn btn-success" value="Save"/>
                        <input  class="btn btn-default" type="button" onclick="parent.location='/listOfTeachers'"
                                value="Cancel">
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
