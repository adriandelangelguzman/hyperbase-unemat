<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Biblioteca do Campus Universitario de Colider</title>
<link href="css/default.css" rel="stylesheet" type="text/css" media="screen"/>
<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="js/utilities.js"></script>
</head>
<body>
<%
	String log = request.getParameter("result");
	if(log == null)
		log = "";
%>
<div id="base">
	<div id="header"></div>
	
	<div id="log_mess">
		<span id="log_result"><%=log  %></span>
	</div>
	
	<div id="login">
		<a id="logon" href="#" onclick='makeRequest("login","")' >Administrar</a>
	</div>
	
	<div id="menu">
	<ul>
		<li onclick='makeRequest("monografias","")'> <span id="id_con"></span> Consulta Monografias </li>
		<li onclick='makeRequest("projetos","")'> <span id="id_con"></span>Consulta Projetos </li>
		<li onclick='makeRequest("ajuda","")'><span id="id_ajuda"></span> Ajuda</li>
		<li onclick='makeRequest("contato","")'><span id="id_contato"></span> Contato</li>
	</ul>
	</div>
	<div id="content">
	<h1>Apresentacao</h1>
	<img src="images/campus.jpg" align="right" />
	<p>Este Sistema Serve como auxilio para consulta dos Trabalhos de TCC (Monografias e Artigos) e tambÃ©m, 
	dos projetos de Estagio Supervisionado do Campus Universitario de Colider</p>
	<p>Seguran&ccedil;a</p>
	</div>
	<div id="footer">
		<div>biblioteca@colider.unemat.br</div>
	</div>
</div>

</body>
</html>