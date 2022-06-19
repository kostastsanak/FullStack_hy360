

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Transaction
 */
@WebServlet("/Transaction")
public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String speciality=request.getParameter("speciality");
		if(speciality == null) {
			response.sendRedirect("http://localhost:8080/FHospital/login/login.jsp");
		}
		else if (speciality.equals("personnel")) {
			response.sendRedirect("http://localhost:8080/FHospital/login/personnel.jsp");
		}else if(speciality.equals("patient")) {
			response.sendRedirect("http://localhost:8080/FHospital/login/patient.jsp");
		}
	}

}
