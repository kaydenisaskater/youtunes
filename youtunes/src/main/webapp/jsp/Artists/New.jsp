<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Artist Listing</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<jsp:include page="../Navbar.jsp" flush="true"/>
<div>
<h1 class="text-center">New Artist</h1>
	<form class="mx-auto" style="padding: 4%;width: 70%;margin-bottom: -17px;">
		<input type="hidden" name="action" value="createArtist" />
		<label for="firstName" class="form-label d-inline">Artist First Name<input id="firstName" name="firstName" class="form-control" type="text"></label>
		<label for="lastName" class="form-label d-inline">Artist Last Name<input id="lastName" name="lastName" class="form-control" type="text"></label>
		<button class="btn btn-primary d-block mx-auto" type="submit" style="margin: 5px;">Add Artist</button>
	</form>
</div>

<jsp:include page="../Footer.jsp" flush="true"/>
<jsp:include page="../ScriptFooter.jsp" flush="true"/>
</body>
</html>