package com.gruposti.apimiddleware.service;

import com.gruposti.apimiddleware.model.DataGenericResponse;
import com.gruposti.apimiddleware.model.PokeApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;


@Service
public class CharacterService {
	private static final String API_URL = "https://pokeapi.co/api/v2/pokemon";

    @Autowired
    private RestTemplate restTemplate;

    public DataGenericResponse getPokemonCharacter() {
    	HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<PokeApiResponse> response = restTemplate.exchange(
                API_URL,
                HttpMethod.GET,
                entity,
                PokeApiResponse.class
        );
        
        System.out.println(response.getBody());
        
        DataGenericResponse dataResponse = new DataGenericResponse();
        dataResponse.setAction("CONTINUE");
        dataResponse.setType("SUCCESS");
        dataResponse.setData(response.getBody());

        return dataResponse;
    }
}
