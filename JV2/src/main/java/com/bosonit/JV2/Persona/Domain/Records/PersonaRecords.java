package com.bosonit.JV2.Persona.Domain.Records;

import java.util.Date;

public record PersonaRecords (
        String usuario,
        String password,
        String name,
        String surname,
        String company_email,
        String personal_email,
        String city,
        Boolean active,
        Date created_date,
        String imagen_url,
        Date termination_date){
}
