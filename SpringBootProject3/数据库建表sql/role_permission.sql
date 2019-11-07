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

 Date: 11/07/2019 17:35:13 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id_p` int(11) DEFAULT NULL,
  `permission_id_p` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id_for_permission` (`role_id_p`),
  KEY `permission_id_p` (`permission_id_p`),
  CONSTRAINT `permission_id_for_permission` FOREIGN KEY (`permission_id_p`) REFERENCES `permission` (`id`),
  CONSTRAINT `role_id_for_permission` FOREIGN KEY (`role_id_p`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `role_permission`
-- ----------------------------
BEGIN;
INSERT INTO `role_permission` VALUES ('1', '1', '1'), ('2', '1', '2');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
