package com.bosonit.BP1.Persona.Domain;

import com.bosonit.BP1.Errores.UnprocesableException;
import com.bosonit.BP1.Estudiante.Domain.Student;
import com.bosonit.BP1.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.BP1.Profesor.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "Persona")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne(mappedBy = "persona", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Student student;

    @OneToOne(mappedBy = "persona", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Profesor profesor;


    public Persona(PersonaInputDTO persona){
        if (persona == null)
            return;
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



    }

    public void actualiza(PersonaInputDTO personaInputDTO) throws Exception{
        try {
            if (personaInputDTO.getUsuario() != null && personaInputDTO.getUsuario().length() <= 10 && personaInputDTO.getUsuario().length() >= 6) {
                setUsuario(personaInputDTO.getUsuario());
            }
            if (personaInputDTO.getPassword() != null) {
                setPassword(personaInputDTO.getPassword());
            }
            if (personaInputDTO.getName() != null) {
                setName(personaInputDTO.getName());
            }
            if (personaInputDTO.getSurname() != null) {
                setSurname(personaInputDTO.getSurname());
            }
            if (personaInputDTO.getCompany_email() != null) {
                setCompany_email(personaInputDTO.getCompany_email());
            }
            if (personaInputDTO.getPersonal_email() != null) {
                setPersonal_email(personaInputDTO.getPersonal_email());
            }
            if (personaInputDTO.getCity() != null) {
                setCity(personaInputDTO.getCity());
            }
            if (personaInputDTO.getActive() != null) {
                setActive(personaInputDTO.getActive());
            }
            if (personaInputDTO.getCreated_date() != null) {
                setCreated_date(personaInputDTO.getCreated_date());
            }
            if (personaInputDTO.getImagen_url() != null) {
                setImagen_url(personaInputDTO.getImagen_url());
            }
        }catch (Exception e){
            throw new UnprocesableException("Campos erróneos");
        }
    }

    public void setStudent(Student studentTest) {
        if(this.profesor == null) {
            if (studentTest == null) {
                if (this.student != null) {
                    this.student.setPersona(null);
                }
            } else {
                studentTest.setPersona(this);
            }
            this.student = studentTest;
        }
        else {
            throw new UnprocesableException("No puede haber un Estudiante que a la vez sea profesor");
        }
    }


    public void setProfesor(Profesor profesorTest) {
        if (this.student == null) {
            if (profesorTest == null) {
                if (this.profesor != null) {
                    this.profesor.setPersona(null);
                }
            } else {
                profesorTest.setPersona(this);
            }
            this.profesor = profesorTest;
        }
        else {
            throw new UnprocesableException("No puede haber un profesor que sea a la vez un alumno");
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id_persona=" + id_persona +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", company_email='" + company_email + '\'' +
                ", personal_email='" + personal_email + '\'' +
                ", city='" + city + '\'' +
                ", active=" + active +
                ", created_date=" + created_date +
                ", imagen_url='" + imagen_url + '\'' +
                ", termination_date=" + termination_date +
                '}';
    }
}