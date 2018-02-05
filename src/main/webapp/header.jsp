    <!doctype html>
    <%@page import="java.util.List"%>
<html lang="fr">
    <head>
      <meta charset="utf-8">
      <title>Titre de la page</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="./">Films</a>
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
        </button>
    </div>
      <div id="menu" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
    <ul class="nav navbar-nav navbar-right">
      <li><a href="films">Films</a></li>
      <li><a href="addFilm">Ajouter un film</a></li>
      <li><a href="style">Styles</a></li>
    </ul>
      </div>
  </div>
</nav>
<jsp:include page="FlashMessage.jsp"></jsp:include>
        <main class="container">
            <div class="jumbotron">