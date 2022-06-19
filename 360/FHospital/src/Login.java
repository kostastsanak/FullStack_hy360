import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseManager dbm ;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result1 = "";
		dbm = new DatabaseManager();
		String character= null;
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Member member = new Member();
		member.setName(name);
		member.setPassword(password);
		
		if (dbm.check(member)) {
			Connection con = dbm.getConnection();
			String sql ="select * from user where name = ? and password = ?";	

			try {
				PreparedStatement ps = con.prepareStatement(sql); //edw vriskw thn idiothta toy episkepth
				ps.setString(1,member.getName());
				ps.setString(2,member.getPassword());
				ResultSet rs = ps.executeQuery();
				String sql1 ="";
				if(rs.next()) { 
					character = rs.getString("speciality"); 
					Connection con1 = dbm.getConnection();
					if (character == null) {
						sql1 ="select * from patient where name = ? and password = ?";
					}else{
						sql1 ="select * from user where name = ? and password = ?";
					}
						

					try {
						PreparedStatement ps1 = con1.prepareStatement(sql1); //edw vriskw thn idiothta toy episkepth
						ps1.setString(1,member.getName());
						ps1.setString(2,member.getPassword());
						ResultSet rs1 = ps1.executeQuery();
						if(rs1.next()) {
							String namei=rs1.getString("name");
							String passwordi=rs1.getString("password");
							String email=rs1.getString("email");
							String phone=rs1.getString("phone");
							if(character == null) {
								String amka=rs1.getString("amka");
								String address=rs1.getString("address");
								String agency=rs1.getString("agency");
								String diseases=rs1.getString("diseases");
								String LastLoggedIn=rs1.getString("LastLoggedIn");
								
								String symptoms=rs1.getString("symptoms");
								String appointment=rs1.getString("appointment");
								String day=rs1.getString("day");
								String month=rs1.getString("month");
								String time=rs1.getString("time");	
								
								String illness=rs1.getString("illness");
								String drugs=rs1.getString("drugs");	
								String examinations =rs1.getString("examinations");
								Member member3 = new Member(namei, passwordi, email, phone, amka, address, agency, diseases,LastLoggedIn,symptoms,appointment,day,month,time,illness,drugs,examinations);
								result1  = dbm.insertPi(member3);
							}else if(character != null) {
								String speciality=rs1.getString("speciality");
								Date date = Calendar.getInstance().getTime();  
						        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");  
						        String LastLoggedIn1 = dateFormat.format(date);
								result1  = dbm.insertUi(namei, passwordi,speciality, email, phone,LastLoggedIn1);
							}
							
						}
						
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
						
						
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			Date date = Calendar.getInstance().getTime();
	        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");  //edw ananewnw to teleutaio login tou an einai as8enhs
	        String LoggedInTime = dateFormat.format(date);
	        member.setLastLoggedIn(LoggedInTime);
			
			dbm.Update(member);
			
			if(character!= null) {
				if(character.equals("d")) {
					response.sendRedirect("http://localhost:8080/FHospital/profile/doctorpage.jsp");//proswpiko
				}else if(character.equals("e")) {
					response.sendRedirect("http://localhost:8080/FHospital/profile/employeepage.jsp");//proswpiko
				}else if (character.equals("n")){
					response.sendRedirect("http://localhost:8080/FHospital/profile/nursepage.jsp");//proswpiko
				}
			}else {
				
				response.sendRedirect("http://localhost:8080/FHospital/profile/patientpage.jsp");//as8enhs
			}
			
			
			
		}else {
			response.sendRedirect("http://localhost:8080/FHospital/login/login.jsp");//proswpiko
		}
	}
	
}
