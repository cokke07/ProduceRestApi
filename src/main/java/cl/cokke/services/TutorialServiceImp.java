package cl.cokke.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.cokke.dto.TutorialDTO;

@Service
public class TutorialServiceImp implements TutorialServices {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<TutorialDTO> findAll() {
		
		ResponseEntity<List<TutorialDTO>> response =
		
		restTemplate.exchange(
				"http://localhost:8083/api/v1/tutoriales", //url donde se comunica el metodo
				HttpMethod.GET, //el tipo de metodo de la peticion
				null,  //objeto que viaja en el Request
				new ParameterizedTypeReference<List<TutorialDTO>>() {}  //respuesta del servicio
				);
		
		return response.getBody();
	}

	@Override
	public TutorialDTO save(TutorialDTO tutorial) {

		HttpEntity<TutorialDTO> request = new HttpEntity<>(tutorial); // entidad que viaja en el request
		
		ResponseEntity<TutorialDTO> response =
		restTemplate.exchange(
				"http://localhost:8083/api/v1/tutoriales", //url donde se comunica el metodo
				HttpMethod.POST, //el tipo de metodo de la peticion
				request,  //objeto que viaja en el Request
				new ParameterizedTypeReference<TutorialDTO>() {}  //respuesta del servicio
				);
		
		System.out.println(response.getStatusCodeValue());
		return response.getBody();
	}

	@Override
	public TutorialDTO update(TutorialDTO tutorial) {
		
		HttpEntity<TutorialDTO> request = new HttpEntity<>(tutorial);
		
		ResponseEntity<TutorialDTO> response =
			restTemplate.exchange(
					"http://localhost:8083/api/v1/tutoriales/"+tutorial.getId(), //url donde se comunica el metodo
					HttpMethod.PUT,
					request,  //objeto que viaja en el Request
					new ParameterizedTypeReference<TutorialDTO>() {}   //se responde la clase
					);
		
		return response.getBody();
	}

	@Override
	public HttpStatus delete(Long id) {
		
		ResponseEntity<HttpStatus> response =
			restTemplate.exchange(
					"http://localhost:8083/api/v1/tutoriales/"+id, 
					HttpMethod.DELETE, 
					null, 
					new ParameterizedTypeReference<HttpStatus>() {} 
					);
		
		return response.getStatusCode();
	}

	@Override
	public TutorialDTO findById(Long id) {
		
		ResponseEntity<TutorialDTO> response =
				restTemplate.exchange(
					"http://localhost:8083/api/v1/tutoriales/"+id, //url donde se comunica el metodo pasando el id buscado
					HttpMethod.GET, //el tipo de metodo de la peticion
					null,  //objeto que viaja en el Request
					new ParameterizedTypeReference<TutorialDTO>() {}  //respuesta del servicio
					);
				
		return response.getBody();
	}

}
