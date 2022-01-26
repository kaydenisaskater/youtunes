<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="youtunes.Artist" %>
<jsp:useBean id="artistDao" scope="application" class="youtunes.JdbcArtistDao" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Artist's Details</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<jsp:include page="../Navbar.jsp" flush="true"/>
<div>
<h1 class="text-center">Update Artist</h1>
	<%
	try{
		String artistId = request.getParameter("artistId");
		Artist artist = artistDao.find(Long.parseLong(artistId));
		
		if (artist != null) {
	%>
			<form class="mx-auto" style="padding: 4%;width: 70%;margin-bottom: -17px;">
				<input type="hidden" name="action" value="updateArtist" />
				<input type="hidden" name="artistId" value="<%=artist.getArtistId() %>" />
				<label for="firstName" class="form-label d-inline">Artist First Name<input id="firstName" name="firstName" class="form-control" type="text" value="<%= artist.getFirstName()%>"></label>
				<label for="lastName" class="form-label d-inline">Artist Last Name<input id="lastName" name="lastName" class="form-control" type="text" value="<%= artist.getLastName()%>"></label>
				<button class="btn btn-primary d-block mx-auto" type="submit" style="margin: 5px;">Update Artist</button>
			</form>
	<%
		}
	}
	catch (Exception e){
		System.out.print(e);
	}
	%>
</div>

<jsp:include page="../Footer.jsp" flush="true"/>
<jsp:include page="../ScriptFooter.jsp" flush="true"/>
</body>
</html>