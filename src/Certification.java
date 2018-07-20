
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Certification
 */
@WebServlet("/Certification")
public class Certification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Certification() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	
	//Generate pdf works only for the first call
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		for (int i = 0; i < StorageObjects.getInstance().getNames().size(); i++) {
			String[] attrs = { "{{name}}", "{{country}}", "{{institute}}", "{{email}}", "{{status}}" };
			String text = request.getParameter("certificate");
			for (String s : attrs) {
				if (text.contains(s) && s.equals("{{name}}")) {
					text = text.replace(s, StorageObjects.getInstance().getNames().get(i));
				}else if(text.contains(s) && s.equals("{{country}}")) {
					text = text.replace(s, StorageObjects.getInstance().getCountries().get(i));
				}else if(text.contains(s) && s.equals("{{institute}}")) {
					text = text.replace(s, StorageObjects.getInstance().getInstitutes().get(i));
				}else if(text.contains(s) && s.equals("{{email}}")) {
					text = text.replace(s, StorageObjects.getInstance().getEmails().get(i));
				}else if(text.contains(s) && s.equals("{{status}}")) {
					text = text.replace(s, StorageObjects.getInstance().getStatus().get(i));
				}
			}
			System.out.println("texto para o pdf: " + text);
			GeneratePDF generator = new GeneratePDF();
			generator.generate(text, StorageObjects.getInstance().getNames().get(i), StorageObjects.getInstance().getImage());
		}
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
