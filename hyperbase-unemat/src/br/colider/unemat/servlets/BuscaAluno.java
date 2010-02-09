package br.colider.unemat.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.colider.unemat.dao.AlunoDao;
import br.colider.unemat.entities.Aluno;
import br.colider.unemat.servlets.logic.Logic;

/**
 * Servlet implementation class BuscaAluno
 */
public class BuscaAluno implements Logic {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuscaAluno() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception, ServletException {

		Aluno aluno = new Aluno();
		String nome = request.getParameter("nome");
		String matricula = request.getParameter("matricula");

		if (nome != null) {
			aluno.setNome(nome);
			buscaPeloNome(aluno, response);
		} else if (matricula != null) {
			aluno.setMatricula(matricula);
			buscaPelaMatricula(aluno, response);
		}
	}

	private void buscaPelaMatricula(Aluno aluno, HttpServletResponse response)
			throws SQLException, IOException {

		PrintWriter out = response.getWriter();

		AlunoDao dao = new AlunoDao();

		Aluno novo_aluno = dao.getAlunoByMatricula(aluno.getMatricula());
		
		out.print("<br />");
		out.print("<input type='radio' name='alunor' value='"
				+ novo_aluno.getMatricula()
				+ "' onclick=\"selecionaValor(this.value)\" />" + " - "
				+ novo_aluno.getMatricula() + " : " + novo_aluno.getNome());

	}

	private void buscaPeloNome(Aluno aluno, HttpServletResponse response)
			throws SQLException, IOException {
		PrintWriter out = response.getWriter();

		AlunoDao dao = new AlunoDao();

		List<Aluno> alunos = dao.getAlunoByName(aluno.getNome());

		Iterator<Aluno> iter = alunos.iterator();
		if (iter.hasNext()) {
			while (iter.hasNext()) {
				Aluno novoaluno = iter.next();
				out.print("<br />");
				out.print("<input type='radio' name='alunor' value='"
						+ novoaluno.getMatricula()
						+ "' onclick=\"selecionaValor(this.value)\" />" + " - "
						+ novoaluno.getMatricula() + " : "
						+ novoaluno.getNome());
			}
		}else{
			out.print("Aluno nao encontrado");
		}
	}

}
