package com.bosonit.CrudTest.Security.service;

import com.bosonit.CrudTest.Security.entity.Rol;
import com.bosonit.CrudTest.Security.enums.RolNombre;
import com.bosonit.CrudTest.Security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre (RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }
}

//https://www.youtube.com/watch?v=MWW8sFbq39c&list=PL4bT56Uw3S4z9rtwwGvuk1Mjhu5sdLSwX&index=4
