package com.example.demo.ServiceInter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.example.demo.Model.Cosem;
import com.example.demo.Model.DataModel;
import com.example.demo.Model.DlmsAttribut;
import com.example.demo.Model.RestrectionType;



public interface DataModelService {
	
//	public DataModel CreerDataModel() throws ParserConfigurationException, SAXException, IOException;

	public List<DataModel> findAll();

	public Optional<DataModel> findById(int n);

	public DataModel findByVersion(String v);

	public Optional<DataModel> deleteById(String n);

	public DataModel findByDateCreation(LocalDate d);

	public void saveData(DataModel d);
/*	public boolean CreeDataModelComplet() throws ParserConfigurationException, SAXException, IOException;*/

	public Iterable<DataModel> save(List<DataModel> users);

	public Iterable<DataModel> list();

	public void deletAll();
	public void editerDataModel(int id,String s,RestrectionType type);



	

}
