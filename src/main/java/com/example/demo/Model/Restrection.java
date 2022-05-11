package com.example.demo.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="metering_restriction")
public class Restrection {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="firmware_version")
	private String firmwareVersion;
	@Column(name="restriction_type")
	private RestrectionType restrictionType;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private DeviceType device_type_id;
	@ManyToOne(cascade=CascadeType.ALL)
	private DeviceVendor device_vendor_id;
	@ManyToMany(cascade=CascadeType.ALL)
	private List<DataModel> dataModels;
	public Restrection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restrection(int id, String firmwareVersion, RestrectionType restrictionType, DeviceType deviceType,
			DeviceVendor deviceVendor,List<DataModel> dataModels) {
		super();
		this.id = id;
		this.firmwareVersion = firmwareVersion;
		this.restrictionType = restrictionType;
		this.device_type_id = deviceType;
		this.device_vendor_id = deviceVendor;
		this.dataModels=dataModels;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirmwareVersion() {
		return firmwareVersion;
	}
	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
	}
	public RestrectionType getRestrictionType() {
		return restrictionType;
	}
	public void setRestrictionType(RestrectionType restrictionType) {
		this.restrictionType = restrictionType;
	}
	public DeviceType getDevice_type_id() {
		return device_type_id;
	}
	public void setDevice_type_id(DeviceType deviceType) {
		this.device_type_id = deviceType;
	}
	public DeviceVendor getDevice_vendor_id() {
		return device_vendor_id;
	}
	public void setDevice_vendor_id(DeviceVendor deviceVendor) {
		this.device_vendor_id = deviceVendor;
	}
	public List<DataModel> getDataModels() {
		return dataModels;
	}
	public void setDataModels(List<DataModel> dataModels) {
		this.dataModels = dataModels;
	}
	

}
