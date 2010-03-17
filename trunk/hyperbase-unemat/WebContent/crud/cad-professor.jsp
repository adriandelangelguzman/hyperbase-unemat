<div id="part1" class="form" style="visibility:visible;" >
	<fieldset class="cadastro">
	<legend class="legenda">Cadastro de Professor</legend>
		<form name="cadastro" method="post" action="../hyperbase" >	
			
			<input type="hidden" name="hyperbase" value="CadastraProfessor" />
			
			<label>Matricula SAD:</label> <br />
			<input type="text" name="matricula" id="matricula" onKeypress="return IsNumber(event);" /> <br />
			
			<label>Nome:</label> <br />
			<input type="text" name="nome" id="idnome" onkeyup="this.value = this.value.toUpperCase()" size="50" /> <br />
			
			<label>Email:</label> <br />
			<input type="text" name="email" id="idemail" onkeyup="this.value = this.value.toLowerCase()" size="50"/> <br />
			
			<label>Login:</label> <br />
			<input type="text" name="login" id="idlogin" onkeyup="this.value = this.value.toLowerCase()"/> <br />
			
			<label>Senha:</label> <br />
			<input type="text" name="senha" id="idsenha"/> <br />
			
			<label>Confirme senha:</label> <br />
			<input type="text" name="senha2" id="idsenha2"/> <br />
			
			<input type="button" name="notsend" value="Cadastrar" onClick="switchDone(this.form,'part1', 'part2');">
		</form>
	</fieldset>
</div>
<div id="part2" class="form" style="visibility: hidden;">
	<fieldset class="cadastro">
		<legend class="legenda">Confirmar Envio dos Dados</legend> 
		
		<span id="confirme"></span> 
		
		<input type="button" value="Anterior" onClick="switchDiv('part2', 'part1');"> 
		<input type="button" value="Enviar" onClick="submitTheInfo();">
	</fieldset>
<span id="report" > </span>
</div>
