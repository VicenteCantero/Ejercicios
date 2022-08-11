package com.bosonit.BS22.services;

import com.bosonit.BS22.model.Ciudad;

import java.util.List;

public interface CiudadService {
List<Ciudad> getCiudades();
Ciudad añadirCiudad(Ciudad ciudad);
}
