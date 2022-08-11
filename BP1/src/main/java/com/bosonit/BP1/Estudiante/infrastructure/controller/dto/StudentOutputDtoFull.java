package com.bosonit.BP1.Estudiante.infrastructure.controller.dto;

import com.bosonit.BP1.Estudiante.Domain.Student;
import com.bosonit.BP1.Persona.Domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentOutputDtoFull extends StudentOutputDtoSimple{

    private Persona persona;
    private int id_persona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    public StudentOutputDtoFull (Student student) {
        /*setId_student(student.getId_student());

        setNum_hours_week(student.getNum_hours_week());
        setComents(student.getComents());
        setBranch(student.getBranch());*/

        setId_persona(student.getPersona().getId_persona());
        setUsuario(student.getPersona().getUsuario());
        setPassword(student.getPersona().getPassword());
        setName(student.getPersona().getName());
        setSurname(student.getPersona().getSurname());
        setCompany_email(student.getPersona().getCompany_email());
        setImagen_url(student.getPersona().getImagen_url());
        setPersonal_email(student.getPersona().getPersonal_email());
        setCity(student.getPersona().getCity());
        setActive(student.getPersona().getActive());
        setCreated_date(student.getPersona().getCreated_date());
        setTermination_date(student.getPersona().getTermination_date());


    }
}
