<%@ page import="java.util.Calendar"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.lang.String"%>
<%
	SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
	Calendar data = Calendar.getInstance();
	//cria a string 
	String novaData = formatador.format(data.getTime());
	formatador = new SimpleDateFormat("yyyy");
	Integer ano = Integer.parseInt(formatador.format(data.getTime()));
%>
<div id="part1" style="visibility: visible;">
	<fieldset class="cadastro">
	<legend class="legenda">Cadastro de Projetos</legend>
		<form name="cadastro" method="post" action="../cad-projeto" enctype="multipart/form-data" >	

			<label>Titulo</label> <br />
			<textarea name="titulo" id="idtitulo"> </textarea> <br />
			
			<label>Academico:</label>
			<a href="#b" onClick="ativaBusca('ui');" ><span class="iconbusca"></span> Buscar </a>
			
			<div id="mats" style="visibility:hidden;" >
			</div>
			
			<div id="ui" style="visibility:hidden;" >
			</div>
					
			<br />
			<label for="idlocal">Local</label> 
			<input type="text" name="local" id="idlocal" class="inputform" />
			<br />
			
			<label for="idpublico">Publico Alvo</label> 
			<input type="text" name="publico" id="idpublico" class="inputform"/>
			<br />
			
			<label>Ano</label>
			<select name="ano">
			<% for(int i=2005;i<=ano;i++){ 
					out.print("<option value=" + i + ">" + i + "  </option>");
			 } %>
			</select>
			<br /> 
			<label>Semestre:</label> 
			<br />
			<input type="radio" name="semestre" value="1" size="10px" /> 1 Semestre
  			<input type="radio" name="semestre" value="2" size="10px" /> 2 Semestre
			<br />
			
			<input type="file" name="arquivo" id="pdf" value="Select" size="35" /> 
			<br />
			
			<input type="button" name="notsend" value="Proximo" onClick="switchDone(this.form,'part1', 'part2');">
		</form>
	</fieldset>
</div>

<div id="part2" style="visibility: hidden;">
	<fieldset class="cadastro">
		<legend class="legenda">Confirmar Envio</legend> 
		
		<span id="confirme"></span> 
		
		<input type="button" value="Anterior" onClick="switchDiv('part2', 'part1');"> 
		<input type="button" value="Enviar" onClick="submitTheInfo();">
	</fieldset>
	<span id="report" > </span>
</div>
