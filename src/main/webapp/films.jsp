<%@page import="fr.m2i.formation.bean.Film"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp"></jsp:include>
<% List<Film> films = (List<Film>)request.getAttribute("films"); %>
        <h1 style="margin-bottom: 50px;">Liste des films</h1>
              <table class="table table-hover">
    <thead>
      <tr>
        <th>Nom</th>
        <th>Réalisateur</th>
        <th>Année</th>
        <th>Vu</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
    <% for(Film film : films){ %>
      <tr>
        <td><a href="film?id=<%= film.getId() %>"><%= film.getTitre() %></a></td>
          <td><%= film.getRealisateur().getNomPrenom() %></td>
          <td><%= film.getAnnee() %></td>
          <td><%= film.getVu() == true ? "Oui" : "Non" %></td>
          <td>
              <a href="editFilm?id=<%= film.getId() %>"><i class="fas fa-edit"></i></a>
              <a class="delete-btn" href="deleteFilm?id=<%= film.getId() %>"><i class="fas fa-trash"></i></a>
          </td>
      </tr>
      <%} %>
    </tbody>
  </table>
              <script type="text/javascript">
            	$(function(){
            		$(".delete-btn").click(function(e){
            			if (confirm("Voulez-vous vraiment supprimer ce film ?")) {
            			    return 0;
            			} else {
            			    e.preventDefault();
            			} 
            		});
            	});
            </script>
<jsp:include page="footer.jsp"></jsp:include>