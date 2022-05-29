package com.example.pv.hanbiro.ql_tts.Model;

public class User {

	private int id;
	private String tendangnhap;
	private String matkhau;
	private String ten;
	private String email;
	private String sdt;
	public User(int id, String tendangnhap, String matkhau, String ten, String email, String sdt) {
		super();
		this.id = id;
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
		this.ten = ten;
		this.email = email;
		this.sdt = sdt;
	}
	
	public User() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTendangnhap() {
		return tendangnhap;
	}
	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
}
