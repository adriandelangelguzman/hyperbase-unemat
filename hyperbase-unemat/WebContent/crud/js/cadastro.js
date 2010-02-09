   var http_request = false;
   function makeRequest(url, parameters) {
      url = url+".jsp";
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