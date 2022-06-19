

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PatientExam
 */
@WebServlet("/PatientExam")
public class PatientExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseManager dbm;

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dbm = new DatabaseManager();
		Connection con = dbm.getConnection();
		Connection con1 = dbm.getConnection();

		
		String illness = " ",drugs=" ", amka=" ",appointmentChange= " ",dayChange= " ", monthChange= " ",timeChange= " ";
		String  illnessChange = " ",drugsChange=" ",examinationChange= " ";
		
		amka = request.getParameter("patient");
		illnessChange = request.getParameter("illness");
		drugsChange = request.getParameter("drugs");
		examinationChange = request.getParameter("examination");

		appointmentChange = request.getParameter("doctor");
		dayChange= request.getParameter("day");
		monthChange= request.getParameter("month");
		timeChange= request.getParameter("time");
		
		
		
		String sql ="select * from patient where amka = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql); //edw vriskw ola ta stoixeia toy episkepth
			ps.setString(1,amka);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				illness=rs.getString("illness");
				drugs=rs.getString("drugs");		
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(illnessChange == null ||illnessChange.equals("")) {illnessChange = illness;}
		if(drugsChange == null||drugsChange.equals("")) {drugsChange =drugs ;}
		
				
		String sql1 ="UPDATE patient SET appointment= ?, day = ?, month= ?, time= ?, illness = ?, drugs = ?, examinations= ? WHERE amka = ?"; // where name = ? and password = ?
		
		try {
			PreparedStatement ps1 = con1.prepareStatement(sql1);
			ps1.setString(1,appointmentChange);
			ps1.setString(2,dayChange);
			ps1.setString(3,monthChange);
			ps1.setString(4,timeChange);
			
			ps1.setString(5,illnessChange);
			ps1.setString(6,drugsChange);
			ps1.setString(7,examinationChange);

			
			
						
			ps1.setString(8,amka);
		
		
			ps1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		response.sendRedirect("http://localhost:8080/FHospital/login/login.jsp");//as8enhs
	
	}

}
