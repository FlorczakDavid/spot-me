SELECT * FROM t_spots ts ;

INSERT INTO t_spots (spot_desc, spot_lat, spot_lng, spot_name) 
VALUES ('test_desk_a', 12, 34, 'test_name_a');
    

    select
        s1_0.id_spot,
        s1_0.spot_desc,
        s1_0.spot_img,
        s1_0.spot_lat,
        s1_0.spot_lng,
        s1_0.spot_name 
    from
        t_spots s1_0 
    where
        s1_0.spot_name='testName16' 
        and s1_0.spot_lng=56.78
        and s1_0.spot_lat=12.34;
        
DELETE FROM t_spots ;