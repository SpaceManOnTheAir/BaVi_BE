INSERT INTO main_category(id, name,description) values
(1,'Foods','This is the food list'),
(2,'Drinks', 'This is the drink list')
;

INSERT INTO sub_category(id, name,main_category_id) values
(1,'Appetizer',1),
(2,'Main',1),
(3, 'Dessert', 1),
(4, 'Alcohol', 2),
(5, 'Soft drinks', 2);


INSERT INTO _item(id, item_name,item_description,photos,item_price,sub_category_ID) values
(1, 'Angels on horseback', 'It consists of grilled (and sometimes skewered), bacon-wrapped oysters which are often drizzled with fresh lemon juice for extra flavor. 
The dish takes its poetic name after the visual appearance of curled bacon, which looks like angel wings.', 
'https://cdn.tasteatlas.com/images/dishes/8b65444f914747348dfe6be02ba9ad7d.jpg?w=905&h=510', 15, 1),
(2, 'Devils on horseback', 'Devils on horseback is a flavorful and juicy English appetizer that combines sweet and savory flavors. 
It consists of prunes wrapped in bacon, the whole concoction baked until there is a blissfull contrast of the sweet, 
almost melting prunes and crispy, salty bacon.',
'https://cdn.tasteatlas.com/Images/Dishes/7a4a08257e0a4c5bbdf43d1ee88ec4bf.jpg?w=905&h=510', 15, 1),
(3, 'Saffron Risotto', 'A signature dish is the simple but perfect saffron risotto with liquorice powder',
'https://www.elitetraveler.com/wp-content/uploads/2013/06/le-calandre-3648-saffron-risotto-close-up-1.jpg', 30, 2),
(4, 'Herb-Crusted Filet Mignon', 'Coat tender filet mignon steaks in a garlic-spiked herb mixture and marinate for a couple of hours before grilling.
Using dried herbs in the marinade creates a fabulous crust on the meat and makes for a simple preparation.',
'https://www.thespruceeats.com/thmb/IAiXV4rSt2ArMlPgS4imCYOou9g=/975x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/Herb-CrustedFiletMignon-JamesAndJames-Stockbyte-GettyImages-5c62eec5c9e77c0001d931d5.jpg', 40, 2),
(5, 'Petit Pois', 'You may enjoy tartlets of wild mushrooms with black truffles, or a signature dish of green peas in several different textures with poached egg.  You might finish with a rich but carefully balanced desert of chocolate mousse with lime and a chocolate fondant.',
'https://www.elitetraveler.com/wp-content/uploads/2013/06/guy-savoy-5472-petit-pois-1.jpeg', 10, 3),
(6, 'Chriesiauflauf', 'The signature dish of duck liver crème brulee with green apple sorbet has remarkable depth of flavour, but leave room for dessert, as Pic has one of the finest pastry sections in France. A striking arch of chocolate with citrus cream and cherry is just one example of the stunning desserts here',
'https://www.elitetraveler.com/wp-content/uploads/2017/12/pic-5472-cherry-dessert.jpg', 10, 3),
(7, 'Heineken', '#OpenYourWorld with Heineken', 'https://st2.depositphotos.com/2445635/5449/i/950/depositphotos_54497925-stock-photo-thailand-bangkok-july-3-heineken.jpg', 2, 4),
(8, 'Dom Perignon 1996', 'Best Dom Perignon that you can find in the world', 'https://cdn.webshopapp.com/shops/23807/files/48705990/dom-perignon-vintage-1996.jpg', 3000, 4),
(9, 'Coca cola', 'Authentic Coca Cola', 'https://cdn.tgdd.vn/Products/Images/2443/83757/bhx/nuoc-ngot-coca-cola-250ml-202006131605554035.jpg', 2, 5),
(10, 'Pepsi cola', 'Authentic Pepsi Cola', 'https://www.vegeta-chay.com/wp-content/uploads/2016/07/pepsi.jpg', 2,5),
(11, 'Hennessy XO', 'Hennessy XO for elegant wine drinkers', 'https://sanhruou.com/media/image/1078/ruou-hennessy-xo.jpg', 200, 4),
(12, '2014 RESERVE TO KALON VINEYARD CABERNET SAUVIGNON OAKVILLE NAPA VALLEY', 'The complexity, power and sophistication of fruit from our To Kalon site, considered a grand cru among Napa Valley vineyards, is on full display in this vineyard-designated Reserve, with sweet dark cherry and richly concentrated blackberry fruits, a savory, earthy complexity, and toasty oak, vanilla and spice which lingers through the luxuriously long finish.',
'https://cdn.klwines.com/images/skus/1331347x.jpg', 200, 4);

INSERT INTO _table VALUES (1, 'Table 1', 23423);
INSERT INTO _table VALUES (2, 'Table 2', 972348);
INSERT INTO _table VALUES (3, 'Table 3', 209342);
INSERT INTO _table VALUES (4, 'Table 4', 303030);
INSERT INTO _table VALUES (5, 'Table 5', 123456);
INSERT INTO _table VALUES (6, 'Table 6', 194823);

--INSERT INTO main_category(id, name,description) values
--(1,'Foods','This is the food list'),
--(2,'Drinks', 'This is the drink list')
--;
--
--INSERT INTO sub_category(id, name,main_category_id) values
--(1,'Hot pot',1),
--(2,'Main',1)
--;
--
--INSERT INTO _item(id, item_name,item_description,photos,item_price,sub_category_ID) values
--(1,'Chao xa vit','Nothing','https://znews-photo.zadn.vn/w660/Uploaded/pgi_cuhpguvau/2019_05_27/vnc.jpg',80000,1)
--;
--INSERT INTO _item(id, item_name,item_description,photos,item_price,sub_category_ID) values
--(2,'Tom nuong muoi ot','Tom nuong','https://cdn.netspace.edu.vn/2020/5/1/cach-lam-tom-nuong-muoi-ot-ai-cung-ghien-244947-800.jpg',20000,2)
--;
--
--INSERT INTO `_table` VALUES (1, 'Table 1', 23423);
--INSERT INTO `_table` VALUES (2, 'Table 2', 972348);
--INSERT INTO `_table` VALUES (3, 'Table 3', 209342);


--
--
--INSERT INTO (id, name,main_category_id) values
--(1,'Hot pot',1),
--(2,'Main',1)
--;
--
--
