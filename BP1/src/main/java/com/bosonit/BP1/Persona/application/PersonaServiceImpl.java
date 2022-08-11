package com.bosonit.BP1.Persona.application;

import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoSimple;
import com.bosonit.BP1.Persona.Domain.Persona;
import com.bosonit.BP1.Errores.NotFoundException;
import com.bosonit.BP1.Errores.UnprocesableException;
import com.bosonit.BP1.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.BP1.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.BP1.Persona.infrastructure.controller.dto.output.PersonaOutputDtoProfesor;
import com.bosonit.BP1.Persona.infrastructure.controller.dto.output.PersonaOutputDtoStudent;
import com.bosonit.BP1.Persona.infrastructure.repository.PersonaRepositoryJPA;
import com.bosonit.BP1.Profesor.infrastructure.controller.dto.ProfesorOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaRepositoryJPA personaRepositoryJPA;

    //CREATE-POST
    @Override
    public PersonaOutputDTO añadir(PersonaInputDTO personaInputDTO) throws Exception{
        //creamos objeto con los parámetros input
        //validamos campos
        try {
            if (personaInputDTO.getUsuario() == null) {
                throw new UnprocesableException("Usuario no puede ser nulo");
            }
            if (personaInputDTO.getUsuario().length() > 10) {
                throw new UnprocesableException("Longitud de usuario no puede ser superior a 10 caracteres");
            }
            if (personaInputDTO.getPassword() == null) {
                throw new UnprocesableException("Password no puede ser nulo");
            }
            if (personaInputDTO.getName() == null) {
                throw new UnprocesableException("Name no puede ser nulo");
            }
            if (personaInputDTO.getCompany_email() == null) {
                throw new UnprocesableException("Company_email no puede ser nulo");
            }
            if (personaInputDTO.getPersonal_email() == null) {
                throw new UnprocesableException("Personal_email no puede ser nulo");
            }
            if (personaInputDTO.getActive() == null) {
                throw new UnprocesableException("Active no puede ser nulo");
            }
            if (personaInputDTO.getCreated_date() == null) {
                throw new UnprocesableException("Create_date no puede ser nulo");
            }

            Persona persona= new Persona(personaInputDTO);

            //guardamos el objeto de entrada
            personaRepositoryJPA.save(persona);
            //creamos objeto de salida y le pasamos los parámetros
            PersonaOutputDTO personaOutput= new PersonaOutputDTO(persona);
            return personaOutput;

        }catch(Exception e){
            throw new UnprocesableException("Campos inválidos");
        }
    }

    //GET-DAME
    @Override
    public List<PersonaOutputDTO> findAll(String outputType) {
        //creamos lista de personas de salida
        List<PersonaOutputDTO> personas;
        //buscamos todas los objetos en el repositorio y los casteamos a nuestro objeto de salida
        personas = personaRepositoryJPA.findAll().stream().map(p -> new PersonaOutputDTO(p)).toList();

        return personas;
    }

    @Override
    public ResponseEntity<PersonaOutputDTO> findById(int id, String outputType) throws Exception {
        try {
            if (outputType.equalsIgnoreCase("simple")) {
                Persona p = personaRepositoryJPA.findById(id).orElseThrow(() -> new NotFoundException("Persona con id: " + id + "no encontrada."));
                PersonaOutputDTO persOutputDto = new PersonaOutputDTO(p);
                return new ResponseEntity<>(persOutputDto, HttpStatus.OK);
            }
            if (outputType.equalsIgnoreCase("profesor")) {
                Persona p = personaRepositoryJPA.findById(id).orElseThrow(() -> new NotFoundException("Persona con id: " + id + "no encontrada."));
                PersonaOutputDtoProfesor persOutputDto = new PersonaOutputDtoProfesor(p);
                return new ResponseEntity<>(persOutputDto, HttpStatus.OK);
            }
            if (outputType.equalsIgnoreCase("estudiante")) {
                Persona p = personaRepositoryJPA.findById(id).orElseThrow(() -> new NotFoundException("Persona con id: " + id + "no encontrada."));
                PersonaOutputDtoStudent persOutputDto = new PersonaOutputDtoStudent(p);
                return new ResponseEntity<>(persOutputDto, HttpStatus.OK);
            } else {
                Persona p = personaRepositoryJPA.findById(id).orElseThrow(() -> new NotFoundException("Persona con id: " + id + "no encontrada."));
                PersonaOutputDTO persOutputDto = new PersonaOutputDTO(p);
                return new ResponseEntity<>(persOutputDto, HttpStatus.OK);}
            }catch(Exception e){
                System.out.println(e.getMessage());
                throw new NotFoundException("No existe");
            }
    }


    @Override
    public List<Object> findByUsuario(String usuario, String outputType) throws Exception {
        try {
            if (outputType.equalsIgnoreCase("simple")) {
                List<Object> personas;
                personas = personaRepositoryJPA.findByUsuario(usuario).stream().map(p -> new PersonaOutputDTO(p)).collect(Collectors.toList());
                return personas;
            }if (outputType.equalsIgnoreCase("profesor")) {
                List<Object> personas;
                personas = personaRepositoryJPA.findByUsuario(usuario).stream().map(p -> new PersonaOutputDtoProfesor(p)).collect(Collectors.toList());
                return personas;
            } if (outputType.equalsIgnoreCase("estudiante")) {
                List<Object> personas;
                personas = personaRepositoryJPA.findByUsuario(usuario).stream().map(p -> new PersonaOutputDtoStudent(p)).collect(Collectors.toList());
                return personas;
            }else{
                List<Object> personas;
                personas =personaRepositoryJPA.findByUsuario(usuario).stream().map(p -> new PersonaOutputDTO(p)).collect(Collectors.toList());
                return personas;
            }

        }catch (Exception e){
            System.out.println("usuario no encontrado");
            return null;
        }
    }

    @Override
    public PersonaOutputDTO actualizaPersona(int id, PersonaInputDTO personaInputDTO) {
       try {
           Persona personaEncontrada = personaRepositoryJPA.findById(id)
                   .orElseThrow(() -> new RuntimeException("Persona con esa id no encontrada"));

           personaEncontrada.actualiza(personaInputDTO);
           personaRepositoryJPA.save(personaEncontrada);

           return new PersonaOutputDTO(personaEncontrada);
       }catch (Exception e){
           throw new UnprocesableException("Error");
       }

    }

    public ResponseEntity<String> personaBorradaPorID(@PathVariable int id) throws Exception {
        try {
            personaRepositoryJPA.deleteById(id);
            return new ResponseEntity<>(("Borrada persona con id: " + id),HttpStatus.OK);
         } catch (Exception e) {
            throw new NotFoundException("No existe el id");
         }
    }
}
