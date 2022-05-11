package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Model.Association_attribute;
import com.fasterxml.jackson.core.JsonParseException;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
public class AdapterAssociation implements  JsonDeserializer<List<Association_attribute>> {
	public List<Association_attribute> deserialize(JsonElement json, Type typeOfT,
                                    JsonDeserializationContext jsc) {
        List<Association_attribute> result;

        if (json.isJsonArray()) {
            result = jsc.deserialize(json, typeOfT);
        }else {
            result  =  new ArrayList<>();
            result.add((Association_attribute) jsc.deserialize(json, Association_attribute.class));
        }
        return result;
    }
	
}
