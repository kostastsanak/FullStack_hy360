
public class Member 
{
	private String name,password,speciality,email,phone,vigil,amka,address,agency,diseases,LastLoggedIn,symptoms,appointment,day,month,time,illness,drugs,examinations;

	public Member() {
		super();
	}
	
	public Member(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	public Member(String name, String password, String email, String phone) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	
	public Member(String name, String password, String email, String phone,String LastLoggedIn) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.LastLoggedIn = LastLoggedIn;
	}
	
	public Member(String name, String password, String speciality, String email, String phone, String vigil) {
		super();
		this.name = name;
		this.password = password;
		this.speciality = speciality;
		this.email = email;
		this.phone = phone;
		this.vigil = vigil;
	}
	
	public Member(String name, String password,String email, String phone,String amka,String address,String agency, String diseases, String LastLoggedIn) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.amka = amka;
		this.address = address;
		this.agency = agency;
		this.diseases = diseases;
		this.LastLoggedIn = LastLoggedIn;

	}

	public Member(String name, String password,String email, String phone,String amka,String address,String agency, String diseases, String LastLoggedIn,String symptoms, String appointment, String day, String month, String time,String illness, String drugs, String examinations) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.amka = amka;
		this.address = address;
		this.agency = agency;
		this.diseases = diseases;
		this.LastLoggedIn = LastLoggedIn;
		this.symptoms = symptoms;
		this.appointment = appointment;
		this.day = day;
		this.month = month;
		this.time = time;
		this.illness = illness;
		this.drugs = drugs;
		this.examinations= examinations;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getVigil() {
		return vigil;
	}

	public void setVigil(String vigil) {
		this.vigil = vigil;
	}
	
	
	public String getAmka() {
		return amka;
	}

	public void setAmka(String amka) {
		this.amka = amka;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getDiseases() {
		return diseases;
	}

	public void setDiseases(String diseases) {
		this.diseases = diseases;
	}

	public String getLastLoggedIn() {
		return LastLoggedIn;
	}

	public void setLastLoggedIn(String lastLoggedIn) {
		LastLoggedIn = lastLoggedIn;
	}
	
	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getAppointment() {
		return appointment;
	}

	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}
	
	public String getDrugs() {
		return drugs;
	}

	public void setDrugs(String drugs) {
		this.drugs = drugs;
	}
	
	public String getExaminations() {
		return examinations;
	}

	public void setExaminations(String examinations) {
		this.examinations = examinations;
	}
}