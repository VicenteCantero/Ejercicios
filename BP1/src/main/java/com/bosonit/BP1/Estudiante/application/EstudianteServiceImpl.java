package com.bosonit.BP1.Estudiante.application;

import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturaOutputDto;
import com.bosonit.BP1.Errores.NotFoundException;
import com.bosonit.BP1.Errores.UnprocesableException;
import com.bosonit.BP1.Estudiante.Domain.Student;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentInputDto;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoSimple;
import com.bosonit.BP1.Estudiante.infrastructure.repository.StudentRepositoryJpa;
import com.bosonit.BP1.Persona.Domain.Persona;
import com.bosonit.BP1.Persona.infrastructure.repository.PersonaRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@AllArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    StudentRepositoryJpa studentRepositoryJpa;

    @Autowired
    PersonaRepositoryJPA personaRepositoryJPA;


    @Override
    public StudentOutputDtoFull crearEstudiante(StudentInputDto studentInputDto) {

            Student student= new Student(studentInputDto);
            Persona persona;
            persona= personaRepositoryJPA.findById((studentInputDto.getId_persona())).get();
            persona.setStudent(student);
            student.setPersona(persona);

            //guardamos el objeto estudiante de entrada + objeto persona
            studentRepositoryJpa.save(student);

            //System.out.println("El estudiante: " + studentRepositoryJpa.findById(student.getId_student()) + " es la persona: " + studentRepositoryJpa.findById(persona.getId_persona()));
            //System.out.println("La persona : " + personaRepositoryJPA.findById(persona.getId_persona()) + " es el estudiante: " + studentRepositoryJpa.findById(student.getId_student()));
           return student.StudentOutputDtoFull(student);

    }

    @Override
    public StudentOutputDtoSimple getStudentByID(int id, String outputType) throws Exception {
        Student student= new Student();
        student= studentRepositoryJpa.findById(id).orElseThrow(()->new Exception("Id inexistente"));
        if (outputType.equalsIgnoreCase("simple"))
        return new StudentOutputDtoSimple(student);
        else
        return new StudentOutputDtoFull(student);
    }

    @Override
    public List<StudentOutputDtoFull> getAllStudent() {
        //creamos lista de estudiantes de salida
        List<StudentOutputDtoFull> estudiantes;
        //buscamos todas los objetos en el repositorio y los casteamos a nuestro objeto de salida
        estudiantes = studentRepositoryJpa.findAll().stream().map(s -> new StudentOutputDtoFull(s)).toList();

        return estudiantes;
    }

    @Override
    public StudentOutputDtoFull actualizaEstudiante(int id, StudentInputDto studentInputDto) {
        try {
            Student estudianteEncontrado = studentRepositoryJpa.findById(id)
                    .orElseThrow(() -> new RuntimeException("Estudiante con ese id no encontrado"));

            estudianteEncontrado.actualiza(studentInputDto);
            studentRepositoryJpa.save(estudianteEncontrado);

            return new StudentOutputDtoFull(estudianteEncontrado);
        } catch (Exception e) {
            throw new UnprocesableException("Error");
        }
    }

    @Override
    public List<AsignaturaOutputDto> asignaturasEstudiante(int idEstudiante) {
        return studentRepositoryJpa.findById(idEstudiante).get().getEstudios().stream().map(n -> n.AsignaturaOutputDto(n)).toList();
    }

    public ResponseEntity<String> deleteById(@PathVariable int id)throws Exception{
        try{
            studentRepositoryJpa.deleteById(id);
            return new ResponseEntity<>(("Borrado alumno con id: " + id), HttpStatus.OK);
        } catch (Exception e) {
            throw new NotFoundException("No existe el id");
        }
    }
}

/*

    @Override
    public List<StudentOutputDTO> getAllStudents() {
        if (studentRepository.findAll() != null) {
            List<StudentOutputDTO> studentOutputDTOList = new ArrayList<>();
            studentRepository.findAll().forEach(studentEntity -> {
                StudentOutputDTO studentOutputDTO = new StudentOutputDTO(studentEntity);
                studentOutputDTOList.add(studentOutputDTO);
            });
            return studentOutputDTOList;
        }

        List<StudentOutputDTO> studentOutputDTOListVacia = new ArrayList<>();
        return studentOutputDTOListVacia;
    }

 */