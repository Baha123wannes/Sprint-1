package com.example.demo.Service;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.w3c.dom.Element;

import org.xml.sax.SAXException;

import com.example.demo.Model.Cosem;
import com.example.demo.Model.DataModel;
import com.example.demo.Model.DlmsAttribut;
import com.example.demo.Model.Restrection;
import com.example.demo.Model.RestrectionType;
import com.example.demo.Model.XmlModelData;
import com.example.demo.ServiceInter.AttributService;
import com.example.demo.ServiceInter.CosemService;
import com.example.demo.ServiceInter.DataModelService;

import com.example.demo.dao.DataModelRepository;
import com.example.demo.dao.DeviceTypeRepository;
import com.example.demo.dao.DeviceVendorRepository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.google.gson.Gson;
import com.fasterxml.jackson.core.type.TypeReference;


@Service

public class DataModelServiceImp extends XmlService implements DataModelService {
	@Autowired
	private DataModelRepository model;
	@Autowired
	private DeviceTypeRepository DeviceTypeRepo;
	@Autowired
	private DeviceVendorRepository DeviceVendorRepo;
	public DataModelServiceImp(DataModelRepository model,DeviceTypeRepository DeviceTypeRepo,DeviceVendorRepository DeviceVendorRepo) {
		super();
		this.model = model;
		this.DeviceTypeRepo=DeviceTypeRepo;
		this.DeviceVendorRepo=DeviceVendorRepo;
	}
	
	
	public Iterable<DataModel> save(List<DataModel> data)
	{
		return model.saveAll(data);
	}
	public DataModel findById(int n)
	{
		return model.findById(n).get();
	}
	


	public void saveData(DataModel d)
	{
		model.save(d);
	}
	

	
		
	public void editerDataModel(int id,String s,RestrectionType typeRestrection) {
		DataModel data=model.findById(id).get();
		List<Restrection>restrection=data.getRestrection();
		for(Restrection r:restrection)
		{
			if(typeRestrection==RestrectionType.VENDOR)
			{
				r.setDevice_vendor_id(DeviceVendorRepo.findById(r.getDevice_vendor_id().getId()).get());
				r.setRestrictionType(RestrectionType.VENDOR);
				
			}
			if(typeRestrection==RestrectionType.TYPE)
			{
				r.setDevice_type_id(DeviceTypeRepo.findById(r.getDevice_type_id().getId()).get());
				r.setRestrictionType(RestrectionType.TYPE);
			}
			else
			{
				r.setRestrictionType(RestrectionType.FIRMWARE);
				r.setFirmwareVersion(s);
			}
		}
	}
	//Search all , by name, version, datecreation, uploadDate, username 
	//---------------------------------------------------------------
	public DataModel findByName(String Name)
	{
		return model.findByName(Name);

	}
	public List<DataModel> findByVersion(int version)
	{
		return model.findByVersion(version);
	}
	public DataModel findByDateCreation(LocalDate date)
	{
		return model.findByDateCreation(date);
	}
	public DataModel findByDateUpload(LocalDate d) {
		return model.findByDateCreation(d);
	}
	public DataModel findByUser_name(String d)
	{
		return model.findByUserName(d);

	}

	@Override
	public List<DataModel> findAll() {
		
		return model.findAll();
	}
//-------------------------------------------------
//Supprimer DataModel
	public Optional<DataModel> deleteById(int id)
	{
		Optional<DataModel> d=model.findById(id);
		model.deleteById(id);
		return d;
	}
	@Override
	public void deletAll() {
		 model.deleteAll();
		 
	}
	/*public ResponseEntity<?> delete(String dataModel)
	{
		Optional<DataModel>data=model.deleteByName(dataModel);
		if(data.isEmpty())
		{
			return new ResponseEntity<String>("Movie Deleted", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(dataModel, HttpStatus.OK);
		 
	}*/
	//--------------------------------------------------------------------------
//Importer DataModel

		public DataModel insererData(String myJSON) throws IOException 	//Mapper Un seul xml du dataModel  
		{	
		   Gson gson = new Gson();
		   DataModel data= gson.fromJson(myJSON, DataModel.class);
		   this.saveData(data);
		   return   data;   
		}
		//Lire notre data on json
		public XmlMapper lireData() throws IOException
		{
			DataModel data;

			data= this.findAll().get(0);
			Gson gson =new Gson();
			 String jsonStr=gson.toJson(data.toString());
			 ObjectMapper jsonMapper = new ObjectMapper();
		        JsonNode node = jsonMapper.readValue(jsonStr, JsonNode.class);
		        XmlMapper xmlMapper = new XmlMapper();
		        xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
		        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_1_1, true);
		        StringWriter sw = new StringWriter();
		        xmlMapper.writeValue(sw, node);
		       return xmlMapper;
		}
		//inser dans la base
		public DataModel inseret() throws IOException
		{
			
			File f= new File("src/main/resources/DataModels");
			File[] flist =f.listFiles();
			String json = null;
			int i=0;
			DataModel data =new DataModel();
			for(File f1:flist)
			{
				i++;
				if(i==19) continue;
				String xml = new String(Files.readAllBytes(Paths.get("src/main/resources/DataModels/DataModelESB_part"+i+".xml")));
				XmlMapper xmlMapper = new XmlMapper();
				ObjectMapper jsonMapper = new ObjectMapper();
				JsonNode node = xmlMapper.readTree(xml.getBytes());
				 json = jsonMapper.writeValueAsString(node);
				 data= this.insererData(json);
			}
			 
		return data;
		}
		//--------------------------------------------------------------------------
		//Exporter Data
		public void parseObjectToXml(String filePath, XmlModelData xmlModel) {
			try {
				JAXBContext contextObj = JAXBContext.newInstance(XmlModelData.class);

				Marshaller marshallerObj = contextObj.createMarshaller();
				marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

				marshallerObj.marshal(xmlModel, new FileOutputStream(filePath));
			} catch (JAXBException je) {
				System.out.println("JAXBException");
			} catch (IOException ie) {
				System.out.println("IOException");
			}
		}
		public void ExportDataModel(DataModel data)
		{
			XmlModelData xmlModel =new XmlModelData();
			xmlModel.setData(data);
			this.parseObjectToXml("src/main/resources/xmlExported.xml", xmlModel);
		}
}
