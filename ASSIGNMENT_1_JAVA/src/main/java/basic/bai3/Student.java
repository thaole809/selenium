package basic.bai3;

public class Student {

	private String fullName = "";
	private String address = "";
	private String dob = "";
	private String gender = "";
	private float finalGrade = 0;
	public int step = 0;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDOB() {
		return dob;
	}

	public void setDOB(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public float getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(float finalGrade) {
		this.finalGrade = finalGrade;
	}
	
	@Override
	public String toString() {
		return " + Full name: " + getFullName()
		+ "\n + Address: " + getAddress()
		+ "\n + DOB: " + getDOB()
		+ "\n + Gender: " + getGender()
		+ "\n + Final grade: " + getFinalGrade();
	}
}
