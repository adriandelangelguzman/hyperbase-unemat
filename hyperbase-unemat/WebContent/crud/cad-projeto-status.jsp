<%@page%>
<%@ page import="br.colider.unemat.servlets.controller.FileUploadListener"%>
<%
  FileUploadListener listener = (FileUploadListener)session.getAttribute("LISTENER");
%>
Total size: <%=listener.getTotalSize()%><br/>
Read count: <%=listener.getTotalRead()%><br/>