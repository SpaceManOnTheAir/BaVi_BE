

INSERT INTO main_category(id, name,description) values
(1,'Foods','This is the food list'),
(2,'Drinks', 'This is the drink list')
;

INSERT INTO sub_category(id, name,main_category_id) values
(1,'Hot pot',1),
(2,'Main',1)
;

INSERT INTO _item(id, item_name,item_description,photos,item_price,sub_category_ID) values
(1,'Chao xa vit','Nothing','https://znews-photo.zadn.vn/w660/Uploaded/pgi_cuhpguvau/2019_05_27/vnc.jpg',80000,1)
;
INSERT INTO _item(id, item_name,item_description,photos,item_price,sub_category_ID) values
(2,'Tom nuong muoi ot','Tom nuong','https://cdn.netspace.edu.vn/2020/5/1/cach-lam-tom-nuong-muoi-ot-ai-cung-ghien-244947-800.jpg',20000,2)
;

INSERT INTO `_table` VALUES (1, 'Table 1', 23423);
INSERT INTO `_table` VALUES (2, 'Table 2', 972348);
INSERT INTO `_table` VALUES (3, 'Table 3', 209342);


--
--
--INSERT INTO (id, name,main_category_id) values
--(1,'Hot pot',1),
--(2,'Main',1)
--;
--
--
