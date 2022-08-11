CREATE TABLE PERSONA (
id_persona int IDENTITY,
usuario VARCHAR(64),
password VARCHAR(64),
name VARCHAR(64),
surname VARCHAR(64),
company_email VARCHAR(64),
personal_email VARCHAR(64),
city VARCHAR(64),
active int,
created_date DATE,
imagen_url VARCHAR(64),
termination_date DATE
)