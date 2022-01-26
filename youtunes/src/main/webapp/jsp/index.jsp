<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="youtunes.Album" %>

<jsp:useBean id="albumDao" scope="application" class="youtunes.JdbcAlbumDao" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>YouTunes</title>
   	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<jsp:include page="Navbar.jsp" flush="true"/>
	<div class="text-center">
	    <h1 class="text-center">Discover</h1>
	    <p class="text-center" style="margin: 20px;padding: 3px;">
	    YouTunes is here to provide the latest music. Discover new albums and artists to add to your collection.
	    </p>
	    <a href="youtunes?action=newAlbum" class="btn btn-primary" tybe="submit">Add Albums</a>
	</div>
	<div class="d-flex d-sm-flex flex-wrap mx-auto" style="padding: 10px;margin: 5px;width: 70%;">
		<%
			List<Album> albums = albumDao.list();
			Iterator<Album> iterator = albums.iterator();
			while (iterator.hasNext()) {
				Album album = (Album)iterator.next();
		%>
		
		    <div class="d-inline-flex d-sm-inline-flex d-md-inline-flex d-lg-flex d-xl-flex d-xxl-flex flex-grow-1 flex-shrink-0" style="padding: 10px;margin: 0px;">
		        <div class="card">
		            <div class="card-body">
		            	<img class="float-end" src="<%= request.getContextPath() + "/images/" + album.getImgUrl()%>" height="300"/>
		                <h4 class="card-title"><%=album.getTitle()%></h4>
		                <h5 class="text-muted card-subtitle mb-2"><%=album.getGenre()%></h5>
		                <h6 class="text-muted card-subtitle mb-2">$<%=album.getPrice()%></h6>
		                <a class="card-link" href="youtunes?action=albumDetails&albumId=<%=album.getAlbumId()%>">Edit</a>
		                <a class="card-link" href="youtunes?action=deleteAlbum&albumId=<%=album.getAlbumId()%>">Delete</a>
		            </div>
		        </div>
		    </div>
		<%
			}
		%>
	</div>
	<jsp:include page="Footer.jsp" flush="true"/>
	<jsp:include page="ScriptFooter.jsp" flush="true"/>
</body>
</html>