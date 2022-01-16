<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Navbar.jsp" flush="true"/>
<div style="width: 75%;margin-left: 12.5%;">
        <h1 class="text-center">Contact Us</h1>
        <form class="d-inline" style="width: 75%;text-align: left;"><label class="form-label d-block">Email:&nbsp;</label><input class="form-control form-control-sm d-block" type="email" style="width: 60%;padding-bottom: 10px;" name="email" placeholder="youremail@provider.com"><label class="form-label d-block d-md-flex align-items-md-start">Comments:</label><textarea class="form-control d-block" name="comments"></textarea></form>
</div>
<jsp:include page="Footer.jsp" flush="true"/>
<jsp:include page="ScriptFooter.jsp" flush="true"/>
</body>
</html>