package com.model;

public class UserDetails {
	public int userId;
	public  String name;
    public String phoneNumber;
    public String password;
    public String city;
    public String mailId;
	public  String adminName;
    public String adminPassword;

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
		
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", name=" + name + ", phoneNumber=" + phoneNumber + ", password="
				+ password + ", city=" + city + ", mailId=" + mailId + ", adminName=" + adminName + ", adminPassword="
				+ adminPassword + ", getUserId()=" + getUserId() + ", getName()=" + getName() + ", getPhoneNumber()="
				+ getPhoneNumber() + ", getPassword()=" + getPassword() + ", getCity()=" + getCity() + ", getMailId()="
				+ getMailId() + ", getAdminName()=" + getAdminName() + ", getAdminPassword()=" + getAdminPassword()
				+ "]";
	}
//	public UserDetails(int userId2, String name2, String phoneNumber2, String password2, String city2, String mail_id) {
//		super();
//		this.userId = userId;
//		this.name = name;
//		this.phoneNumber = phoneNumber;
//		this.password = password;
//		this.city = city;
//		this.mailId = mailId;
//		this.adminName = adminName;
//		this.adminPassword = adminPassword;
//	}
	
	public UserDetails(String name,String phoneNumber,String password,String city, String mailId){
		this.name=name;
		this.phoneNumber =phoneNumber;
		this.password = password;
		this.city =city;
		this.mailId = mailId;
	}
//	public UserDetails() {
//		// TODO Auto-generated constructor stub
//	}
	public UserDetails() {
		// TODO Auto-generated constructor stub
	}


}