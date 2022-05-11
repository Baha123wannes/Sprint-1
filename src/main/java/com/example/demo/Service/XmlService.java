package com.example.demo.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import net.lingala.zip4j.ZipFile;
import net.minidev.json.JSONObject;


public class XmlService {
	public void addData( MultipartFile file,String code) throws IOException
	{
		   File zip = File.createTempFile(UUID.randomUUID().toString(), "temp");
	        FileOutputStream o = new FileOutputStream(zip);
	        IOUtils.copy(file.getInputStream(), o);
	        o.close();
	        String destination = "src/main/resources/DataModels";
	        Scanner sc = new Scanner(System.in);
	        code = sc.nextLine();

	        try {
	            ZipFile zipFile = new ZipFile(zip);
	            char[] t=code.toCharArray();
	            zipFile.setPassword(t);
	            zipFile.extractAll(destination);
	        } finally {
	           
	            zip.delete();
	        }
	}

	
	public static  void CreeJson(String jsonObject )
	{
		try {

		    FileWriter file = new FileWriter("src/main/resources/Json.json");
		    file.write(jsonObject);
		    file.flush();
		    file.close();

		        } catch (IOException e) {
		          e.printStackTrace();
		        }
	}
	public String DeletFile()
	{
		File f=new File("src/main/resources/DataModels");
		if (f.delete())
			return "Supprimer";
		else 
			return "echec";
	}
}
