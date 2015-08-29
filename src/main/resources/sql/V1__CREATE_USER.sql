CREATE TABLE users (
	id INT NOT NULL AUTO_INCREMENT,
	email VARCHAR(80) NOT NULL,
	encrypted_password VARCHAR(40) NOT NULL,
	PRIMARY KEY (id, email)
) ENGINE INNODB;

CREATE INDEX idx_users_email ON users(email);
