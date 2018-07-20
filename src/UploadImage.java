

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
/**
 * Servlet implementation class UploadImage
 */
//Servlet que cuida do upload da imagem de background.
@WebServlet("/UploadImage")
@MultipartConfig(maxFileSize=1024*1024*2) //2MB
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ServletFileUpload uploader = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImage() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Image Sucessfully Uploaded ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Entrei aqui");
			Part filePart = request.getPart("file");
			System.out.println(filePart);
			InputStream inputStream = null;
			if(filePart != null) {
				long fileSize = filePart.getSize();
				String fileContent = filePart.getContentType();
				System.out.println("Tipo do Conteúdo: "+fileContent);
				inputStream = filePart.getInputStream();
				StorageObjects storage = StorageObjects.getInstance();
				storage.setImage(inputStream);
				System.out.println("Tamanho da photo: "+fileSize);
			}
		}catch(Exception e){
			System.out.println("Deu erro");
			e.printStackTrace();
		}
	}
}


