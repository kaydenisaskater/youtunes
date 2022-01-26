<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="youtunes.Album" %> 
<%@page import="youtunes.Artist" %>  
<%@page import="java.util.List" %>
<%@page import="java.util.Iterator" %>
<jsp:useBean id="albumDao" scope="application" class="youtunes.JdbcAlbumDao" />
<jsp:useBean id="artistDao" scope="application" class="youtunes.JdbcArtistDao" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Album</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<jsp:include page="../Navbar.jsp" flush="true"/>

<div>
<h1 class="text-center">New Album</h1>
    <form id="albumForm" class="mx-auto" style="padding: 4%;width: 70%;">
	    <input type="hidden" name="action" value="createAlbum"/>
	    <label for="title" class="form-label d-inline">Title<input id="title" name="title" class="form-control" type="text"></label>
	    <label for="price" class="form-label d-inline">Price<input id="price" name="price" class="form-control" type="text"></label>
	    <label for="imgUrl" class="form-label d-inline">Image URL<input id="imgUrl" name="imgUrl" class="form-control" type="text"></label>
	    <label for="genre" class="form-label d-inline">Genre<select id="genre" name="genre" class="form-select">
		    <optgroup label="This is a group">
		        <option value="0" selected>Choose a Genre</option>
		        <option value="Rock">Rock</option>
		        <option value="Hip-Hop">Hip-Hop</option>
		        <option value="Country">Country</option>
		        <option value="Holiday">Holiday</option>
		        <option value="Pop">Pop</option>
		        <option value="Rap">Rap</option>
		    </optgroup>
		</select>
		</label>
		<label for="artist" class="form-label d-inline">Artist<select id="artist" name="artist" class="form-select">
		    <optgroup label="This is a group">
		        <option value="0" selected="">Choose the Artist</option>
		        <%
		       	List<Artist> artists = artistDao.list();
				Iterator<Artist> i = artists.iterator();
				while (i.hasNext()) {
					Artist artist = (Artist)i.next();
		        %>
		        <option value="<%=artist.getArtistId()%>"><%=artist.getFirstName()%> <%=artist.getLastName()%></option>
		        <%
				}
		        %>
		    </optgroup>
	</select>
	</label>
	<button id="btnSubmit" type="submit" class="btn btn-primary d-block mx-auto" style="margin: 5px;">Add Album</button>
</form>
</div>

<jsp:include page="../Footer.jsp" flush="true"/>
<jsp:include page="../ScriptFooter.jsp" flush="true"/>

<script type="text/javascript">
	// TODO: refactor this code into a function/javascript file.  The Details.jsp and index.jsp pages use the same code.
	let albumForm = document.getElementById("albumForm");
	
	albumForm.onsubmit = function() {
		let genre = document.getElementById('genre').value;
		let artist = document.getElementById('artist').value;
		let alertGenreDiv = document.getElementById('alert-genre-message'); 
		let alertArtistDiv = document.getElementById('alert-artist-message');
		
		console.log('Genre: ' + genre);
		console.log('Artist: ' + artist);
		
		if (genre.localeCompare('0') === 0) {	
			showAlertBox(alertGenreDiv, 'Invalid genre selection.');
			
			return false;
		} else if (artist.localeCompare('0') === 0) {
			hideAlertBox(alertGenreDiv, ''); 
			showAlertBox(alertArtistDiv, 'Invalid artist selection.');
			
			return false;
		}
		else {
			hideAlertBox(alertGenreDiv, '');
			hideAlertBox(alertArtistDiv, '');
			albumForm.submit(); 
		} 
	}
	
	function hideAlertBox(div, msg) {
		div.style.display = 'none';
		div.innerHTML = msg;
	}
	
	function showAlertBox(div, msg) {
		div.style.display = 'block';
		div.innerHTML = msg;
	}
</script>

</body>
</html>