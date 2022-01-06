package com.sp.app.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/oembed/*")
public class OembedController {

	private Map<String, Object> providerMap = new HashMap<String, Object>();

	@RequestMapping("/")
	public ModelAndView oembedForm(HttpSession session,
			Model model) throws Exception {
		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArray = new JSONArray();
		
		// provider의 정보를 담은 파일을 jsonArray로 받기
		String root = session.getServletContext().getRealPath("/"); 
		root = root.substring(0, root.indexOf("webapp"));
		String pathname = root + "resources" + File.separator + "provider" + File.separator + "provider.json";

		jsonArray = (JSONArray) jsonParser.parse(new FileReader(pathname));
		
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
		
		ModelAndView view = new ModelAndView("oembed");
			
		return view;
	}
	
	@RequestMapping("/resource")
	@ResponseBody
	public Map<String, Object> getUrlInfo(
			@RequestParam String user_url
			) throws Exception {
		Map<String, Object> model = new HashMap<>();
		HttpURLConnection conn = null;
		String host = "";
		String comUrl = "";

		// 뒤에 파라미터에 다른 provider의 명칭이 있을 수 있으므로 
		if(user_url.contains("?")) {
			comUrl = user_url.substring(0, user_url.indexOf("?") );			
		} else {
			comUrl = user_url;
		}
		user_url = URLEncoder.encode(user_url, "utf-8");

		Object keys[] = providerMap.keySet().toArray();
		for(int i = 0; i < keys.length; i++) {
			if( comUrl.contains((String)keys[i]) ) {
				host = (String)keys[i];
			}
		}
		// oembed로 보내기 위한 url을 providerList 에서 가져오기
		String paramUrl = (String)providerMap.get(host);
		model.put("host", host);
		model.put("paramUrl", paramUrl);
		paramUrl += "?format=json&url="+user_url; // json으로 받아서 뿌려줄예정
		if(host.contains("instagram")) {
			paramUrl = (String)providerMap.get(host)+"?url="+user_url+"&access_token=622376832303347|ce24ead8e1d39af83e9aafcb11bd5812";
		}
		conn = (HttpURLConnection) new URL(paramUrl).openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String s;
		while( (s = br.readLine()) != null) {
			sb.append(s);
		}
		
		JSONParser jsonParser = new JSONParser();
		JSONObject result = (JSONObject)jsonParser.parse(URLDecoder.decode(sb.toString(), "utf-8"));
		
		model.put("result", result);
		return model;
	}
}