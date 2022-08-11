package com.bosonit.BP1.Profesor.domain;


import com.bosonit.BP1.Errores.UnprocesableException;
import com.bosonit.BP1.Estudiante.Domain.Student;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentInputDto;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoSimple;
import com.bosonit.BP1.Persona.Domain.Persona;
import com.bosonit.BP1.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.BP1.Profesor.infrastructure.controller.dto.ProfesorInputDto;
import com.bosonit.BP1.Profesor.infrastructure.controller.dto.ProfesorOutputDto;
import com.bosonit.BP1.Profesor.infrastructure.controller.dto.ProfesorOutputDtoFull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name= "Profesor")
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_profesor;

    @OneToOne
    @JoinColumn(name= "id_persona")
    private Persona persona;

    private String coments;

    private String branch;

    public Profesor(ProfesorInputDto profesorInputDto) {
        setComents(profesorInputDto.getComents());
        setBranch(profesorInputDto.getBranch());
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id_profesor=" + id_profesor +
                ", coments='" + coments + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }

    public void ProfesorInputDto(ProfesorInputDto profesorInputDto) {
        this.setComents(profesorInputDto.getComents());
        this.setBranch(profesorInputDto.getBranch());
    }

    public ProfesorOutputDto ProfesorOutputDto(Profesor profesor) {

        ProfesorOutputDto profesorOutputDto = new ProfesorOutputDto();
        profesorOutputDto.setId_profesor(this.getId_profesor());
        profesorOutputDto.setBranch(this.getBranch());
        profesorOutputDto.setComents(this.getComents());

        return profesorOutputDto;
    }

    public ProfesorOutputDtoFull ProfesorOutputDtoFull(Profesor profesor) {

        ProfesorOutputDtoFull profesorOutputDtoFull = new ProfesorOutputDtoFull();
        profesorOutputDtoFull.setId_profesor(this.getId_profesor());
        profesorOutputDtoFull.setBranch(this.getBranch());
        profesorOutputDtoFull.setComents(this.getComents());
        profesorOutputDtoFull.setPersona(this.getPersona());

        return profesorOutputDtoFull;
    }


    public void actualiza(ProfesorInputDto profesorInputDTO) throws Exception{
        try {
            if (profesorInputDTO.getComents() != null) {
                setComents(profesorInputDTO.getComents());
            }
            if (profesorInputDTO.getBranch() != null) {
                setBranch(profesorInputDTO.getBranch());
            }
        }catch (Exception e){
            throw new UnprocesableException("Campos erróneos");
        }
    }
}
