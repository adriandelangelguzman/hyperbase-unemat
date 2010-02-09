
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
