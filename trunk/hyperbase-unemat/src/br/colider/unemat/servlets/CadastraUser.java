package br.colider.unemat.servlets;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.colider.unemat.entities.Aluno;
import br.colider.unemat.entities.Professor;
import br.colider.unemat.servlets.logic.Logic;

/**
 * Servlet implementation class CadastraUser
 */
public class CadastraUser implements Logic {

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");
		String tipo = request.getParameter("tipo");
		
		if(tipo == "1"){
			Aluno aluno = new Aluno();
			aluno.setNome(nome);
			aluno.setLogin(login);
			aluno.setSenha(senha);
			aluno.setEmail(email);
		}
		if(tipo == "2"){
			Professor professor = new Professor();
			professor.setNome(nome);
			professor.setLogin(login);
			professor.setSenha(senha);
			professor.setEmail(email);
		}

		PrintWriter out = response.getWriter();
		out.write("Inscricao Realizada com Sucesso:" + nome);

	}

}
