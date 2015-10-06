<%-- 
    Document   : index
    Created on : 18/09/2015, 09:37:15
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <<link rel="stylesheet" type="text/css" href="estilo.css"/>
        <title>Index</title>
    </head>
<body class="align">

    <div class="site__container">

    <div class="grid__container">

      <form action="FrontController" method="post" class="form form--login">

        <div class="form__field">
          <label class="fontawesome-user" for="login__username"><span class="hidden">Username</span></label>
          <input id="login__username" type="text" class="form__input" placeholder="Username" name="username" required>
        </div>

        <div class="form__field">
          <label class="fontawesome-lock" for="login__password"><span class="hidden">Password</span></label>
          <input id="login__password" type="password" class="form__input" placeholder="Password" name="password" required>
        </div>

        <div class="form__field">
          <input type="submit" value="Sign In">
        </div>

      </form>

      <p class="text--center">Not a member? <a href="#">Sign up now</a> <span class="fontawesome-arrow-right"></span></p>

    </div>

  </div>

</body>
</html>
