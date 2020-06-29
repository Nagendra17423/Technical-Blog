package com.tech.blog.entities;

import java.sql.Timestamp;

public class Posts {
	private int pid;
	private String ptitle;
	private String pcontent;
	private String pcode;
	private String ppic;
	private int catid;
	@Override
	public String toString() {
		return "Posts [pid=" + pid + ", ptitle=" + ptitle + ", pcontent=" + pcontent + ", pcode=" + pcode + ", ppic="
				+ ppic + ", catid=" + catid + ", pdate=" + pdate + ", user_id=" + user_id + "]";
	}

	private Timestamp pdate;
	private int user_id;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPpic() {
		return ppic;
	}

	public void setPpic(String ppic) {
		this.ppic = ppic;
	}

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	public Timestamp getPdate() {
		return pdate;
	}

	public void setPdate(Timestamp pdate) {
		this.pdate = pdate;
	}

}
