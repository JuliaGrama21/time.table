<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit group</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/styles.css"
          media="screen"/>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div style="width: 800px" class="container panel panel-footer">
    <h3 align="center">
        Enter information
    </h3>
    <div class="alert alert-danger ${error==null ? "hidden" : ""}" role="alert ">
        ${error}
    </div>
    <form action="editGroup" method="post">
        <input type="hidden" name="id" value="${group.id}">
        <table class="table">
            <tr>
                <td><p>Number Of Group: </p></td>
                <td><input style="width: 40%" type="text" name="number" maxlength="5" value="${group.number}"
                           class="form-control" required pattern="^[ 0-9]+$"></td>

            </tr>
            <tr>
                <td><p>Speciality: </p></td>
                <td><input style="width: 40%" type="text" name="name" maxlength="30" value="${group.name}"
                           class="form-control" required pattern="^[a-zA-Z]+$"></td>
            </tr>
            <tr>
                <td align="right">
                    <div>
                        <input type="submit" name="button" class="saveLesson btn btn-success" value="Save"/>
                        <input  class="btn btn-default" type="button" onclick="parent.location='/listOfGroups'"
                                value="Cancel">
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
