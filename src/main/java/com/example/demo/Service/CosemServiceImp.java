package com.example.demo.Service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.w3c.dom.Element;

import org.xml.sax.SAXException;

import com.example.demo.Model.Cosem;
import com.example.demo.Model.DataModel;
import com.example.demo.Model.DlmsAttribut;
import com.example.demo.Model.DlmsMethode;
import com.example.demo.ServiceInter.AttributService;
import com.example.demo.ServiceInter.CosemService;
import com.example.demo.ServiceInter.DataModelService;
import com.example.demo.ServiceInter.MethodeService;
import com.example.demo.dao.CosemRepository;

@Service

public class CosemServiceImp implements CosemService {

	@Autowired 
	private CosemRepository CosemRepo;
	@Autowired
	private AttributService attributService;
	@Autowired
	private MethodeService	methodeService;
	
	public CosemServiceImp(CosemRepository cosemRepo, AttributService attributService, MethodeService methodeService) {
		super();
		this.CosemRepo = cosemRepo;
		this.attributService = attributService;
		this.methodeService = methodeService;
	}
	
	public CosemServiceImp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CosemRepository getCosemRepo() {
		return CosemRepo;
	}

	public void setCosemRepo(CosemRepository cosemRepo) {
		CosemRepo = cosemRepo;
	}

	public AttributService getAttributService() {
		return attributService;
	}

	public void setAttributService(AttributService attributService) {
		this.attributService = attributService;
	}

	public MethodeService getMethodeService() {
		return methodeService;
	}

	public void setMethodeService(MethodeService methodeService) {
		this.methodeService = methodeService;
	}
	
	
/*	public Cosem FindCosem(Cosem cos)
	{
		return CosemRepo.getById(cos.getId());
	}*/
	public Cosem UpdateCosem(Cosem cos)
	{
		return CosemRepo.save(cos);
	}
	public Cosem DeleteCosem(Cosem cos)
	{
		 CosemRepo.delete(cos);
		 return cos;
	}
	@Override
	public Iterable<Cosem> list() {
		return CosemRepo.findAll();
	}
	@Override
	public Cosem save(Cosem c) {
		return CosemRepo.save(c);
	}
	@Override
	public void save(Iterable<Cosem>CosemList) {
		CosemRepo.saveAll(CosemList);
	}

	


}
