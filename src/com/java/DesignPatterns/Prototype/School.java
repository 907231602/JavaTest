package com.java.DesignPatterns.Prototype;

import java.io.Serializable;

public class School implements Cloneable,Serializable{
	private String schoolName;
	private String address;//µÿ÷∑
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "School [schoolName=" + schoolName + ", address=" + address + "]";
	}
	
	public School CloneSchool() throws CloneNotSupportedException {
		return (School) super.clone();
	}
}
