DROP TABLE IF EXISTS event_member;
DROP TABLE IF EXISTS event_table;
DROP TABLE IF EXISTS group_member;
DROP TABLE IF EXISTS member_table;
DROP TABLE IF EXISTS group_table;

CREATE TABLE member_table (
	member_id SERIAL NOT NULL PRIMARY KEY,
	first_name VARCHAR(25) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	email_address VARCHAR(55) NOT NULL,
	birthday TIMESTAMP NOT NULL,
	wants_reminder BOOLEAN NOT NULL
);

CREATE TABLE group_table (
	group_id SERIAL NOT NULL PRIMARY KEY,
	group_name VARCHAR(40) NOT NULL
);

CREATE TABLE group_member(
	group_id SERIAL NOT NULL CONSTRAINT fk_group REFERENCES group_table(group_id),
	member_id SERIAL NOT NULL CONSTRAINT fk_member REFERENCES member_table(member_id),
	CONSTRAINT pk_group_member PRIMARY KEY(group_id, member_id)
);

CREATE TABLE event_table (
	event_id SERIAL NOT NULL PRIMARY KEY,
	event_name VARCHAR(100) NOT NULL,
	description VARCHAR(500) NOT NULL,
	duration_in_minutes INT NOT NULL,
	start_date TIMESTAMP NOT NULL,
	group_id SERIAL NOT NULL CONSTRAINT fk_group REFERENCES group_table(group_id)
);

CREATE TABLE event_member(
	event_id SERIAL NOT NULL CONSTRAINT fk_event REFERENCES event_table(event_id),
	member_id SERIAL NOT NULL CONSTRAINT fk_member REFERENCES member_table(member_id),
	CONSTRAINT pk_event_member PRIMARY KEY (event_id, member_id)
);


INSERT INTO member_table(first_name, last_name, email_address, birthday, wants_reminder)
VALUES ('Zach', 'Keller', 'zachkeller@gmail.com', '19920616', false),
		('Alex', 'Keller', 'alexkeller@gmail.com', '19980730', true),
		('Greg', 'Bumble', 'gregbumble@gmail.com', '19531210', false),
		('Roland', 'Potski', 'iamposki@yahoo.com', '20000101', true),
		('Christopher', 'Lendow', 'thisischris@gmail.com', '20011205', false),
		('Bruce', 'Moose', 'bruethemoose@gmail.com', '19630718', false),
		('Carol', 'Baskins', 'ilovetigers@hotmail.com', '19740801', true),
		('Patty', 'Fenwick', 'pattyfenwick@gmail.com', '19991111', false);
		
INSERT INTO group_table(group_name)
VALUES ('The Anti-group group'),
	   ('Dads for dogs'),
	   ('The Weird Al Fan Club');
	   
INSERT INTO event_table(event_name, description, duration_in_minutes, start_date, group_id)
VALUES ('Adopt-a-dog-athon', 'Adopt a fun puppy!', 480, '20220101 12:00', (SELECT group_id FROM group_table WHERE group_name = 'Dads for dogs')),
	('The Anti-group group Annual anti-gathering Gathering!', 'Lets meet up to discuss how much we do not like meeting up.', 30, '20220222 6:00', (SELECT group_id FROM group_table WHERE group_name = 'The Anti-group group')),
      ('Weird Al listenting Party', 'Lets rock out to Weird Al!', 120, '20240920 15:00', (SELECT group_id FROM group_table WHERE group_name = 'The Weird Al Fan Club')),
	  ('The Dads for dogs dog show', 'May the best dad and dog win!', 630, '20230205 21:00', (SELECT group_id FROM group_table WHERE group_name = 'Dads for dogs'));

INSERT INTO group_member (group_id, member_id)
VALUES ((SELECT group_id FROM group_table WHERE group_name = 'Dads for dogs'), (SELECT member_id FROM member_table WHERE first_name = 'Greg' AND last_name = 'Bumble')),
		((SELECT group_id FROM group_table WHERE group_name = 'The Weird Al Fan Club'), (SELECT member_id FROM member_table WHERE first_name = 'Zach' AND last_name = 'Keller')),
		((SELECT group_id FROM group_table WHERE group_name = 'The Anti-group group'), (SELECT member_id FROM member_table WHERE first_name = 'Christopher' AND last_name = 'Lendow')),
		((SELECT group_id FROM group_table WHERE group_name = 'Dads for dogs'), (SELECT member_id FROM member_table WHERE first_name = 'Roland' AND last_name = 'Potski')),
		((SELECT group_id FROM group_table WHERE group_name = 'The Weird Al Fan Club'), (SELECT member_id FROM member_table WHERE first_name = 'Patty' AND last_name = 'Fenwick')),
		((SELECT group_id FROM group_table WHERE group_name = 'The Anti-group group'), (SELECT member_id FROM member_table WHERE first_name = 'Alex' AND last_name = 'Keller'));
		
INSERT INTO event_member (event_id, member_id)
VALUES ((SELECT event_id FROM event_table WHERE event_name = 'The Dads for dogs dog show'), (SELECT member_id FROM member_table WHERE first_name = 'Greg' AND last_name = 'Bumble')),
		((SELECT event_id FROM event_table WHERE event_name = 'Adopt-a-dog-athon'), (SELECT member_id FROM member_table WHERE first_name = 'Alex' AND last_name = 'Keller')),
		((SELECT event_id FROM event_table WHERE event_name = 'The Anti-group group Annual anti-gathering Gathering!'), (SELECT member_id FROM member_table WHERE first_name = 'Carol' AND last_name = 'Baskins')),
		((SELECT event_id FROM event_table WHERE event_name = 'Weird Al listenting Party'), (SELECT member_id FROM member_table WHERE first_name = 'Bruce' AND last_name = 'Moose'));



		