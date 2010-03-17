function getStyleObject(objectId) {
	// cross-browser function to get an object's style object given its id
	if (document.getElementById && document.getElementById(objectId)) {
		// W3C DOM
		return document.getElementById(objectId).style;
	} else if (document.all && document.all(objectId)) {
		// MSIE 4 DOM
		return document.all(objectId).style;
	} else if (document.layers && document.layers[objectId]) {
		// NN 4 DOM.. note: this won't find nested layers
		return document.layers[objectId];
	} else {
		return false;
	}
}

function changeObjectVisibility(objectId, newVisibility) {
	// get a reference to the cross-browser style object and make sure the
	// object exists
	var styleObject = getStyleObject(objectId);
	if (styleObject) {
		styleObject.visibility = newVisibility;
		return true;
	} else {
		// we couldn't find the object, so we can't change its visibility
		return false;
	}
}

function moveObject(objectId, newXCoordinate, newYCoordinate) {
	// get a reference to the cross-browser style object and make sure the
	// object exists
	var styleObject = getStyleObject(objectId);
	if (styleObject) {
		styleObject.left = newXCoordinate;
		styleObject.top = newYCoordinate;
		return true;
	} else {
		// we couldn't find the object, so we can't very well move it
		return false;
	}
} // moveObject

function validacampos(url,the_form) {
	var report = document.getElementById('report');
	var str = "?";
	for (i = 0; i < the_form.childNodes.length; i++) {
		
		if (the_form.childNodes[i].tagName == "INPUT") {
			if (the_form.childNodes[i].type == "text" || the_form.childNodes[i].type == "password") {
				if (the_form.childNodes[i].value == "") {
					the_form.childNodes[i].focus();
					the_form.childNodes[i].style.background = "#f9f5c9";
					report.innerHTML = 'Por Favor, Complete todos os campos';
					return false;
				} else {
					report.innerHTML = '';
					the_form.childNodes[i].style.background = "#e7f1e3";
					str += the_form.childNodes[i].name + "=" + the_form.childNodes[i].value + "&";
				}
			}
		}
	}
	makeLogin(url,str);
}
var http_request = false;
function makeLogin(url, parameters) {
	url = url + ".jsp";
	http_request = false;
	if (window.XMLHttpRequest) { // Mozilla, Safari,...
		http_request = new XMLHttpRequest();
		if (http_request.overrideMimeType) {
			http_request.overrideMimeType('text/html');
		}
	} else if (window.ActiveXObject) { // IE
		try {
			http_request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				http_request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}
	if (!http_request) {
		alert('Cannot create XMLHTTP instance');
		return false;
	}
	document.getElementById('content').innerHTML = "<img src='../images/carregando.gif' />";

	http_request.onreadystatechange = getState;
	http_request.open('GET', url + parameters, true);
	http_request.send(null);
}

function getState() {
	if (http_request.readyState == 4) {
		if (http_request.status == 200) {
			result = http_request.responseText;
			if (trim(result) == "success") {
				alert("Login Sucess");
				window.location = 'crud/index.jsp';
			}
			document.getElementById('content').innerHTML = result;
		} else {
			document.getElementById('content').innerHTML = "<p>Conteúdo temporariamente indisponível</p>";
		}
	}
}

function trim(str){
	return str.replace(/^\s+|\s+$/g,"");
}
