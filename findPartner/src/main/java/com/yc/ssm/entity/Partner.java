package com.yc.ssm.entity;

public class Partner {
	private String lid;
	private String phone;
	private String email;
	private String password;
	private String uname;
	private String gender;
	private String regdate;// 注册时间

	public Partner() {

	}

	public Partner(String lid, String phone, String email, String password, String uname, String gender,
			String regdate) {
		this.lid = lid;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.uname = uname;
		this.gender = gender;
		this.regdate = regdate;
	}

	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "\nPartner [lid=" + lid + ", phone=" + phone + ", email=" + email + ", password=" + password + ", uname="
				+ uname + ", gender=" + gender + ", regdate=" + regdate + "]";
	}

}
