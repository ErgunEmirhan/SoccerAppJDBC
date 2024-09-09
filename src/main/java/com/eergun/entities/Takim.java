package com.eergun.entities;

public class Takim extends BaseEntity{
	private String ad;
	private Integer baskanId = -1;
	private Integer stadyumId = -1;
	
	public Takim() {
	}
	
	public Takim(String ad, Integer baskanId, Integer stadyumId) {
		this.ad = ad;
		this.baskanId = baskanId;
		this.stadyumId = stadyumId;
	}
	
	public Takim(Integer id, String ad, Integer baskanId, Integer stadyumId) {
		super(id);
		this.ad = ad;
		this.baskanId = baskanId;
		this.stadyumId = stadyumId;
	}
	
	public String getAd() {
		return ad;
	}
	
	public void setAd(String ad) {
		this.ad = ad;
	}
	
	public Integer getBaskanId() {
		return baskanId;
	}
	
	public void setBaskanId(Integer baskanId) {
		this.baskanId = baskanId;
	}
	
	public Integer getStadyumId() {
		return stadyumId;
	}
	
	public void setStadyumId(Integer stadyumId) {
		this.stadyumId = stadyumId;
	}
	
	@Override
	public String toString() {
		return "Takim{" + "id=" + getId() + ", state=" + getState() + ", ad='" + getAd() + '\'' + ", baskanId=" + getBaskanId() + ", stadyumId=" + getStadyumId() + '}';
	}
}