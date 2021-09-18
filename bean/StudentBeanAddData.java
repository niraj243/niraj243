package com.app.bean;

public class StudentBeanAddData {

	private static long studentId;
	private String firstname;
	private String lastname;
	private long bdate;
	private String email;
	private long phone;
	private String addressLine1;
	private String addressLine2;
	private int gender;
	private String city;
	private String country;
	private String course;

	public StudentBeanAddData(long studentId, String firstname, String lastname, long bdate, String email, long phone,
			int gender, String addressLine1, String addressLine2, String city, String country, String course) {

		this.studentId = studentId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.bdate = bdate;
		this.email = email;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.gender = gender;
		this.city = city;
		this.country = country;
		this.course = course;
	}

	public static long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public long getBdate() {
		return bdate;
	}

	public void setBdate(long bdate) {
		this.bdate = bdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

}
