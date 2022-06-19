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
 * Servlet implementation class Covid
 */
@WebServlet("/Covid")
public class Covid extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseManager dbm;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result1 = "";
		dbm = new DatabaseManager();
		Connection con = dbm.getConnection();

		String name = " ",password=" ",email=" ",phone=" ",amka=" ",address=" ",agency=" ",diseases=" ",LastLoggedIn =" ",symptoms = " ",appointment= " ",day= " ", month= " ",time= " ", illness, drugs= " ", examinations= " ";
	
		String sql ="select * from patient where illness = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql); //edw vriskw ola ta stoixeia toy episkepth
			ps.setString(1,"Covid");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				name= rs.getString("name");
				password= rs.getString("password");
				email= rs.getString("email");
				phone= rs.getString("phone");
				amka= rs.getString("amka");
				address= rs.getString("address");
				agency= rs.getString("agency");
				diseases= rs.getString("diseases");
				LastLoggedIn= rs.getString("LastLoggedIn");
				
				symptoms=rs.getString("symptoms");
				appointment=rs.getString("appointment");
				day=rs.getString("day");
				month=rs.getString("month");
				time=rs.getString("time");	
				
				illness=rs.getString("illness");
				drugs=rs.getString("drugs");
				examinations=rs.getString("examinations");
				
				Member member = new Member(name, password, email, phone, amka, address, agency, diseases,LastLoggedIn,symptoms,appointment,day,month,time,illness,drugs,examinations);
				result1  = dbm.insertCovid(member);
				System.out.println(result1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		response.sendRedirect("http://localhost:8080/FHospital/profile/doctorpage.jsp");//as8enhs
	
	}

}
