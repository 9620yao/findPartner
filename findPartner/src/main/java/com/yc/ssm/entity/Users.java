package com.yc.ssm.entity;
import com.yc.ssm.entity.Partner;

public class Users {
	private String aid;
	private String alid;
	private String nickname;
	private String age;
	private String birthday;
	private String photo;
	private String star;
	private String hobby;
	private String job;
	private String company;
	private String school;
	private String address;
	private String hometown;
	private String picture;
	private String astate;
	private Partner partner;

	public Users() {
	}

	public Users(String aid, String alid, String nickname, String age, String birthday, String photo, String star,
			String hobby, String job, String company, String school, String address, String hometown, String picture,
			String astate, Partner partner) {
		this.aid = aid;
		this.alid = alid;
		this.nickname = nickname;
		this.age = age;
		this.birthday = birthday;
		this.photo = photo;
		this.star = star;
		this.hobby = hobby;
		this.job = job;
		this.company = company;
		this.school = school;
		this.address = address;
		this.hometown = hometown;
		this.picture = picture;
		this.astate = astate;
		this.partner = partner;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getAlid() {
		return alid;
	}

	public void setAlid(String alid) {
		this.alid = alid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getAstate() {
		return astate;
	}

	public void setAstate(String astate) {
		this.astate = astate;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	@Override
	public String toString() {
		return "\nUsers [aid=" + aid + ", alid=" + alid + ", nickname=" + nickname + ", age=" + age + ", birthday="
				+ birthday + ", photo=" + photo + ", star=" + star + ", hobby=" + hobby + ", job=" + job + ", company="
				+ company + ", school=" + school + ", address=" + address + ", hometown=" + hometown + ", picture="
				+ picture + ", astate=" + astate + ", Partner=" + partner + "]";
	}

}
