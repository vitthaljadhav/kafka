package com.deliveryboy.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryboy.service.KafkaService;

@RestController
@RequestMapping("/location")
public class LocationController {
	
	
	
	@Autowired
	KafkaService kafkaService;
	
	@PostMapping("/update")
	public ResponseEntity<?> updateLocation() {
		
		HashMap<String,String> mapObj =new HashMap<String,String>();
		
		for(int i=0;i<=1000;i++) {
			
			this.kafkaService.updateLocation("("+Math.round(Math.random()*100)+")" +","+"("+Math.round(Math.random()*100)+")");
		}
		
		return new ResponseEntity<>(mapObj.put("message","Location update"),HttpStatus.OK);
		
	}
	

}
