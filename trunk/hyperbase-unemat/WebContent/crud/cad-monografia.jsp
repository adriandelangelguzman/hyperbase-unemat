<span id="report" > </span>

<div id="part1" class="form" style="visibility:visible;" >
	<fieldset class="cadastro">
	<legend class="legenda">Cadastro de Monografias</legend>
		<form name="cadastro" method="post" action="../cad-monografia" enctype="multipart/form-data" >	

			<label>Titulo</label> <br />
			<input type="text" name="titulo" id="idtitulo" onkeyup="this.value = this.value.toUpperCase()"/>
			<br />
			<label>Resumo</label><br />
			<textarea name="resumo" id="idresumo"> </textarea> 
			
			<label>Abstract</label><br />
			<textarea name="abstract" id="idabstract"> </textarea> 
		
			<label>Numero de Paginas</label> 
			<input type="text" name="numpage" id="idnumpage" maxlength="4" size="3px" onKeypress="return IsNumber(event);" />
			<span id="idnum"></span>
			
			<br />
			<label>Data</label> 
			<script type="text/javascript">
				var cal = new CalendarPopup();
				cal.setMonthNames('Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez');
				cal.setDayHeaders('D','S','T','Q','Q','S','S');
				cal.setWeekStartDay(1);
				cal.setTodayText("Hoje");
			</script>
			
			<input type="text" name="data" value="" maxlength="10"> 
			<input type="button" name="btdata" id="btdata" value="Selecionar" 
				onClick="cal.select(document.forms[0].data,'btdata','dd/MM/yyyy'); return false;"
				title="Selecionar Data" 
			/>
			<br />
			
			<label>Palavras Chave</label> 
			<textarea name="keywords" id="keywords" /> </textarea>
			<br />
			
			<input type="file" name="Arquivo" id="pdf" value="Select" /> 
			<br />
			
			<input type="button" name="notsend" value="Proximo" onClick="switchDone(this.form,'part1', 'part2');">
		
		</form>
	</fieldset>
</div>

<div id="part2" class="form" style="visibility: hidden;">
	<fieldset class="cadastro">
		<legend class="legenda">Confirmar Envio</legend> 
		<span id="confirme"></span> 
		
		<input type="button" value="Anterior" onClick="switchDiv('part2', 'part1');"> 
		<input type="button" value="Enviar" onClick="submitTheInfo();">
	</fieldset>
</div>