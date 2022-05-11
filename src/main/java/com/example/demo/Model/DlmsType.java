package com.example.demo.Model;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name="metering_dlms_type")
@JsonIgnoreProperties
@JsonRootName("dlmsType")
public class DlmsType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="type")
	private String type;
	@Column(name="editable")
	private boolean editable;
	@Column(name="defaultValue")
	private String defaultValue;
	@Column(name="dlms_type_edition")
	private String edition;
	@Column(name="is_primitive")
	private boolean is_primitive;
	
	@OneToMany(cascade= CascadeType.ALL,mappedBy="dlmsType_id")
	private List<Parameter> parameter;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="Attribute_type")
	private DlmsAttribut dlmsAttribute;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Methode_type")
	private DlmsMethode dlmsMethod;
	
	
	public DlmsType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DlmsType(String name, String type, boolean editable, String defaultValue, String edition,boolean primi) {
		super();
		
		this.name = name;
		this.type = type;
		this.editable = editable;
		this.defaultValue = defaultValue;
		this.edition = edition;
		this.is_primitive=primi;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean getEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public boolean getIs_primitive() {
		if(type == "STRUCTURE")
			is_primitive=true;
		else 
			is_primitive=false;
		return is_primitive;
	}
	public void setIs_primitive(boolean is_primitive) {
		this.is_primitive = is_primitive;
	}
	
	public List<Parameter> getParameter() {
		return parameter;
	}
	public void setParameter(List<Parameter> dlmsType_id) {
		this.parameter = dlmsType_id;
	}
	public DlmsAttribut getDlmsAttribute() {
		return dlmsAttribute;
	}
	public void setDlmsAttribute(DlmsAttribut dlmsAttribute) {
		this.dlmsAttribute = dlmsAttribute;
	}
	public DlmsMethode getDlmsMethod() {
		return dlmsMethod;
	}
	public void setDlmsMethod(DlmsMethode dlmsMethod) {
		this.dlmsMethod = dlmsMethod;
	}
	
	@Override
	public String toString() {
		return "DlmsType [id=" + id + ", name=" + name + ", type=" + type + ", editable=" + editable + ", defaultValue="
				+ defaultValue + ", edition=" + edition + ", is_primitive=" + is_primitive + ", dlmsAttribute="
				+ dlmsAttribute + ", dlmsMethod=" + dlmsMethod + "]";
	}
	
	

}
