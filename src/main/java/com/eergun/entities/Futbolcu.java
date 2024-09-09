package com.eergun.entities;

public class Futbolcu extends BaseEntity {
	private String ad;
	private String soyad;
	private Integer takimId;
	private Integer yetenekPuani;
	private Integer butce;
	
	public String getAd() {
		return ad;
	}
	
	public void setAd(String ad) {
		this.ad = ad;
	}
	
	public String getSoyad() {
		return soyad;
	}
	
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	
	public Integer getTakimId() {
		return takimId;
	}
	
	public void setTakimId(Integer takimId) {
		this.takimId = takimId;
	}
	
	public Integer getYetenekPuani() {
		return yetenekPuani;
	}
	
	public void setYetenekPuani(Integer yetenekPuani) {
		this.yetenekPuani = yetenekPuani;
	}
	
	public Integer getButce() {
		return butce;
	}
	
	public void setButce(Integer butce) {
		this.butce = butce;
	}
	
	public Futbolcu(Integer id, String ad, String soyad, Integer takim_id, Integer yetenek_puani, Integer butce) {
		super(id);
		this.ad = ad;
		this.soyad = soyad;
		this.takimId = takim_id;
		this.yetenekPuani = yetenek_puani;
		this.butce = butce;
	}
	
	public Futbolcu(String ad, String soyad, Integer takim_id, Integer yetenek_puani, Integer butce) {
		this.ad = ad;
		this.soyad = soyad;
		this.takimId = takim_id;
		this.yetenekPuani = yetenek_puani;
		this.butce = butce;
	}
	
	public Futbolcu() {
	}
	
	@Override
	public String toString() {
		return "Futbolcu{" + "id=" + getId() + ", state=" + getState() + ", ad='" + getAd() + '\'' + ", soyad='" + getSoyad() + '\'' + ", takimId=" + getTakimId() + ", yetenekPuani=" + getYetenekPuani() + ", butce=" + getButce() + '}';
	}
}