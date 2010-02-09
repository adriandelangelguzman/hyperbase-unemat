package br.colider.unemat.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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

import br.colider.unemat.dao.ProjetoDao;
import br.colider.unemat.entities.Projeto;

public class CadastraProjeto extends HttpServlet {

	public CadastraProjeto() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		File tmpFile = null;

		String titulo = null;
		String local = null;
		String publico = null;
		Integer ano = null;
		Integer semestre = null;

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart) {

			DiskFileItemFactory factory = new DiskFileItemFactory();

			ServletFileUpload upload = new ServletFileUpload(factory);
			// Set overall request size constraint
			upload.setSizeMax(10 * 1024 * 1024);

			// Set factory constraints
			// factory.setSizeThreshold(10000);
			// factory.setRepository(new File("/tmp"));

			List<?> items = null;

			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}

			Iterator<?> itr = items.iterator();

			while (itr.hasNext()) {

				FileItem item = (FileItem) itr.next();

				if (item.isFormField()) {

					if (item.getFieldName().equals("titulo")) {
						titulo = item.getString();
					}
					if (item.getFieldName().equals("local")) {
						local = item.getString();
					}
					if (item.getFieldName().equals("publico")) {
						publico = item.getString();
					}
					if (item.getFieldName().equals("ano")) {
						ano = Integer.parseInt(item.getString());
					}
					if (item.getFieldName().equals("semestre")) {
						semestre = Integer.parseInt(item.getString());
					}
				} else {
					tmpFile = new File(item.getName());
					try {
						System.out.println("Gravando Arquivo Temporário");
						item.write(tmpFile);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

		Projeto projeto = new Projeto();

		if (titulo != null)
			projeto.setTitulo(titulo);
		if (local != null)
			projeto.setLocal(local);
		if (publico != null)
			projeto.setPublicoAlvo(publico);
		if (ano != null)
			projeto.setAno(ano);
		if (semestre != null)
			projeto.setSemestre(semestre);

		String newFileName = ".pdf";

		try {
			ProjetoDao dao = new ProjetoDao();

			int id = dao.adiciona(projeto);

			projeto.setId(id);

			newFileName = Integer.toString(id) + newFileName;
			dao.adicionaPdf(projeto, newFileName);

			File dirToMove = new File("/home/benevid/Desktop/files/projetos/");
			PrintWriter out = response.getWriter();
			
			if (dirToMove.exists()) {
				File newFile = new File(dirToMove, newFileName);
				int sizefree = 5 * (1024 * 1024);
				
				if(tmpFile.length() <= sizefree){
					tmpFile.renameTo(newFile);
					tmpFile.delete();
				}else {
					out.println("Erro no Cadastro! <ERRO 51> Arquivo Muito Grande");
					dao.remove(projeto);
					tmpFile.delete();
				}
				
				String msg = "ID:" + projeto.getId() + " Titulo:" + projeto.getTitulo() + 
				" Local:" + projeto.getLocal() + " Publico:" + projeto.getPublicoAlvo();
				
				String html = "<html><body> " + msg + 
						"<a href=\"crud/cad-projeto.jsp\">Novo Cadastro </a> " +
						"<a href=\"index.html\">Pagina Inicial </a>" +
						"</body></html>";
				
				out.println(html);

				//response.sendRedirect("crud/cad-projeto.jsp");
				// RequestDispatcher rd =
				// request.getRequestDispatcher("/crud/cad-monografia.jsp");
				// rd.forward(request, response);
			}else{
				out.println("Erro no Cadastro! Tente novamente ou contacte o administrador do sistema.");
				dao.remove(projeto);
				tmpFile.delete();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
