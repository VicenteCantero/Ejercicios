### Petición para insertar un registro
curl --location --request POST 'localhost:8085/persona' \
--header 'Content-Type: application/json' \
--data-raw '{    
"user": "Chuchi",
"password": "secreto",
"surname": "P",
"companyEmail": "cc@bosonit.com",
"personalEmail": "jj@gmail.com",
"city": "Logrono",
"imagenUrl": "http://imagenes.com/chuchi"
}'

### Petición para buscar un registro.