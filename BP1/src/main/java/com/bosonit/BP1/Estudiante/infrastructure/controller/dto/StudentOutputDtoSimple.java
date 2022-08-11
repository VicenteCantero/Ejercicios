package com.bosonit.BP1.Estudiante.infrastructure.controller.dto;

import com.bosonit.BP1.Estudiante.Domain.Student;
import com.bosonit.BP1.Persona.Domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentOutputDtoSimple implements Serializable {

    private int id_student;
    //private Persona persona;
    private int num_hours_week;
    private String coments;
    private String branch;



    /*
     private Profesor profesor;

     List<Alumnos_Estudios> estudios;
     */


    public StudentOutputDtoSimple (Student student){
        setId_student(student.getId_student());
        //setPersona(student.getPersona());
        setNum_hours_week(student.getNum_hours_week());
        setComents(student.getComents());
        setBranch(student.getBranch());
    }
}
