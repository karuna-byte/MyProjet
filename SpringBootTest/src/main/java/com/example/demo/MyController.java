package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController 
{
	@GetMapping("/MyPathVariable/{name}")
	private String getPathVariable(@PathVariable String name)
	{
		return name;
	}
	@GetMapping("/MyRequestParam")
	public String getRequestParam(@RequestParam String firstName, @RequestParam String lastName)
	{
		return firstName+lastName;
	}
	@PostMapping(path = "/MyRequestBody",consumes="application/json", produces="application/xml")
	public Student getRequestBody(@RequestBody Student stud)
	{
		return stud;
	}
	@PostMapping("/MyRequestHeader")
	public String getMyRequestHeader(@RequestHeader("accept-language") String language,
			@RequestHeader("Content-Type") String contentType)
	{
		return language +"		"+contentType;
	}
	@GetMapping("/MyResponseEntity")
	public ResponseEntity<String> getResponseEntity(@RequestParam String name)
	{
		if(name.equals(""))//if name is empty
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(name, HttpStatus.OK);
	}
}
