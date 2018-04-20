USE spring_lec_db;

SHOW TABLES;

DROP DATABASE IF EXISTS spring_lec_db;
DESCRIBE users;
DESCRIBE posts;

SELECT * FROM users;
SELECT * FROM posts;

TRUNCATE posts;

INSERT INTO users (username, email, password)
VALUES
  ('Bobby', 'bobby@email.com', 'getmein'),
  ('Stacy', 'stacy@email.com', 'getmein'),
  ('Fred', 'freddy@email.com', 'getmein'),
  ('Kyle', 'kyle@email.com', 'getmein');


INSERT INTO posts (title, body, user_id)
VALUES 
('Post Title 1', 'This is a test post for post 1', 1),
('Post Title 2', 'This is a test post for post 2', 2),
('Post Title 3', 'This is a test post for post 3', 3),
('Post Title 4', 'This is a test post for post 4', 4);
    
    

    

