   var http_request = false;
   function makeRequest(url, parameters) {
      url = "./centeudo/"+url+".inc.jsp";
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
            } catch (e) {}
         }
      }
      if (!http_request) {
         alert('Cannot create XMLHTTP instance');
         return false;
      }
      document.getElementById('content').innerHTML = "<img src='./images/carregando.gif' />";
      http_request.onreadystatechange = getContents;
      http_request.open('GET', url + parameters, true);
      http_request.send(null);
   }

   function getContents() {
      if (http_request.readyState == 4) {
         if (http_request.status == 200) {
            result = http_request.responseText;
            document.getElementById('content').innerHTML = result;            
         } else {
            document.getElementById('content').innerHTML = "<p>Conteúdo temporariamente indisponível</p>";
         }
      }
   }
   
   function get(obj) {
      var getstr = "?";
      for (i=0; i<obj.childNodes.length; i++) {
         if (obj.childNodes[i].tagName == "INPUT") {
            if (obj.childNodes[i].type == "text" || obj.childNodes[i].type == "hidden" ) {
               getstr += obj.childNodes[i].name + "=" + obj.childNodes[i].value + "&";
            }
            if (obj.childNodes[i].type == "checkbox") {
               if (obj.childNodes[i].checked) {
                  getstr += obj.childNodes[i].name + "=" + obj.childNodes[i].value + "&";
               } else {
                  getstr += obj.childNodes[i].name + "=&";
               }
            }
            if (obj.childNodes[i].type == "radio") {
               if (obj.childNodes[i].checked) {
                  getstr += obj.childNodes[i].name + "=" + obj.childNodes[i].value + "&";
               }
            }
         }   
         if (obj.childNodes[i].tagName == "SELECT") {
            var sel = obj.childNodes[i];
            getstr += sel.name + "=" + sel.options[sel.selectedIndex].value + "&";
         }         
         if (obj.childNodes[i].tagName == "TEXTAREA") {
            getstr += obj.childNodes[i].name + "=" + obj.childNodes[i].value + "&";
         }    
      }
      makeRequest('get', getstr);
   }