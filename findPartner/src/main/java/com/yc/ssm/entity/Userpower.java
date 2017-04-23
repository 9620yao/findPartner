package com.yc.ssm.entity;

public class Userpower {
	private String upid; // 权限编号
	private String upuid; // 用户编号
	private String upower; // 用户权限
	private String updata; // 权限修改时间

	public Userpower() {
	}

	public Userpower(String upid, String upuid, String upower, String updata) {
		this.upid = upid;
		this.upuid = upuid;
		this.upower = upower;
		this.updata = updata;
	}

	public String getUpid() {
		return upid;
	}

	public void setUpid(String upid) {
		this.upid = upid;
	}

	public String getUpuid() {
		return upuid;
	}

	public void setUpuid(String upuid) {
		this.upuid = upuid;
	}

	public String getUpower() {
		return upower;
	}

	public void setUpower(String upower) {
		this.upower = upower;
	}

	public String getUpdata() {
		return updata;
	}

	public void setUpdata(String updata) {
		this.updata = updata;
	}

	@Override
	public String toString() {
		return "\nUserpower [upid=" + upid + ", upuid=" + upuid + ", upower=" + upower + ", updata=" + updata + "]";
	}

}
