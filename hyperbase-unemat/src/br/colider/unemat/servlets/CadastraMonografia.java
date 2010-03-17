package br.colider.unemat.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import br.colider.unemat.dao.MonografiaDao;
import br.colider.unemat.entities.Monografia;

public class CadastraMonografia extends HttpServlet {

	public CadastraMonografia(){
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
		String resumo = null;
		String abstract_ = null;
		Integer numpage = null;
		Date data = null;
		String keywords = null;

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart) {
			
			DiskFileItemFactory factory = new DiskFileItemFactory();

			ServletFileUpload upload = new ServletFileUpload(factory);
			// Set overall request size constraint
			upload.setSizeMax(10 * 1024 * 1024);

			// Set factory constraints
			// factory.setSizeThreshold(10000);
			//factory.setRepository(new File("/tmp"));

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
					if (item.getFieldName().equals("resumo")) {
						resumo = item.getString();
					}
					if (item.getFieldName().equals("abstract")) {
						abstract_ = item.getString();
					}
					if (item.getFieldName().equals("numpage")) {
						numpage = Integer.parseInt(item.getString());
					}
					if (item.getFieldName().equals("data")) {
						String sdata = item.getString();
						DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
						try {
							data = new Date(fmt.parse(sdata).getTime());
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}
					if (item.getFieldName().equals("keywords")) {
						keywords = item.getString();
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

		Monografia monografia = new Monografia();
		
		if (titulo != null)
			monografia.setTitulo(titulo);
		if (resumo != null)
			monografia.setResumo(resumo);
		if (abstract_ != null)
			monografia.setAbstract_(abstract_);
		if (numpage != null)
			monografia.setNumpage(numpage);
		if (data != null)
			monografia.setData(data);
		if (keywords != null)
			monografia.setKeywords(keywords);

		System.out.println("CAD:" + monografia.getTitulo());
		System.out.println(monografia.getResumo());
		System.out.println(monografia.getAbstract_());
		System.out.println(monografia.getData());
		System.out.println(monografia.getNumpage());
		System.out.println("CAD:" + monografia.getKeywords());
		
		String newFileName = ".pdf";
		try {
			MonografiaDao dao = new MonografiaDao();;
			
			int id = dao.adiciona(monografia);
			
			monografia.setId(id);
			
			newFileName = Integer.toString(id) + newFileName;
			dao.adicionaPdf(monografia,newFileName);
			
			File dirToMove = new File("/home/benevid/Desktop/files/monografias/");
			File newFile = new File(dirToMove,newFileName);
			
			tmpFile.renameTo(newFile);
			tmpFile.delete();
			
			PrintWriter out = response.getWriter();
			//out.println("Cadastro Realizado com Sucesso --");
			//out.write("<html>");
			//	out.write("<label>Titulo:" + monografia.getTitulo() + "</label>");
			//out.write("</html>");
			
			response.sendRedirect("crud/index.jsp");
			//RequestDispatcher rd = request.getRequestDispatcher("/crud/cad-monografia.jsp");
			//rd.forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
