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

 Date: 11/05/2019 10:15:49 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `index` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `menu`
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES ('8', '首页', 'all', '0'), ('9', '我的', 'all', '1'), ('10', '资料下载', 'all', '2');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
