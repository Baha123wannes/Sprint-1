package com.example.demo.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FlushModeType;
import javax.persistence.Table;

import org.hibernate.annotations.*;

import com.example.demo.Service.AdapterMethode;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.JsonAdapter;

@Entity
@Table(name="metering_cosem_object")
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class Cosem implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="class_id")
	private int classId;
	@Column(name="obis")
	private String logicalName;
	@Column(name="name")
	private String name;
	@Column(name="category")
	private String category;
	@Column(name="class_version")
	private String classVersion;
	@Column(name="description")
	private String description;

	
    
	@OneToMany(cascade = CascadeType.ALL)
	@Embedded
	@JoinColumn(name="cosemObject")
	@JsonManagedReference
	private List<DlmsAttribut> dlmsAttribute;
    
	@OneToMany(cascade = CascadeType.ALL)
	@Embedded
	@JoinColumn(name="Cosem_id")
	@JsonManagedReference
	@JsonAdapter(AdapterMethode.class)
	private List<DlmsMethode> dlmsMethod;

	public Cosem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cosem(int id, int classId, String logicalName, String name, String category, String classVersion,
			String description, DataModel data, List<DlmsAttribut> dlmsAttribute, List<DlmsMethode> dlmsMethod) {
		super();
		this.id = id;
		this.classId = classId;
		this.logicalName = logicalName;
		this.name = name;
		this.category = category;
		this.classVersion = classVersion;
		this.description = description;
		this.dlmsAttribute = dlmsAttribute;
		this.dlmsMethod = dlmsMethod;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getLogicalName() {
		return logicalName;
	}

	public void setLogicalName(String logicalName) {
		this.logicalName = logicalName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getClassVersion() {
		return classVersion;
	}

	public void setClassVersion(String classVersion) {
		this.classVersion = classVersion;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<DlmsAttribut> getDlmsAttribute() {
		return dlmsAttribute;
	}

	public void setDlmsAttribute(List<DlmsAttribut> dlmsAttribute) {
		this.dlmsAttribute = dlmsAttribute;
	}

	public List<DlmsMethode> getDlmsMethod() {
		return dlmsMethod;
	}

	public void setDlmsMethod(List<DlmsMethode> dlmsMethod) {
		this.dlmsMethod = dlmsMethod;
	}

	
	
}