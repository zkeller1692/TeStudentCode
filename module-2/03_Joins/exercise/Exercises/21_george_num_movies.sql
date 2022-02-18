-- 21. For every person in the person table with the first name of "George", list the number of movies they've been in--include all Georges, even those that have not appeared in any movies. Display the names in alphabetical order. (59 rows)
-- Name the count column 'num_of_movies'
SELECT 
person_name
, count (movie.title) AS num_of_movies
FROM person
LEFT JOIN movie_actor ON movie_actor.actor_id = person.person_id
LEFT OUTER JOIN movie ON movie.movie_id = movie_actor.movie_id
WHERE 
person_name LIKE 'George %'
GROUP BY actor_id, person_name
ORDER BY person_name;
