package com.example.demo.controller;

import com.example.demo.Model.Cosem;
import com.example.demo.Model.DataModel;
import com.example.demo.Model.DeviceType;
import com.example.demo.Model.DeviceVendor;
import com.example.demo.Model.DlmsAttribut;
import com.example.demo.Model.DlmsMethode;
import com.example.demo.Model.DlmsType;
import com.example.demo.Model.RestrectionType;
import com.example.demo.Service.LireXml;
import com.example.demo.Service.XmlService;
import com.example.demo.ServiceInter.AttributService;
import com.example.demo.ServiceInter.CosemService;
import com.example.demo.ServiceInter.DataModelService;
import com.example.demo.ServiceInter.DeviceTypeService;
import com.example.demo.ServiceInter.DeviceVendorService;
import com.example.demo.ServiceInter.MethodeService;
import com.example.demo.ServiceInter.RestrectionService;
import com.example.demo.ServiceInter.TypeService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

import org.xml.sax.SAXException;

import java.util.List;
import java.util.Optional;



import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.converter.json.MappingJacksonValue;

import org.springframework.web.bind.annotation.*;




@RestController

public class DataModelController {
	 @Autowired
	private DataModelService datamodelservice;
	  @Autowired
	private LireXml xmlReader;
	
	  @Autowired
	private RestrectionService restrectionService;
	  @Autowired 
	private DeviceTypeService deviceTypeService;
	  @Autowired 
	private DeviceVendorService deviceVendorService;
	public DataModelController(DataModelService datamodelservice,LireXml xmlReader,RestrectionService restrectionService,DeviceTypeService deviceTypeService,DeviceVendorService deviceVendorService) {
		super();
		this.datamodelservice = datamodelservice;
		this.restrectionService=restrectionService;
		this.xmlReader=xmlReader;
		this.deviceTypeService=deviceTypeService;
		this.deviceVendorService=deviceVendorService;
	}
	
	@GetMapping(value="/search")
	public MappingJacksonValue searchAll()
	{
		Iterable<DataModel> d=datamodelservice.findAll();
		MappingJacksonValue data =new MappingJacksonValue(d);
		return data;
	}
	@GetMapping(value="/search/{n}")
	public Optional<DataModel>  searchDatByName(@PathVariable int n)
	{
		return datamodelservice.findById(n);
	}
	@GetMapping(value="/search/version/{v}")
	public DataModel searchDatByVersion(@PathVariable String v)
	{
		return datamodelservice.findByVersion(v);
	}
	@DeleteMapping(value="/delete/{n}")
	public Optional<DataModel> deletDatById(@PathVariable String n)
	{
			return datamodelservice.deleteById(n);
	}
	@DeleteMapping(value="/delete")
	public void deletAllData()
	{
			 datamodelservice.deletAll();
	}

   
	@PostMapping("/Importer")
	public Object Importer() throws IOException, ParseException, org.json.simple.parser.ParseException
	{
			return xmlReader.inseret();
	}
	@GetMapping("/Exporter")
	public Object Exporter()
	{
		return datamodelservice.findAll();
	}
	@PostMapping("/Editer/restrection")
	public void Editer(@RequestBody int i,@RequestBody String s,@RequestBody RestrectionType type)
	{
		datamodelservice.editerDataModel(i,s,type);
	}
		
}	
	
	
	

