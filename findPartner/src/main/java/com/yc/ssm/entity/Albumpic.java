package com.yc.ssm.entity;

public class Albumpic {// 相册集
	private String abid; // 相册编号
	private String apic; // 图片
	private String apiccontent; // 图片描述
	private String apicdate; // 图片上传时间

	public Albumpic() {
	}

	public Albumpic(String abid, String apic, String apiccontent, String apicdate) {
		this.abid = abid;
		this.apic = apic;
		this.apiccontent = apiccontent;
		this.apicdate = apicdate;
	}

	public String getAbid() {
		return abid;
	}

	public void setAbid(String abid) {
		this.abid = abid;
	}

	public String getApic() {
		return apic;
	}

	public void setApic(String apic) {
		this.apic = apic;
	}

	public String getApiccontent() {
		return apiccontent;
	}

	public void setApiccontent(String apiccontent) {
		this.apiccontent = apiccontent;
	}

	public String getApicdate() {
		return apicdate;
	}

	public void setApicdate(String apicdate) {
		this.apicdate = apicdate;
	}

	@Override
	public String toString() {
		return "\nAlbumpic [abid=" + abid + ", apic=" + apic + ", apiccontent=" + apiccontent + ", apicdate=" + apicdate
				+ "]";
	}

}
