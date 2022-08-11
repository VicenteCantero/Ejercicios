package com.bosonit.BP1.Asignaturas.application;

import com.bosonit.BP1.Asignaturas.domain.Asignaturas;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturaOutputDto;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturaInputDto;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturaOutputDtoFull;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturasIDInputDto;
import com.bosonit.BP1.Asignaturas.infrastructure.repository.AsignaturasRepositoryJpa;
import com.bosonit.BP1.Estudiante.Domain.Student;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import com.bosonit.BP1.Estudiante.infrastructure.repository.StudentRepositoryJpa;
import com.bosonit.BP1.Profesor.domain.Profesor;
import com.bosonit.BP1.Profesor.infrastructure.repository.ProfesorRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AsignaturasServiceImpl implements AsignaturasService {

    @Autowired
    AsignaturasRepositoryJpa asignaturasRepositoryJpa;

    @Autowired
    StudentRepositoryJpa studentRepositoryJpa;

    @Autowired
    ProfesorRepositoryJpa profesorRepositoryJpa;


    @Override
    public AsignaturaOutputDto crearAsignatura(AsignaturaInputDto asignaturaInputDto) throws Exception {
        // Profesor profesor= profesorRepositoryJpa.findById(asignaturasInputDto.getProfesorID()).orElse(null);
        //if(profesor==null)
        //  throw new RuntimeException("Necesita asignar un profesor");

        Asignaturas asignaturas = new Asignaturas(asignaturaInputDto);
        asignaturasRepositoryJpa.save(asignaturas);
        return asignaturas.AsignaturaOutputDto(asignaturas);

    }

    @Override
    public AsignaturaOutputDto dameAsignaturaID(int id) throws Exception {
        return null;
    }

    @Override
    public List<AsignaturaOutputDtoFull> dameAsignaturas() {
        List<AsignaturaOutputDtoFull> listaAsignaturas = new ArrayList<>();
        for (Asignaturas asignaturas : asignaturasRepositoryJpa.findAll()) {
            listaAsignaturas.add(new AsignaturaOutputDtoFull(asignaturas));
        }
        return listaAsignaturas;
    }

    @Override
    public AsignaturaOutputDto actualizaAsignatura(int id, AsignaturaInputDto asignaturaInputDto) {
        return null;
    }


/* SOLUCION EMAR
    @Override
    public Asignaturas apuntarEstudianteAsignatura(int idAsignatura, int idEstudiante) {
        Asignaturas asignatura = asignaturasRepositoryJpa.findById(idAsignatura).get();
        Student student = studentRepositoryJpa.findById(idEstudiante).get();
        asignatura.inscribir(student);
        return asignaturasRepositoryJpa.save(asignatura);
    }

    @Override
    public Asignaturas apuntarProfesorAsignatura(int idAsignatura, int idProfesor) {
        Asignaturas asignatura = asignaturasRepositoryJpa.findById(idAsignatura).get();
        Profesor profesor = profesorRepositoryJpa.findById(idProfesor).get();
        asignatura.apuntarProfesor(profesor);
        return asignaturasRepositoryJpa.save(asignatura);
    }

    @Override
    public List<AsignaturaOutputDto> apuntarEstudianteListaAsignaturas(List<Integer> listaIdAsignaturas, int idEstudiante) {
        List<Asignaturas> lista = listaIdAsignaturas.stream().map(n -> asignaturasRepositoryJpa.findById(n).get()).toList();
        Student student = studentRepositoryJpa.findById(idEstudiante).get();
        lista.stream().forEach(n -> {
            n.inscribir(student);
            asignaturasRepositoryJpa.save(n);
        });


        return lista.stream().map(n -> n.AsignaturaOutputDto(n)).toList();
    }

    @Override
    public List<AsignaturaOutputDto> BorraAsignaturas(List<Asignaturas> borradas) {
        return null;
    }
*/

//     solucion Oscar
    @Override
    public List<AsignaturaOutputDto> dameAsignaturasEstudiante(int id) {

        List<AsignaturaOutputDto> asignaturaOutputDtoList = new ArrayList<>();
        for(Asignaturas asignaturas: asignaturasRepositoryJpa.encuentraAsignaturaEstudiante(id)){
            asignaturaOutputDtoList.add(new AsignaturaOutputDto(asignaturas));
        }
        return asignaturaOutputDtoList;
    }

    @Override
    public StudentOutputDtoFull añadirAsignaturasEstudiante(AsignaturasIDInputDto asignaturasIDInputDto, String id_estudiante) {
        //coge estudiante
        Student estudiante = studentRepositoryJpa.findById(Integer.valueOf(id_estudiante)).get();


        //coge asignaturas
        for (int id_study : asignaturasIDInputDto.getAsignaturas()) {
            Asignaturas asignaturas = asignaturasRepositoryJpa.findById(id_study).get();
            asignaturas.inscribir(estudiante);
            asignaturasRepositoryJpa.save(asignaturas);
        }
        return new StudentOutputDtoFull(estudiante);
    }
}
