package com.capgemini.movieticketsystem.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.movieticketsystem.dto.TheaterBean;
import com.capgemini.movieticketsystem.dto.TheaterResponse;
import com.capgemini.movieticketsystem.service.TheaterService;
@CrossOrigin(origins ="*",allowedHeaders="*",allowCredentials ="true")
@RestController
public class TheaterController {
	@Autowired
	private TheaterService service;
	@GetMapping(path = "/search-theater/{theaterCity}",produces = MediaType.APPLICATION_JSON_VALUE)
	public TheaterResponse searchTheater(@PathVariable ("theaterCity")String theaterCity) {
		TheaterResponse response = new TheaterResponse();
		List<TheaterBean> listTheater = service.searchTheater(theaterCity);
	
	if(listTheater!=null)
		{
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Details of Theater found");
			response.setTheater(listTheater);

		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Theater doesn't exists");
		}
		return response;
	}
	
	@PutMapping(path = "/update-theater/{theaterId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public TheaterResponse updateTheater(@PathVariable("theaterId") int theaterId, @RequestBody TheaterBean theater) {
		TheaterResponse response = new TheaterResponse();
		if (service.updateTheater(theaterId, theater)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Theater details are updated");
			response.setTheater(Arrays.asList(theater));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Theater details not found");
		}
		return response;
	}
}
