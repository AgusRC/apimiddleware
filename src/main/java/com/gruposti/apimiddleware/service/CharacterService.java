package com.gruposti.apimiddleware.service;

import com.gruposti.apimiddleware.model.CharacterDetailInfo;
import com.gruposti.apimiddleware.model.DataGenericResponse;
import com.gruposti.apimiddleware.model.GameIndices;
import com.gruposti.apimiddleware.model.PokeApiResponse;
import com.gruposti.apimiddleware.util.AppConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;


@Service
public class CharacterService {
	@Value("${api.url}")
	private String API_URL;

    @Autowired
    private RestTemplate restTemplate;

    public DataGenericResponse<PokeApiResponse> getPokemonCharacter() {
    	HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<PokeApiResponse> response = restTemplate.exchange(
                API_URL+"?"+AppConstants.URL_PARAM_LIMIT_25,
                HttpMethod.GET,
                entity,
                PokeApiResponse.class
        );
        
        DataGenericResponse<PokeApiResponse> dataResponse = new DataGenericResponse();
        
        if(response.getStatusCode() == HttpStatus.OK) {
        	response.getBody().setItems(response.getBody().getResults().length);
            dataResponse.setAction(AppConstants.ACTION_CONTINUE);
            dataResponse.setType(AppConstants.TYPE_SUCCESS);
            dataResponse.setData(response.getBody());
        }
        
        return dataResponse;
    }
    
    public DataGenericResponse<CharacterDetailInfo> getPokemonCharacterById(String pokemonId) {
    	HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<CharacterDetailInfo> response = restTemplate.exchange(
                API_URL+"/"+pokemonId,
                HttpMethod.GET,
                entity,
                CharacterDetailInfo.class
        );
        
        DataGenericResponse<CharacterDetailInfo> dataResponse = new DataGenericResponse<CharacterDetailInfo>();
        
        if(response.getStatusCode() == HttpStatus.OK) {
        	
            dataResponse.setAction(AppConstants.ACTION_CONTINUE);
            dataResponse.setType(AppConstants.TYPE_SUCCESS);
            dataResponse.setData(response.getBody());
        }
        
        return dataResponse;
    }
}
