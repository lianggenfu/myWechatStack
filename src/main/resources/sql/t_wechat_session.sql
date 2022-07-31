CREATE TABLE `t_wechat_session`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `session_id` int(0) NULL DEFAULT NULL,
  `is_deleted` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;