-- ---
-- Table 'USERS'
-- ユーザマスタ初期データ
-- ---
INSERT INTO users (username, encoded_password, firstname, lastname, mail, last_login_on, created_on, updated_on) 
VALUES (
    'user1', /*username*/
    '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i', /*demo*/
    'Taro', /*firstname*/
    'Demo', /*lastname*/
    'user1@test.co.jp', /*mail*/
    current_timestamp,
    current_timestamp,
    current_timestamp
    );
INSERT INTO users (username, encoded_password, firstname, lastname, mail, last_login_on, created_on, updated_on) 
VALUES (
    'user2',  /*username*/
    '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i', /*demo*/
    'Jiro', /*firstname*/
    'Demo', /*lastname*/
    'user2@test.co.jp', /*mail*/
    current_timestamp,
    current_timestamp,
    current_timestamp
    );

