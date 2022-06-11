package com.example.demo.Model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.hibernate.engine.profile.Fetch;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="metering_data_model")
public class DataModel implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="version")
	private int version;
	@Column(name="creation_date")
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date dateCreation;
	
	@Column(name="upload_date")
	private Date update_date;
	@Column(name="user_name")
	private String userName;
	@Column(name="device_type")
	private String device_type;
	@Column(name="hardware_version")
	private String hardware_version;
	@Column(name="software_version")
	private String software_version;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="data_id") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<Cosem> cosemObject;
	@Embedded
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Restrection> restrection;
	public DataModel(String name, int version,Date date) {
		super();
		this.name= name;
		this.version = version;
		this.dateCreation = date;
;
	}
	
	public DataModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DataModel {"+ 
					"name=" + name + 
					", version='" + version + '\''+
					", dateCreation=" + dateCreation + "}";
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getData_name() {
		return name;
	}
	public void setData_name(String data_name) {
		this.name = data_name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public String getuserName() {
		return userName;
	}
	public void setuserName(String user_name) {
		this.userName = user_name;
	}
	public String getDevice_type() {
		return device_type;
	}
	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	public String getHardware_version() {
		return hardware_version;
	}
	public void setHardware_version(String hardware_version) {
		this.hardware_version = hardware_version;
	}
	public String getSoftware_version() {
		return software_version;
	}
	public void setSoftware_version(String software_version) {
		this.software_version = software_version;
	}
	
	public List<Cosem> getObjetCosem() {
		return cosemObject;
	}
	public void setObjetCosem(List<Cosem> objetCosem) {
		this.cosemObject = objetCosem;
	}

	public List<Cosem> getCosemObject() {
		return cosemObject;
	}

	public void setCosemObject(List<Cosem> cosemObject) {
		this.cosemObject = cosemObject;
	}

	public List<Restrection> getRestrection() {
		return restrection;
	}

	public void setRestrection(List<Restrection> restrection) {
		this.restrection = restrection;
	}
	
	
}