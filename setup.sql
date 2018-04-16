
# Initial setup to create application database and user
CREATE DATABASE IF NOT EXISTS spring_lec_db;
CREATE USER spring_lec_user@localhost IDENTIFIED BY 'getmein';
GRANT ALL ON spring_lec_db.* TO spring_lec_user@localhost;


# Test if Hibernate creates a table based on entity mapping
USE spring_lec_db;
SHOW TABLES;
DESCRIBE ads;



# Populate ads table
INSERT INTO ads (title, description)
VALUES
  ("Test Ad 1", "An ad about the number 1"),
  ("Test Ad 2", "An ad about the number 2"),
  ("Test Ad 3", "An ad about the number 3"),
  ("Test Ad 4", "An ad about the number 4");