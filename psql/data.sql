-- Mild
INSERT INTO adverse_reactions (severity, reaction) VALUES('mild', 'dysgeusia');
INSERT INTO adverse_reactions (severity, reaction) VALUES('mild', 'gastroesophageal reflux');
INSERT INTO adverse_reactions (severity, reaction) VALUES('mild', 'xerostomia');

-- Moderate
INSERT INTO adverse_reactions (severity, reaction) VALUES('moderate', 'dysphagia');INSERT INTO adverse_reactions (severity, reaction) VALUES('moderate', 'esophagitis');
INSERT INTO adverse_reactions (severity, reaction) VALUES('moderate', 'glossitis');
INSERT INTO adverse_reactions (severity, reaction) VALUES('moderate', 'oral ulceration');
INSERT INTO adverse_reactions (severity, reaction) VALUES('moderate', 'pneumonitis');

-- Severe
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'bronchospasm');
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'esophageal stricture');
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'esophageal ulceration');
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'laryngeal edema');
INSERT INTO adverse_reactions (everity, reaction) VALUES('severe', 'laryngospasm');
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'tardive dyskinesia');

-- Medications
INSERT INTO medications (brand_name, has_reaction) VALUES('Haldol', true);
INSERT INTO medications (brand_name, has_reaction) VALUES('Pylera', true);
INSERT INTO medications (brand_name, has_reaction) VALUES('Fosamax', true);
INSERT INTO medications (brand_name, has_reaction) VALUES('Neurontin', true);
INSERT INTO medications (brand_name, has_reaction) VALUES('Gablofen', true);
INSERT INTO medications (brand_name, has_reaction) VALUES('Ditropan XL', true);
INSERT INTO medications (brand_name, has_reaction) VALUES('Coumadin', true);
INSERT INTO medications (brand_name, has_reaction) VALUES('Celexa', true);
INSERT INTO medications (brand_name, has_reaction) VALUES('Protonix', true);

-- Generics
INSERT INTO generics (generic_name, med_fk) VALUES('haloperidol', 1);
INSERT INTO generics (generic_name, med_fk) VALUES('bismuth subcitrate potassium', 2);INSERT INTO generics (generic_name, med_fk) VALUES('alendronate sodium', 3);
INSERT INTO generics (generic_name, med_fk) VALUES('gabapentin', 4);
INSERT INTO generics (generic_name, med_fk) VALUES('baclofen', 5);
INSERT INTO generics (generic_name, med_fk) VALUES('oxybutynin chloride', 7);
INSERT INTO generics (generic_name, med_fk) VALUES('warfarin sodium', 9);
INSERT INTO generics (generic_name, med_fk) VALUES('citalopram hydrobromide', 8);
INSERT INTO generics (generic_name, med_fk) VALUES('pantoprazole sodium', 9);

-- Users
INSERT INTO users (pseudo_name, age, date_of_eval, date_of_discharge, med_dx_icd, tx_dx_icd) VALUES('ClaireRF', 50, '01/01/21', '02/02/21', 'I69.391', 'R13.12');
INSERT INTO users (pseudo_name, age, date_of_eval, date_of_discharge, med_dx_icd, tx_dx_icd) VALUES('JamesMF', 47, '03/03/21', '04/04/21', 'G20', 'R13.12');
INSERT INTO users (pseudo_name, age, date_of_eval, date_of_discharge, med_dx_icd, tx_dx_icd) VALUES('BriannaRW', 31, '05/05/21', '06/06/21', 'G31.83', 'R13.11');
INSERT INTO users (pseudo_name, age, date_of_eval, date_of_discharge, med_dx_icd, tx_dx_icd) VALUES('RogerW', 39, '07/07/21', '08/08/21', 'K20.0', 'R13.14');

-- User Meds List
INSERT INTO user_meds_list (user_fk, med_fk) VALUES(1, 9);
INSERT INTO user_meds_list (user_fk, med_fk) VALUES(2, 8);
INSERT INTO user_meds_list (user_fk, med_fk) VALUES(2, 7);
INSERT INTO user_meds_list (user_fk, med_fk) VALUES(3, 1);
INSERT INTO user_meds_list (user_fk, med_fk) VALUES(3, 5);
INSERT INTO user_meds_list (user_fk, med_fk) VALUES(3, 4);
INSERT INTO user_meds_list (user_fk, med_fk) VALUES(3, 2);
INSERT INTO user_meds_list (user_fk, med_fk) VALUES(4, 3);

-- Med Adverse Reactions
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (1, 12);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (1, 9);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (1, 14);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (1, 1);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (1, 4);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (1, 13);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (2, 4);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (2, 1);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (2, 11);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (2, 5);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (2, 1);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (2, 6);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (3, 10);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (3, 4);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (3, 2);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (3, 7);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (3, 1);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (3, 5);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (3, 11);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (4, 3);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (5, 3);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (5, 9);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (6, 3);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (6, 4);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (6, 2);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (6, 1);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (6, 9);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (7, 1);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (8, 3);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (8, 2);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (8, 5);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (8, 9);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (8, 6);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (9, 3);
INSERT INTO med_adverse_reactions (med_fk, reaction_fk) VALUES (9, 1);