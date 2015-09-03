package com.entity;

import java.util.Date;

public class Students {

	private String sid;
	private String sName;
	private String gender;
	private Date birthday;
	private String address;
	
	public Students()
	{}
	
	public Students(String sid, String sName, String gender, Date birthday,
			String address) {
		this.sid = sid;
		this.sName = sName;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
	}

	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Students [sid=" + sid + ", sName=" + sName + ", gender="
				+ gender + ", birthday=" + birthday + ", address=" + address
				+ "]";
	}
	
}
