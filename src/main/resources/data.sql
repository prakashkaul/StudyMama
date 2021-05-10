/*
-- Query: SELECT * FROM studymama.user
LIMIT 0, 1000

-- Date: 2021-05-10 17:54
*/
INSERT INTO `user` (`id`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`,`password`,`role`,`user_profile_id`,`username`) VALUES (1,'anonymousUser','2021-05-10 17:53:54.645000','anonymousUser','2021-05-10 17:53:54.645000','$2a$10$FRmhrJhcmtjfHBLlXaTST.RTlHxKTqWyUZY3WfgVgX/5qJ5.F0aVy','ROLE_USER',1,'user');
INSERT INTO `user` (`id`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`,`password`,`role`,`user_profile_id`,`username`) VALUES (2,'anonymousUser','2021-05-10 17:54:13.331000','anonymousUser','2021-05-10 17:54:13.331000','$2a$10$ivjNYZ8Ug/V7H1YufVgTluNl1m6BPEjyyXHBUlmFlQpsDOBdPPAcO','ROLE_USER',2,'prakash@kaul.com');
INSERT INTO `user` (`id`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`,`password`,`role`,`user_profile_id`,`username`) VALUES (3,'anonymousUser','2021-05-10 17:54:27.184000','anonymousUser','2021-05-10 17:54:27.184000','$2a$10$P8FxCU.1TrJNMhr4osOfquWPSI6g9MyNaW1bJFd6XAQ0K4gco2ziS','ROLE_ADMIN',3,'admin');

/*
-- Query: SELECT * FROM studymama.user_profile
LIMIT 0, 1000

-- Date: 2021-05-10 17:55
*/
INSERT INTO `user_profile` (`id`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`,`address`,`contact`,`first_name`,`last_name`) VALUES (1,'anonymousUser','2021-05-10 17:53:54.625000','anonymousUser','2021-05-10 17:53:54.625000',NULL,NULL,NULL,NULL);
INSERT INTO `user_profile` (`id`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`,`address`,`contact`,`first_name`,`last_name`) VALUES (2,'anonymousUser','2021-05-10 17:54:13.300000','anonymousUser','2021-05-10 17:54:13.300000',NULL,NULL,NULL,NULL);
INSERT INTO `user_profile` (`id`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`,`address`,`contact`,`first_name`,`last_name`) VALUES (3,'anonymousUser','2021-05-10 17:54:27.164000','anonymousUser','2021-05-10 17:54:27.164000',NULL,NULL,NULL,NULL);
