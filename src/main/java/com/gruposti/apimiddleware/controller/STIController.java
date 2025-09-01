package com.gruposti.apimiddleware.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gruposti.apimiddleware.service.CharacterService;
import com.gruposti.apimiddleware.model.DataGenericResponse;

@RestController
public class STIController {
	
	@Autowired
	private CharacterService characterService;
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@GetMapping("/pokemon")
	public DataGenericResponse getCharacter() {
		return characterService.getPokemonCharacter();
	}
}
