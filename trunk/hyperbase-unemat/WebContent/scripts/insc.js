function validacampos() {
	
	var nome = document.getElementById("idnome").value;
	var email = document.getElementById("idemail").value;
	var cpf = document.getElementById("idcpf").value;
	
	var status = document.getElementById("status");
	
	if (nome == "" || email == "" || cpf == "") {
		status.innerHTML = "É necessário digitar os campos Nome, Email e CPF";
		return false;
	}
	if(!valida_email(document.getElementById("idemail"))){
		status.innerHTML = "Email não válido";
		document.getElementById('idemail').setFocus = true;
		return false;
	}else
		salvar();
}

function valida_email(field) {
	with (field) {
		apos = value.indexOf("@");
		dotpos = value.lastIndexOf(".");
		if (apos < 1 || dotpos - apos < 2) {
			return false;
		} else {
			return true;
		}
	}
}

function GetXmlHttpObject() {
	var xmlhttp;

	// code for IE7+, Firefox, Chrome, Opera, Safari
	if (window.XMLHttpRequest){
	  xmlhttp=new XMLHttpRequest();
	// code for IE6, IE5
	}else {
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp;
}

function salvar() {
	
	var nome = document.getElementById('idnome').value;
	var email = document.getElementById('idemail').value;
	var cpf = document.getElementById('idcpf').value;
	var logica = document.getElementById('idvseace').value;

	var status = document.getElementById('status');

	var xmlhttp = GetXmlHttpObject();
	
	var url = "mvc?nome=" + nome + "&email=" + email + "&cpf=" + cpf
	+ "&vseace=" + logica;
	
	// antes era GET
	xmlhttp.open("GET",url, true);

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
	document.getElementById('idnome').value = "Nome de Teste";
	document.getElementById('idemail').value = "teste@email.com";
	document.getElementById('idcpf').value = "12345";
	document.getElementById('idnome').setFocus = true;
}