

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
 * Servlet implementation class UpdatePinfo
 */
@WebServlet("/UpdatePinfo")
public class UpdatePinfo extends HttpServlet {
	private DatabaseManager dbm;
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dbm = new DatabaseManager();
		Connection con = dbm.getConnection();
		Connection con1 = dbm.getConnection();
		Connection con2 = dbm.getConnection();
		Connection con3 = dbm.getConnection();
		Connection con4 = dbm.getConnection();
		
		String name = " ",password=" ", speciality= " ", email=" ",phone=" ",LastLoggedIn =" ",day= " ", month= " ",time= " ";
		String  nameChange = " ",passwordChange=" ",emailChange=" ",phoneChange=" ",patientAmka = " ",patientDay= " ",patientMonth= " ",patientTime= " ";
		
		
		
		nameChange = request.getParameter("change_name");
		passwordChange = request.getParameter("change_password");
		emailChange = request.getParameter("change_email");
		phoneChange = request.getParameter("change_phone");
		
		
		String sql ="select * from userinfo ORDER BY LastLoggedIn DESC LIMIT 1";

		try {
			PreparedStatement ps = con.prepareStatement(sql); //edw vriskw ola ta stoixeia toy episkepth
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				name=rs.getString("name");
				password=rs.getString("password");
				email=rs.getString("email");
				phone=rs.getString("phone");
				speciality = rs.getString("speciality");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(nameChange == null ||nameChange.equals("")) {nameChange = name;}
		if(passwordChange == null||passwordChange.equals("")) {passwordChange =password ;}
		if(emailChange == null||emailChange.equals("")) {emailChange =email ;}
		if(phoneChange ==null||phoneChange.equals("")) {phoneChange =phone ;}

		
		String sql1 =""; 
		if(speciality.equals("d")) {
			sql1 ="UPDATE doctor SET name = ?, password = ?, email = ?, phone = ? WHERE name = ? AND password = ?"; 
		}else if(speciality.equals("n")) {
			sql1 ="UPDATE nurse SET name = ?, password = ?, email = ?, phone = ? WHERE name = ? AND password = ?"; 
		}else if(speciality.equals("e")) {
			sql1 ="UPDATE employee SET name = ?, password = ?, email = ?, phone = ? WHERE name = ? AND password = ?"; 
		}else {
		}	
		
		try {
			PreparedStatement ps1 = con1.prepareStatement(sql1);
			
			
			ps1.setString(1,nameChange);
			ps1.setString(2,passwordChange);
			ps1.setString(3,emailChange);
			ps1.setString(4,phoneChange);
						
			ps1.setString(5,name);
			ps1.setString(6,password);
		
		
			ps1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		String sql2 ="UPDATE user SET name = ?, password = ?, email = ?, phone = ? WHERE name = ? AND password = ? AND email = ?"; 
		
		try {
			PreparedStatement ps2 = con2.prepareStatement(sql2);
			
			
			ps2.setString(1,nameChange);
			ps2.setString(2,passwordChange);
			ps2.setString(3,emailChange);
			ps2.setString(4,phoneChange);
			
						
			ps2.setString(5,name);
			ps2.setString(6,password);
			ps2.setString(7,email);
		
			ps2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//ALLAZW TA RANTEVOU
		
		patientAmka = request.getParameter("patient");
		patientDay = request.getParameter("day");
		patientMonth = request.getParameter("month");
		patientTime = request.getParameter("time");

		String sql3 ="select * from patient where amka = ?";
			
		try {
			PreparedStatement ps3 = con3.prepareStatement(sql3); //edw vriskw thn idiothta toy episkepth
			ps3.setString(1,patientAmka);
			ResultSet rs3 = ps3.executeQuery();
			if(rs3.next()) {
				day=rs3.getString("day");
				month=rs3.getString("month");
				time=rs3.getString("time");
				
				if(patientDay == null ||patientDay.equals("")) {patientDay = day;}
				if(patientMonth == null||patientMonth.equals("")) {patientMonth =month ;}
				if(patientTime == null||patientTime.equals("")) {patientTime =time ;}
				
				String sql4 ="UPDATE patient SET day = ?, month= ?, time= ? WHERE amka = ?"; // where name = ? and password = ?
				
				try {
					PreparedStatement ps4 = con4.prepareStatement(sql4);
					
					
					ps4.setString(1,patientDay);
					ps4.setString(2,patientMonth);
					ps4.setString(3,patientTime);
					ps4.setString(4,patientAmka);

					ps4.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
	
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}

			
		response.sendRedirect("http://localhost:8080/FHospital/login/login.jsp");//as8enhs
	}

}
