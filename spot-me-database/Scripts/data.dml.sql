DELETE FROM t_spots;

INSERT INTO t_spots (spot_name, spot_lat, spot_lng, spot_desc) VALUES
	('celtic clover', 48.86328976481655, 2.3482775111142575, 'un bar a guiness a chatelet'),
	('The 1/3rd coffee bar', 35.70252709088118, 139.77220392300111, 'un bar a tokyo');
	
SELECT * FROM t_spots ts ;