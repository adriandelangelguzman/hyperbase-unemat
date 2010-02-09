package br.colider.unemat.servlets.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUpload
 */
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
    	
    	// Check that we have a file upload request
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if (isMultipart) {

			//FileUploadListener listener = new FileUploadListener(request
			//		.getContentLength());

			HttpSession session = request.getSession();
			String abstract_ = session.getAttribute("abstract").toString();
			if(abstract_ != null)
				System.out.println(abstract_);
			FileItemFactory factory = new DiskFileItemFactory();

			// Create a factory for disk-based file items
			//DiskFileItemFactory factory = new MonitoredDiskFileItemFactory(
			//		listener);

			// Set factory constraints
			//factory.setSizeThreshold(10000);
			//factory.setRepository(new File("/tmp"));

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			// Set overall request size constraint
			upload.setSizeMax(10 * 1024 * 1024);

			File tmpFile = null;
			
			FileItem parseFile = null;
			
			try {
				parseFile = (FileItem) upload.parseRequest(request).get(0);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (!parseFile.isFormField()) {
				
				try {
					tmpFile = new File(parseFile.getName());
					System.out.println(parseFile.getName());
					
					parseFile.write(tmpFile);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String caminho = getServletContext().getRealPath("/files");
				System.out.println("Caminho -->" + caminho);
				
				File dirToMove = new File("/home/benevid/workspace/hyperbase-unemat/WebContent/files/");
				
				
				String newFileName = (new Random().nextInt()) + "93" + ".pdf";
				
				File fileToMove = new File(dirToMove, newFileName);

				tmpFile.renameTo(fileToMove);

				/**
				 * Delete temporary file
				 */
				tmpFile.delete();
				System.out.println("<-- tmp file delete -->");
				/**
				 * Display newly uploaded file
				 */
				PrintWriter out = response.getWriter();
				out.write(newFileName);
				//response.sendRedirect("files/");
			}
		}
	}
}
