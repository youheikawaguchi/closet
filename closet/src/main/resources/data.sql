INSERT IGNORE INTO category (category_id,category_name)
VALUES(1,"トップス"),(2,"ボトムス"),(3,"トップス"),(4,"ワンピース"),(5,"小物");
INSERT IGNORE INTO sub_category (sub_category_id,category_id,subcategory_name)
VALUES(1,1,"シャツ/ブラウス/カットソー"),(2,1,"ニット"),(3,1,"パーカー/スウェット"),(4,2,"ジャケット"),(5,2,"コート"),(6,2,"ブルゾン"),(7,3,"パンツ"),(8,3,"スカート"),(9,4,"ワンピース"),(10,4,"サロペット"),(11,4,"オールインワン"),(12,5,"帽子"),(13,5,"バッグ"),(14,5,"シューズ");
INSERT IGNORE INTO users (id,user_id,password,gender,born_year,admin_key,area_id)
    VALUES(0,'IKEDA','aaaaaaaa','女',19940419,0,3);
INSERT IGNORE INTO users (id,user_id,password,gender,born_year,admin_key,area_id)
    VALUES(1,'YAMAMOTO','aaaaa','男',19960806,1,1996);
INSERT IGNORE INTO items (item_id,category_id,sub_category_id,season_id,color_id,id,picture,comment,created_at,updated_at)
    VALUES(1,1,1,1,1,1, 'picture',"メモ","2019-06-17", "2019-06-17");
INSERT IGNORE INTO calender (calender_id,id,coordinate_id,event,event_date,met_person)
    VALUES(1, 1, 1,'event', "2019-06-17", met_person);
INSERT IGNORE INTO coordinate (coordinate_id,id,coordinate_title,comment,created_at,updated_at)
    VALUES(1, 1,'title', "coment", "2019-06-17", "2019-06-17");
INSERT IGNORE INTO coordinate_choice (coordinate_id,item_id)
    VALUES(1,1);
INSERT IGNORE INTO season (season_id,season_name) VALUES(1,"春"),(2,"夏"),(3,"秋"),(4,"冬"),(5,"春夏"),(6,"秋冬"),(7,"ALL SEASON");
INSERT IGNORE INTO color (color_id,color_name)
VALUES(1,"ホワイト"),(2,"ブラック"),(3,"グレー"),(4,"ブラウン"),(5,"ベージュ"),(6,"グリーン"),(7,"ブルー"),(8,"パープル"),(9,"イエロー"),(10,"ピンク"),(11,"レッド"),(12,"オレンジ"),(13,"シルバー"),(14,"ゴールド"),(15,"その他");

--以下Areaデータインサート文
--VARUES(都道府県、県庁所在地の緯度、県庁所在地の経度);となっています.idは自動連番になっています
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("北海道",43.058854,141.352844);

--以上Areaテータインサート文
