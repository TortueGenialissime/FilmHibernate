<%@page import="fr.m2i.formation.bean.Style"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp"></jsp:include>
	<% List<Style> styles = (List<Style>)request.getAttribute("styles"); %>
	    <h1 style="margin-bottom: 50px;">Liste des styles</h1>
                  <table class="table table-hover">
        <thead>
          <tr>
            <th>id</th>
            <th>Libellé</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
        <% for(Style s : styles){ %>
          <tr>
            <td><%= s.getId() %></td>
            <td>
                <form id="form-editstyle-<%= s.getId() %>" action="updateStyle" method="post">
                    <input type="text" name="libelle" value="<%= s.getLibelle() %>">
                    <input type="hidden" name="id" value="<%= s.getId() %>">
                </form>
                <form id="form-deletestyle-<%= s.getId() %>" action="deleteStyle" method="post">
                    <input type="hidden" name="id" value="<%= s.getId() %>">
                </form>
            </td>
            <td>
                <button form="form-editstyle-<%= s.getId() %>" type="submit"><i class="fas fa-edit"></i></button>
                <button type="submit" form="form-deletestyle-<%= s.getId() %>"><i class="fas fa-trash"></i></button>
            </td>
          </tr>
          <% } %>
        </tbody>
      </table>
      	    <h1 style="margin: 50px 0;">Ajouter un style</h1>
      	         <form action="addStyle" method="post">
      	         <label for="libelle">Libellé</label><br>
                    <input type="text" id="libelle" name="libelle">
                    <input type="submit" value="Ajouter un style">
                </form>
<jsp:include page="footer.jsp"></jsp:include>