package com.sp.app.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

@Service("service.provider")
public class ProviderMap implements Provider {
	
	public Map<String, Object> getProviderMap() throws Exception {
		Map<String, Object> providerMap = new HashMap<String, Object>();
		
		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArray = new JSONArray();
		URLConnection conn = null;
		
		String prividerUrl = "https://oembed.com/providers.json";
		// 인터넷에서 provider를 jsonArray로 받기
		conn = (URLConnection) new URL(prividerUrl).openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		
		String s;
		while( (s = br.readLine()) != null) {
			sb.append(s);
		}
		
		jsonArray = (JSONArray) jsonParser.parse(sb.toString());
		
		for(int i = 0; i < jsonArray.size(); i++) {
			JSONObject provider_name = (JSONObject) jsonArray.get(i);
			String name = (String) provider_name.get("provider_name").toString();
			
			JSONObject provider_url = (JSONObject) jsonArray.get(i);
			String url = (String) provider_url.get("endpoints").toString();
			
			Object obj = jsonParser.parse(url);
			JSONArray item = (JSONArray) obj;
			JSONObject urlData = (JSONObject) item.get(0);
			
			String urlValue = (String)urlData.get("url");
			if(urlValue.contains("format")) {
				urlValue = urlValue.replace("{format}", "json");
			}
			
			providerMap.put(name.toLowerCase(), urlValue);
			
		}
		
		return providerMap;
	}
	
}
