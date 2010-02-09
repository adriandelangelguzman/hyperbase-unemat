package br.colider.unemat.servlets.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.colider.unemat.servlets.logic.Logic;

@SuppressWarnings("serial")
public class ControllerServlet extends HttpServlet {

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String business = request.getParameter("hyperbase");
		
		if (business != null) {
			
			String className = "br.colider.unemat.servlets." + business;
			Class classe = null;
			try {
				classe = Class.forName(className);

				if (!Logic.class.isAssignableFrom(classe)) {
					throw new ServletException(
							"Classe não implementa interface" + className);
				}

			} catch (Exception e) {
				throw new ServletException("A lógica causou uma excessão", e);
			}

			Logic businessLogic;
			try {
				businessLogic = (Logic) classe.newInstance();
				businessLogic.execute(request, response);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			PrintWriter out = response.getWriter();
			out.print("Logica nao informada!");
		}
	}
}
