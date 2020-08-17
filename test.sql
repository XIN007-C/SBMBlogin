/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2020-08-17 17:38:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `password` varchar(255) NOT NULL,
  `jurisdiction` varchar(255) NOT NULL DEFAULT '用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1000001', '520baby1314', '管理员');
INSERT INTO `user` VALUES ('2', '1000002', '520', '用户');
INSERT INTO `user` VALUES ('3', '1000003', '5201314', '用户');
INSERT INTO `user` VALUES ('5', '1000004', '321123', '用户');
INSERT INTO `user` VALUES ('6', '1000005', '456', '用户');
INSERT INTO `user` VALUES ('7', '1000006', '789', '用户');
INSERT INTO `user` VALUES ('38', '1000009', '123456', '用户');
INSERT INTO `user` VALUES ('65', '10000010', '7758258', '用户');
INSERT INTO `user` VALUES ('66', '10000011', '54288', '用户');
INSERT INTO `user` VALUES ('67', '10000012', '123456789', '用户');
