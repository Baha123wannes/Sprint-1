package com.example.demo.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="metering_device_type")
public class DeviceType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="description")
	private String description ;
	@Column(name="value")
	private String Value;
	
	@OneToOne
	private Restrection restrictionType;

	public DeviceType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeviceType(int id, String description, String value, Restrection restrictionType) {
		super();
		this.id = id;
		this.description = description;
		Value = value;
		this.restrictionType = restrictionType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

	public Restrection getRestrictionType() {
		return restrictionType;
	}

	public void setRestrictionType(Restrection restrictionType) {
		this.restrictionType = restrictionType;
	}
	
	
}
