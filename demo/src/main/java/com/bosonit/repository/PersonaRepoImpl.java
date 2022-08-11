package com.bosonit.repository;

import com.bosonit.DemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaRepoImpl implements IPersonaRepo{

    public static Logger LOG= LoggerFactory.getLogger(DemoApplication.class);

    @Override
    public void registrar (String nombre){
    LOG.info("Se registro a " + nombre);
    }

}
