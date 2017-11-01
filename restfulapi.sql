/*
 Navicat Premium Data Transfer

 Source Server         : localhsot
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : restfulapi

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 10/23/2017 17:38:12 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `sys_button`
-- ----------------------------
DROP TABLE IF EXISTS `sys_button`;
CREATE TABLE `sys_button` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auth_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `demo_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `sys_button`
-- ----------------------------
BEGIN;
INSERT INTO `sys_button` VALUES ('1', '短信', '短信名字', '我的短信', '1'), ('2', '两天假', '得到的', '地点', '1');
COMMIT;

-- ----------------------------
--  Table structure for `sys_demo`
-- ----------------------------
DROP TABLE IF EXISTS `sys_demo`;
CREATE TABLE `sys_demo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `sys_demo`
-- ----------------------------
BEGIN;
INSERT INTO `sys_demo` VALUES ('1', '12', '2017-10-03 16:06:09', '34342343', '猜猜猜', '1', 'admin'), ('2', '122', '2017-10-23 17:32:28', '123456', '我的测试类', '11', 'walker10'), ('4', '122', '2017-10-23 17:32:40', '123456', '我的测试类', '1', 'walker8');
COMMIT;

-- ----------------------------
--  Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `add_qx` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `del_qx` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `edit_qx` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `find_qx` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `rights` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `role_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `sys_role`
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES ('1', '323223', 'erere', 'vffdfdf', 'ddcds', '0', 'vfv44353', '超级管理员'), ('2', 'cccc', 'ssss', 'cfvvdfv', 'dfdcd', '1', '43343', '系统管理员');
COMMIT;

-- ----------------------------
--  Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
