<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="youtunes.Album" %>
<%@page import="youtunes.Artist" %>

<jsp:useBean id="artistDao" scope="application" class="youtunes.JdbcArtistDao" />
<jsp:useBean id="albumDao" scope="application" class="youtunes.JdbcAlbumDao" />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>YouTunes Artist Listing</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>

<body style="padding: 10;">
<jsp:include page="../Navbar.jsp" flush="true"/>
    <div>
    	<h1 class="text-center">Artist Listing</h1>
    	<div class="text-center">
        	<a class="btn btn-primary" href="youtunes?action=newArtist">New Artist</a>
        </div>
        <div class="d-flex d-sm-flex flex-wrap mx-auto" style="width: 90%">
    <%
    	List<Artist> artists = artistDao.list();
    	Iterator<Artist> i = artists.iterator();
    	while(i.hasNext()){
    		Artist artist = (Artist)i.next();
    %>
        <div class="card" style="margin: 2%;">
            <div class="card-body">
                <h4 class="card-title"><%=artist.getFirstName()%> <%=artist.getLastName()%></h4>
				<a class="card-link btn btn-primary" href="youtunes?action=artistDetails&artistId=<%=artist.getArtistId()%>">Edit</a>
				<a class="card-link btn btn-danger" href="youtunes?action=deleteArtist&artistId=<%=artist.getArtistId() %>">Delete</a>
            </div>
        </div>
        <%
    	}
        %>
        </div>
    </div>
<jsp:include page="../ScriptFooter.jsp" flush="true"/>
<jsp:include page="../Footer.jsp" flush="true"/>
</body>

</html>