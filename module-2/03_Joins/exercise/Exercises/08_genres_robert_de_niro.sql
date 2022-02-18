-- 8. The genres of movies that Robert De Niro has appeared in that were released in 2010 or later (6 rows)
SELECT DISTINCT
genre.genre_name
FROM
movie
JOIN movie_genre ON movie_genre.movie_id = movie.movie_id
JOIN genre ON genre.genre_id = movie_genre.genre_id
JOIN movie_actor ON movie_actor.movie_id = movie.movie_id
JOIN person ON person.person_id = movie_actor.actor_id
WHERE person.person_name = 'Robert De Niro' AND movie.release_date >= '20100101';

