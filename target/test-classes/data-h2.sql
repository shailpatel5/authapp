CREATE TABLE users (
id BIGINT NOT NULL,
username VARCHAR(255),
password VARCHAR(255),
role VARCHAR(255),
PRIMARY KEY (id)
);

INSERT INTO users (id, username, password, role)
  VALUES (1, 'tyler', 'tyler1' ,'Administrator');
INSERT INTO users (id, username, password, role)
  VALUES (2, 'tyler', 'tyler2', 'Manager');
INSERT INTO users (id, username, password, role)
  VALUES (3, 'tyler', 'tyler3', 'User');
INSERT INTO users (id, username, password, role)
  VALUES (4, 'tyler', 'tyler4', 'Guest');