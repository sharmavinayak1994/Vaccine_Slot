package com.vinayak.demo.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vinayak.demo.utility.FetchAvailability;

@RestController
public class FetchController {

	@Autowired
	public FetchAvailability fetchAvailability;
	
	@GetMapping("/fetchDetails/{id}")
	public Object fetchDetails(@PathVariable String id ) {
		
		try {
			fetchAvailability.connectToCowin();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("this is id passed in url : " + id);
		return id;
		
	}
	
}
