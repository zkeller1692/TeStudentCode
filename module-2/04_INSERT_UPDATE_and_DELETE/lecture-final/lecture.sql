-- INSERT
 -- Add Disneyland to the park table.
-- (It was established on 7/17/1955, has an area of 2.1 square kilometers and does not offer camping.)

INSERT INTO PARK (
	PARK_NAME
--	,DATE_ESTABLISHED
	,AREA
	,HAS_CAMPING)
VALUES ('Disneyland', '19550717', 2.1, FALSE);


SELECT *
FROM PARK;

-- Add Hawkins, IN (with a population of 30,000 and an area of 38.1 square kilometers)
-- and Cicely, AK (with a popuation of 839 and an area of 11.4 square kilometers) to the city table.

INSERT INTO CITY (CITY_NAME,

														STATE_ABBREVIATION,
														POPULATION,
														AREA)
VALUES ('Hawkins', 'IN', 30000, 38.1)
					, ('Cicely', 'AK', 839, 11.4);

-- Since Disneyland is in California (CA), add a record representing that to the park_state table.

INSERT INTO PARK_STATE (PARK_ID,

														STATE_ABBREVIATION)
SELECT PARK_ID, 'CA'
FROM PARK
WHERE PARK_NAME = 'Disneyland';


INSERT INTO PARK_STATE (PARK_ID,

														STATE_ABBREVIATION)
VALUES ((SELECT PARK_ID FROM PARK WHERE PARK_NAME = 'Disneyland' LIMIT 1), 'CA')
SELECT *
FROM PARK_STATE
WHERE STATE_ABBREVIATION = 'CA';

-- UPDATE

-- Change the state nickname of California to "The Happiest Place on Earth."
UPDATE state
SET state_nickname = 'The Happiest Place on Earth'
WHERE state_abbreviation = 'CA';

SELECT *
FROM state
WHERE state_abbreviation = 'CA'
 
 -- Increase the population of California by 1,000,000.
UPDATE state
SET population = population + 1000000
WHERE state.state_abbreviation = 'CA';

SELECT *
FROM state
WHERE state.state_abbreviation = 'CA';

-- Change the capital of California to Anaheim.

UPDATE state
SET capital = (
	SELECT city_id
	FROM city
	WHERE city.city_name = 'Anaheim')
WHERE state_abbreviation = 'CA';

SELECT *
FROM state
WHERE state_abbreviation = 'CA';




-- Change California's nickname back to "The Golden State", 
-- reduce the population by 1,000,000, 
-- and change the capital back to Sacramento.

UPDATE state
SET 
	state_nickname = 'The Golden State',
	population = population - 1000000,
	capital = (
		SELECT city_id
		FROM city
		WHERE city.city_name = 'Sacramento'
			AND city.state_abbreviation = 'CA'
	)
WHERE state_abbreviation = 'CA';

SELECT city_id
FROM city
WHERE city.city_name = 'Sacramento'
	AND city.state_abbreviation = 'CA';
	
SELECT *
FROM state
WHERE state_abbreviation = 'CA';

 
 
 -- DELETE
-- Delete Hawkins, IN from the city table.

DELETE FROM city
WHERE city_name = 'Hawkins'
	AND state_abbreviation = 'IN';

SELECT *
FROM city
WHERE city_name = 'Hawkins'
	AND state_abbreviation = 'IN';
	
-- Delete all cities with a population of less than 1,000 people from the city table.

DELETE FROM city
WHERE population < 1000;

SELECT *
FROM city
WHERE population < 1000;

-- REFERENTIAL INTEGRITY
 -- Try adding a city to the city table with "XX" as the state abbreviation.
 INSERT INTO city (city_name, state_abbreviation, population, area)
 VALUES ('iantown', 'XX', 1, 10);
 
 -- Try deleting California from the state table.
 DELETE FROM state
 WHERE state_abbreviation = 'CA';
 
  -- Try deleting Disneyland from the park table. Try again after deleting its record from the park_state table.

DELETE FROM park_state
WHERE park_id = (
	SELECT park_id
	FROM park
	WHERE park_name = 'Disneyland'
)

DELETE FROM park
WHERE park_name = 'Disneyland';

-- CONSTRAINTS
 -- NOT NULL constraint
-- Try adding Smallville, KS to the city table without specifying its population or area.
INSERT INTO city (city_name, state_abbreviation)
VALUES ('Smallville', 'KS');

-- DEFAULT constraint
-- Try adding Smallville, KS again, specifying an area but not a population.
INSERT INTO city (city_name, state_abbreviation, area)
VALUES ('Smallville', 'KS', 12);

-- this won't work
INSERT INTO city (city_id, city_name, state_abbreviation, area, population)
VALUES (NEXTVAL('sequence'), 'Smallville', 'KS', 12, null);

-- DELETE FROM city
-- WHERE 1=1



SELECT *
FROM city
WHERE city_name='Smallville';

-- Retrieve the new record to confirm it has been given a default, non-null value for population.


-- UNIQUE constraint
-- Try changing California's nickname to "Vacationland" (which is already the nickname of Maine).

UPDATE state
SET state_nickname = 'Vacationland'
WHERE state_abbreviation = 'CA';


SELECT *
FROM state
WHERE state_abbreviation = 'CA';

-- CHECK constraint
-- Try changing the census region of Florida (FL) to "Southeast" (which is not a valid census region).
UPDATE state
SET census_region = 'Southeast'
WHERE state_abbreviation = 'FL';

SELECT *
FROM state
WHERE state_abbreviation = 'FL';

-- TRANSACTIONS
-- Delete the record for Smallville, KS within a transaction.

BEGIN TRANSACTION;

	DELETE FROM city
	WHERE city_name = 'Smallville';

--COMMIT
ROLLBACK


SELECT * 
FROM city
WHERE city_name = 'Smallville';


-- Delete all of the records from the park_state table, but then "undo" the deletion by rolling back the transaction.

-- Update all of the cities to be in the state of Texas (TX), but then roll back the transaction.

-- Demonstrate two different SQL connections trying to access the same table where one is inside of a transaction but hasn't committed yet.

