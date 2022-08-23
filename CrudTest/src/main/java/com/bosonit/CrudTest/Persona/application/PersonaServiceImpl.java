package com.bosonit.CrudTest.Persona.application;

import com.bosonit.CrudTest.Persona.application.PersonaService;
import com.bosonit.CrudTest.Persona.domain.Persona;
import com.bosonit.CrudTest.Persona.infraestructure.dto.PersonaInputDto;
import com.bosonit.CrudTest.Persona.infraestructure.dto.PersonaOutputDto;
import com.bosonit.CrudTest.Persona.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDto save(PersonaInputDto personaInputDto) {
        Persona persona= new Persona(personaInputDto);

        //guardamos el objeto de entrada
        personaRepository.save(persona);
        //creamos objeto de salida y le pasamos los parámetros
        PersonaOutputDto personaSalida= new PersonaOutputDto(persona);
        return personaSalida;
    }
    @Override
    public List<PersonaOutputDto> getall() {
        //creamos lista de personas de salida
        List<PersonaOutputDto> personas;
        //buscamos todas los objetos en el repositorio y los casteamos a nuestro objeto de salida
        personas = personaRepository.findAll().stream().map(p -> new PersonaOutputDto(p)).toList();

        return personas;
    }

    @Override
    public PersonaOutputDto get(int id) {
        //encuentra persona en el repositorio con la Id
        Persona p = personaRepository.findById(id).orElseThrow(() -> new RuntimeException("Persona con id: " + id + "no encontrada."));
        //Crea objeto salida y le pasamos la persona encontrada
        PersonaOutputDto persOutputDto = new PersonaOutputDto(p);
        return persOutputDto;
    }

    @Override
    public PersonaOutputDto put(int id, PersonaInputDto personaInputDto) {
        try {
            Persona personaEncontrada = personaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Persona con esa id no encontrada"));

            personaEncontrada.put(personaInputDto);
            personaRepository.save(personaEncontrada);

            return new PersonaOutputDto(personaEncontrada);
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    @Override
    public ResponseEntity<String> delete(@PathVariable int id) {
            try {
                personaRepository.deleteById(id);
                return new ResponseEntity<>(("Borrada persona con id: " + id),HttpStatus.OK);
            } catch (Exception e) {
                throw new RuntimeException("No existe el id");
            }
        }
}
