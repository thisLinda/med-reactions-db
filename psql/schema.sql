-- CREATE DATABASE medication_db;
-- USE medication_db;

DROP TABLE IF EXISTS generics;
DROP TABLE IF EXISTS user_meds_list;
DROP TABLE IF EXISTS med_adverse_reactions;
DROP TABLE IF EXISTS adverse_reactions;
DROP TABLE IF EXISTS medications;
DROP TABLE IF EXISTS users;

CREATE TABLE adverse_reactions (
    reaction_pk SERIAL PRIMARY KEY,
    severity varchar(40) NOT NULL,
    reaction varchar(40) NOT NULL
);

CREATE TABLE medications (
    med_pk SERIAL PRIMARY KEY,
    brand_name varchar(40) NOT NULL,
    has_reaction boolean NOT NULL
);
    
CREATE TABLE users (
    user_pk SERIAL PRIMARY KEY,
    pseudo_name varchar(40) NOT NULL,
    age int NOT NULL,
    date_of_eval varchar(10) NOT NULL,
    date_of_discharge varchar(10),
    med_dx_icd varchar(20) NOT NULL,
    tx_dx_icd varchar(20) NOT NULL
);

CREATE TABLE med_adverse_reactions (
    med_adverse_reaction_pk SERIAL PRIMARY KEY,
    med_fk int NOT NULL,
    reaction_fk int NOT NULL,
    FOREIGN KEY (med_fk) REFERENCES medications,
    FOREIGN KEY (reaction_fk) REFERENCES adverse_reactions
);

CREATE TABLE user_meds_list (
    user_meds_list_pk SERIAL PRIMARY KEY,
    user_fk int NOT NULL,
    med_fk int NOT NULL,
    FOREIGN KEY (user_fk) REFERENCES users,
    FOREIGN KEY (med_fk) REFERENCES medications
);

CREATE TABLE generics (
	generic_pk SERIAL PRIMARY KEY,
	med_fk int NOT NULL,
	generic_name varchar(40),
	FOREIGN KEY (med_fk) REFERENCES medications
);