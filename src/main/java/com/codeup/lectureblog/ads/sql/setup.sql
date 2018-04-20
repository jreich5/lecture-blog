DROP DATABASE IF EXISTS spring_lec_db;

# Test if Hibernate creates a table based on entity mapping
USE spring_lec_db;
SHOW TABLES;
DESCRIBE ads;
DESCRIBE details;
DESCRIBE images;
DESCRIBE categories;
DESCRIBE ads_categories;
DESCRIBE categories_ads;

SELECT * FROM ads;
SELECT * FROM details;
SELECT * FROM ads_categories;
SELECT * FROM categories_ads;

# Populate details
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
INSERT INTO images (path, ad_id)
  VALUE ('/img/blender.jpeg', 1),
  ('/img/iphone.jpg', 2),
  ('/img/iphone2.png', 2),
  ('/img/webstorm.jpg', 3),
  ('/img/razor.jpg', 4);


# Populate categories
INSERT INTO categories (name)
VALUE ('funny'),
  ('expensive'),
  ('technology'),
  ('grooming'),
  ('trendy'),
  ('small');


# Populate ads_categories
INSERT INTO ads_categories (ad_id, category_id)
VALUES (1, 1),
  (1, 3),
  (2, 2),
  (2, 5),
  (3, 3),
  (4, 3),
  (4, 4),
  (4, 5);




