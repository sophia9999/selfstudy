package com.example.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.ApiOperation;

@RestController("/api")
public class ApiController {

	@ApiOperation(value = "동작테스트", notes = "Swagger 잘 작동되는지 확인용")
    @GetMapping("getApi")
    public ResponseEntity<Map<String, Object>> getApi(@RequestParam(value="param1")String param1){
        Map<String, Object> map = new HashMap<>();
        map.put("param1",param1);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    
	@ApiOperation(value = "카카오 우편번호 API 테스트", notes = "우편번호 및 주소입력")
    @GetMapping("address")
    public ModelAndView kakaoExample() {
    	
    	ModelAndView mav = new ModelAndView("address");
    	
    	return mav;
    }
    
	@ApiOperation(value = "서버에서 다시 뿌려주기", notes = "우편번호 및 상세 주소 받아서 서버에 왔다가 다시 뿌려주기(확인용)")
    @PostMapping("address")
    public ModelAndView showAddress(
    		@RequestParam String postcode,
    		@RequestParam String roadAddress,
    		@RequestParam String jibunAddress,
    		String detailAddress, String extraAddress
    		) {
    	List<String> data = new ArrayList<String>();
    	
    	data.add(postcode);
    	data.add(roadAddress);
    	data.add(jibunAddress);
    	data.add(detailAddress);
    	data.add(extraAddress);
    	
    	ModelAndView mav = new ModelAndView("result");
    	mav.addObject("data", data);
    	
    	return mav;
    }
}