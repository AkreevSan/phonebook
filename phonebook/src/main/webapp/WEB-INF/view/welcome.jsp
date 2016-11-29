<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="resources\bootstrap\css\bootstrap.css" rel="stylesheet">
    <script src="resources\bootstrap\js\jquery-3.1.1.min.js"></script>
    <script src="resources\bootstrap\js\bootstrap.js"></script>

    <style type="text/css">

           #fail{
               color: red;
              }
           #info{
               color: green;
                   }

                           #col1 {
                             width:1000px;
                             height:50px;
                             float:left;

                           }

        </style>



</head>
<body>
<div id="col1">
<h3 id="fail">${fail}<h3><h3 id="info">${info}<h3>
</div>
<br>
<br>
<H1 class="col-xs-offset-2">PHONEBOOK</H1>
<br>
<br>

<form  class="form-horizontal col-xs-offset-1" action="welcome" method="post">
		<div class="form-group">
            <label for="inputLogin" class="col-xs-1 control-label" >Login</label>
            <div class="col-xs-3">
                <input name = "log" class="form-control" id="inputLogin" placeholder="Login">
            </div>
        </div>

        <div class="form-group">
            <label for="inputPassword3" class="col-xs-1 control-label">Пароль</label>
            <div class="col-xs-3">
                <input type="password" name="pass" class="form-control" id="inputPassword3" placeholder="Password">
            </div>
        </div>



        <div class="form-group">
        <div class="col-xs-offset-1 col-xs-5">


 <button id="sub" type="submit" name="button" value="signin" class="btn btn-default">Войти</button>


            <button type="submit" name="button" value="registration" class="btn btn-default">Регистрация</button>

			<br>
			<br>

			<button type="submit" name="button" value="continue" class="btn btn-default">Продолжить без регистрации</button>




        </div>

    </div>

</form>
</body>
</html>