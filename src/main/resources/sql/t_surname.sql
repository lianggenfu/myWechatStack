

DROP TABLE IF EXISTS `t_surname`;
CREATE TABLE `t_surname`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `sur_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓',
  `matching` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '匹配姓名',
  `sex_type` int(0) NULL DEFAULT NULL COMMENT '性别',
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;