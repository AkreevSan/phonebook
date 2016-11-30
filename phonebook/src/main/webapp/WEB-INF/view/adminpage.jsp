<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Phonebook</title>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="resources\bootstrap\css\bootstrap.css" rel="stylesheet">
        <script src="resources\bootstrap\js\jquery-3.1.1.min.js"></script>
        <script src="resources\bootstrap\js\bootstrap.js"></script>
        <style type="text/css">
        #col1 {
                 width:600px;
                 height:300px;
                 float:left;

               }
               #col2 {
                 width:600px;
                 height:300px;
                 float:left;
               }
               #line {
                 width:10px;
                 height:300px;
                 float:left;
               }


               #userdiv {
               height: 150px;
               width: 400px;
               }

               #usertable{
               width: 550px;
               }

               #userbody{
               display: block;
                 height: 100px;
                 width: 550px;
               overflow: scroll;
               }

               .usertd {
               width: 210px;
               overflow: auto;
               }

               #userhead{
                 display: block;
                 width: 550px;
               }
       #tddiv{
         width: 80px;
       }

        </style>

</head>
<body>
<a  href="logout"><button class="btn btn-default">Logout</button></a>

<br/>
<br/>
<h2 class="col-xs-offset-1">Admin page</h2>

<table class="table table-bordered">
<tr>
<td>
<div id="col1">

<h1>Persons List</h1>

<c:if test="${!empty listPerson}">
    <table class="tg">
      <thead>
        <tr>
            <th width="80">id</th>
            <th width="120">name</th>
            <th width="120">address</th>
            <th width="120">phone</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
      </thead>
      <tbody>
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
        </tbody>
    </table>
</c:if>


<h1>Add a Person</h1>

<c:url var="addAction" value="add"/>

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
</div>
</td>

<td>
<div id="col2">

<h1>User List</h1>
<c:if test="${!empty authorizations}">

    <form action = "delete" class="form-horizontal col-xs-offset-1">

<div id="userdiv">

    <table id = "usertable" class="table table-bordered">
       <thead id="userhead">
        <tr>
       <th class="usertd">login</th>
        <th class="usertd">role</th>
        <th class="usertd">select</th>
        </tr>
          </thead>
      <tbody id="userbody">
      <c:forEach items="${authorizations}" var="auth">
      <tr>
        <td class="usertd"><div id="tddiv">${auth.login}</div></td>
      <td class="usertd">${auth.role}</td>
      <td class="usertd"><input type="radio" name="group1" value="${auth.login}"></td>
      </tr>


      </c:forEach>
      </tbody>
    </table>
</div>
      <button type="submit" name="button" value="delete" class="btn btn-default">Delete</button>
       </form>
</c:if>
</div>
</td>
</tr>
</table>

</body>


</html>
