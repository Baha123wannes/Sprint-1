package com.example.demo.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.Service.AdapterAssociation;
import com.example.demo.Service.AdapterAssociationMeth;
import com.example.demo.Service.AdapterMethode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.gson.annotations.JsonAdapter;
@Entity
@JsonIgnoreProperties
@Table(name="Metering_methode_Associations")
@JsonRootName("methodAssociations")
public class AssociationMeth {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="allowMultipleReferences")
	private boolean allowMultipleReferences;
	@OneToMany(cascade=CascadeType.ALL)
	@JsonAdapter(AdapterAssociationMeth.class)
	private List<Association_Methode> association;

	public AssociationMeth() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AssociationMeth(List<Association_Methode> association) {
		super();
		this.association = association;
	}

	public List<Association_Methode> getAssociation() {
		return association;
	}

	public void setAssociation(List<Association_Methode> association) {
		this.association = association;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public boolean isAllowMultipleReferences() {
		return allowMultipleReferences;
	}


	public void setAllowMultipleReferences(boolean allowMultipleReferences) {
		this.allowMultipleReferences = allowMultipleReferences;
	}




}
