package com.bosonit.BP1.Estudiante.Domain;


import com.bosonit.BP1.Asignaturas.domain.Asignaturas;
import com.bosonit.BP1.Errores.UnprocesableException;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentInputDto;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoSimple;
import com.bosonit.BP1.Persona.Domain.Persona;
import com.bosonit.BP1.Profesor.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name= "Estudiantes")
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_student;

    @OneToOne
    @JoinColumn(name= "id_persona")
    private Persona persona;

    @Column(name= "Horas_por_semana")
    private int num_hours_week;

    @Column(name= "Comentarios")
    private String coments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "id_profesor")
    private Profesor profesor;

    @Column(name= "rama")
    //(columnDefinition = "VARCHAR(10) CHECK(branch IN ('FRONT', 'BACK', 'FULLSTACK'))")
    private String branch;

    @Override
    public String toString() {
        return "Student{" +
                "id_student=" + id_student +
                ", num_hours_week=" + num_hours_week +
                ", coments='" + coments + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudios")
    private List<Asignaturas> estudios = new ArrayList<>();


    public void ValidadorEstudiante() throws Exception{
        if (String.valueOf(num_hours_week) == null){
            throw new UnprocesableException("Inserte número de horas");
        }
        if (branch == null){
            throw new UnprocesableException("Escoja entre Front, Back o Full");
        }
    }

    public Student (StudentInputDto studentInputDto){
        setNum_hours_week(studentInputDto.getNum_hours_week());
        setComents(studentInputDto.getComents());
        setBranch(studentInputDto.getBranch());

    }


    public void StudentInputDto(StudentInputDto studentInputDto) {
        this.setComents(studentInputDto.getComents());
        this.setNum_hours_week(studentInputDto.getNum_hours_week());
        this.setBranch(studentInputDto.getBranch());
    }

    public StudentOutputDtoSimple StudentToOutputDtoSimple(Student student) {

        StudentOutputDtoSimple studentOutputDtoSimple = new StudentOutputDtoSimple();
        studentOutputDtoSimple.setId_student(this.getId_student());
        studentOutputDtoSimple.setBranch(this.getBranch());
        studentOutputDtoSimple.setComents(this.getComents());
        studentOutputDtoSimple.setNum_hours_week(this.getNum_hours_week());

        return studentOutputDtoSimple;
    }

    public StudentOutputDtoFull StudentOutputDtoFull(Student student) {

        StudentOutputDtoFull studentOutputDtoFull = new StudentOutputDtoFull();
        studentOutputDtoFull.setId_student(this.getId_student());
        studentOutputDtoFull.setBranch(this.getBranch());
        studentOutputDtoFull.setComents(this.getComents());
        studentOutputDtoFull.setNum_hours_week(this.getNum_hours_week());

        studentOutputDtoFull.setUsuario(this.persona.getUsuario());
        studentOutputDtoFull.setPassword(this.persona.getPassword());
        studentOutputDtoFull.setName(this.persona.getName());
        studentOutputDtoFull.setSurname(this.persona.getSurname());
        studentOutputDtoFull.setCompany_email(this.persona.getCompany_email());
        studentOutputDtoFull.setPersonal_email(this.persona.getPersonal_email());
        studentOutputDtoFull.setCity(this.persona.getCity());
        studentOutputDtoFull.setCreated_date(this.persona.getCreated_date());
        studentOutputDtoFull.setImagen_url(this.persona.getImagen_url());
        studentOutputDtoFull.setTermination_date(this.persona.getTermination_date());

        return studentOutputDtoFull;
    }

    public void actualiza(StudentInputDto studentInputDto) throws Exception{
        try {
            if (studentInputDto.getComents() != null) {
                setComents(studentInputDto.getComents());
            }
            if (studentInputDto.getBranch() != null) {
                setBranch(studentInputDto.getBranch());
            }
            if (String.valueOf(studentInputDto.getNum_hours_week()) != null) {
                setNum_hours_week(studentInputDto.getNum_hours_week());
            }
        }catch (Exception e){
            throw new UnprocesableException("Campos erróneos");
        }
    }
}
