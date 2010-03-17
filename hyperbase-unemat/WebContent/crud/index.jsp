
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String log_result = "";
	//Verifica se está logado
	if (session.getAttribute("loginUsuario") != null
			|| session.getAttribute("senhaUsuario") != null) {
		log_result =  ("Você está logado com sucesso no sistema. Seu login é: "
						+ session.getAttribute("loginUsuario"));
	} else {
		log_result = ("Voce nao esta logado no sistema");
		out.println("<script> window.location = '../index.jsp?result="+log_result + "';</script>");
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Biblioteca do Campus Universitario de Colider</title>
<link href="css/default_cad.css" rel="stylesheet" type="text/css" media="screen"/>
<script type="text/javascript" src="js/cadastro.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="js/utilities.js"></script>

</head>
<body>
<div id="base">
	<div id="header"></div>
	<div id="login_mess">
		<span id="log_result"><%= log_result %></span>
	</div>
	<div id="login">
		<a id="logoff" href='../logoff.jsp' >Sair</a>
	</div>
	<div id="menu">
	<ul>
		<li onclick='makeRequest("cad-monografia","")'> <span id="id_cadm"></span> Cadastrar Monografias </li>
		<li onclick='makeRequest("cad-projeto","")'> <span id="id_cadp"></span>Cadastrar Projetos </li>
		<li onclick='makeRequest("cad-aluno","")'><span id="id_aluno"></span> Cadastrar Academico</li>
		<li onclick='makeRequest("cad-professor","")'><span id="id_prof"></span> Cadastrar Professor</li>
		<li onclick='makeRequest("contato","")'><span id="id_ajuda"></span> Ajuda</li>
	</ul>
	</div>
	<div id="content"><h1>Apresentacao</h1>
	<img src="images/campus.jpg" align="right" />
	<p>Este Sistema Serve como auxilio para Cadastro dos Trabalhos de TCC (Monografias e Artigos) e também, 
	dos projetos de Estagio Supervisionado do Campus Universitario de Colider</p>
	
	<p>Segurança</p>

	</div>
	<div id="footer">
		<div>biblioteca@colider.unemat.br</div>
	</div>
</div>

</body>
</html>