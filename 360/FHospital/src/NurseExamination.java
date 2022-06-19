

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
 * Servlet implementation class NurseChanges
 */
@WebServlet("/NurseExamination")
public class NurseExamination extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseManager dbm ;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dbm = new DatabaseManager();
		Connection con = dbm.getConnection();
		Connection con1 = dbm.getConnection();

		
		String examination = " ",re_examination=" ",amka = " ";
		String Pexamination = " ";
		
		examination = request.getParameter("examination");
		re_examination = request.getParameter("re_examination");
		amka = request.getParameter("patient");
		
		
		String sql ="select * from patient WHERE amka = ?";//h name

		try {
			PreparedStatement ps = con.prepareStatement(sql); //edw vriskw ola ta stoixeia toy episkepth
			ps.setString(1,amka);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Pexamination = rs.getString("examinations");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(re_examination.equals("no")) {
			System.out.println("The examination was canceled");
		}else if(re_examination.equals("yes") && examination.equals(Pexamination)) {
			examination = "";
			String sql1 ="UPDATE patient SET  examinations= ? WHERE amka = ?"; // where name = ? and password = ?
			
			try {
				PreparedStatement ps1 = con1.prepareStatement(sql1);

				ps1.setString(1,examination);
				ps1.setString(2,amka);
				ps1.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		response.sendRedirect("http://localhost:8080/FHospital/profile/nursepage.jsp");
	}

}
