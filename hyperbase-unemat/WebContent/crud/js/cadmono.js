function switchDiv(this_div, next_div)
{
	
	if (getStyleObject(this_div) && getStyleObject(next_div)) {
	    changeObjectVisibility(this_div, "hidden");
	    changeObjectVisibility(next_div, "visible");
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
	  for (var form_loop=0; form_loop<document.forms.length; form_loop++) 
	  {
		for (var elems=0; elems<document.forms[form_loop].length;elems++)
	    {
		  if (document.forms[form_loop].elements[elems].name != 
			  "" && document.forms[form_loop].elements[elems].name != "notsend"
				  && document.forms[form_loop].elements[elems].name != "hyperbase"
				  )
	      {
	       submission_string += document.forms[form_loop].elements[elems].name.toUpperCase() + " = " +
	       document.forms[form_loop].elements[elems].value + "<br />";
	      }
	    }
	  }
	  //submission_string = submission_string + "PDF =" + document.getElementById("pdf").value;
	  confirma.innerHTML = submission_string;
}
function submitTheInfo()
{
    document.forms[0].submit();
}

function IsNumber(evt){
	var charCode = (evt.which) ? evt.which : event.keyCode;
	var num = document.getElementById("idnum");
	if (charCode>=48 && charCode<=57 || charCode<20){
		num.innerHTML = "";
		return true;
	}else{
		num.innerHTML = "Digite Somente numeros!";
		return false;
	}
}