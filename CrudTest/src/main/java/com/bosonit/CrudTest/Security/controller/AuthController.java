package com.bosonit.CrudTest.Security.controller;

import com.bosonit.CrudTest.Persona.infraestructure.dto.PersonaOutputDto;
import com.bosonit.CrudTest.Security.dto.JwtDto;
import com.bosonit.CrudTest.Security.dto.LoginUsuario;
import com.bosonit.CrudTest.Security.dto.NuevoUsuario;
import com.bosonit.CrudTest.Security.entity.Rol;
import com.bosonit.CrudTest.Security.entity.Usuario;
import com.bosonit.CrudTest.Security.entity.UsuarioPrincipal;
import com.bosonit.CrudTest.Security.enums.RolNombre;
import com.bosonit.CrudTest.Security.jwt.JwtProvider;
import com.bosonit.CrudTest.Security.service.RolService;
import com.bosonit.CrudTest.Security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo (@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(("Campos mal puestos"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(("Nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(("Email ya existe"), HttpStatus.BAD_REQUEST);
        Usuario usuario= new Usuario(
                nuevoUsuario.getNombre(),
                nuevoUsuario.getNombreUsuario(),
                nuevoUsuario.getEmail(),
                passwordEncoder.encode(nuevoUsuario.getPassword()));

        Set<Rol> roles= new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity<>(("Usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public List<Usuario> getAll(){
        return usuarioService.getall();
    }


}

// min 14
// https://www.youtube.com/watch?v=jX2tsI58j-c&list=PL4bT56Uw3S4z9rtwwGvuk1Mjhu5sdLSwX&index=6