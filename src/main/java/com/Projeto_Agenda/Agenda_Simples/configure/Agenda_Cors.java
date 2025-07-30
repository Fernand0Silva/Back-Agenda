package com.Projeto_Agenda.Agenda_Simples.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Agenda_Cors {
	@Bean
	public WebMvcConfigurer corsCofigure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) 
			{
				registry.addMapping("/**")
				.allowedOriginPatterns("http://localhost:3000","http://127.0.0.1:5500") // ✔ aceita origem do front
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                //.allowedHeaders("*")
                .allowCredentials(true); // ✔ habilita cookies/autenticação se necessário				
				

			}
		}; 
	}

}
