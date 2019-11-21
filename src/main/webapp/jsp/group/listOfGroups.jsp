<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Of Groups</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/styles.css"
          media="screen"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/groupsUtils.js"></script>
</head>
<body>
<div style="width: 900px" class="container panel panel-footer">
    <h3 style="text-align: center">List Of Group</h3>
    <div class="alert alert-danger ${error==null ? "hidden" : ""}" role="alert ">
        ${error}
    </div>
    <c:if test="${groups.size() == 0}">
        <div><em>No groups</em></div>
    </c:if>
    <c:if test="${groups.size() != 0}">
        <table class="table table-bordered table-responsive">
            <tr>
                <th class="col-sm-3 text-center">Number Of Group</th>
                <th class="col-sm-3 text-center">Speciality</th>
                <th class="col-sm-1 text-center"></th>
                <th class="col-sm-1 text-center"></th>
                <th class="col-sm-1 text-center"></th>
            </tr>
            <c:forEach items="${groups}" var="group">
                <tr valign="top">
                    <td class="text-center"><span>${group.number}</span></td>
                    <td class="text-center"><span>${group.name}</span></td>
                    <td class="text-center"><a class="btn btn-primary"
                                               href="${pageContext.servletContext.contextPath}/editGroup?id=${group.id}">Edit</a>
                    </td>
                    <td class="text-center">
                        <button class="deleteGroup btn btn-danger glyphicon glyphicon-trash"
                                id="${group.id}"></button>
                    </td>
                    <td class="text-center"><a class="btn btn-primary"
                                               href="/lessons?groupId=${group.id}">TimeTable</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <td align="right">
        <input style="margin-left: 35%; margin-top: 5%" class="btn btn-success" type="button"
               onclick="parent.location='/addGroup'" value="Add group">
        <input style="margin-top: 5%" class="btn btn-default" type="button" onclick="parent.location='/home_page'"
               value="Return to home page">
    </td>
</div>
</body>
</html>
