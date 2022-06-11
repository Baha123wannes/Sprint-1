package com.example.demo.ServiceInter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.example.demo.Model.Cosem;
import com.example.demo.Model.DataModel;


public interface CosemService {

	Optional<Cosem> findCosem(Cosem cos);
	void save(Iterable<Cosem> list);
	Iterable<Cosem> list();
	Cosem save(Cosem c);
    List<Cosem> findBycategory(String cat);
	Cosem findByCategory(String category);
	Cosem findByName(String name);
}
