<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Us</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<jsp:include page="Navbar.jsp" flush="true"/>
<div style="width: 75%;margin-left: 12.5%;">
<div class="text-center mx-auto" style="width: 80%;">
    <h1>Contact YouTunes</h1>
    <p>YouTunes is here to satisfy your music needs. If you have an questions or concerns, please contact YouTunes support with one of the following forms of communication.</p>
    <div class="d-inline">
        <h5>Phone</h5>
        <ul class="list-inline">
            <li class="list-inline-item text-start">(123)456-7890</li>
        </ul>
    </div>
    <div class="d-inline">
        <h5>Email</h5>
        <ul class="list-inline">
            <li class="list-inline-item text-start">youtunes@support.com</li>
        </ul>
    </div>
    <div class="d-inline">
        <h5>Mail</h5>
        <ul class="list-inline">
            <li class="list-inline-item text-start">12345 Programmer St<br /> Kearney, NE 68845</li>
        </ul>
    </div>
</div>
        <h1 class="text-center">Contact Form</h1>
        <form class="d-inline" style="width: 75%;text-align: left;">
	        <label class="form-label d-block">Email:&nbsp;</label>
	        <input class="form-control form-control-sm d-block" type="email" style="padding-bottom: 10px;" name="email" placeholder="youremail@provider.com">
	        <label class="form-label d-block d-md-flex align-items-md-start">Comments:</label>
	        <textarea class="form-control d-block" name="comments"></textarea>
        </form>
</div>
<jsp:include page="Footer.jsp" flush="true"/>
<jsp:include page="ScriptFooter.jsp" flush="true"/>
</body>
</html>