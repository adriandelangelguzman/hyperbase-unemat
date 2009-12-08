<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	String login = "thales";
	String senha = "123";
%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/cadastro.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HyperBase Unemat Colider - Login</title>

</head>
<body>
<%
	String login_form = request.getParameter("login"); // Pega o Login vindo do formulário
	String senha_form = request.getParameter("senha"); //Pega a senha vinda do formulário
	
	if (login_form.equals(login) && senha_form.equals(senha)) { //Caso login e senha estejam corretos...
		out.println("Logado com sucesso."); //Mostra na tela que foi logado com sucesso
		session.setAttribute("loginUsuario", login); //Grava a session com o Login
		session.setAttribute("senhaUsuario", senha); //Grava a session com a Senha
		out
				.println("<script>document.location.href='logado.jsp';</script>"); //Exibe um código javascript para redireionar ao painel
	} else { //Se estiverem incorretos...
		out
				.println("Login ou senha inválidos. <a href='java script:back()'>Voltar</a>"); //Exibe na tela e pede para voltar
	}
%>
</body>
</html>