package br.colider.unemat.servlets.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.colider.unemat.servlets.logic.Logic;

@SuppressWarnings("serial")
public class ControllerServlet extends HttpServlet {

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String business = request.getParameter("hyperbase");
		
		String className = "br.colider.unemat.servlets." + business;

		try {
			Class classe = Class.forName(className);
			if (!Logic.class.isAssignableFrom(classe)) {
				throw new ServletException("Classe não implementa interface"
						+ className);
			}
			Logic businessLogic = (Logic) classe.newInstance();
			businessLogic.execute(request, response);
		} catch (Exception e) {
			throw new ServletException("A lógica causou uma excessão", e);
		}
	}
}
