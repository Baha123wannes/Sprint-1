package com.example.demo.ServiceInter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.example.demo.Model.DlmsAttribut;

public interface AttributService {
	public void createAttribut(DlmsAttribut att);
	public Optional<DlmsAttribut>	SearchAttributById(DlmsAttribut att);
	public Iterable<DlmsAttribut> SearchAttributs();
	public DlmsAttribut deleteAttribut(DlmsAttribut att);
	public DlmsAttribut deleteAttributById(int i);
	public DlmsAttribut UpdateAttribut(DlmsAttribut att);
	public DlmsAttribut FindAttribut(DlmsAttribut att);
	/*public List<DlmsAttribut> CreerDlmsAttribute() throws ParserConfigurationException, SAXException, IOException;
	public List<DlmsAttribut> CreerAttributeComplet() throws ParserConfigurationException, SAXException, IOException;*/
	public void save(List<DlmsAttribut> attribut);



}
