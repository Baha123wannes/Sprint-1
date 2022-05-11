package com.example.demo.Service;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.w3c.dom.Element;

import org.xml.sax.SAXException;

import com.example.demo.Model.Cosem;
import com.example.demo.Model.DataModel;
import com.example.demo.Model.DlmsAttribut;
import com.example.demo.Model.Restrection;
import com.example.demo.Model.RestrectionType;
import com.example.demo.ServiceInter.AttributService;
import com.example.demo.ServiceInter.CosemService;
import com.example.demo.ServiceInter.DataModelService;

import com.example.demo.dao.DataModelRepository;
import com.example.demo.dao.DeviceTypeRepository;
import com.example.demo.dao.DeviceVendorRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	
	public Iterable<DataModel> list()
	{
		return model.findAll();
	}
	public Iterable<DataModel> save(List<DataModel> data)
	{
		return model.saveAll(data);
	}
	public Optional<DataModel> findById(int n)
	{
		return model.findById(n);
	}
	public DataModel findByVersion(String version)
	{
		return model.findByVersion(version);
	}
	public Optional<DataModel> deleteById(String id)
	{
		Optional<DataModel> d=model.findById(id);
		model.deleteById(id);
		return d;
	}
	public DataModel findByDateCreation(LocalDate date)
	{
		return model.findByDateCreation(date);
	}
	
	public void saveData(DataModel d)
	{
		model.save(d);
	}
	

	@Override
	public List<DataModel> findAll() {
		
		return model.findAll();
	}

	@Override
	public void deletAll() {
		 model.deleteAll();
		 
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

	




}
