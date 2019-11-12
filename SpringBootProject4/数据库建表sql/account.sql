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

 Date: 11/07/2019 17:34:38 PM
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
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'user' COMMENT 'user',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_name` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `account`
-- ----------------------------
BEGIN;
INSERT INTO `account` VALUES ('1', 'liu', '123', 'nick', '18', null, 'user'), ('9', 'zhangsan1', 'Abcd1234.', 'nackzhang1', '111', null, 'user'), ('15', '123', '123', '123', '12', '1', 'user'), ('17', '11', '11', '11', '11', '1', 'user'), ('18', '222', '222', '222', '22', '2', 'user'), ('19', 'test100', 'test100', 'test100', '100', 'test100', 'user'), ('20', 'test455', 'test455', 'test455', '455', 'test455', 'user'), ('21', 'test825', 'test825', 'test825', '825', 'test825', 'user'), ('22', 'test821', 'test821', 'test821', '821', 'test821', 'user'), ('23', 'test856', 'test856', 'test856', '856', 'test856', 'user'), ('24', 'test788', 'test788', 'test788', '788', 'test788', 'user'), ('28', 'test520', 'test520', 'test520', '520', 'test520', 'user'), ('29', 'test756', 'test756', 'test756', '756', 'test756', 'user'), ('31', 'test232', 'test232', 'test232', '232', 'test232', 'user');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
