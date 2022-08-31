package cl.cokke.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;

import cl.cokke.dto.TutorialDTO;

public interface TutorialServices {

	public List<TutorialDTO> findAll();
	public TutorialDTO save(TutorialDTO tutorial);
	public TutorialDTO update(TutorialDTO tutorial);
	public HttpStatus delete(Long id);
	public TutorialDTO findById(Long id);

}
