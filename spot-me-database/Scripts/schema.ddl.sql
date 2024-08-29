DROP TABLE IF EXISTS t_spots;
DROP TABLE IF EXISTS t_categories;

CREATE TABLE t_categories(
   	id_category INT GENERATED ALWAYS AS IDENTITY,
   	category_name VARCHAR(100) NOT NULL,
   	CONSTRAINT t_categories_pkey PRIMARY KEY(id_category),
   	CONSTRAINT t_categories_ukey UNIQUE (category_name)
);

CREATE TABLE t_spots(
	id_spot INT GENERATED ALWAYS AS IDENTITY,
   	spot_name VARCHAR(200),
   	spot_lat DECIMAL(9,6),
   	spot_lng DECIMAL(9,6),
   	spot_desc VARCHAR(2000),
   	spot_img VARCHAR(60),
   	spot_category_id INT,
   	CONSTRAINT t_spots_pkey PRIMARY KEY (id_spot),
    CONSTRAINT t_spots_ukey UNIQUE (spot_name, spot_lat, spot_lng),
    CONSTRAINT t_spots_categories_fkey FOREIGN KEY(spot_category_id) 
    	REFERENCES t_categories(id_category)
);

SELECT * FROM t_spots ts;
SELECT * FROM t_categories tc;