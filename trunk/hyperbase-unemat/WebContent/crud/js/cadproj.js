
function buscaNome() 
{
	var nome = document.getElementById('idfaluno').value;
	
	var logicanome = document.getElementById('logica').name;
	var logica = document.getElementById('logica').value;
	var result = document.getElementById('result');	
	var size = nome.length;
	
	if (size == 0) {
		result.innerHTML = "Você precisa selecionar um arquivo antes de transmitir";
		return false;
	} else {
		var url = "../hyperbase?nome=" + nome + "&" + logicanome + "=" + logica;
		enviar(url,result);
	}
}

function GetXmlHttpObject() 
{
	var xmlhttp;

	// code for IE7+, Firefox, Chrome, Opera, Safari
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
		// code for IE6, IE5
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp;
}

function enviar(url,this_result) 
{
	var xmlhttp = GetXmlHttpObject();

	xmlhttp.open("GET", url, true);
	

	// status da conexao
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 1) // on load
		{
			//do not
		}
		if (xmlhttp.readyState == 4) // ready
		{
			if (xmlhttp.status == 200) {
				var resultado = xmlhttp.responseText;
				this_result.innerHTML = resultado;
			} else {
				alert("Problem retrieving XML data:" + xmlhttp.statusText);
				this_result.innerHTML = "Erro nas funções do Ajax";
			}
		}
	};
	xmlhttp.send(null);
}

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
	+ " <fieldset id='abusca'> "
	+ " <legend>Busca pelo Nome</legend> "
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