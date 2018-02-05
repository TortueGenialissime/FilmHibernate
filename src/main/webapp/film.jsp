<%@page import="fr.m2i.formation.bean.Acteur"%>
<%@page import="java.util.List"%>
<%@page import="fr.m2i.formation.bean.Film"%>
<jsp:include page="header.jsp"></jsp:include>
<% Film film = (Film)request.getAttribute("film"); %>
        <h1 id="titre" style="font-size: 30px;text-decoration: underline;display: inline-block;"><%= film.getTitre() %></h1>
            <span style="position: relative;top: -6px;margin-left: 10px;" class="label label-info"><%= film.getStyle().getLibelle() %></span>
            <span style="position: relative;top: -6px;" class="label label-success"><%= film.getDuree() %></span>
            <span style="position: relative;top: -6px;" class="label label-<%= film.getVu() == true ? "success" : "danger" %>"><%= film.getVu() == true ? "Vu" : "Pas vu" %></span>
            <br>            <span id="annee" style="position: relative;top: -6px;" class="label label-default"><%= film.getAnnee() %></span><br>
            <img src="" id="cover">
            <div class="row">
                <div class="col-sm-6">
                    <h3>Réalisateur</h3>
                    <p style="font-size: 15px;margin-bottom: 0;color:#4286c8;"><%= film.getRealisateur().getNomPrenom()%></p>
                    <h3>Synopsis</h3>
                    <p style="font-size: 15px;margin-bottom: 0;">
						<%= film.getSynopsis()%>                    
					</p>
                </div>
                <div class="col-sm-6">
                    <h3>Acteurs</h3>
                    <% List<Acteur> acteurs = film.getActeurs();%>
                    <% for(Acteur acteur : acteurs) { %>
                    <p style="font-size: 15px;margin-bottom: 0;"><%= acteur.getNomPrenom() %></p>
                    <%} %>
                </div>
            </div>
            <script type="text/javascript">
            	$(function(){
            		$.getJSON("http://essearch.allocine.net/fr/autocomplete?geo2=83082&q="+$("#titre").text(), function(data){
            				
            			for(film in data){
            				var titre = data[film].title1 || data[film].title2;
            				var anneeSortie = data[film].metadata[1].value;
            				if(titre == $("#titre").text() && anneeSortie == $("#annee").text())
             				{
                 				var coverfilm = "http://fr.web.img3.acsta.net/r_1280_720"+data[film].poster;
                				$("#cover").attr("src", coverfilm);	
                				break;
            				}
            			}
            		});
            	});
            </script>
        
<jsp:include page="footer.jsp"></jsp:include>