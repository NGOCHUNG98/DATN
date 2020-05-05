package com.laptrinhjavaweb.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

@Component
public class GetCityUtils {
	
	@SuppressWarnings("unchecked")
	public List<String> cityJson(List<String> listTitle) {
		String path="D:\\Project\\DATN\\project-tttn-spring-mvc\\src\\main\\webapp\\resources\\json\\city.json";
		try {
			File file = new File(path);
			JSONParser parser = new JSONParser();
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			Object object = parser.parse(in);
			JSONObject LtsItem = (JSONObject) object;
			JSONArray jsonArray = (JSONArray) LtsItem.get("LtsItem");
			Iterator<JSONObject> iterator = jsonArray.iterator();
			listTitle=new ArrayList<String>();
			while (iterator.hasNext()) {
				String title=(String) iterator.next().get("Title");
				listTitle.add(title);
			}
			return listTitle;
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

}
