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
 * Servlet implementation class UpdateUserInfo
 */
@WebServlet("/UpdatePatientInfo")
public class UpdatePatientInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseManager dbm;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dbm = new DatabaseManager();
		Connection con = dbm.getConnection();
		Connection con1 = dbm.getConnection();
		Connection con2 = dbm.getConnection();

		
		String name = " ",password=" ",email=" ",phone=" ",amka=" ",address=" ",agency=" ",diseases=" ",LastLoggedIn =" ",symptoms = " ",appointment= " ",day= " ", month= " ",time= " ";
		String  nameChange = " ",passwordChange=" ",emailChange=" ",phoneChange=" ",amkaChange=" ",addressChange=" ",agencyChange=" ",diseasesChange=" ",symptomsChange = " ",appointmentChange= " ",dayChange= " ", monthChange= " ",timeChange= " ";
		
		
		
		nameChange = request.getParameter("change_name");
		passwordChange = request.getParameter("change_password");
		emailChange = request.getParameter("change_email");
		phoneChange = request.getParameter("change_phone");
		amkaChange = request.getParameter("change_amka");
		addressChange = request.getParameter("change_address");
		agencyChange = request.getParameter("change_agency");
		diseasesChange = request.getParameter("change_diseases");
		
		symptomsChange = request.getParameter("symptoms");
		appointmentChange = request.getParameter("doctorappointment");
		dayChange= request.getParameter("day");
		monthChange= request.getParameter("month");
		timeChange= request.getParameter("time");
		
		
		
		
		String sql ="select * from patientinfo ORDER BY LastLoggedIn DESC LIMIT 1";

		try {
			PreparedStatement ps = con.prepareStatement(sql); //edw vriskw ola ta stoixeia toy episkepth
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				name=rs.getString("name");
				password=rs.getString("password");
				email=rs.getString("email");
				phone=rs.getString("phone");
				amka=rs.getString("amka");
				address=rs.getString("address");
				agency=rs.getString("agency");
				diseases=rs.getString("diseases");
				LastLoggedIn=rs.getString("LastLoggedIn");
				
				symptoms=rs.getString("symptoms");
				appointment=rs.getString("appointment");
				day=rs.getString("day");
				month=rs.getString("month");
				time=rs.getString("time");
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(nameChange == null ||nameChange.equals("")) {nameChange = name;}
		if(passwordChange == null||passwordChange.equals("")) {passwordChange =password ;}
		if(emailChange == null||emailChange.equals("")) {emailChange =email ;}
		if(phoneChange ==null||phoneChange.equals("")) {phoneChange =phone ;}
		if(amkaChange == null||amkaChange.equals("")) {amkaChange =amka ;}
		if(addressChange ==null||addressChange.equals("")) {addressChange = address;}
		if(agencyChange == null||agencyChange.equals("")) {agencyChange =agency ;}
		if(diseasesChange == null||diseasesChange.equals("")) {diseasesChange =diseases ;}
		
		if(symptomsChange ==null||symptomsChange.equals("")) {symptomsChange =symptoms ;}
		if(appointmentChange == null||appointmentChange.equals("")) {appointmentChange =appointment ;}
		if(dayChange ==null||dayChange.equals("")) {dayChange = day;}
		if(monthChange == null||monthChange.equals("")) {monthChange =month ;}
		if(timeChange == null||timeChange.equals("")) {timeChange =time ;}
		
				
				
		String sql1 ="UPDATE patient SET name = ?, password = ?, email = ?, phone = ?, amka= ?, address = ?, agency= ?, diseases= ?, symptoms = ?, appointment= ?, day = ?, month= ?, time= ? WHERE name = ? AND password = ?"; // where name = ? and password = ?
		
		try {
			PreparedStatement ps1 = con1.prepareStatement(sql1);
			
			
			ps1.setString(1,nameChange);
			ps1.setString(2,passwordChange);
			ps1.setString(3,emailChange);
			ps1.setString(4,phoneChange);
			ps1.setString(5,amkaChange);
			ps1.setString(6,addressChange);
			ps1.setString(7,agencyChange);
			ps1.setString(8,diseasesChange);
			
			
			ps1.setString(9,symptomsChange);
			ps1.setString(10,appointmentChange);
			ps1.setString(11,dayChange);
			ps1.setString(12,monthChange);
			ps1.setString(13,timeChange);
						
			ps1.setString(14,name);
			ps1.setString(15,password);
		
		
			ps1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		String sql2 ="UPDATE user SET name = ?, password = ?, email = ?, phone = ? WHERE name = ? AND password = ? AND email = ?"; // where name = ? and password = ?
		
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
		

		
		response.sendRedirect("http://localhost:8080/FHospital/profile/patientpage.jsp");//as8enhs
	}
}
