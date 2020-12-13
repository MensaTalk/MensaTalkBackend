INSERT INTO chat_room (chat_room_id, name) VALUES ('1', 'Room 1');
INSERT INTO chat_room (chat_room_id, name) VALUES ('2', 'Room 2');
INSERT INTO chat_room (chat_room_id, name) VALUES ('3', 'Room 3');
INSERT INTO chat_room (chat_room_id, name) VALUES ('4', 'Room 4');

INSERT INTO app_user (app_user_id, username, password) values ('1','dummyUser','pw');

INSERT INTO chat_message (chat_message_id, created_at, text_message, chat_room_id, app_user_id) VALUES ('1', current_timestamp ,'first message room 1','1','1');
INSERT INTO chat_message (chat_message_id, created_at, text_message, chat_room_id, app_user_id) VALUES ('2', current_timestamp , 'second message room 1','1','1');
INSERT INTO chat_message (chat_message_id, created_at, text_message, chat_room_id, app_user_id) VALUES ('3', current_timestamp , 'thid message room 1','1','1');

