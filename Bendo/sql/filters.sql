SELECT * FROM uni_university;


SELECT * FROM uni_location;


SELECT * FROM 
uni_university, uni_location 
WHERE uni_university.id_uni_location = uni_location.id_uni_location;



/*  Select university depending on country and state */
SELECT * FROM 
uni_university, uni_location 
WHERE uni_university.id_uni_location = uni_location.id_uni_location
AND ((uni_location.id_loc_country = 225 AND uni_location.id_loc_state = 1)
OR uni_location.id_loc_country = 42);