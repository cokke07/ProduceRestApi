package cl.cokke.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component("tutorial")
public class TutorialDTO {

	private Long id;
	private String titulo;
	private String descripcion;
	private boolean publicado;
	
}
