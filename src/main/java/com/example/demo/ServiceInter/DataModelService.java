package com.example.demo.ServiceInter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.http.ResponseEntity;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.example.demo.Model.Cosem;
import com.example.demo.Model.DataModel;
import com.example.demo.Model.DlmsAttribut;
import com.example.demo.Model.RestrectionType;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;



public interface DataModelService {
	
//	public DataModel CreerDataModel() throws ParserConfigurationException, SAXException, IOException;

	public List<DataModel> findAll();

	public DataModel findById(int n);

	public List<DataModel> findByVersion(int v);
	public DataModel findByName(String v);
	public Optional<DataModel> deleteById(int n);

	public DataModel findByDateCreation(LocalDate d);

	public void saveData(DataModel d);
/*	public boolean CreeDataModelComplet() throws ParserConfigurationException, SAXException, IOException;*/

	public Iterable<DataModel> save(List<DataModel> users);


	public void deletAll();
	public void editerDataModel(int id,String s,RestrectionType type);

	public DataModel findByDateUpload(LocalDate d);

	public DataModel findByUser_name(String d);
	public DataModel insererData(String myJSON) throws IOException;
//	public XmlMapper lireData() throws IOException;
	public DataModel inseret() throws IOException;
	public void ExportDataModel(DataModel data);
//	public ResponseEntity<?> delete(String dataModel);



	

}
