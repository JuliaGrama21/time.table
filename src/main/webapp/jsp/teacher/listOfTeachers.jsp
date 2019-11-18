<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Of Teachers</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/styles.css"
          media="screen"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/teachersUtils.js"></script>
</head>
<body>
<div style="width: 900px" class="container panel panel-footer">
    <h3 style="text-align: center">List Of Teacher</h3>
    <c:if test="${teachers.size() == 0}">
        <div><em>No teachers</em></div>
    </c:if>
    <c:if test="${teachers.size() != 0}">
        <table class="table table-bordered table-responsive">
            <tr>
                <th class="col-sm-3 text-center">First Name</th>
                <th class="col-sm-3 text-center">Last Name</th>
                <th class="col-sm-6 text-center">Position</th>
                <th class="col-sm-2 text-center"></th>
                <th class="col-sm-2 text-center"></th>
                <th class="col-sm-2 text-center"></th>
            </tr>
            <c:forEach items="${teachers}" var="teacher">
                <tr valign="top">
                    <td class="text-center"><span>${teacher.firstName}</span></td>
                    <td class="text-center"><span>${teacher.lastName}</span></td>
                    <td class="text-center"><span>${teacher.position}</span></td>
                    <td class="text-center"><a class="btn btn-primary"
                                               href="editTeacher?id=${teacher.id}">Edit</a>
                    </td>
                    <td class="text-center">
                        <button class="deleteTeacher btn btn-danger glyphicon glyphicon-trash"
                                id="${teacher.id}"></button>
                    </td>
                    <td class="text-center"><a class="btn btn-primary"
                                              href="/lessons?teacherId=${teacher.id}">TimeTable</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <td align="right">
            <input style="margin-left: 35%; margin-top: 5%" class="btn btn-success" type="button"
                   onclick="parent.location='/addTeacher'" value="Add teacher">
            <input style="margin-top: 5%" class="btn btn-default" type="button" onclick="parent.location='/home_page'"
                   value="Return to home page">
    </td>
</div>
</body>
</html>
