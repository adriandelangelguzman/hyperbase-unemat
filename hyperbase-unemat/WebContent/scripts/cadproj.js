function valida() {

	var status = document.getElementById('status');
	
	var campo = document.getElementById("idupload");
	
	alert("" + campo.Value);
	
	var TamanhoString = campo.length;
	var extensao = campo.substr(TamanhoString - 4, TamanhoString);

	if (TamanhoString == 0) {
		status.innerHTML = "Você precisa selecionar um arquivo antes de transmitir";
		return false;
	} else {
		var ext = ".pdf";// extensões desejadas

		if (extensao == ext) {
			flag = "ok";
			break;
		} else {
			flag = "erro";
		}

		if (flag == "erro") {
			status.innerHTML = "Tipo de arquivo invalido.\nArquivos validos: .pdf";			document.formBaixa.arquivo.value = "";
			return false;
		}
	}
	
	enviar(url);
	
	return true;
}
function val(){
	alert("Aqui estou");
}
function GetXmlHttpObject() {
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

function enviar(url) {


	var status = document.getElementById('status');

	var xmlhttp = GetXmlHttpObject();

	// antes era GET
	xmlhttp.open("POST", url, true);
	xmlhttp.setRequestHeader("Content-Type","multipart/form-data");

	// status da conexao
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 1) // on load
		// carregando...
		{
			status.innerHTML = "Inserindo...";
		}
		if (xmlhttp.readyState == 4) // ready
		{
			if (xmlhttp.status == 200) {
				var resultado = xmlhttp.responseText;
				status.innerHTML = resultado;
			} else {
				alert("Problem retrieving XML data:" + xmlhttp.statusText);
				status.innerHTML = "Erro nas funções do Ajax";
			}
		}
	};
	xmlhttp.send(null);
}