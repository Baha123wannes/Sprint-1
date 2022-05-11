package com.example.demo.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


import com.example.demo.Model.DlmsMethode;
import com.example.demo.ServiceInter.MethodeService;
import com.example.demo.ServiceInter.TypeService;
import com.example.demo.dao.MethodeRepository;

@Service
public class MethodeServiceImpl implements MethodeService {
	@Autowired 
	private MethodeRepository methRepo;
	public MethodeServiceImpl(MethodeRepository repo) {
		super();
		methRepo = repo;
	}
	public void save(DlmsMethode meth)
	{
		methRepo.save(meth);
	}
	public void save(List<DlmsMethode>meth)
	{
		methRepo.saveAll(meth);
	}
	public Optional<DlmsMethode>	SearchMethodeById(DlmsMethode meth)
	{
		return methRepo.findById(meth.getId());
	}
	public Iterable<DlmsMethode> SearchMethodes()
	{
		return methRepo.findAll();
	}
	public DlmsMethode deleteMethode(DlmsMethode meth)
	{
		methRepo.delete(meth);
		return meth;
	}
	public DlmsMethode deleteMethodeById(int i)
	{
		DlmsMethode dl=methRepo.getById(i);
		methRepo.deleteById(i);
		return dl;
	}
	public DlmsMethode UpdateMethode(DlmsMethode meth)
	{
		methRepo.save(meth);
		return methRepo.getById(meth.getId());
	}
	
	
}
