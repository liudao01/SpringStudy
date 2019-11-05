/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost
 Source Database       : ssm

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : utf-8

 Date: 11/05/2019 10:15:35 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT '0',
  `location` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_name` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `account`
-- ----------------------------
BEGIN;
INSERT INTO `account` VALUES ('1', 'liu', '123', 'nick', '18', null, 'user'), ('9', 'zhangsan1', 'Abcd1234.', 'nackzhang1', '111', null, 'user'), ('15', '123', '123', '123', '12', '1', 'user'), ('17', '11', '11', '11', '11', '1', 'user');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
