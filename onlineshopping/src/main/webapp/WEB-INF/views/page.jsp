<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Loading JSTL tag library -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Add Spring tag library -->
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<!-- Set a variable contextRoot and value is be EL expression and that value is stored at this contextRoot variable -->
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping - ${title}</title>
    
    <script>
    	window.menu = '${title}';
    </script>

    <!-- Bootstrap core CSS -->
    <!-- <link href="vendor/bootstrap/${css}/bootstrap.min.css" rel="stylesheet">-->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

	 <!-- Bootstrap Readable Theme copy from bootswatch.com which is yeti -->
    <link href="${css}/bootstrap-lumen-theme.css" rel="stylesheet">
	
    <!-- Custom styles for this template -->
    <link href="${css}/myapp.css" rel="stylesheet">

  </head>

  <body>  
	
	<div class="wrapper">

    <!-- Navigation -->
    <%@include file="./shared/navbar.jsp" %>
    
    <!-- Page Content -->
   <div class="content">
    
    <!-- Loading the home content -->
    <!-- This Content is loaded when the user click home -->
    <c:if test="${userClickHome == true }">
    <%@include file="home.jsp" %>
    </c:if>
    
     <!-- This Content is loaded when the user click about -->
    <c:if test="${userClickAbout == true }">
    <%@include file="about.jsp" %>
    </c:if>
    
     <!-- This Content is loaded when the user click listProducts -->
    <c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
    <%@include file="listProducts.jsp" %>
    </c:if>
    
     <!-- This Content is loaded when the user click offerZone -->
    <c:if test="${userClickOfferZone == true }">
    <%@include file="offerZone.jsp" %>
    </c:if>
    
     <!-- This Content is loaded when the user click contact us-->
    <c:if test="${userClickContactUs == true }">
    <%@include file="contact.jsp" %>
    </c:if>
    
    </div>
    
    <!-- Footer Comes Here -->
    <%@include file="./shared/footer.jsp" %>

    <!-- Bootstrap core JavaScript -->
    <!-- <script src="vendor/jquery/jquery.min.js"></script>-->
    <script src="${js}/jquery.js"></script>
    
    <!-- <script src="vendor/bootstrap/${js}/bootstrap.bundle.min.js"></script> -->
    <script src="${js}/bootstrap.bundle.min.js"></script>

	<!-- Self Coded JavaScript -->
    <script src="${js}/myapp.js"></script>

	</div>
	
  </body>

</html>




<!-- Only for testing purpose
	JSP as a view technology and need to print this greeting
		To integrate all this things have the spring bean configuration file which will be dispatcher-servlet.xml
		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping</title>

</head>
<body>
	${contextRoot} says - ${greeting}
</body>
</html>-->