<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Enter Group info</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/styles.css"
          media="screen"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/jquery.validate.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/groupsUtils.js"></script>
</head>
<body>
<div style="width: 800px" class="container panel panel-footer">
    <h3 style="text-align: center">Enter information</h3>
    <div class="alert alert-danger ${error==null ? "hidden" : ""}" role="alert ">
        ${error}
    </div>
    <form name="addGroup" action="addGroup" method="post">
        <table class="table">
            <tr>
                <td><p>Number Of Group: </p></td>
                <td><input style="width: 60%" type="text" name="number" maxlength="5"
                           class="form-control" required pattern="^[ 0-9]+$"></td>

            </tr>
            <tr>
                <td><p>Speciality: </p></td>
                <td><input style="width: 60%" type="text" id="name" name="name" maxlength="30"
                           class="form-control" required pattern="^[a-zA-Z]+$"></td>
            </tr>
            <tr>
                <td>
                </td>
                <td align="right">
                    <div>
                        <input style="margin-top: 5%" type="submit" name="button" class="saveTeacher btn btn-success"
                               value="Save"/>
                        <input style="margin-top: 5%" class="btn btn-default" type="button"
                               onclick="parent.location='/listOfGroups'" value="Cancel">
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
