package com.example.demo.Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")

public class XmlModelData {

	private DataModel data;

	public XmlModelData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public XmlModelData(DataModel data) {
		super();
		this.data = data;
	}
	@XmlElement(name = "DataModel")

	public DataModel getData() {
		return data;
	}

	public void setData(DataModel data) {
		this.data = data;
	}
	
}
