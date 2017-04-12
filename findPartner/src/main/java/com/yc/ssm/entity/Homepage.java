package com.yc.ssm.entity;

/**
 * 
 * @author 姚秋林 添加主页表，用来显示个人中心和他的主页
 *
 */
public class Homepage {

	private String hpid;// 用来存放说说/图片的编号
	private String hpuseid;// 用来存放说说/图片发表人的编号
	private String hpdate;// 用来存放说说/图片 的发表时间

	public Homepage() {
	}

	public Homepage(String hpid, String hpuseid, String hpdate) {
		this.hpid = hpid;
		this.hpuseid = hpuseid;
		this.hpdate = hpdate;
	}

	public String getHpid() {
		return hpid;
	}

	public void setHpid(String hpid) {
		this.hpid = hpid;
	}

	public String getHpuseid() {
		return hpuseid;
	}

	public void setHpuseid(String hpuseid) {
		this.hpuseid = hpuseid;
	}

	public String getHpdate() {
		return hpdate;
	}

	public void setHpdate(String hpdate) {
		this.hpdate = hpdate;
	}

	@Override
	public String toString() {
		return "\nHomepage [hpid=" + hpid + ", hpuseid=" + hpuseid + ", hpdate=" + hpdate + "]";
	}

}
