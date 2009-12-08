<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/cadastro.css" />

<title>Sistema de Login :: JSP</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%
	//Verifica se está logado
	if (session.getValue("loginUsuario") != null
			|| session.getValue("senhaUsuario") != null) {
		out.println("Você está logado com sucesso no sistema, por isso consegue ver está pagina. Seu login é: "
						+ session.getValue("loginUsuario")
						+ " e sua senha: "
						+ session.getValue("senhaUsuario")
						+ ". Clique <a href='logoff.jsp'>aqui</a> para sair do sistema");
	} else {
		out
				.println("Você não está logado no sistema. Clique <a href='index.html'>aqui</a> para logar-se");
	}
%>
<br />
<br />
<br />
Desenvolvimento:
<a href="http://darkthales.hcerto.com" target="_blank">DarK ThaleS</a>
</body>
</html>