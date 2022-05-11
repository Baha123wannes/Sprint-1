package com.example.demo.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name="metering_property")
@JsonRootName("parameter")
@JsonIgnoreProperties

public class Parameter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	@Column(name="code")
	private int code;
	@Column(name="description")
	private String description;
	@Column(name="bitmask")
	private String bitmask;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="dlmsType_id")
	private DlmsType dlmsType_id;
	public Parameter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Parameter(int id, int code, String description, String bitmask, DlmsType dlmsType_id) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.bitmask = bitmask;
		this.dlmsType_id = dlmsType_id;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBitmask() {
		return bitmask;
	}
	public void setBitmask(String bitmask) {
		this.bitmask = bitmask;
	}
	
	public DlmsType getDlmsType_id() {
		return dlmsType_id;
	}
	public void setDlmsType_id(DlmsType dlmsType_id) {
		this.dlmsType_id = dlmsType_id;
	}
	
	
}
