/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : s_h_b

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2016-06-03 16:40:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` varchar(15) DEFAULT NULL,
  `book_name` varchar(60) DEFAULT NULL,
  `book_author` varchar(150) DEFAULT NULL,
  `book_press` varchar(50) DEFAULT NULL,
  `book_press_date` varchar(60) DEFAULT NULL,
  `book_price` bigint(20) DEFAULT NULL,
  `book_amount` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('B0001', 'web应用开发', '张三', null, '2010-07-14', '40', '5');
INSERT INTO `book` VALUES ('B0002', '数据库', '李四', null, '2016-04-05', '18', '10');
INSERT INTO `book` VALUES ('B0003', '数据结构', '王五', null, '2016-04-10', '33', '6');
INSERT INTO `book` VALUES ('B0004', '操作系统', '赵六', null, '2016-04-24', '25', '7');
INSERT INTO `book` VALUES ('B0005', '算法设计与分析', '洪七', null, '2016-04-29', '30', '3');
INSERT INTO `book` VALUES ('B0006', 'mysql', 'lisa', null, '2016-05-06', '30', '4');
INSERT INTO `book` VALUES ('B0007', 'C++', 'Bob', null, '2016-04-06', '40', '8');
INSERT INTO `book` VALUES ('B0008', 'java', 'XX', null, '2016-08-09', '40', '30');
INSERT INTO `book` VALUES ('B0009', 'c', 'Mary', null, '2015-12-01', '31', '23');
INSERT INTO `book` VALUES ('B0010', 'html', 'Isia', null, '2013-08-04', '50', '12');
INSERT INTO `book` VALUES ('B0011', 'jquery', 'kasa', null, '2014-09-08', '40', '2');
INSERT INTO `book` VALUES (null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `name` varchar(50) NOT NULL DEFAULT '',
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(50) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `account` varchar(50) DEFAULT NULL,
  `user_name` varchar(60) DEFAULT NULL,
  `book_name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart` (
  `user_id` varchar(50) NOT NULL,
  `book_id` varchar(50) DEFAULT NULL,
  `book_name` varchar(50) DEFAULT NULL,
  `book_price` bigint(20) DEFAULT NULL,
  `quantities` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------
INSERT INTO `shoppingcart` VALUES ('20160002', 'B0005', '算法设计与分析', '30', '3');
INSERT INTO `shoppingcart` VALUES ('20160001', 'B0003', '数据结构', '33', '3');
INSERT INTO `shoppingcart` VALUES ('20160001', 'B0001', 'web应用开发', '40', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(24) NOT NULL,
  `user_psw` varchar(60) DEFAULT NULL,
  `user_name` varchar(60) DEFAULT NULL,
  `user_address` varchar(60) DEFAULT NULL,
  `user_tel` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('20160001', '123456', '李湘识', 'Changsha', '13115469985');
INSERT INTO `user` VALUES ('20160002', '123456', '徐名业', 'Changsha', '13517318790');
INSERT INTO `user` VALUES ('20160003', '123456', '徐红秀', 'Changsha', '13154856489');
INSERT INTO `user` VALUES ('20160004', '123456', '杨远', 'Changsha', '18956466213');
INSERT INTO `user` VALUES ('20160005', '123456', '乔瑞秀', 'Changsha', '18965635546');
