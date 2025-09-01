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

    public ResponseEntity<DataGenericResponse<PokeApiResponse>> getPokemonCharacter(Integer limit) {
    	
    	if(limit<0 || limit>100) {
    		DataGenericResponse<PokeApiResponse> errorResponse = new DataGenericResponse<>();
            errorResponse.setAction(AppConstants.ACTION_CANCEL);
            errorResponse.setType(AppConstants.TYPE_ERROR);
            errorResponse.setMessage("Provided value for limits param is invalid");
            errorResponse.setCode(AppConstants.ERROR_CODE_LIMIT);
            errorResponse.setData(null);

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorResponse);

    	}
    	
    	HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<PokeApiResponse> response = restTemplate.exchange(
                API_URL+"?limit="+limit,
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
            
            return ResponseEntity.ok(dataResponse);
        }
        
        dataResponse.setAction(AppConstants.ACTION_CANCEL);
        dataResponse.setType(AppConstants.TYPE_ERROR);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dataResponse);
    }
    
    public ResponseEntity<DataGenericResponse<CharacterDetailInfo>> getPokemonCharacterById(String pokemonId) {
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
            
            return ResponseEntity.ok(dataResponse);
        }
        
        dataResponse.setAction(AppConstants.ACTION_CANCEL);
        dataResponse.setType(AppConstants.TYPE_ERROR);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dataResponse);
    }
}
