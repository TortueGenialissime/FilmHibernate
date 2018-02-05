<%@page import="java.util.List"%>
<%
if(session.getAttribute("errors") != null){
	%>
	<div class="container">
	<%
	List<String> errors = (List<String>)session.getAttribute("errors");
	for(String er : errors)
	{
		%>
<div class="alert alert-danger">
  <strong><%=er%></strong>
  <button type="button" class="close" data-dismiss="alert">×</button>
</div>
		<%
	}
	%>
	</div>
	<%
	session.removeAttribute("errors");
}
%>
<%
if(session.getAttribute("success") != null){
	%>
	<div class="container">
	<%
	List<String> success = (List<String>)session.getAttribute("success");
	for(String sc : success)
	{
		%>
<div class="alert alert-success">
  <strong><%=sc%></strong>
  <button type="button" class="close" data-dismiss="alert">×</button>
</div>
		<%
	}
	%>
	</div>
	<%
	session.removeAttribute("success");
}

%>