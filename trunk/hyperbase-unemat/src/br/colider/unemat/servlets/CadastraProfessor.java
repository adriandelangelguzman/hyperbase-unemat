package br.colider.unemat.servlets;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.colider.unemat.entities.Professor;
import br.colider.unemat.servlets.logic.Logic;

public class CadastraProfessor implements Logic {

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String matricula = request.getParameter("matricula");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");

		Professor professor = new Professor();
		professor.setMatricula(matricula);
		professor.setLogin(login);
		professor.setSenha(senha);
		professor.setNome(nome);
		professor.setEmail(email);

		PrintWriter out = response.getWriter();
		out.write("Cadastro Efetuado");

	}
}
