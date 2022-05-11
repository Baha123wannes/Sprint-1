package com.example.demo.Service;


import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;


import com.example.demo.Model.DataModel;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;


import com.example.demo.ServiceInter.AttributService;
import com.example.demo.ServiceInter.CosemService;
import com.example.demo.ServiceInter.DataModelService;
import com.example.demo.ServiceInter.MethodeService;
import com.example.demo.ServiceInter.TypeService;

import com.example.demo.dao.AttributeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;


@Service
@JsonIgnoreProperties(ignoreUnknown = true)
public class LireXml {
	
	@Autowired 
	private DataModelService dataService;
	
	public LireXml() {
		super();
	
	}

	public LireXml(DataModelService dataService) {
		super();
		dataService=dataService;
		
	}

	
	public DataModel insererData(String myJSON) throws IOException  {
		
	   Gson gson = new Gson();
	   DataModel data= gson.fromJson(myJSON, DataModel.class);
	   dataService.saveData(data);
	   return   data;   
	}
	
	public XmlMapper lireData() throws IOException
	{
		DataModel data;
		ResourceLoader resourceLoader;

		data= dataService.findAll().get(0);
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
	public DataModel inseret() throws IOException
	{
		File f= new File("src/main/resources/DataModels");
		File[] flist=f.listFiles();
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
}
