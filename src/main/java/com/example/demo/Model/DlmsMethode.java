package com.example.demo.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.annotation.Reference;

import com.example.demo.Service.AdapterType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.gson.annotations.JsonAdapter;

@Entity
@Table(name="metering_method")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("dlmsMethod")
@Embeddable
public class DlmsMethode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="allow_multiple_references")
	private boolean allowMultipleReferences; 
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "Methode_type")
	@JsonAdapter(AdapterType.class)
	private List<DlmsType> dlmsType;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="methodAssociations")
	private AssociationMeth methodAssociations;
	public DlmsMethode() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DlmsMethode( String name, String desc,Boolean reference) {
		super();
		this.name = name;
		this.description=desc;
		this.allowMultipleReferences=reference;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
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
	public boolean isMultiple_references() {
		return allowMultipleReferences;
	}
	public void setMultiple_references(boolean multiple_references) {
		this.allowMultipleReferences = multiple_references;
	}

	
	public boolean isAllowMultipleReferences() {
		return allowMultipleReferences;
	}
	public void setAllowMultipleReferences(boolean allowMultipleReferences) {
		this.allowMultipleReferences = allowMultipleReferences;
	}
	public List<DlmsType> getDlmsType() {
		return dlmsType;
	}
	public void setDlmsType(List<DlmsType> dlmsType) {
		this.dlmsType = dlmsType;
	}
	public AssociationMeth getMethodAssociations() {
		return methodAssociations;
	}
	public void setMethodAssociations(AssociationMeth methodAssociations) {
		this.methodAssociations = methodAssociations;
	}
	
	
}
