create database moviecruiser2;
use moviecruiser2;
CREATE TABLE IF NOT EXISTS moviecruiser2.user (
  us_id INT NOT NULL AUTO_INCREMENT,
  
  PRIMARY KEY (us_id))
ENGINE = InnoDB;
drop table moviecruiser2.user;

CREATE TABLE moviecruiser2.movie (
  mo_id int NOT NULL,
  mo_active bit(1) NOT NULL,
  mo_box_office varchar(255) DEFAULT NULL,
  mo_date_of_launch datetime DEFAULT NULL,
  mo_genre varchar(255) DEFAULT NULL,
  mo_has_teaser bit(1) NOT NULL,
  mo_title varchar(255) DEFAULT NULL,
  PRIMARY KEY (mo_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS moviecruiser2.favorites (
  fav_id INT NOT NULL AUTO_INCREMENT,
  mo_id INT NULL,
  fav_us_id INT NOT NULL,
  PRIMARY KEY (fav_id),
  INDEX mo_id (mo_id ASC),
  INDEX fav_us (fav_us_id ASC),
  CONSTRAINT mo_id
    FOREIGN KEY (mo_id)
    REFERENCES moviecruiser2.movie (mo_id),
  
  CONSTRAINT fav_us
    FOREIGN KEY (fav_us_id)
    REFERENCES moviecruiser2.user (us_id)
  
    )
ENGINE = InnoDB;

INSERT INTO movie VALUES (1,_binary '','$2,787,965,087','2017-03-15 00:00:00','Science Fiction',_binary '','Avatar'),(2,_binary '','$1,518,812,988','2017-12-23 00:00:00','Superhero',_binary '\0','The Avengers'),(3,_binary '','$2,187,463,944','2017-08-21 00:00:00','Romance',_binary '\0','Titanic'),(4,_binary '\0','$1,671,713,208','2017-07-02 00:00:00','Science Fiction',_binary '','Jurassic World'),(5,_binary '','$2,750,760,348','2022-11-02 00:00:00','Superhero',_binary '','Avengers: End Game');
select * from movie;
use moviecruiser;
insert into user(us_name) values("cust1");