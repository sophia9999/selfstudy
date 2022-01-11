package com.sp.app.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sp.app.service.Provider;

@Controller
@RequestMapping("/oembed2/*")
public class OembedController2 {
	
	@Autowired
	private Provider provider;

	@RequestMapping("/")
	public ModelAndView oembedForm(Model model) throws Exception {
		ModelAndView view = new ModelAndView("oembed2");
		
		return view;
	}
	
	@RequestMapping("/resource")
	@ResponseBody
	public Map<String, Object> getUrlInfo(
			@RequestParam String user_url
			) throws Exception {
		Map<String, Object> providerMap = provider.getProviderMap();
		
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
			} else if( comUrl.contains("youtu") ) {
				host = "youtube";
			}
		}
		
		// oembed로 보내기 위한 url을 providerList 에서 가져오기
		String paramUrl = (String)providerMap.get(host);
		
		model.put("host", host);
		model.put("paramUrl", paramUrl);
		paramUrl += "?format=json&url="+user_url; // json으로 받아서 뿌려줄예정
		if(host.contains("instagram")) { // 인스타그램의 경우 facebook 에서 oembed read 기능에 대한 앱 검수를 통해 액세스 토큰을 발급받아야한다.
			paramUrl = (String)providerMap.get(host)+"?url="+user_url+"&access_token=[앱ID]|[앱 클라이언트 토큰]";
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
		
		model.put("providerMap", providerMap);
		model.put("result", result);
		return model;
	}
}
