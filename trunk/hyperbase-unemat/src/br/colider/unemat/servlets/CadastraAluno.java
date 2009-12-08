package br.colider.unemat.servlets;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.colider.unemat.dao.AlunoDao;
import br.colider.unemat.entities.Aluno;
import br.colider.unemat.servlets.logic.Logic;

/**
 * Servlet implementation class CadastraUser
 */
public class CadastraAluno implements Logic {

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception,ServletException {

		
		String matricula = request.getParameter("matricula");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");

		Aluno aluno = new Aluno();
		
		aluno.setMatricula(matricula);
		aluno.setLogin(login);
		aluno.setSenha(senha);
		aluno.setNome(nome);
		aluno.setEmail(email);
		
		AlunoDao dao = new AlunoDao();
		//dao.adiciona(aluno);

		PrintWriter out = response.getWriter();
		out.write("Cadastro Efetuado!");

	}

}
