<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Cadastro de Projetos</title>
<script type="text/javascript" src="js/utilities.js"></script>
<script type="text/javascript" src="js/cadproj.js"></script>
<link rel="stylesheet" type="text/css" href="css/cadastro.css" />
<script type="text/javascript">
//<!--

function switchDiv(this_div, next_div)
{
	
	if (getStyleObject(this_div) && getStyleObject(next_div)) {
	    changeObjectVisibility(this_div, "hidden");
	    changeObjectVisibility(next_div, "visible");
	}
	hiddenDivMats();
}

function ativaBusca(this_div){

	var styleObject = getStyleObject(this_div);
	var element = document.getElementById(this_div);
	
	var busca = "" 
	+ " <fieldset> "
	+ " <legend class=\"legenda\">Busca pelo Nome</legend> "
	+ " <label> Pelo Nome:</label> "
	+ " <input type='hidden' name='hyperbase' id='logica' value='BuscaAluno' size='25px'/> "
	+ " <input type='text' name='notsend' id='idfaluno' size='25px'/> " 
	+ " <input type='button' name='notsend' value='Enviar' onClick='buscaNome()' /> <br /> "
	+ " <span id='result'> ----Resultados --- </span> "
	+ " </fieldset> ";
	
	if (styleObject.visibility == "hidden") {
		element.innerHTML = busca;
		changeObjectVisibility(this_div, "visible");
	}else{
		element.innerHTML = "";
		changeObjectVisibility(this_div, "hidden");
	}
	
}

function switchDone(the_form, this_div, next_div)
{
	var confirma = document.getElementById("confirme");
	
	var report = document.getElementById("report");

	for (var loop=0; loop < the_form.elements.length; loop++)
	{
	   if (the_form.elements[loop].value == "")
	   {
	      the_form.elements[loop].focus();
	      the_form.elements[loop].style.background = "#e4f4ff";
	      report.innerHTML = 'Por Favor, Complete todos os campos';
	      return false;
	   }else{
		   report.innerHTML = '';
		   the_form.elements[loop].style.background = "#fcfcfc";
	   }
	}

	if (getStyleObject(this_div) && getStyleObject(next_div)) {
	    changeObjectVisibility(this_div, "hidden");
	    changeObjectVisibility(next_div, "visible");
	}

	var submission_string="";
	
	for (var elems=0; elems < the_form.elements.length;elems++)
	{
	  if (the_form.elements[elems].name != ""  && the_form.elements[elems].name != "notsend" )
		  {
	      submission_string += the_form.elements[elems].name.toUpperCase() + " = " +
	      the_form.elements[elems].value + " <br />";
		  }
	 }
	hiddenDivMats();
	confirma.innerHTML = submission_string;
}
function submitTheInfo()
{
    document.forms[0].submit();
}
function IsNumber(evt){
	var charCode = (evt.which) ? evt.which : event.keyCode;
	if (charCode>=48 && charCode<=57 || charCode<20){
		return true;
	}else{
		return false;
	}
}

function selecionaValor(aluno){

	var this_div = 'mats';
	var element = document.getElementById(this_div);
	var html = '';
	changeObjectVisibility(this_div, "visible");
	changeObjectVisibility("ui", "hidden");
	var busca = document.getElementById("ui");
	busca.innerHTML = "";

	html =" <input type='text' name='aluno' disabled='disabled' value='" + aluno + "' />" ;
	element.innerHTML = html;	
}
function hiddenDivMats(){
	var this_div = 'mats';
	var styleObject = getStyleObject(this_div);
	var element = document.getElementById(this_div);
	
	if (styleObject.visibility == "hidden") {
		changeObjectVisibility(this_div, "visible");
	}else{
		changeObjectVisibility(this_div, "hidden");
	}
	
}
// -->

</script>
</head>
<body>
<div id="up" class="updiv">
	Cadastro de Projeto
</div>

<span id="report" > </span>

<div id="corpo" class="corpoclass">
<div id="part1" class="form" style="visibility: visible;">
	<fieldset class="cadastro">
	<legend class="legenda">Cadastro</legend>
		<form name="cadastro" method="post" action="../cad-projeto" enctype="multipart/form-data" >	

			<label>Titulo</label> <br />
			<textarea name="titulo" id="idtitulo"> </textarea> <br />
			
			<label>Academico:</label>
			<input type="button" id="idbusca" name="notsend" value=" Buscar" onClick="ativaBusca('ui');" /> <br />
			
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

<div id="part2" class="form2" style="visibility: hidden;">
	<fieldset class="cadastro">
		<legend class="legenda">Confirmar Envio</legend> 
		
		<span id="confirme"></span> 
		
		<input type="button" value="Anterior" onClick="switchDiv('part2', 'part1');"> 
		<input type="button" value="Enviar" onClick="submitTheInfo();">
	</fieldset>
</div>
</div>
</body>
</html>