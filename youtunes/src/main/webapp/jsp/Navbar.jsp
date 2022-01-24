<%@page language="java" contentType="text/html"%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>YouTunes</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="youtunes/assets/css/styles.css">
</head>

<header><img><a class="float-end" href="#">Link<img class="border rounded-circle float-end"></a>
        <nav class="navbar navbar-light navbar-expand-md">
            <div class="container">
            	<a class="navbar-brand" href="youtunes?action=homepage">YouTunes</a>
            	<button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1">
            		<span class="visually-hidden">Toggle navigation</span>
            		<span class="navbar-toggler-icon"></span>
            	</button>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="navbar-nav">
                        <li class="nav-item"><a class="nav-link" href="youtunes?action=showArtists">Artists</a></li>
                        <li class="nav-item"><a class="nav-link" href="youtunes?action=showAboutUs">About Us</a></li>
                        <li class="nav-item"><a class="nav-link" href="youtunes?action=showContactUs">Contact Us</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>