
# Initial setup to create application database and user
CREATE DATABASE IF NOT EXISTS spring_lec_db;
CREATE USER spring_lec_user@localhost IDENTIFIED BY 'getmein';
GRANT ALL ON spring_lec_db.* TO spring_lec_user@localhost;


# Test if Hibernate creates a table based on entity mapping
USE spring_lec_db;
SHOW TABLES;
DESCRIBE ads;