package com.example.demo.ServiceInter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.example.demo.Model.DlmsType;

public interface TypeService {
	public void createType(DlmsType type);
	public Optional<DlmsType>	SearchTypeById(DlmsType type);
	public Iterable<DlmsType> SearchTypes();
	public DlmsType deleteType(DlmsType type);
	public DlmsType deleteTypeById(int i);
	public DlmsType UpdateType(DlmsType type);
	//public List<DlmsType> CreerDlmsType() throws ParserConfigurationException, SAXException, IOException;
	public List<DlmsType> save(List<DlmsType>type);
}
