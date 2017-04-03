package com.yc.ssm.entity;

public class Comments {
	private String cid;
	private String callid;
	private String detail;
	private String comuserid;
	private String comTime;
	
	public Comments() {
	}
	public Comments(String cid, String callid, String detail, String comuserid, String comTime) {
		this.cid = cid;
		this.callid = callid;
		this.detail = detail;
		this.comuserid = comuserid;
		this.comTime = comTime;
	}


	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCallid() {
		return callid;
	}

	public void setCallid(String callid) {
		this.callid = callid;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getComuserid() {
		return comuserid;
	}

	public void setComuserid(String comuserid) {
		this.comuserid = comuserid;
	}

	public String getComTime() {
		return comTime;
	}

	public void setComTime(String comTime) {
		this.comTime = comTime;
	}

	@Override
	public String toString() {
		return "\nComments [cid=" + cid + ", callid=" + callid + ", detail=" + detail + ", comuserid=" + comuserid
				+ ", comTime=" + comTime + "]";
	}
	
	
}
