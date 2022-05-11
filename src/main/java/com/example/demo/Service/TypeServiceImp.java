package com.example.demo.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


import com.example.demo.Model.DlmsType;
import com.example.demo.ServiceInter.AttributService;
import com.example.demo.ServiceInter.TypeService;
import com.example.demo.dao.TypeRepository;

@Service
public class TypeServiceImp implements TypeService {
	private TypeRepository typeRepo;
	
	public TypeServiceImp(TypeRepository typeRepo) {
		super();
		this.typeRepo = typeRepo;
	}
	public void createType(DlmsType type)
	{
		typeRepo.save(type);
	}
	public List<DlmsType> save(List<DlmsType>type)
	{
		return typeRepo.saveAll(type);
	}
	public Optional<DlmsType>	SearchTypeById(DlmsType type)
	{
		return typeRepo.findById(type.getId());
	}
	public Iterable<DlmsType> SearchTypes()
	{
		return typeRepo.findAll();
	}
	public DlmsType deleteType(DlmsType type)
	{
		typeRepo.delete(type);
		return type;
	}
	/**
	 * test
	 */
	public DlmsType deleteTypeById(int i)
	{
		DlmsType dl=typeRepo.getById(i);
		typeRepo.deleteById(i);
		return dl;
	}
	public DlmsType UpdateType(DlmsType type)
	{
		typeRepo.save(type);
		return typeRepo.getById(type.getId());
	}
	
}
