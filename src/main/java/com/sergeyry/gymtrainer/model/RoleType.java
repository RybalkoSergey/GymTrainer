package com.sergeyry.gymtrainer.model;

public enum RoleType {
	ATHLETE("ATHLETE"),
	TRAINER("TRAINER"),
	ADMIN("ADMIN");
	
	String roleType;
	
	private RoleType(String roleType){
		this.roleType = roleType;
	}
	
	public String getRoleType(){
		return roleType;
	}
	
}
