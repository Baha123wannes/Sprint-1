package com.example.demo.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name="metering_attribute_association")

public class Association_attribute {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id_Association_Attribute;
	
	@Column(name="name")
	private String name;
	@Column(name="multi_cast")
	private boolean multiCast;
	
	@Column(name="broadcast")
	private boolean broadCast;
	
	@Column(name="unicast")
	private boolean uniCast;
	
	
	public Association_attribute() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Association_attribute(int id, String name, boolean multiCast, boolean broadCast, boolean uniCast) {
		super();
		this.id_Association_Attribute = id;
		this.name = name;
		this.multiCast = multiCast;
		this.broadCast = broadCast;
		this.uniCast = uniCast;
	}
	public int getId_Association_Attribute() {
		return id_Association_Attribute;
	}

	public void setId_Association_Attribute(int id) {
		this.id_Association_Attribute = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMultiCast() {
		return multiCast;
	}

	public void setMultiCast(boolean multiCast) {
		this.multiCast = multiCast;
	}

	public boolean isBroadCast() {
		return broadCast;
	}

	public void setBroadCast(boolean broadCast) {
		this.broadCast = broadCast;
	}

	public boolean isUniCast() {
		return uniCast;
	}

	public void setUniCast(boolean uniCast) {
		this.uniCast = uniCast;
	}

	
	


	}
