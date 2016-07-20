<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="Samazon">
    <meta name="author" content="Samazon">
    <link rel="icon" href="resources/images/fav.jpg">
 <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
    <title>LOGIN PAGE</title>

    <!-- Custom styles for this template -->
     
   
    <style>
#grad1 {
    height: 200px;
     /* For browsers that do not support gradients */    
    background: -webkit-linear-gradient(left, aqua , blue); /* For Safari 5.1 to 6.0 */
    background: -o-linear-gradient(left, aqua, blue); /* For Opera 11.1 to 12.0 */
    background: -moz-linear-gradient(right, aqua, blue); /* For Firefox 3.6 to 15 */
    background: linear-gradient(to right, aqua , blue); /* Standard syntax (must be last) */
}
</style>
  </head>


    <body id="grad1">
    <center>
    <div class="container">
    <center>    <h1 id="banner">Welcome to Samazon </h1> </center>  
        <form class="form-signin" name="f" action="<c:url value='j_spring_security_check'/>"
                    method="POST">
                    <h2 class="form-signin-heading">Please sign in</h2>
            <table>
                <tr>
                    <td><h3><span class="label">Username </span></h3></td>
                    <td><input type='text' name='j_username' /></td>
                </tr>
                <tr>
                   <td><h3><span class="label">Password </span></h3></td>
                    <td><input type='password' name='j_password'></td>
                </tr>
                <tr>
                    <td colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td ></td><td><center><input type="submit" class="btn btn-success " value="Login"> &nbsp;&nbsp;<input class="btn  "  name="reset" type="reset"></center></td>
                </tr>
                <tr><td><a href="index">Back to Home</a></td></tr>
            </table><br/><br/>
           <p>  
      </p>
        </form>
        
        </div><!-- container ends -->
        </center>
    </body>
</html>