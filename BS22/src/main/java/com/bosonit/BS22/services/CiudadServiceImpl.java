package com.bosonit.BS22.services;

import com.bosonit.BS22.model.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CiudadServiceImpl implements CiudadService{


    List<Ciudad> listaCiudades= new ArrayList<>();

    @Override
    public List<Ciudad> getCiudades() {
        return listaCiudades;
    }

    @Override
    public Ciudad añadirCiudad(Ciudad ciudad) {
        listaCiudades.add(ciudad);
        return ciudad;
    }


}
