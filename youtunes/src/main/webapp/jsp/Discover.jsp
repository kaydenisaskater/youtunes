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
<div style="margin: 20px;">
        <h1 class="text-center">Discover</h1>
        <div class="d-flex align-items-center" style="height: 100px;padding-bottom: 10px;"><img class="d-inline float-start">
            <p class="text-center mx-auto" style="width: 70%;">Artist - Album - Song - Length</p><button class="btn btn-primary float-end" type="button" style="margin-right: 0px;">Button</button>
        </div>
    </div>
<jsp:include page="Footer.jsp" flush="true"/>
<jsp:include page="ScriptFooter.jsp" flush="true"/>

</body>
</html>