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
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("北海道",43.06417,141.34694);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("青森県",40.82444,140.74);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("岩手県",39.70361,141.1525);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("宮城県",38.26889,140.87194);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("秋田県",39.71861,140.1025);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("山形県",38.24056,140.36333);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("福島県",37.75,140.46778);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("茨城県",36.34139,140.44667);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("栃木県",36.56583,139.88361);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("群馬県",36.39111,139.06083);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("埼玉県",35.85694,139.64889);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("千葉県",35.60472,140.12333);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("東京都",35.68944,139.69167);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("神奈川県",35.44778,139.6425);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("新潟県",37.90222,139.02361);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("富山県",36.69528,137.21139);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("石川県",36.59444,136.62556);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("福井県",36.06528,136.22194);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("山梨県",35.66389,138.56833);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("長野県",36.65139,138.18111);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("岐阜県",35.39111,136.72222);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("静岡県",34.97694,138.38306);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("愛知県",35.18028,136.90667);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("三重県",34.73028,136.50861);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("滋賀県",35.00444,135.86833);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("京都府",35.02139,135.75556);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("大阪府",34.68639,135.52);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("兵庫県",34.69139,135.18306);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("奈良県",34.68528,135.83278);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("和歌山県",34.22611,135.1675);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("鳥取県",35.50361,134.23833);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("島根県",35.47222,133.05056);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("岡山県",34.66167,133.935);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("広島県",34.39639,132.45944);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("山口県",34.18583,131.47139);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("徳島県",34.06583,134.55944);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("香川県",34.34028,134.04333);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("愛媛県",33.84167,132.76611);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("高知県",33.55972,133.53111);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("福岡県",33.60639,130.41806);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("佐賀県",33.24944,130.29889);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("長崎県",32.74472,129.87361);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("熊本県",32.78972,130.74167);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("大分県",33.23806,131.6125);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("宮崎県",31.91111,131.42389);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("鹿児島県",31.56028,130.55806);
INSERT IGNORE INTO areas (area_name,latitude,longitude)VALUES("沖縄県",26.2125,127.68111);
--以上Areaデータインサート文
