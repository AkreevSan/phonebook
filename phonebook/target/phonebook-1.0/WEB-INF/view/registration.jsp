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

    #sub {
                display: none;
            }
      #labe {
                 display: inline;
       }
        #col1 {
                                    width:1000px;
                                    height:50px;
                                    float:left;

                                  }
    </style>

    <script type="text/javascript">
        document.addEventListener("DOMContentLoaded", ready);
        function ready(){
        setInterval(function gogo(){
                   var labe = document.getElementById('labe');
                 var btn = document.getElementById('sub');
                var conf = document.getElementById('confirmPassword').value;
                var inp = document.getElementById('inputPassword').value;
                var logi = document.getElementById('inputLogin').value;

               if (  (conf==inp)&&(inp!="")&&(logi!="")  ){
                              btn.style.display='inline';
                              labe.style.display='none';
                               } else {
                                btn.style.display='none';
                                labe.style.display='inline';
                                }

            }, 100);

        }

    </script>

</head>

<body>

<div id="col1">
<a  href="welcome"><button class="btn btn-default">Back</button></a>
</div>
<br>
<br>
<H1 class=" col-xs-offset-2">РЕГИСТРАЦИЯ</H1>
<br>
<br>

<form class="form-horizontal col-xs-offset-1" action="registration.form" method="post">
<div class="form-group">
    <label class="control-label col-xs-1" for="inputLogin">Login</label>
    <div class="col-xs-3">
      <input class="form-control" name = "log" id="inputLogin" placeholder="Login">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-xs-1" for="inputPassword">Пароль</label>
    <div class="col-xs-3">
      <input type="password" class="form-control" name = "pass" id="inputPassword" placeholder="Введите пароль">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-xs-1" for="confirmPassword">Пароль</label>
    <div class="col-xs-3">
      <input type="password" class="form-control" name="pass2" id="confirmPassword" placeholder="Введите пароль ещё раз">
    </div>
  </div>
<div class="form-group">
    <div class="col-xs-offset-1 col-xs-5">
        <label  id="labe" >Регистрация</label>
       <button id="sub" type="submit"  class="btn btn-default" >Регистрация</button>
       <button id="reset" type="reset" class="btn btn-default">Очистить форму</button>
    </div>
  </div>
</form>

</body>
</html>