/*
 Navicat Premium Data Transfer

 Source Server         : 主机mysql
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : spring_study

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 27/04/2019 19:16:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gym
-- ----------------------------
DROP TABLE IF EXISTS `gym`;
CREATE TABLE `gym` (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `modify_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gym_trainer
-- ----------------------------
DROP TABLE IF EXISTS `gym_trainer`;
CREATE TABLE `gym_trainer` (
  `gym_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trainer_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`gym_id`,`trainer_id`),
  KEY `trainer_id` (`trainer_id`),
  CONSTRAINT `gym_id_` FOREIGN KEY (`gym_id`) REFERENCES `gym` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `trainer_id` FOREIGN KEY (`trainer_id`) REFERENCES `trainer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for trainer
-- ----------------------------
DROP TABLE IF EXISTS `trainer`;
CREATE TABLE `trainer` (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `headpic` varchar(255) DEFAULT NULL,
  `introduce` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `name` varchar(255) DEFAULT NULL,
  `age` int(32) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
