
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
<div id='divlogin'>
<form name ="formlogin" id="formlogin">
	<input type="hidden" name="hyperbase" id="idhyperbase" value="Login" />
	
	<label for="idlogin">Login:</label>
	<input type="text" name="login" id="idlogin" /> <br />
	
	<label for="idsenha">Senha</label>
	<input type="password" name="senha" id="idsenha" /> <br />
		
	<input type="hidden" name="data" id="iddata" value="<%=novaData%>" />
	Data: <%=novaData%><br />
	
	<input type="hidden" name="horario" id="idhora" value="<%=hora%>" /> 
	Hora: <%=hora%><br /> 
	
	<input type="submit" value="Enviar" onclick="validacampos('logar',document.getElementById('formlogin'));" /> 
	<input type="reset" value="Limpar" />
</form>
<span id="report" > </span>
</div>