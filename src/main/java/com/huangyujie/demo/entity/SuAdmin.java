package com.huangyujie.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class SuAdmin {
	@Id
	@GeneratedValue
	private int suadminID;
	
	public int getSuadminID() {
		return suadminID;
	}

	private String suadminName;
	private String password;

	public void setSuadminID(int suadminID) {
		this.suadminID = suadminID;
	}


	public String getSuadminName() {
		return suadminName;
	}


	public void setSuadminName(String suadminName) {
		this.suadminName = suadminName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



	
	
	public SuAdmin() {
		// TODO Auto-generated constructor stub
	}

}
