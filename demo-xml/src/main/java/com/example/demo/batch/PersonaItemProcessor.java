package com.example.demo.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.demo.model.Persona;
import com.example.demo.model.PersonaDTO;

@Component
public class PersonaItemProcessor implements ItemProcessor<PersonaDTO, Persona> {
	private static final Logger log = LoggerFactory.getLogger(PersonaItemProcessor.class);
	
	@Override
	public Persona process(PersonaDTO item) throws Exception {	 
		if("Male".equals(item.getSexo())) return null;
		Persona rslt = new Persona(item.getId(), item.getApellidos() + ", " + item.getNombre(), 
				item.getCorreo(), item.getIp());
		log.info("Procesando: " + item);
		return rslt;
	}
}
