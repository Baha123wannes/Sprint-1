package com.example.demo.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Model.Association_Methode;
import com.example.demo.Model.DlmsMethode;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

public class AdapterAssociationMeth implements  JsonDeserializer<List<Association_Methode>> {
					public List<Association_Methode> deserialize(JsonElement json, Type typeOfT,
				            JsonDeserializationContext jsc) {
				List<Association_Methode> result;
				
				if (json.isJsonArray()) {
				result = jsc.deserialize(json, typeOfT);
				}else {
				result  =  new ArrayList<>();
				result.add((Association_Methode) jsc.deserialize(json, Association_Methode.class));
				}
				return result;
				}
	
}
