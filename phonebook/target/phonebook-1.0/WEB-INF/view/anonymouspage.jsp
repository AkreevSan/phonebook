<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Phonebook</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a  href="welcome"><button class="btn btn-default">Back</button></a>
<h2>Anonymous page</h2>
<h1>Persons list</h1>
<br/>
<br/>

<form

<c:if test="${!empty listPerson}">
    <table class="tg">
        <tr>
            <th width="80">id</th>
            <th width="120">name</th>
            <th width="120">address</th>
            <th width="120">phone</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listPerson}" var="person">
            <tr>
                <td>${person.id}</td>
                <td><a href="/persondata/${person.id}" target="_blank">${person.name}</a></td>
                <td>${person.address}</td>
                <td>${person.phone}</td>
                <td><a href="<c:url value='/edit/${person.id}'></c:url>">Edit</a></td>
                <td><a href="<c:url value='/remove/${person.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Person</h1>

<c:url var="addAction" value="/persons/add"/>

<form:form action="${addAction}" commandName="person">
    <table>
        <c:if test="${!empty person.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="id"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="address">
                    <spring:message text="address"/>
                </form:label>
            </td>
            <td>
                <form:input path="address"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="phone">
                    <spring:message text="phone"/>
                </form:label>
            </td>
            <td>
                <form:input path="phone"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty person.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Person"/>"/>
                </c:if>
                <c:if test="${empty person.name}">
                    <input type="submit"
                           value="<spring:message text="Add Person"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
