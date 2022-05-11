package com.example.demo.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.boot.jackson.JsonComponent;

import com.example.demo.Service.AdapterType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.gson.annotations.JsonAdapter;

@Entity 
@Table(name="metering_attribute")
@JsonRootName("dlmsAttribute")
@JsonIgnoreProperties
@Embeddable
public class DlmsAttribut {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int ide;
	
	@Column(name="name")
	private String name; 
	
	
	@Column(name="description")
	private String description;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Attribute_type")
	@JsonAdapter(AdapterType.class)
	private List<DlmsType> dlmsType;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="association")
	private AssociationAttri attributeAssociations;
	
	
	
	public DlmsAttribut() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DlmsAttribut(int id,String name, String description,String default_value) {
		super();
		this.ide=id;
		this.name = name;
		
		this.description = description;
	}

	
	public int getIde() {
		return ide;
	}
	public void setIde(int id) {
		this.ide = id;
	}
	
	
    public List<DlmsType> getDlmsType() {
		return dlmsType;
	}
	public void setDlmsType(List<DlmsType> dlmsType) {
		this.dlmsType = dlmsType;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public AssociationAttri getAttributeAssociations() {
		return attributeAssociations;
	}
	public void setAttributeAssociations(AssociationAttri attributes) {
		this.attributeAssociations = attributes;
	}
	
	
	@Override
	public String toString() {
		return "DlmsAttribut [id=" + ide + ", name=" + name + ", description=" + description
				+  ", dlmstype=" + dlmsType + ", attributes=" + attributeAssociations +  "]";
	}
	
}
