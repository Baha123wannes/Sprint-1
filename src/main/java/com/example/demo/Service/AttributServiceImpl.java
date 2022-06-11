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

import com.example.demo.Model.DlmsAttribut;
import com.example.demo.ServiceInter.AttributService;
import com.example.demo.ServiceInter.CosemService;
import com.example.demo.ServiceInter.TypeService;
import com.example.demo.dao.AttributeRepository;


@Service
public class AttributServiceImpl implements AttributService {
	@Autowired
	private AttributeRepository attriRepo;

	public AttributServiceImpl(AttributeRepository attriRepo) {
		super();
		this.attriRepo = attriRepo;
	}
	public void createAttribut(DlmsAttribut att)
	{
		attriRepo.save(att);
	}
	public DlmsAttribut  FindAttribut(DlmsAttribut att)
	{
		return attriRepo.getById(att.getIde());
	}
	public DlmsAttribut UpdateAttribut(DlmsAttribut att)
	{
		attriRepo.save(att);
		return attriRepo.getById(att.getIde());
	}
	public DlmsAttribut deleteAttribut(DlmsAttribut att)
	{
		attriRepo.delete(att);
		return att;
	}
	public Optional<DlmsAttribut>	SearchAttributById(DlmsAttribut att)
	{
		return attriRepo.findById(att.getIde());
	}
	public Iterable<DlmsAttribut> SearchAttributs()
	{
		return attriRepo.findAll();
	}
	
	public DlmsAttribut deleteAttributById(int i)
	{
		DlmsAttribut dl=attriRepo.getById(i);
		attriRepo.deleteById(i);
		return dl;
	}
	@Override
	public void save(List<DlmsAttribut> attribut) {
		attriRepo.saveAll(attribut);
	}
	@Override
	public DlmsAttribut SearchByName(String name) {
		// TODO Auto-generated method stub
		return attriRepo.findByName(name);
	}
	
	
	
	
}
