import java.sql.*;

public class DatabaseManager
{
	private String dburl="jdbc:mysql://localhost:3306/test";
	private String dbname="root";
	private String dbpass="pigRvVaQQ8RLR8yi";
	private String dbdriver="com.mysql.cj.jdbc.Driver";
	
	public void loadDriver(String dbDriver) 
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() 
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(dburl,dbname,dbpass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public String insert(Member member) //Gia to register kuriws
	{
		loadDriver(dbdriver);
		Connection con = getConnection();
		String result ="data entered successfully";
		String sql ="insert into test.user values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,member.getName());
			ps.setString(2,member.getPassword());
			ps.setString(3,member.getSpeciality());
			ps.setString(4,member.getEmail());
			ps.setString(5,member.getPhone());
			
			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
			result = "FAILED TO ENTER THE INFO"; 
		}
		return result;
	}
	
	public String insertD(Member member) //Gia to register kuriws
	{
		loadDriver(dbdriver);
		Connection con = getConnection();
		String result ="data entered successfully";
		String sql ="insert into test.doctor values(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,member.getName());
			ps.setString(2,member.getPassword());
			ps.setString(3,member.getSpeciality());
			ps.setString(4,member.getEmail());
			ps.setString(5,member.getPhone());
			ps.setString(6,member.getVigil());
			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
			result = "FAILED TO ENTER THE INFO"; 
		}
		return result;
	}
	
	public String insertE(Member member) //Gia to register kuriws
	{
		loadDriver(dbdriver);
		Connection con = getConnection();
		String result ="data entered successfully";
		String sql ="insert into test.employee values(?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,member.getName());
			ps.setString(2,member.getPassword());
			ps.setString(3,member.getEmail());
			ps.setString(4,member.getPhone());
			
			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
			result = "FAILED TO ENTER THE INFO"; 
		}
		return result;
	}
	
	
	public String insertN(Member member) //Gia to register kuriws
	{
		loadDriver(dbdriver);
		Connection con = getConnection();
		String result ="data entered successfully";
		String sql ="insert into test.nurse values(?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,member.getName());
			ps.setString(2,member.getPassword());
			ps.setString(3,member.getEmail());
			ps.setString(4,member.getPhone());
			
			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
			result = "FAILED TO ENTER THE INFO"; 
		}
		return result;
	}
	
	public String insertP(Member member) //Gia to register kuriws
	{
		loadDriver(dbdriver);
		Connection con = getConnection();
		String result ="data entered successfully";
		String sql ="insert into test.patient values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,member.getName());
			ps.setString(2,member.getPassword());
			ps.setString(3,member.getEmail());
			ps.setString(4,member.getPhone());
			
			ps.setString(5,member.getAmka());
			ps.setString(6,member.getAddress());
			ps.setString(7,member.getAgency());
			ps.setString(8,member.getDiseases());
			ps.setString(9,member.getLastLoggedIn());

			ps.setString(10,member.getSymptoms());
			ps.setString(11,member.getAppointment());
			ps.setString(12,member.getDay());
			ps.setString(13,member.getMonth());
			ps.setString(14,member.getTime());
			ps.setString(15,member.getIllness());
			ps.setString(16,member.getDrugs());
			ps.setString(17,member.getExaminations());
			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
			result = "FAILED TO ENTER THE INFO"; 
		}
		return result;
	}
	
	public String insertPi(Member member) //Gia to register kuriws
	{
		loadDriver(dbdriver);
		Connection con = getConnection();
		String result ="data entered successfully";
		String sql ="insert into test.patientinfo values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,member.getName());
			ps.setString(2,member.getPassword());
			ps.setString(3,member.getEmail());
			ps.setString(4,member.getPhone());
			
			ps.setString(5,member.getAmka());
			ps.setString(6,member.getAddress());
			ps.setString(7,member.getAgency());
			ps.setString(8,member.getDiseases());
			ps.setString(9,member.getLastLoggedIn());
			
			ps.setString(10,member.getSymptoms());
			ps.setString(11,member.getAppointment());
			ps.setString(12,member.getDay());
			ps.setString(13,member.getMonth());
			ps.setString(14,member.getTime());
			ps.setString(15,member.getIllness());
			ps.setString(16,member.getDrugs());
			ps.setString(17,member.getExaminations());

			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
			result = "FAILED TO ENTER THE INFO"; 
		}
		return result;
	}
	
	
	public String insertCovid(Member member) //Gia to register kuriws
	{
		loadDriver(dbdriver);
		Connection con = getConnection();
		String result ="data entered successfully";
		String sql ="insert into test.covid values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,member.getName());
			ps.setString(2,member.getPassword());
			ps.setString(3,member.getEmail());
			ps.setString(4,member.getPhone());
			
			ps.setString(5,member.getAmka());
			ps.setString(6,member.getAddress());
			ps.setString(7,member.getAgency());
			ps.setString(8,member.getDiseases());
			ps.setString(9,member.getLastLoggedIn());
			
			ps.setString(10,member.getSymptoms());
			ps.setString(11,member.getAppointment());
			ps.setString(12,member.getDay());
			ps.setString(13,member.getMonth());
			ps.setString(14,member.getTime());
			ps.setString(15,member.getIllness());
			ps.setString(16,member.getDrugs());
			ps.setString(17,member.getExaminations());

			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
			result = "FAILED TO ENTER THE INFO"; 
		}
		return result;
	}
	
	
	public String insertUi(String name, String password, String speciality, String email, String phone,String LastLoggedIn) //Gia to register kuriws
	{
		loadDriver(dbdriver);
		Connection con = getConnection();
		String result ="data entered successfully";
		String sql ="insert into test.userinfo values(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,speciality);
			ps.setString(4,email);
			ps.setString(5,phone);
			ps.setString(6,LastLoggedIn);	
			
			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
			result = "FAILED TO ENTER THE INFO"; 
		}
		return result;
	}
	
	public boolean check(Member member) {//Gia to login kuriws
		boolean status = false;
		loadDriver(dbdriver);
		Connection con = getConnection();
		String sql ="select * from user where name = ? and password = ?";	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,member.getName());
			ps.setString(2,member.getPassword());
			ResultSet rs = ps.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public void Update(Member member) {//Gia to login kuriws
		loadDriver(dbdriver);
		Connection con = getConnection();
		String sql ="update patient set LastLoggedIn = ? where name = ? and password = ?";	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,member.getLastLoggedIn());
			ps.setString(2,member.getName());
			ps.setString(3,member.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
