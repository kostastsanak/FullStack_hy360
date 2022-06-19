

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String speciality=request.getParameter("speciality");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String vigil=request.getParameter("vigil");

		
		String amka=request.getParameter("amka");
		String address=request.getParameter("address");
		String agency=request.getParameter("agency");
		String diseases=request.getParameter("diseases");
		
		
		Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");  
        String LastLoggedIn = dateFormat.format(date);  
        
		
		
		
		
		Member member = new Member(name, password, speciality, email, phone, vigil);
		DatabaseManager dbmU = new DatabaseManager();
		String result  = dbmU.insert(member);
		
		String result1 = "";
		DatabaseManager dbmO = new DatabaseManager(); //eisagwgh sta ypoloipa meloi
		if(speciality != null) {
			if (speciality.equals("d")) {
				speciality = request.getParameter("doctor");
				Member member2 = new Member(name, password, speciality, email, phone, vigil);
				result1  = dbmO.insertD(member2);
			}else if(speciality.equals("n")) {
				Member member1 = new Member(name, password, email, phone);
				result1  = dbmO.insertN(member1);
			}else if(speciality.equals("e")) {
				Member member1 = new Member(name, password, email, phone);
				result1  = dbmO.insertE(member1);
			}
		}else {
			Member member3 = new Member(name, password, email, phone, amka, address, agency, diseases, LastLoggedIn,null,null,null,null,null,null,null,null);
			result1  = dbmO.insertP(member3);
		}
		
		
		
		
		
		
		response.getWriter().println(result);
		response.getWriter().println(result1);
		response.sendRedirect("http://localhost:8080/FHospital/login/login.jsp");//as8enhs
	}

}
