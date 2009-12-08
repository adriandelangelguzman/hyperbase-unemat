package br.colider.unemat.servlets;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.colider.unemat.entities.Monografia;
import br.colider.unemat.servlets.logic.Logic;

public class CadastraMonografia implements Logic {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception, ServletException {
		
		String titulo = request.getParameter("titulo");
		String resumo = request.getParameter("resumo");
		String abstract_ = request.getParameter("abstract");
		Integer numpage = Integer.parseInt(request.getParameter("numpage"));
		
		String	sdata = request.getParameter("data");
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date(fmt.parse(sdata).getTime());
		
		String keywords = request.getParameter("palavraschave");
		String link = request.getParameter("localpdf");
		
		  
		
		Monografia monografia = new Monografia();
		
		monografia.setTitulo(titulo);
		monografia.setResumo(resumo);
		monografia.setAbstract_(abstract_);
		monografia.setNumpage(numpage);
		monografia.setData(data);
		monografia.setKeywords(keywords);
		monografia.setLink(link);
		
	}

}
