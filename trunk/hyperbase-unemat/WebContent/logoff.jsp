<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//Destroi as sessions
	session.invalidate();

	//out.println("Você saiu com sucesso do sistema. Tente ver agora a página dos \"<a href='logado.jsp'>logados</a>\" ou efetue novamente <a href='index.html'>login</a>");
	response.sendRedirect("index.jsp");
%>