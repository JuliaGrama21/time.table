<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Of Rooms</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/styles.css"
          media="screen"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/roomsUtils.js"></script>
</head>
<body>
<div style="width: 900px" class="container panel panel-footer">
    <h3 style="text-align: center">List Of Rooms</h3>
    <div class="alert alert-danger ${error==null ? "hidden" : ""}" role="alert ">
        ${error}
    </div>
    <c:if test="${rooms.size() == 0}">
        <div><em>No rooms</em></div>
    </c:if>
    <c:if test="${rooms.size() != 0}">
        <table class="table table-bordered table-responsive">
            <tr>
                <th class="col-sm-3 text-center">Number Of Room</th>
                <th class="col-sm-3 text-center">Type Of Room</th>
                <th class="col-sm-1 text-center"></th>
                <th class="col-sm-1 text-center"></th>
                <th class="col-sm-1 text-center"></th>
            </tr>
            <c:forEach items="${rooms}" var="room">
                <tr valign="top">
                    <td class="text-center"><span>${room.number}</span></td>
                    <td class="text-center"><span>${room.roomType}</span></td>
                    <td class="text-center"><a class="btn btn-primary"
                                               href="editRoom?id=${room.id}">Edit</a>
                    </td>
                    <td class="text-center">
                        <button class="deleteRoom btn btn-danger glyphicon glyphicon-trash"
                                id="${room.id}"></button>
                    </td>
                    <td class="text-center"><a class="btn btn-primary"
                                               href="lessons?roomId=${room.id}">TimeTable</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <td align="right">
        <input style="margin-left: 35%; margin-top: 5%" class="btn btn-success" type="button"
               onclick="parent.location='/addRoom'" value="Add room">
        <input style="margin-top: 5%" class="btn btn-default" type="button" onclick="parent.location='/home_page'"
               value="Return to home page">
    </td>
</div>
</body>
</html>
