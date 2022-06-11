package com.example.demo.ServiceInter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.example.demo.Model.DlmsMethode;


public interface MethodeService {
	public void save(DlmsMethode meth);
	public Optional<DlmsMethode>	SearchMethodeById(DlmsMethode meth);
	public Iterable<DlmsMethode> SearchMethodes();
	public DlmsMethode deleteMethode(DlmsMethode meth);
	public DlmsMethode deleteMethodeById(int i);
	public DlmsMethode UpdateMethode(DlmsMethode meth);
	public DlmsMethode SearchByName(String name);
	public void save(List<DlmsMethode> meth);
	





}
