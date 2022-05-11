package com.example.demo.Model;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name="metering_method_association")

public class Association_Methode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Association_Methode;
	
	@Column(name="Id")
	private int id;
	@Column(name="action_right")
	private boolean action_right;
	@Column(name="broadcast")
	private boolean broadCast;
	@Column(name="multicast")
	private boolean multiCast;
	@Column(name="unicast")
	private boolean uniCast;
	public Association_Methode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Association_Methode(Integer id_Association_Methode, int id, boolean action_right, boolean broadCast,
			boolean multiCast, boolean uniCast) {
		super();
		this.id_Association_Methode = id_Association_Methode;
		this.id = id;
		this.action_right = action_right;
		this.broadCast = broadCast;
		this.multiCast = multiCast;
		this.uniCast = uniCast;
	}
	public Integer getId_Association_Methode() {
		return id_Association_Methode;
	}
	public void setId_Association_Methode(Integer id_Association_Methode) {
		this.id_Association_Methode = id_Association_Methode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isAction_right() {
		return action_right;
	}
	public void setAction_right(boolean action_right) {
		this.action_right = action_right;
	}
	public boolean isBroadCast() {
		return broadCast;
	}
	public void setBroadCast(boolean broadCast) {
		this.broadCast = broadCast;
	}
	public boolean isMultiCast() {
		return multiCast;
	}
	public void setMultiCast(boolean multiCast) {
		this.multiCast = multiCast;
	}
	public boolean isUniCast() {
		return uniCast;
	}
	public void setUniCast(boolean uniCast) {
		this.uniCast = uniCast;
	}
	
	
	
	

	

}
