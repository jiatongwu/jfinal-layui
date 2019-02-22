/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : jfinal_demo

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 22/02/2019 21:36:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for baominghaoXianquma
-- ----------------------------
DROP TABLE IF EXISTS `baominghaoXianquma`;
CREATE TABLE `baominghaoXianquma` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of baominghaoXianquma
-- ----------------------------
BEGIN;
INSERT INTO `baominghaoXianquma` VALUES (2, '安定区', '1');
INSERT INTO `baominghaoXianquma` VALUES (3, '通渭县', '4');
INSERT INTO `baominghaoXianquma` VALUES (4, '陇西县', '5');
INSERT INTO `baominghaoXianquma` VALUES (5, '渭源县', '6');
INSERT INTO `baominghaoXianquma` VALUES (6, '临洮县', '7');
INSERT INTO `baominghaoXianquma` VALUES (7, '漳县', '8');
INSERT INTO `baominghaoXianquma` VALUES (8, '岷县', '9');
COMMIT;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `content` mediumtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
BEGIN;
INSERT INTO `blog` VALUES (4, 'test 3', 'test 3');
INSERT INTO `blog` VALUES (5, 'test 4', 'test 4');
INSERT INTO `blog` VALUES (6, '标题', '内容');
COMMIT;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pageCount` int(11) DEFAULT NULL,
  `money` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
BEGIN;
INSERT INTO `book` VALUES (1, '三国演义', 300, 50);
INSERT INTO `book` VALUES (2, '西游记', 200, 50.1);
INSERT INTO `book` VALUES (3, '水许传', 500, 60.5);
INSERT INTO `book` VALUES (4, '红楼梦', 100, 20.08);
COMMIT;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `school` varchar(255) NOT NULL,
  `idcard` varchar(255) NOT NULL,
  `gendar` varchar(255) NOT NULL,
  `minzu` varchar(255) DEFAULT NULL,
  `baominghao` varchar(255) DEFAULT NULL,
  `zhunkaozhenghao` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES (4, NULL, '张三2', '陇西第二中学', '23478', '女', NULL, '', '', '普通考生');
INSERT INTO `student` VALUES (5, NULL, '李四', '陇西第四中学', '2347', '男', NULL, '', '', '普通考生');
INSERT INTO `student` VALUES (6, NULL, '王五55', '陇西第一中学2', '2347822', '女', NULL, '', '', '普通考生');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
