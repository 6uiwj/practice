package com.momo.dto;

public class MemberDto {
private String id;
private String pass;
private String name;
private String regidate;

@Override
	public String toString() {
		return id + " / " + pass + " / " + name + " / " + regidate;
	}

public MemberDto(){}

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRegidate() {
	return regidate;
}
public void setRegidate(String regidate) {
	this.regidate = regidate;
}
}
