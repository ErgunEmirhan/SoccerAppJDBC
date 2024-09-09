package com.eergun.entities;

public class BaseEntity {
	private Integer id;
	private Integer state = 1;
	public BaseEntity(Integer id) {
		this.id = id;
	}
	
	public BaseEntity(){}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
}