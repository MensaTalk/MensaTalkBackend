INSERT INTO chat_room (chat_room_id, name) VALUES ('1', 'Room 1');
INSERT INTO chat_room (chat_room_id, name) VALUES ('2', 'Room 2');
INSERT INTO chat_room (chat_room_id, name) VALUES ('3', 'Room 3');
INSERT INTO chat_room (chat_room_id, name) VALUES ('4', 'Room 4');

INSERT INTO app_user (app_user_id, username, password, age, interests, status) values ('1','dummyUser','pw','26','Sports, Coding, Food','Whats up ppl??');
INSERT INTO app_user (app_user_id, username, password, age, interests, status) values ('999','abteilung6','abteilung6','26','Sports, Coding, Food','Whats up ppl??');

INSERT INTO chat_message (chat_message_id, creation_date_time, text_message, chat_room_id, app_user_id) VALUES ('1', NOW() ,'first message room 1','1','1');
INSERT INTO chat_message (chat_message_id, creation_date_time, text_message, chat_room_id, app_user_id) VALUES ('2', NOW() , 'second message room 1','1','1');
INSERT INTO chat_message (chat_message_id, creation_date_time, text_message, chat_room_id, app_user_id) VALUES ('3', CURRENT_TIME , 'thid message room 1','1','1');

