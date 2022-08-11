package com.bosonit.BP1.Persona.infrastructure.controller.dto.output;


import com.bosonit.BP1.Estudiante.Domain.Student;
import com.bosonit.BP1.Persona.Domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaOutputDtoStudent extends PersonaOutputDTO{

    private int id_student;
    private int num_hours_week;
    private String coments;
    private String branch;


    public PersonaOutputDtoStudent (Persona persona){
        setId_persona(persona.getId_persona());
        setUsuario(persona.getUsuario());
        setPassword(persona.getPassword());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompany_email());
        setPersonal_email(persona.getPersonal_email());
        setCity(persona.getCity());
        setActive(persona.getActive());
        setCreated_date(persona.getCreated_date());
        setImagen_url(persona.getImagen_url());
        setTermination_date(persona.getTermination_date());

        setId_student(persona.getStudent().getId_student());
        setNum_hours_week(persona.getStudent().getNum_hours_week());
        setBranch(persona.getStudent().getBranch());
        setComents(persona.getStudent().getComents());
    }
}
