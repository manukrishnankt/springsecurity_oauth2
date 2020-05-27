INSERT INTO `spring_sec`.`user` (`user_id`,`enabled`,`password`,`username`) VALUES (1, 1, 'manu', 'manu');
INSERT INTO `spring_sec`.`user` (`user_id`,`enabled`,`password`,`username`) VALUES (2, 1, 'meera', 'meera');

INSERT INTO `spring_sec`.`authorities` (`authorities_id`, `authority`, `user_id`) VALUES (1, 'ROLE_ADMIN', 1);
INSERT INTO `spring_sec`.`authorities` (`authorities_id`, `authority`, `user_id`) VALUES (2, 'ROLE_USER', 2);