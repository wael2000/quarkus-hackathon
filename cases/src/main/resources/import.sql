INSERT INTO medicalcase(id, description,symptoms,date,patientName,patientDOB,patientGender,patientNationality,physician,username) VALUES (1, 'permenant headache','headache, red eye, cough, sneezing',DATE '2020-05-1','Ivar ragnerson',DATE '1990-05-1','Male','Scotch','5eedc4da73cbdf5d69338b01','alice');
INSERT INTO report (id,medicalcase_id,type) VALUES (1,1,'x-ray');
INSERT INTO report (id,medicalcase_id,type) VALUES (2,1,'MRI');

INSERT INTO medicalcase(id, description,symptoms,date,patientName,patientDOB,patientGender,patientNationality,physician,username) VALUES (2,'Stomach pain','diarrhea, Gas',DATE '2020-06-1','Jorge eznar',DATE '1975-05-1','Male','Irish','5eedc4da73cbdf5d69338b01','alice');
INSERT INTO report (id,medicalcase_id,type) VALUES (3,2,'Blood Test');
INSERT INTO report (id,medicalcase_id,type) VALUES (4,2,'MRI');


INSERT INTO medicalcase(id, description,symptoms,date,patientName,patientDOB,patientGender,patientNationality,physician,username) VALUES (3,'Stomach pain','pain, headache',DATE '2020-06-4','basma ameen',DATE '1982-05-1','Female','Egyptian','5eedfcc651a9cc4f4cd52223','alice');
INSERT INTO report (id,medicalcase_id,type) VALUES (5,3,'Blood Test');
INSERT INTO report (id,medicalcase_id,type) VALUES (6,3,'MRI');