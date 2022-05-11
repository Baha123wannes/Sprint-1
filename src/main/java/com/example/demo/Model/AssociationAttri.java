
package com.example.demo.Model;

import java.util.List;

import javax.persistence.*;

import com.example.demo.Service.AdapterAssociation;
import com.example.demo.Service.AdapterMethode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.JsonAdapter;

@Entity

@JsonIgnoreProperties
@Embeddable
public class AssociationAttri  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="allowMultipleReferences")
	private boolean allowMultipleReferences;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JsonAdapter(AdapterAssociation.class)
	private List<Association_attribute> association;

	public AssociationAttri() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AssociationAttri(List<Association_attribute> association) {
		super();
		this.association = association;
	}

	public List<Association_attribute> getAssociation() {
		return association;
	}

	public void setAssociation(List<Association_attribute> association) {
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