BEGIN TRANSACTION;
drop table if exists profile;
drop table if exists cafe_user;

CREATE TABLE cafe_user (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash varchar(120) NOT NULL,
	user_role varchar(20) DEFAULT 'ROLE_USER'
);

CREATE TABLE profile (
    profile_id SERIAL PRIMARY KEY,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	phone varchar(12) NOT NULL,
	address varchar(120) NOT NULL,
    user_id INT UNIQUE,
    FOREIGN KEY (user_id) REFERENCES cafe_user(user_id) ON DELETE CASCADE
);

COMMIT;
