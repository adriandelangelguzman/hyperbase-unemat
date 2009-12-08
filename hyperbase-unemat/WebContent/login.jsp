<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.Calendar"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.lang.String"%>
<%
	SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
	Calendar data = Calendar.getInstance();
	//cria a string 
	String novaData = formatador.format(data.getTime());
	formatador = new SimpleDateFormat("hh:mm");
	String hora = formatador.format(data.getTime());
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<form name="formlogin" id="idformlogin" method="get">
	<input type="hidden" name="hyperbase" id="idhyperbase" value="Login" />
	
	<label for="idlogin">Login:</label>
	<input name="login" id="idlogin" /> <br />
	
	<label for="idsenha">Senha</label>
	<input type="password" name="senha" id="idsenha" /> <br />
		
	<input type="hidden" name="data" id="iddata" value="<%=novaData%>" />
	Data: <%=novaData%><br />
	
	<input type="hidden" name="horario" id="idhora" value="<%=hora%>" /> 
	Hora: <%=hora%><br /> 
	
	<input type="button" value="Enviar" onclick="return validacampos()" /> 
	<input type="reset" value="Limpar" />
</form>
</body>
</html>