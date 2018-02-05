<%@page import="fr.m2i.formation.bean.Style"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp"></jsp:include>
<%
List<Style> styles = (List<Style>)request.getAttribute("styles");
%>
        <h1 style="margin-bottom: 50px;">Ajouter un film</h1>
            <form action="addFilm" method="post">
                <div class="col-md-6">
                    <div class="form-group ">
                        <label for="titre">Titre du film</label>
                        <input name="titre" type="text" class="form-control" id="titre" placeholder="Titatic">
                    </div>
                    <div class="form-group">
                        <label for="realisateur">Réalisateur</label>
                        <input name="realisateur" type="text" class="form-control" id="realisateur" placeholder="Jean-Michel Réalisateur">
                    </div>
                    <div class="form-group">
                        <label for="annee">Année de sortie</label>
                        <input name="annee" type="text" class="form-control" id="annee" placeholder="2012 (pas le film)">
                    </div>
                    <div class="form-group">
                        <label for="style">Style </label><br>
                        <select id="style" name="style" class="selectpicker">
                        <% for(Style style : styles){ %>
                          <option value="<%= style.getId() %>"><%= style.getLibelle() %></option>
                          <%} %>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="vu">Déjà vu ? </label><br>
                        <select id="vu" name="vu" class="selectpicker">
                          <option value="non">Non</option>
                          <option value="oui">Oui</option>
                        </select>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group ">
                        <label for="duree">Durée</label>
                        <input name="duree" type="text" class="form-control" id="duree" placeholder="Format (h:mm)">
                    </div>
                    <div class="form-group">
                        <label for="acteur">Acteurs</label>
                        <input style="margin-bottom: 15px;" name="acteur" type="text" class="form-control" id="acteur" placeholder="Will Smism">
                        <input style="margin-bottom: 15px;" name="acteur" type="text" class="form-control" id="acteur" placeholder="Will Smism">
                        <input style="margin-bottom: 15px;" name="acteur" type="text" class="form-control" id="acteur" placeholder="Will Smism">
                        <input style="margin-bottom: 15px;" name="acteur" type="text" class="form-control" id="acteur" placeholder="Will Smism">
                        <input style="margin-bottom: 15px;" name="acteur" type="text" class="form-control" id="acteur" placeholder="Will Smism">
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="synopsis">Synopsis</label>
                        <textarea style="height: 200px;" name="synopsis" class="form-control" id="synopsis" placeholder="C'est l'histoire de ..."></textarea>
                    </div>
                </div>
                <div class="clearfix"></div>
                <input type="submit" name="Ajoute un film">
            </form>
<jsp:include page="footer.jsp"></jsp:include>