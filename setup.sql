CREATE DATABASE IF NOT EXISTS spring_lec_db;

CREATE USER spring_lec_user@localhost IDENTIFIED BY 'getmein';

GRANT ALL ON spring_lec_db.* TO spring_lec_user@localhost;



