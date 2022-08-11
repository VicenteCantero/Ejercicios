package com.bosonit.BP1.Asignaturas.domain;

import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturaOutputDto;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturaInputDto;
import com.bosonit.BP1.Estudiante.Domain.Student;
import com.bosonit.BP1.Profesor.domain.Profesor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name= "Estudios")
@NoArgsConstructor
@AllArgsConstructor
public class Asignaturas {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id_study;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    Profesor profesor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    Student student;

    @Column(name = "asignatura")
    String asignatura;

    @Column(name = "comentarios")
    String comment;

    @Column(name = "initial_date")
    Date initial_date;

    @Column(name = "finish_date")
    Date finish_date;


    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "ESTUDIANTES_ASIGNATURAS",
            joinColumns = @JoinColumn, //(name = "subjectID"),
            inverseJoinColumns = @JoinColumn //(name = "studentID")
    )
    List<Student> estudiantesApuntados = new ArrayList<>();


    public Asignaturas(AsignaturaInputDto asignaturaInputDto) {
        setAsignatura(asignaturaInputDto.getAsignatura());
        setComment(asignaturaInputDto.getComment());
        setInitial_date(asignaturaInputDto.getInitial_date());
        setFinish_date(asignaturaInputDto.getFinish_date());
    }

    public void AsignaturasInputDto(AsignaturaInputDto asignaturaInputDto) {
        this.setAsignatura(asignaturaInputDto.getAsignatura());
        this.setComment(asignaturaInputDto.getComment());
        this.setInitial_date(asignaturaInputDto.getInitial_date());
        this.setFinish_date(asignaturaInputDto.getFinish_date());
    }

    public AsignaturaOutputDto AsignaturaOutputDto(Asignaturas asignaturas) {

        AsignaturaOutputDto asignaturaOutputDto = new AsignaturaOutputDto();
        asignaturaOutputDto.setAsignatura(this.getAsignatura());
        asignaturaOutputDto.setComment(this.getComment());
        asignaturaOutputDto.setInitial_date(this.getInitial_date());
        asignaturaOutputDto.setFinish_date(this.getFinish_date());

        return asignaturaOutputDto;
    }


    public void inscribir(Student student){
        estudiantesApuntados.add(student);
    }

    public void apuntarProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

}
