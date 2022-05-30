package com.example.pv.hanbiro.ql_tts.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="USER")
public class User {

	@Id
	@Column(name="ID_USER")
	private long id;
	
	@Column(name="TENDANGNHAP", nullable = false)
	private String tendangnhap;
	
	@Column(name="MATKHAU", nullable = false)
	private String matkhau;
	
	@Column(name="TEN")
	private String ten;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="SDT")
	private String sdt;
	
}
