-- 11. The titles of the movies in the "Star Wars Collection" ordered by release date, most recent to earliest (9 rows)
SELECT
movie.title
FROM
movie
JOIN collection ON collection.collection_id = movie.collection_id
WHERE collection.collection_name = 'Star Wars Collection'
ORDER BY movie.release_date DESC;
