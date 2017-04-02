package com.yc.ssm.entity;

public class Words {// 留言板
	private String wid; // 相册编号
	private String waid; // 用户编号
	private String wfrendid; // 留言人编号
	private String wcontent; // 留言内容
	private String waddress; // 留言人所在位置
	private String wdate; // 留言时间

	public Words() {
	}

	public Words(String wid, String waid, String wfrendid, String wcontent, String waddress, String wdate) {
		this.wid = wid;
		this.waid = waid;
		this.wfrendid = wfrendid;
		this.wcontent = wcontent;
		this.waddress = waddress;
		this.wdate = wdate;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public String getWaid() {
		return waid;
	}

	public void setWaid(String waid) {
		this.waid = waid;
	}

	public String getWfrendid() {
		return wfrendid;
	}

	public void setWfrendid(String wfrendid) {
		this.wfrendid = wfrendid;
	}

	public String getWcontent() {
		return wcontent;
	}

	public void setWcontent(String wcontent) {
		this.wcontent = wcontent;
	}

	public String getWaddress() {
		return waddress;
	}

	public void setWaddress(String waddress) {
		this.waddress = waddress;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "\nWords [wid=" + wid + ", waid=" + waid + ", wfrendid=" + wfrendid + ", wcontent=" + wcontent
				+ ", waddress=" + waddress + ", wdate=" + wdate + "]";
	}

}
