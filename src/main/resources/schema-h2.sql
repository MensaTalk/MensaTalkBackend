DROP TABLE if exists chat_rooms;
CREATE TABLE chat_rooms(
  chat_room_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  chatroom VARCHAR(250)
)

--DROP TABLE if exists `chat_messages`;
--CREATE TABLE `chat_messages`(
--  `chat_messages_id` int(11) unsigned AUTO_INCREMENT  PRIMARY KEY(`chat_messages_id`),
--  `message` VARCHAR(250)
--);
--
--DROP TABLE if exists `chat_users`;
--CREATE TABLE `chat_users` (
--  `chat_users_id` int(11) unsigned AUTO_INCREMENT  PRIMARY KEY(`chat_users_id`),
--  name VARCHAR(250) NOT NULL,
--  chatroom VARCHAR(250)
--);

