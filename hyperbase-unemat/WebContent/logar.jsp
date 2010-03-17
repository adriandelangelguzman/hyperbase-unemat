<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String login = "hyperbase";
	String senha = "123";

	String login_form = request.getParameter("login"); // Pega o Login vindo do formulário
	String senha_form = request.getParameter("senha"); //Pega a senha vinda do formulário

	if (login_form.equals(login) && senha_form.equals(senha)) { //Caso login e senha estejam corretos...
		session.setAttribute("loginUsuario", login); //Grava a session com o Login
		session.setAttribute("senhaUsuario", senha); //Grava a session com a Senha
		out.print("success"); //Exibe um código javascript para redireionar ao painel
	} else {
		out.println("Login ou senha inválidos. <a href='javascript:makeRequest(\"login\",\" \")'>Voltar</a>"); //Exibe na tela e pede para voltar
	}
%>