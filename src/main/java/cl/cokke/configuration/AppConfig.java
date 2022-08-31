package cl.cokke.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration //clase de configuracion 
public class AppConfig {

	//declaracion de Bean de tipo RestTemplate , para realizar intercambio de informacion entre cliente servidor
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
