package com.example.demoCRUD2.Persona.Aplication;

import com.example.demoCRUD2.Persona.Domain.Persona;
import com.example.demoCRUD2.Persona.Infrastructure.Dto.PersonaInputDto;
import com.example.demoCRUD2.Persona.Infrastructure.Dto.PersonaOutputDto;
import com.example.demoCRUD2.Persona.Infrastructure.Repository.PersonaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaRepository repository;

    @Override
    public List<PersonaOutputDto> findAll() {
        List<PersonaOutputDto> personas;
        personas = repository.findAll().stream().map(p -> new PersonaOutputDto(p)).collect(Collectors.toList());
        return personas;
    }

    @Override
    public PersonaOutputDto findById(int id)throws Exception{
        Persona p=repository.findById(id).orElseThrow(() -> new Exception("Persona con id: " + id + "no encontrada."));
        PersonaOutputDto persOutputDto=new PersonaOutputDto(p);
        return persOutputDto;
    }
    @Override
    public List<PersonaOutputDto> findByUser(String user)throws Exception{
        List<PersonaOutputDto> personas;
        personas = repository.findByUser(user).stream().map(p -> new PersonaOutputDto(p)).collect(Collectors.toList());
        return personas;
    }
    @Override
    public PersonaOutputDto save(PersonaInputDto personaInputDto) throws Exception{

        personaValida(personaInputDto);
        Persona persona = new Persona(personaInputDto);
        persona.setActive(true);
        persona.setCreatedDate(new Date());
        repository.save(persona);
        PersonaOutputDto persOutputDto=new PersonaOutputDto(persona);
        return persOutputDto;
    }

    public void personaValida(PersonaInputDto personaInputDto) throws Exception{
        boolean esValida=true;
        String mensaje="";
        if (! userValido(personaInputDto.user())){
            mensaje="La longitud del campo 'user' debe estar entre 6 y 10 caracteres";
        }

        if (!emailValido(personaInputDto.companyEmail())){
            mensaje += "Tu company email no es valido\n";
        }

        if (!emailValido(personaInputDto.personalEmail())){
            mensaje = "Tu personal email no es valido\n";
        }
        if (! mensaje.isEmpty())
            throw new Exception(mensaje);
    }

    public boolean userValido(String user){
        if (user.length()<6 || user.length()>10) {
            return false;
        }else return true;
    }

    public boolean emailValido(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

}
