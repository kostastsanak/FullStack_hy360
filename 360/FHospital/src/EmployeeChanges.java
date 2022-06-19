

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
 * Servlet implementation class EmployeeChanges
 */
@WebServlet("/EmployeeChanges")
public class EmployeeChanges extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseManager dbm ;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dbm = new DatabaseManager();
		Connection con = dbm.getConnection();
		Connection con1 = dbm.getConnection();

		
		String doctor = " ",vigil=" ";
		String vigilChange=" ";
		
		doctor = request.getParameter("doctor");
		
		vigilChange = request.getParameter("vigil");
		
		String sql ="select * from doctor where speciality = ?";//h name

		try {
			PreparedStatement ps = con.prepareStatement(sql); //edw vriskw ola ta stoixeia toy episkepth
			ps.setString(1,doctor);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				vigil = rs.getString("vigil");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(vigilChange == null ||vigilChange.equals("")) {vigilChange = vigil;}
		String sql1 ="UPDATE doctor SET  vigil= ? WHERE name = ?"; // where name = ? and password = ?
		
		try {
			PreparedStatement ps1 = con1.prepareStatement(sql1);
			
			
			ps1.setString(1,vigilChange);
			ps1.setString(2,doctor);
			ps1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		response.sendRedirect("http://localhost:8080/FHospital/profile/employeepage.jsp");//as8enhs
	}

}
