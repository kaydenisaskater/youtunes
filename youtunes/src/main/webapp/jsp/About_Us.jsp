<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About YouTunes</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<jsp:include page="Navbar.jsp" flush="true"/>
<div class="text-center mx-auto" style="width: 50%">
        <h1 class="text-center">About Us</h1>
        <img class="flex-shrink-1" src="<%= request.getContextPath() + "/images/"%>aboutus.jpeg" />
        <p class="text-center" style="margin: 20px;padding: 3px;">
        YouTunes is here to provide the latest music to listeners at a low cost. 
        You can purchase and stream music from various artists. Learn about new and upcoming artist
        ,or even listen to classic artists that you love. Find all your music needs at YouTunes. 
        </p>
</div>
<jsp:include page="Footer.jsp" flush="true"/>
<jsp:include page="ScriptFooter.jsp" flush="true"/>
</body>
</html>