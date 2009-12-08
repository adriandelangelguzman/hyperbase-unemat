<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Cadastro de Monografia</title>

<script type="text/javascript" src="../scripts/ajaxupload.3.6.js"></script>
<script type="text/javascript" src="../scripts/jquery-1.3.1.min.js"></script>
<script type="text/javascript" src="../scripts/cadproj.js"></script>
<script type="text/javascript" src="../scripts/CalendarPopup.js"></script>
<link rel="stylesheet" type="text/css" href="../css/cadastro.css" />

<script type="text/javascript">
	/*<![CDATA[*/
	$(document).ready(function() {

		var button = $('#button1'), interval;
		new AjaxUpload(button, {
			action : '../upfile',
			name : 'myfile',
			onSubmit : function(file, ext) {
			
			// change button text, when user selects file			
			button.text('Enviando');

			// If you want to allow uploading only 1 file at time,
			// you can disable upload button
			this.disable();

			// Uploding -> Uploading. -> Uploading...
			interval = window.setInterval(function() {
				var text = button.text();
				if (text.length < 13) {
					button.text(text + '.');
				} else {
					button.text('Enviando');
				}
			}, 200);
		},
		onComplete : function(file, response) {
			button.text('Enviar');

			window.clearInterval(interval);

			// enable upload button
			this.disable();

			// add file to the list
			//$('<span></span>').appendTo('.file').text(response);
			$('span#status').append(response);
		});
	});/*]]>*/
</script>

<script Language="JavaScript">
	var cal = new CalendarPopup();
	cal.setMonthNames('Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez');
	cal.setDayHeaders('D','S','T','Q','Q','S','S');
	cal.setWeekStartDay(1);
	cal.setTodayText("Hoje");
	
	
</script>
</head>
<body>
<fieldset class="cadastro">
	<legend class="legenda">Cadastro de Monografias</legend>
	<form action="" name="form1">
		<label>Titulo</label> <br />
		<input type="text" name="titulo" id="idtitulo" /> 
		<br />
		
		<label>Resumo</label><br />
		<textarea name="resumo" id="idresumo"> </textarea>
		<br />
		
		<label>Abstract</label><br />
		<textarea name="abstract" id="idabstract"> </textarea>
		<br />
		
		<label>Numero de Paginas</label>
		<input type="text" name="numpage" id="idnumpage" maxlength="4" size="3px" />
		<br />
		
		<label>Data</label>
		<input type="text" name="date" value="" maxlength="10">
		<a href="#" onclick="cal.select(document.forms[0].date,'anchor1','dd/MM/yyyy'); return false;" TITLE="cal.select(document.forms[0].date,'anchor1','dd/MM/yyyy'); return false;" NAME="anchor1" ID="anchor1">Selecionar</A>
		<br />
		
		<label>Palavras Chave</label> 
		<textarea name="keywords"	id="keywords" /> </textarea>
		<br />
		
		<button id="button1" class="button">Selecionar Arquivo...</button>
		<label>Arquivos Enviados:</label>
		<span id="status"></span>
		<br />
		<input type="submit" name="enviar" value="Enviar" />
		<input type="reset" name="reset" value="Limpar" />
	</form>
</fieldset>
</body>
</html>