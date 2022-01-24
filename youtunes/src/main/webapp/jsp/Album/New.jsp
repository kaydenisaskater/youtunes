<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Album</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="youtunes/src/main/webapp/assets/css/styles.css">
</head>
<body>
<jsp:include page="../Navbar.jsp" flush="true"/>

<div>
<h1 class="text-center">New Album</h1>
    <form class="mx-auto" style="padding: 4%;width: 70%;">
    <label class="form-label d-inline">Title<input class="form-control" type="text"></label>
    <label class="form-label d-inline">Price<input class="form-control" type="text"></label>
    <label class="form-label d-inline">Image URL<input class="form-control" type="text"></label>
    <label class="form-label d-inline">Genre<select class="form-select">
	    <optgroup label="This is a group">
	        <option value="12" selected="">This is item 1</option>
	        <option value="13">This is item 2</option>
	        <option value="14">This is item 3</option>
	    </optgroup>
	</select>
	</label><label class="form-label d-inline">Artist<select class="form-select">
	    <optgroup label="This is a group">
	        <option value="12" selected="">This is item 1</option>
	        <option value="13">This is item 2</option>
	        <option value="14">This is item 3</option>
	    </optgroup>
</select></label><button class="btn btn-primary d-block mx-auto" type="button" style="margin: 5px;">Add Album</button></form>
</div>

<jsp:include page="../Footer.jsp" flush="true"/>
<jsp:include page="../ScriptFooter.jsp" flush="true"/>
</body>
</html>