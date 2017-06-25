<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>


</head>
<body>
 <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>


 <nav>
    <div class="nav-wrapper  cyan darken-3">
      <a href="#" class="brand-logo right">Logo</a>
      <ul id="nav-mobile" class="left hide-on-med-and-down">
       <li><a href="user/register">Rekisteröidy</a></li>
      </ul>
    </div>
  </nav>
        

<br>
<br>
<br>

<h2 style="margin-left: 400px">Login</h2>
<br>

<c:if test="${param.succes != null}">
		<p style="margin-left: 200px; color: green;" >Ulos kirjautuminen onnistui</p>
	</c:if>
<br>


 <form action="login" method="post">
 
 <div class="row">
 <c:if test="${param.error != null}">
		<p style="margin-left: 200px; color: red" class="Error">Sähköposti tai salasana on väärin</p>
	</c:if>
 
        <div class="input-field col s12">
        
          <input id="email" name="username" type="email" class="validate">
          <label for="email">Email</label>
        </div>
      </div>
      
      
       <div class="row">
        <div class="input-field col s12">
          <input id="password" name="password" type="password" class="validate">
          <label for="password">Password</label>
        </div>
      </div>
      
      <button class="btn waves-effect waves-light" type="submit" name="action">Login
    <i class="material-icons right">send</i>
  </button>
        
   
   
   <p style="margin-left: 200px">Unohtuiko salasana? Voit uusia sen <a href="user/resetpassword">tästä</a></p>   
      
</form>
<br>
<br>
<br>
<br>

        <footer class="page-footer  cyan darken-3">
          <div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">Footer Content</h5>
                <p class="grey-text text-lighten-4">You can use rows and columns here to organize your footer content.</p>
              </div>
              <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Links</h5>
                <ul>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 3</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 4</a></li>
                </ul>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            © 2014 Copyright Text
            <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
            </div>
          </div>
        </footer>
            



</body>
</html>