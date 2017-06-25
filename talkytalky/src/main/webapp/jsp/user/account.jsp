<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
 <%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="../css/materialize.min.css"  media="screen,projection"/>

 <link type="text/css" rel="stylesheet" href="../css/asettelu.css"  />
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>


</head>
<body>
 <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="../js/materialize.min.js"></script>


 <nav>
    <div class="nav-wrapper  cyan darken-3">
      <a href="#" class="brand-logo right">Logo</a>
      <ul id="nav-mobile" class="left hide-on-med-and-down">
        <li><a href="../logout">Logout</a></li>
        <li><a href="badges.html">Components</a></li>
        <li>
        <ul id="dropdown2" class="dropdown-content ">
    <li><a href="#!">one<span class="badge">1</span></a></li>
    <li><a href="#!">two<span class="new badge">1</span></a></li>
    <li><a href="#!">three</a></li>
  </ul>
  <a class="btn dropdown-button" href="#!" data-activates="dropdown2">Ilmoitukset<i class="mdi-navigation-arrow-drop-down right "></i></a>
            
        </li>
      </ul>
    </div>
  </nav>
        
<div id="sisalto">
<br>
<br>
<br>

<h2>Kayttaja</h2>
<br>
<br><div class="keskusteluPainike">
<a class="waves-effect waves-light btn " href="create">Tee keskustelu</a>
</div>
<br>
<br>



<br>
<div class="asettelu" style="text-align: left: ;">
 <table class="bordered">
 
 
        <thead>
          <tr>
            	<th>Aloitus pvm</th>
              <th>Aihe</th>
              <th>Viimeisin päivitys</th>
          </tr>
        </thead>
 <tbody>
<c:forEach items="${keskustelut}" var="k">




     
        
          <tr>
            <td><c:out value="${k.keskustelu.pvmStr}"></c:out></td>
            <td><div class="chip">
<a href="">
    <img  >
<c:out value="${k.keskustelu.nimi}"></c:out>
</a>
</div></td>
            <td><c:out value="${k.keskustelu.upDatedPvm}"></c:out></td>
          </tr>
        
       
        
    


</c:forEach>
</tbody>
   </table>
   

 
</div>
        
        
<br>
<br>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
</div>
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