

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendText
 */
@WebServlet("/SendText")
public class SendText extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendText() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //implementar parser formato da planilha
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		String textArea = request.getParameter("test");
		ArrayList names = new ArrayList<String>();
		ArrayList countries = new ArrayList<String>();
		ArrayList institutes = new ArrayList<String>();
		ArrayList mails = new ArrayList<String>();
		ArrayList status = new ArrayList<String>();
		
		String[] fields = textArea.split("\t|\n");
		String firstLine = textArea.substring(0, textArea.indexOf("\n"));
		String[] t = firstLine.split("\t");
		int numberOfFields = t.length;
		System.out.println("number: "+numberOfFields);
		for(int i=0; i<fields.length; i++) {		
			if(i%5==0) {
				System.out.println("Name: "+fields[i]);
				names.add(fields[i]);
			}else if(i%5==1) {
				System.out.println("Country: "+fields[i]);
				countries.add(fields[i]);
			}else if(i%5==2) {
				System.out.println("Institute: "+fields[i]);
				institutes.add(fields[i]);
			}else if(i%5==3) {
				System.out.println("Mail: "+fields[i]);
				mails.add(fields[i]);
			}else if(i%5==4) {
				System.out.println("Status: "+fields[i]);
				status.add(fields[i]);
	//			System.out.println("t: "+fields[i]);
			}
	//		System.out.println("Fields: " +fields[i]);
		}
		StorageObjects.getInstance().setEmails(mails);
		StorageObjects.getInstance().setCountries(countries);
		StorageObjects.getInstance().setNames(names);
		StorageObjects.getInstance().setInstitutes(institutes);
		StorageObjects.getInstance().setStatus(status);
		
	}
//		String line = textArea.substring(0, textArea.indexOf("\n"));
	/*

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
