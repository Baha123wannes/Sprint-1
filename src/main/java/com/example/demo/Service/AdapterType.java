package com.example.demo.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Model.DlmsType;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

public class AdapterType implements  JsonDeserializer<List<DlmsType>> {
				public List<DlmsType> deserialize(JsonElement json, Type typeOfT,
			            JsonDeserializationContext jsc) {
			List<DlmsType> result;
			
			if (json.isJsonArray()) {
			result = jsc.deserialize(json, typeOfT);
			}else {
			result  =  new ArrayList<>();
			result.add((DlmsType) jsc.deserialize(json, DlmsType.class));
			}
			return result;
			}
}
