package com.hb.entity;

public class Student {
	
	private Integer sId;
    private String sName;
    private String sGender;
    private Integer sMarks;
    
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsGender() {
		return sGender;
	}
	public void setsGender(String sGender) {
		this.sGender = sGender;
	}
	public Integer getsMarks() {
		return sMarks;
	}
	public void setsMarks(Integer sMarks) {
		this.sMarks = sMarks;
	}
}
