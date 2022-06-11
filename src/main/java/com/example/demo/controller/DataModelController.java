package com.example.demo.controller;


import com.example.demo.Model.DataModel;

import com.example.demo.Model.RestrectionType;
import com.example.demo.Service.XmlService;
import com.example.demo.ServiceInter.DataModelService;
import com.example.demo.ServiceInter.DeviceTypeService;
import com.example.demo.ServiceInter.DeviceVendorService;

import com.example.demo.ServiceInter.RestrectionService;

import net.minidev.json.parser.ParseException;


import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.converter.json.MappingJacksonValue;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;




@RestController

public class DataModelController {
	 @Autowired
	private DataModelService datamodelservice;
	  @Autowired

		private XmlService xmlService;
		
	  @Autowired
	private RestrectionService restrectionService;
	  @Autowired 
	private DeviceTypeService deviceTypeService;
	  @Autowired 
	private DeviceVendorService deviceVendorService;
	public DataModelController(DataModelService datamodelservice,RestrectionService restrectionService,DeviceTypeService deviceTypeService,DeviceVendorService deviceVendorService) {
		super();
		this.datamodelservice = datamodelservice;
		this.restrectionService=restrectionService;
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
	@GetMapping(value="/find")
	public List<DataModel> GetAllData()
	{
		return datamodelservice.findAll();
	}
	
	@DeleteMapping(value="/delete/{n}")
	public Optional<DataModel> deletDatById(@PathVariable int n)
	{
			return datamodelservice.deleteById(n);
	}
	@DeleteMapping(value="/delete")
	public void deletAllData()
	{
			 datamodelservice.deletAll();
	}
	/*
	@DeleteMapping(value="/deleeter/{data}")
	public Object deleteByname(@PathVariable String data)
	{
		return datamodelservice.delete(data);
	}
   */
	@PostMapping("/Importer")
	public Object Importer() throws IOException, ParseException, org.json.simple.parser.ParseException
	{
			return datamodelservice.inseret();
	}
	@PostMapping("/Insere")
	public void Add(@RequestParam("file") MultipartFile file) throws IOException
	{
		xmlService.addData(file, null);
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
	//Search APIs 
	@GetMapping(value="/search/{n}")
	public DataModel  searchDatByName(@PathVariable int n)
	{
		return datamodelservice.findById(n);
	}
	@GetMapping(value="/search/version/{v}")
	public List<DataModel> searchDatByVersion(@PathVariable int v)
	{
		return datamodelservice.findByVersion(v);
	}
	@GetMapping(value="/search/CreationDate/{d}")
	public DataModel searchDataByCreationDate(@PathVariable LocalDate d)
	{
		return datamodelservice.findByDateCreation(d);
	}
	@GetMapping(value="/search/UploadDate/{d}")
	public DataModel searchDataByUploadDate(@PathVariable LocalDate d)
	{
		return datamodelservice.findByDateUpload(d);
	}
	@GetMapping(value="/search/user_name/{d}")
	public DataModel searchDataByUserName(@PathVariable String d)
	{
		return datamodelservice.findByUser_name(d);
	}
	@GetMapping(value="/export/{data}")
	public void export(@PathVariable String data)
	{
		DataModel dataModel = datamodelservice.findByName(data);
		datamodelservice.ExportDataModel(dataModel);
	}
		
}	
	
	
	

