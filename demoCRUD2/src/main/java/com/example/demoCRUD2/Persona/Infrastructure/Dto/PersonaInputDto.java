package com.example.demoCRUD2.Persona.Infrastructure.Dto;

import java.util.Date;

public record PersonaInputDto(String user,
                              String password,
                              String surname,
                              String companyEmail,
                              String personalEmail,
                              String city,
                              Boolean active,
                              Date createdDate,
                              String imagenUrl,
                              Date terminationDate) {
}
