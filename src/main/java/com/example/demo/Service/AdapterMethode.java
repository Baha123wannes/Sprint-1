package com.example.demo.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Model.DlmsMethode;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

public class AdapterMethode implements  JsonDeserializer<List<DlmsMethode>> {
		public List<DlmsMethode> deserialize(JsonElement json, Type typeOfT,
	                                    JsonDeserializationContext jsc) {
	        List<DlmsMethode> result;

	        if (json.isJsonArray()) {
	            result = jsc.deserialize(json, typeOfT);
	        }else {
	            result  =  new ArrayList<>();
	            result.add((DlmsMethode) jsc.deserialize(json, DlmsMethode.class));
	        }
	        return result;
	    }
		
}
