package com.bosonit.JV2.Persona.infrastructure.controller;

import com.bosonit.JV2.Persona.Domain.Persona;
import com.bosonit.JV2.Persona.application.PersonaService;
import com.bosonit.JV2.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.JV2.Persona.infrastructure.repository.PersonaRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = RequestMethod.GET)
public class GetController {

    @Autowired
    PersonaService personaService;

    @Autowired
    EntityManager em;


    @GetMapping("/getall")
    List<PersonaOutputDTO> getAllPersonas(@RequestParam(defaultValue = "simple", required = false) String outputType) throws Exception{
        return personaService.findAll(outputType);
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<PersonaOutputDTO> getbyId(@PathVariable int id, @RequestParam(defaultValue = "simple", required = false) String outputType) throws Exception {
        try{
           return personaService.findById(id);
        }catch(Exception e){
            throw new RuntimeException("No existe el id");
        }
    }

    @GetMapping("persona/usuario/{usuario}")
    public List<Object> damePersonaPorUsuario(@PathVariable (value= "usuario") String usuario, @RequestParam(defaultValue = "simple", required = false) String outputType) throws Exception {
        try{
            return personaService.findByUsuario(usuario);
        }catch(Exception e){
            System.out.println("No encontrado");
            return null;
        }
    }


//---DBA1
    public static final String GREATER_THAN="greater";
    public static final String LESS_THAN="less";
    public static final String EQUAL="equal";

    public static final String PorName="name";
    public static final String PorUsuario="usuario";

    @GetMapping("/get")
    public List<Persona> getData(
            @RequestParam(value="usuario",required=false) String usuario,
            @RequestParam(value="name",required=false) String name,
            @RequestParam(value="surname",required=false) String surname,
            @RequestParam(required=false) @DateTimeFormat(pattern="dd-MM-yyyy") Date created_date,
            @RequestParam(required=false) String dateCondition,
            @RequestParam(required=false) String ordenar,
            @RequestParam String pagina,
            @RequestParam(required=false, name="cantidad", defaultValue = "5") String cantidad)

    {
        HashMap<String, Object> data=new HashMap<>();

        if (usuario!=null)
            data.put("usuario",usuario);
        if (name!=null)
            data.put("name",name);
        if (surname!=null)
            data.put("surname",surname);
        if (dateCondition==null)
            dateCondition=GREATER_THAN;
        if (!dateCondition.equals(GREATER_THAN) && 	!dateCondition.equals(LESS_THAN) && !dateCondition.equals(EQUAL))
            dateCondition=GREATER_THAN;
        if (created_date!=null)
        {
            data.put("created",created_date);
            data.put("dateCondition",dateCondition);
        }
        if (ordenar!=null) {
            if (ordenar.equals(PorName)) {
                data.put("ordenar", ordenar);
            } else {
                ordenar = PorUsuario;
                data.put("ordenar", ordenar);
            }
        }
        if (cantidad!= null){
            data.put("cantidad", cantidad);
        }

        data.put("pagina", pagina);
        return personaService.getData(data);


    }



    //chuchi repositorio
    @GetMapping("/getQuery")
    public List<Persona> getDataQuery(@RequestParam(value="usuario",required=false) String usuario,
                                               @RequestParam(value="name",required=false) String name,
                                               @RequestParam(value="surname",required=false) String surname,
                                              @RequestParam(required=false) @DateTimeFormat(pattern="dd-MM-yyyy") Date created_date,@RequestParam(required=false) String dateCondition			)
    {
        HashMap<String, Object> data=new HashMap<>();


        String sql="select e from PERSONA e where 1=1";

        if (usuario!=null)
            sql+=" and e.usuario = :usuario";
        if (name!=null)
            sql+=" and e.name = :name";

        if (surname!=null)
            sql+=" and e.surname = :surname";
        String cond;
        if (dateCondition==null)
            dateCondition=GREATER_THAN;
        switch (dateCondition)
        {
            case GREATER_THAN:
                cond=">";
                break;
            case LESS_THAN:
                cond="<";
                break;
            default:
                cond="=";
        }

        if (created_date!=null)
            sql+=" and e.created "+cond+" :created_date";
        TypedQuery<Persona> query= em.createQuery(sql, Persona.class);
        if (usuario!=null)
            query.setParameter("usuario", usuario);
        if (name!=null)
            query.setParameter("name", name);

        if (surname!=null)
            query.setParameter("surname", surname);
        if (created_date!=null)
            query.setParameter("created_date", created_date);
        return query.getResultList();

    }
}
