package com.bosonit.BP1.Asignaturas.application;

import com.bosonit.BP1.Asignaturas.domain.Asignaturas;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturaOutputDto;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturaInputDto;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturaOutputDtoFull;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturasIDInputDto;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AsignaturasService {

    AsignaturaOutputDto crearAsignatura(AsignaturaInputDto asignaturaInputDto) throws Exception;

    AsignaturaOutputDto dameAsignaturaID(int id) throws Exception;

    List<AsignaturaOutputDtoFull> dameAsignaturas();

    AsignaturaOutputDto actualizaAsignatura(int id, AsignaturaInputDto asignaturaInputDto);



    // Solucion Oscar
   List<AsignaturaOutputDto> dameAsignaturasEstudiante(int id);

    StudentOutputDtoFull añadirAsignaturasEstudiante(AsignaturasIDInputDto asignaturasIDInputDto, String id_estudiante);



    //Solucion Emar

/*
    Asignaturas apuntarEstudianteAsignatura(int idAsignatura, int idEstudiante);

    Asignaturas apuntarProfesorAsignatura(int idAsignatura, int idProfesor);

    List<AsignaturaOutputDto> apuntarEstudianteListaAsignaturas(List<Integer> listaIdAsignaturas, int idEstudiante);

    List<AsignaturaOutputDto> BorraAsignaturas(List<Asignaturas> borradas);*/
}
