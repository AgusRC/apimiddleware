package com.gruposti.apimiddleware.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.gruposti.apimiddleware.service.CharacterService;
import com.gruposti.apimiddleware.model.DataGenericResponse;
import com.gruposti.apimiddleware.model.PokeApiResponse;
import com.gruposti.apimiddleware.model.CharacterDetailInfo;

@RestController
public class STIController {
	
	@Autowired
	private CharacterService characterService;
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@GetMapping("/characters")
	public DataGenericResponse<PokeApiResponse> getCharacters() {
		return characterService.getPokemonCharacter();
	}
	
	@GetMapping("/characters/{pokemonId}")
	public DataGenericResponse<CharacterDetailInfo> getCharacterById(@PathVariable("pokemonId") String pokemonId) {
		return characterService.getPokemonCharacterById(pokemonId);
	}
}
