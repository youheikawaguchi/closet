INSERT IGNORE INTO category (category_id,category_name)
VALUES(1,"トップス"),(2,"アウター"),(3,"ボトムス"),(4,"ワンピース"),(5,"小物");
INSERT IGNORE INTO sub_category (sub_category_id,category_id,subcategory_name)
VALUES(1,1,"シャツ/ブラウス/カットソー"),(2,1,"ニット"),(3,1,"パーカー/スウェット"),(4,2,"ジャケット"),(5,2,"コート"),(6,2,"ブルゾン"),(7,3,"パンツ"),(8,3,"スカート"),(9,4,"ワンピース"),(10,4,"サロペット"),(11,4,"オールインワン"),(12,5,"帽子"),(13,5,"バッグ"),(14,5,"シューズ");
INSERT IGNORE INTO users (user_id,password,gender,born_year,admin_key,area_id)
    VALUES('IKEDA','4bd854ce541bb5c459f10a1a107d27eeee9d59354021b294b1d81dddb6440966277fde101a6d9ee6','女',1994,0,3);
INSERT IGNORE INTO users (user_id,password,gender,born_year,admin_key,area_id)
    VALUES('YAMAMOTO','4bd854ce541bb5c459f10a1a107d27eeee9d59354021b294b1d81dddb6440966277fde101a6d9ee6','男',1996,1,1);
    INSERT IGNORE INTO users (user_id,password,gender,born_year,admin_key,area_id)
        VALUES('testid','7579e8efa01e16c0370163b62af00864817adc4b3a76eb67444fb9dd6034ef9f8cc16d43106fc5a3','男',1996,12,15);
update users set area_id = 13 where id = 3;
INSERT IGNORE INTO items (item_id,category_id,sub_category_id,season_id,color_id,id,picture,comment)
    VALUES(1,1,1,1,1,1, 'picture',"メモ");
INSERT IGNORE INTO calendar (calendar_id,id,coordinate_id,event,event_date,met_person)
    VALUES(1, 1, 1,'event', "2019-06-17", "met_person");
INSERT IGNORE INTO coordinate (coordinate_id,id,coordinate_title,comment,created_at,updated_at,have_calendar)
    VALUES(1, 1,'title', "coment", "2019-06-17", "2019-06-17",1);
INSERT IGNORE INTO season (season_id,season_name) VALUES(1,"春"),(2,"夏"),(3,"秋"),(4,"冬"),(5,"春夏"),(6,"秋冬"),(7,"ALL SEASON");
INSERT IGNORE INTO color (color_id,color_name)
VALUES(1,"ホワイト"),(2,"ブラック"),(3,"グレー"),(4,"ブラウン"),(5,"ベージュ"),(6,"グリーン"),(7,"ブルー"),(8,"パープル"),(9,"イエロー"),(10,"ピンク"),(11,"レッド"),(12,"オレンジ"),(13,"シルバー"),(14,"ゴールド"),(15,"その他");

-- 以下Areaデータインサート文
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(1,"北海道",43.06417,141.34694);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(2,"青森県",40.82444,140.74);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(3,"岩手県",39.70361,141.1525);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(4,"宮城県",38.26889,140.87194);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(5,"秋田県",39.71861,140.1025);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(6,"山形県",38.24056,140.36333);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(7,"福島県",37.75,140.46778);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(8,"茨城県",36.34139,140.44667);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(9,"栃木県",36.56583,139.88361);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(10,"群馬県",36.39111,139.06083);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(11,"埼玉県",35.85694,139.64889);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(12,"千葉県",35.60472,140.12333);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(13,"東京都",35.68944,139.69167);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(14,"神奈川県",35.44778,139.6425);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(15,"新潟県",37.90222,139.02361);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(16,"富山県",36.69528,137.21139);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(17,"石川県",36.59444,136.62556);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(18,"福井県",36.06528,136.22194);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(19,"山梨県",35.66389,138.56833);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(20,"長野県",36.65139,138.18111);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(21,"岐阜県",35.39111,136.72222);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(22,"静岡県",34.97694,138.38306);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(23,"愛知県",35.18028,136.90667);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(24,"三重県",34.73028,136.50861);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(25,"滋賀県",35.00444,135.86833);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(26,"京都府",35.02139,135.75556);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(27,"大阪府",34.68639,135.52);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(28,"兵庫県",34.69139,135.18306);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(29,"奈良県",34.68528,135.83278);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(30,"和歌山県",34.22611,135.1675);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(31,"鳥取県",35.50361,134.23833);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(32,"島根県",35.47222,133.05056);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(33,"岡山県",34.66167,133.935);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(34,"広島県",34.39639,132.45944);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(35,"山口県",34.18583,131.47139);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(36,"徳島県",34.06583,134.55944);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(37,"香川県",34.34028,134.04333);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(38,"愛媛県",33.84167,132.76611);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(39,"高知県",33.55972,133.53111);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(40,"福岡県",33.60639,130.41806);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(41,"佐賀県",33.24944,130.29889);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(42,"長崎県",32.74472,129.87361);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(43,"熊本県",32.78972,130.74167);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(44,"大分県",33.23806,131.6125);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(45,"宮崎県",31.91111,131.42389);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(46,"鹿児島県",31.56028,130.55806);
INSERT IGNORE INTO areas (area_id,area_name,latitude,longitude)VALUES(47,"沖縄県",26.2125,127.68111);
-- 以上Areaデータインサート文
