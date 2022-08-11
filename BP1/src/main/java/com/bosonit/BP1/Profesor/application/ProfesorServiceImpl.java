package com.bosonit.BP1.Profesor.application;

import com.bosonit.BP1.Errores.NotFoundException;
import com.bosonit.BP1.Errores.UnprocesableException;
import com.bosonit.BP1.Estudiante.Domain.Student;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoSimple;
import com.bosonit.BP1.Persona.Domain.Persona;
import com.bosonit.BP1.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.BP1.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.BP1.Persona.infrastructure.repository.PersonaRepositoryJPA;
import com.bosonit.BP1.Profesor.domain.Profesor;
import com.bosonit.BP1.Profesor.infrastructure.controller.dto.ProfesorInputDto;
import com.bosonit.BP1.Profesor.infrastructure.controller.dto.ProfesorOutputDto;
import com.bosonit.BP1.Profesor.infrastructure.controller.dto.ProfesorOutputDtoFull;
import com.bosonit.BP1.Profesor.infrastructure.repository.ProfesorRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@AllArgsConstructor
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    ProfesorRepositoryJpa profesorRepositoryJpa;

    @Autowired
    PersonaRepositoryJPA personaRepositoryJPA;

    @Override
    public ProfesorOutputDtoFull crearProfesor(ProfesorInputDto profesorInputDto) throws Exception {
        Profesor profesor = new Profesor(profesorInputDto);
        Persona persona;
        persona = personaRepositoryJPA.findById((profesorInputDto.getId_persona())).get();

        profesor.setPersona(persona);

        //guardamos el objeto profesor de entrada + objeto persona
        profesorRepositoryJpa.save(profesor);

        System.out.println("El profesor: " + profesorRepositoryJpa.findById(profesor.getId_profesor()) + " es la persona: " + personaRepositoryJPA.findById(persona.getId_persona()));
        System.out.println("La persona : " + personaRepositoryJPA.findById(persona.getId_persona()) + " es el profesor: " + profesorRepositoryJpa.findById(profesor.getId_profesor()));
        return profesor.ProfesorOutputDtoFull(profesor);
    }

    @Override
    public ProfesorOutputDto dameProfesorId(int id, String outputType) throws Exception {
        Profesor profesor = new Profesor();
        profesor = profesorRepositoryJpa.findById(id).orElseThrow(() -> new Exception("Id inexistente"));
        if (outputType.equalsIgnoreCase("simple"))
            return new ProfesorOutputDto(profesor);
        else
            return new ProfesorOutputDtoFull(profesor);
    }


    @Override
    public List<ProfesorOutputDtoFull> dameProfesores() {
        //creamos lista de profesores de salida
        List<ProfesorOutputDtoFull> profesores;
        //buscamos todas los objetos en el repositorio y los casteamos a nuestro objeto de salida
        profesores = profesorRepositoryJpa.findAll().stream().map(s -> new ProfesorOutputDtoFull(s)).toList();

        return profesores;
    }

    @Override
    public ProfesorOutputDtoFull actualizaProfesor(int id, ProfesorInputDto profesorInputDto) {
        try {
            Profesor profesorEncontrado = profesorRepositoryJpa.findById(id)
                    .orElseThrow(() -> new RuntimeException("Profesor con ese id no encontrado"));

            profesorEncontrado.actualiza(profesorInputDto);
            profesorRepositoryJpa.save(profesorEncontrado);

            return new ProfesorOutputDtoFull(profesorEncontrado);
        } catch (Exception e) {
            throw new UnprocesableException("Error");
        }
    }

    public ResponseEntity<String> deleteById(@PathVariable int id)throws Exception{
        try{
            profesorRepositoryJpa.deleteById(id);
            return new ResponseEntity<>(("Borrado profesor con id: " + id), HttpStatus.OK);
        } catch (Exception e) {
            throw new NotFoundException("No existe el id");
        }
    }
}