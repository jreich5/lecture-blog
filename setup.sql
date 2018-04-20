DROP DATABASE spring_lec_db;

# Test if Hibernate creates a table based on entity mapping
USE spring_lec_db;
SHOW TABLES;
DESCRIBE ads;
DESCRIBE details;
DESCRIBE images;
DESCRIBE categories;

SELECT * FROM ads;
SELECT * FROM details;

# Populate ad_details
INSERT INTO details (brand, avg_market_value)
VALUE ('Sears', 23.00),
  ('Apple', 999.00),
  ('Jet Brains', 129.00),
  ('Burma-Shave', 7.00);

# Populate ads table
INSERT INTO ads (title, description, details_id)
VALUES
  ("Blender", "This is an ad for a blender", 1),
  ("iPhone X", "This phone costs is too much money.", 2),
  ("WebStorm", "An IDE for Javascript.", 3),
  ("Razor", "A razor for every cowboy.", 4);




# Populate ad_images
INSERT INTO images (path)
  VALUE ('/img/blender.jpeg'),
  ('/img/iphone.jpg'),
  ('/img/iphone2.png'),
  ('/img/razor.jpg'),
  ('/img/webstorm.jpg');


# Populate ad_categories
INSERT INTO categories (name)
VALUE ('funny'),
  ('expensive'),
  ('technology'),
  ('grooming'),
  ('trendy'),
  ('small');
