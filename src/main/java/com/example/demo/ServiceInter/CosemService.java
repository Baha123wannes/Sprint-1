package com.example.demo.ServiceInter;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.example.demo.Model.Cosem;


public interface CosemService {



	//Cosem save(CosemCommunity users);

	
	void save(Iterable<Cosem> list);

	Iterable<Cosem> list();

	Cosem save(Cosem c);


	
	

	
}
