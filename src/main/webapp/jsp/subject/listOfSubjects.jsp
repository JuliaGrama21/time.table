<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Of Rooms</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/styles.css"
          media="screen"/>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/subjectsUtils.js"></script>
</head>
<body>
<div style="width: 900px" class="container panel panel-footer">
    <h3 style="text-align: center">List Of Subjects</h3>
    <div class="alert alert-danger ${error==null ? "hidden" : ""}" role="alert ">
        ${error}
    </div>
    <c:if test="${subjects.size() == 0}">
        <div><em>No subjects</em></div>
    </c:if>
    <c:if test="${subjects.size() != 0}">
        <table class="table table-bordered table-responsive">
            <tr>
                <th class="col-sm-3 text-center">Name Of Subject</th>
                <th class="col-sm-1 text-center"></th>
                <th class="col-sm-1 text-center"></th>
            </tr>
            <c:forEach items="${subjects}" var="subject">
                <tr valign="top">
                    <td class="text-center"><span>${subject.name}</span></td>
                    <td class="text-center"><a class="btn btn-primary"
                                               href="editSubject?id=${subject.id}">Edit</a>
                    </td>
                    <td class="text-center">
                        <button class="deleteSubject btn btn-danger glyphicon glyphicon-trash"
                                id="${subject.id}"></button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <td align="right">
        <input style="margin-left: 35%; margin-top: 5%" class="btn btn-success" type="button"
               onclick="parent.location='/addSubject'" value="Add subject">
        <input style="margin-top: 5%" class="btn btn-default" type="button" onclick="parent.location='/home_page'"
               value="Return to home page">
    </td>
</div>
</body>
</html>
