	-- remove the user from MySQL and readd the user
DROP USER IF EXISTS 'youtunes_user'@'localhost';

CREATE USER 'youtunes_user'@'localhost' IDENTIFIED BY 'youtunespass'; 

--give the youtunes_user privileges
GRANT ALL PRIVILEGES ON * . * TO'youtunes_user'@'localhost';

--remove foreign key to be allowed to remove tables
ALTER TABLE album DROP FOREIGN KEY fk_artist;

--remove tables for a clean slate
DROP TABLE IF EXISTS artist;
DROP TABLE IF EXISTS album;

--create tables
CREATE TABLE artist (
	artist_id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	PRIMARY KEY(artist_id)
);

CREATE TABLE album (
	album_id INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(100) NOT NULL,
	price DECIMAL(5, 2) NOT NULL,
	genre VARCHAR(50) NOT NULL,
	img_url VARCHAR(100) NOT NULL,
	artist_id INT NOT NULL,
	PRIMARY KEY(album_id),
	CONSTRAINT fk_artist FOREIGN KEY(artist_id) REFERENCES artist(artist_id)
);

--insert statements
--insert statements for artist table
INSERT INTO artist(first_name, last_name) VALUES('John', 'Mayer');
INSERT INTO artist(first_name, last_name) VALUES('Andy', 'Grammer');
INSERT INTO artist(first_name, last_name) VALUES('Ariana', 'Grande');
INSERT INTO artist(first_name, last_name) VALUES('Marshall', 'Mathers');
INSERT INTO artist(first_name, last_name) VALUES('Dolly', 'Parton');
INSERT INTO artist(first_name, last_name) VALUES('Chris', 'Cagle');

--insert statements for album table
INSERT INTO album(title, price, genre, img_url, artist_id) VALUES('Room for Squares', 24.99, 'Rock', 'RoomForSquares.jpeg', (SELECT artist_id FROM artist WHERE last_name = 'Mayer'));
INSERT INTO album(title, price, genre, img_url, artist_id) VALUES('Sob Rock', 24.99, 'Pop', 'SobRock.jpg', (SELECT artist_id FROM artist WHERE last_name = 'Mayer'));
INSERT INTO album(title, price, genre, img_url, artist_id) VALUES('Magazines or Novels', 30.99, 'Pop', 'MagazinesOrNovels.jpg', (SELECT artist_id FROM artist WHERE last_name = 'Grammer'));
INSERT INTO album(title, price, genre, img_url, artist_id) VALUES('thank u, next', 35.99, 'Pop', 'thankunext.png', (SELECT artist_id FROM artist WHERE last_name = 'Grande'));
INSERT INTO album(title, price, genre, img_url, artist_id) VALUES('Music To Be Murdered By', 32.99, 'Rap', 'MusicToBeMurderedBy.jpeg', (SELECT artist_id FROM artist WHERE last_name = 'Mathers'));
INSERT INTO album(title, price, genre, img_url, artist_id) VALUES('Kamikaze', 34.99, 'Rap', 'Kamikaze.jpeg', (SELECT artist_id FROM artist WHERE last_name = 'Mathers'));
INSERT INTO album(title, price, genre, img_url, artist_id) VALUES('A Holly Dolly Christmas', 29.99, 'Holiday', 'AHollyDollyChristmas.jpg', (SELECT artist_id FROM artist WHERE last_name = 'Parton'));
INSERT INTO album(title, price, genre, img_url, artist_id) VALUES('Anywhere But Here', 20.99, 'Country', 'AnywhereButHere.jpeg', (SELECT artist_id FROM artist WHERE last_name = 'Cagle'));
	
	
	
	
	
	
	
	
	
	
	
	
