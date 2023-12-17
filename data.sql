/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80019 (8.0.19)
 Source Host           : localhost:3306
 Source Schema         : PBL2

 Target Server Type    : MySQL
 Target Server Version : 80019 (8.0.19)
 File Encoding         : 65001

 Date: 17/12/2023 21:56:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ClassInfo
-- ----------------------------
DROP TABLE IF EXISTS `ClassInfo`;
CREATE TABLE `ClassInfo`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `classId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `className` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of ClassInfo
-- ----------------------------
BEGIN;
INSERT INTO `ClassInfo` (`id`, `classId`, `className`) VALUES (1, '1', '创智'), (2, '2', '数据与科学'), (3, '3', '计算机网络班');
COMMIT;

-- ----------------------------
-- Table structure for ClassRegistration
-- ----------------------------
DROP TABLE IF EXISTS `ClassRegistration`;
CREATE TABLE `ClassRegistration`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `classId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `studentId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of ClassRegistration
-- ----------------------------
BEGIN;
INSERT INTO `ClassRegistration` (`id`, `classId`, `studentId`) VALUES (1, '1', '2021402030601'), (2, '1', '2021402030602'), (3, '1', '2021402030603'), (4, '2', '2021402030605'), (5, '2', '2021402030606'), (6, '2', '2021402030607'), (7, '3', '2021402030608'), (8, '3', '2021402030609');
COMMIT;

-- ----------------------------
-- Table structure for Course
-- ----------------------------
DROP TABLE IF EXISTS `Course`;
CREATE TABLE `Course`  (
  `Id` int NOT NULL AUTO_INCREMENT COMMENT '课程ID，唯一标识课程',
  `courseId` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程ID，唯一标示',
  `courseName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程名称',
  `location` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程地点',
  `courseTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程时间',
  `maxCapacity` int NULL DEFAULT NULL COMMENT '课程人数上限',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '课程简介',
  `credits` int NULL DEFAULT NULL COMMENT '学分',
  `teacher` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '授课老师',
  `classes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Course
-- ----------------------------
BEGIN;
INSERT INTO `Course` (`Id`, `courseId`, `courseName`, `location`, `courseTime`, `maxCapacity`, `description`, `credits`, `teacher`, `classes`) VALUES (1, '1', '数据库设计与管理', '东A324', '周三 1-2', 50, '教授数据库设计与管理的知识1', 4, '李永建', '创智'), (2, '2', '计算机网络', '西B201', '周四 2-3', 40, '深入理解计算机网络的基本概念与原理', 3, '王丽', '数据与科学'), (3, '3', 'Web开发入门', '东A101', '周五 9-10', 25, '学习基本的Web开发技术', 2, '赵鑫', '创智'), (4, '4', '人工智能导论', '西B301', '周二 3-4', 35, '介绍人工智能的基本概念和发展趋势卧槽</p>', 3, '陈晓', '数据与科学'), (5, '5', '软件工程实践', '东A201', '周三 10-11', 20, '实践软件工程的基本方法和流程', 3, '刘磊', '创智'), (6, '6', '大数据分析', '西B401', '周五 2-3', 30, '学习大数据分析的基本技术和工具', 3, '吴艳', '数据与科学'), (7, '7', 'PBL1-7', '西B301', '周二 3-4', 35, '介绍人工智能的基本概念和发展趋势卧槽</p>', 3, '陈晓', '创智'), (8, '8', 'PBL2-7', '西B301', '周四 3-4', 35, '介绍人工智能的基本概念和发展趋势卧槽</p>', 3, '陈晓', '数据与科学'), (9, '9', 'PBL3-7', '西B301', '周二 1-4', 35, '介绍人工智能的基本概念和发展趋势卧槽</p>', 3, '陈晓', '数据与科学'), (11, '11', 'PBL5-7', '西B301', '周二 3-4', 35, '介绍人工智能的基本概念和发展趋势卧槽</p>', 3, '陈晓', '数据与科学'), (12, '12', 'PBL6-7', '西B301', '周二 3-4', 35, '介绍人工智能的基本概念和发展趋势卧槽</p>', 3, '陈晓', '数据与科学'), (13, '13', 'PBL7-7', '西B301', '周二 3-4', 35, '介绍人工智能的基本概念和发展趋势卧槽</p>', 3, '陈晓', '创智'), (14, '14', 'PBL8-7', '西B301', '周二 3-4', 35, '介绍人工智能的基本概念和发展趋势卧槽</p>', 3, '陈晓', '创智'), (15, '10', '数据库设计与管理', '东A32', '周三 1-2', 50, '教授数据库设计与管理的知识1', 4, '李永建', '创智');
COMMIT;

-- ----------------------------
-- Table structure for CourseRegistration
-- ----------------------------
DROP TABLE IF EXISTS `CourseRegistration`;
CREATE TABLE `CourseRegistration`  (
  `registrationId` int NOT NULL AUTO_INCREMENT COMMENT '选课ID，唯一标识每次选课',
  `studentId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学生ID，关联到 user_student 表',
  `teacherId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '老师ID，关联到 user_teacher 表',
  `courseId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程ID，关联到 Course 表',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`registrationId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of CourseRegistration
-- ----------------------------
BEGIN;
INSERT INTO `CourseRegistration` (`registrationId`, `studentId`, `teacherId`, `courseId`, `status`) VALUES (1, '2021402030601', '2021402030611', '1', '已选课'), (2, '2021402030601', '2021402030611', '3', '等待');
COMMIT;

-- ----------------------------
-- Table structure for CourseTeacher
-- ----------------------------
DROP TABLE IF EXISTS `CourseTeacher`;
CREATE TABLE `CourseTeacher`  (
  `courseId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `teacherId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of CourseTeacher
-- ----------------------------
BEGIN;
INSERT INTO `CourseTeacher` (`courseId`, `teacherId`, `id`) VALUES ('1', '2021402030611', 1), ('2', '2021402030612', 2), ('3', '2021402030613', 3), ('4', '2021402030614', 4), ('5', '2021402030615', 5), ('6', '2021402030616', 6), ('7', '2021402030618', 7), ('8', '2021402030615', 8), ('9', '2021402030615', 9), ('10', '2021402030611', 10), ('11', '2021402030615', 11), ('12', '2021402030615', 12), ('13', '2021402030615', 13), ('1', '2021402030611', 14);
COMMIT;

-- ----------------------------
-- Table structure for File
-- ----------------------------
DROP TABLE IF EXISTS `File`;
CREATE TABLE `File`  (
  `uuId` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `fileId` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件ID，唯一标示',
  `fileName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件本身的名字',
  `totalSize` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件的总大小',
  `userId` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户上传的Id，用来区分是哪个用户上传',
  `saveFileName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '上传后文件保存的名字，uuid+userId+type',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '上传文件的类型',
  `uploadTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '上传时间',
  PRIMARY KEY (`uuId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of File
-- ----------------------------
BEGIN;
INSERT INTO `File` (`uuId`, `fileId`, `fileName`, `totalSize`, `userId`, `saveFileName`, `type`, `uploadTime`) VALUES ('5d64c312-dcf7-4fb5-accd-5e7212f4548b', '1', '作业1.0', '12694bytes', '1', '5d64c312-dcf7-4fb5-accd-5e7212f4548b.sql', '.sql', '2023/12/06'), ('7ad6bb02-fb72-49a5-8784-3f01511d938d', '1', '作业1.0', '12457bytes', '1', '7ad6bb02-fb72-49a5-8784-3f01511d938d.sql', '.sql', '2023/12/06'), ('9340d99d-aedc-43a2-8a35-b6b956e3a445', '1', '作业1.0', '12457bytes', '1', '9340d99d-aedc-43a2-8a35-b6b956e3a445.sql', '.sql', '2023/12/06'), ('9f75aafe-3532-4510-b1ca-7ff4f00ac14d', '1', '作业1.0', '12457bytes', '1', '9f75aafe-3532-4510-b1ca-7ff4f00ac14d.sql', '.sql', '2023/12/06'), ('bc3fad09-75e6-46e1-8cd3-3bdf7f4b3d8b', '1', '作业1.0', '12457bytes', '1', 'bc3fad09-75e6-46e1-8cd3-3bdf7f4b3d8b.sql', '.sql', '2023/12/06'), ('d0f1e017-d686-43c4-91f6-a91d87bbd759', '1', '作业1.0', '12457bytes', '1', 'd0f1e017-d686-43c4-91f6-a91d87bbd759.sql', '.sql', '2023/12/06');
COMMIT;

-- ----------------------------
-- Table structure for FileRegistration
-- ----------------------------
DROP TABLE IF EXISTS `FileRegistration`;
CREATE TABLE `FileRegistration`  (
  `registrationId` int NOT NULL AUTO_INCREMENT COMMENT '文件ID，唯一标识每次选课',
  `studentId` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学生ID，关联到 user_student 表',
  `teacherId` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '老师ID，关联到 user_teacher 表',
  `fileId` int NULL DEFAULT NULL COMMENT '文件ID，关联到 file 表',
  `status` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态',
  `homeWorkGrade` int NULL DEFAULT NULL,
  PRIMARY KEY (`registrationId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of FileRegistration
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for HomeWork
-- ----------------------------
DROP TABLE IF EXISTS `HomeWork`;
CREATE TABLE `HomeWork`  (
  `Id` int NOT NULL AUTO_INCREMENT COMMENT 'ID，唯一标识课程',
  `homeWorkId` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '作业ID，唯一标示',
  `homeWorkName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '作业名称',
  `homeWorkTime` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '作业发布时间',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '作业简介',
  `teacher` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '授课老师',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of HomeWork
-- ----------------------------
BEGIN;
INSERT INTO `HomeWork` (`Id`, `homeWorkId`, `homeWorkName`, `homeWorkTime`, `description`, `teacher`) VALUES (3, 'ba1176f1-b26b-4357-91e7-578c1e10cfa4', '打字', NULL, '打字练习', NULL), (4, '51a8909a-d23f-463b-ae6a-91810165068c', '打字', NULL, '打字练习', NULL), (5, '864f22a0-1be9-4c4f-9932-df8912a70624', '打字', '2023/12/07', '打字练习', NULL);
COMMIT;

-- ----------------------------
-- Table structure for HomeWorkRegistration
-- ----------------------------
DROP TABLE IF EXISTS `HomeWorkRegistration`;
CREATE TABLE `HomeWorkRegistration`  (
  `Id` int NOT NULL AUTO_INCREMENT COMMENT 'ID，唯一标识每次选课',
  `studentId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学生ID，关联到 user_student 表',
  `teacherId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '老师ID，关联到 user_teacher 表',
  `classId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `fileId` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件ID，关联FIle',
  `courseId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `homeWorkId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '作业ID，关联到 homework 表',
  `homeWorkGrade` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '作业分数',
  `Status` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of HomeWorkRegistration
-- ----------------------------
BEGIN;
INSERT INTO `HomeWorkRegistration` (`Id`, `studentId`, `teacherId`, `classId`, `fileId`, `courseId`, `homeWorkId`, `homeWorkGrade`, `Status`) VALUES (3, NULL, '2021402030611', '1', NULL, '2021402030601', 'ba1176f1-b26b-4357-91e7-578c1e10cfa4', NULL, NULL), (4, NULL, '2021402030611', '1', NULL, '2021402030601', '51a8909a-d23f-463b-ae6a-91810165068c', '10', NULL), (5, NULL, '2021402030611', '1', NULL, '2021402030601', '864f22a0-1be9-4c4f-9932-df8912a70624', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for user_admin
-- ----------------------------
DROP TABLE IF EXISTS `user_admin`;
CREATE TABLE `user_admin`  (
  `userID` int NOT NULL AUTO_INCREMENT COMMENT '用户ID，唯一标识用户',
  `userName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `passWord` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码，用于登录验证',
  `studentId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '工号',
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话号码',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电子邮件地址',
  `weChat` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '微信账号',
  `qq` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'QQ号码',
  `bio` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '用户简介',
  `college` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属学院',
  `classes` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '班级',
  PRIMARY KEY (`userID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_admin
-- ----------------------------
BEGIN;
INSERT INTO `user_admin` (`userID`, `userName`, `passWord`, `studentId`, `phone`, `email`, `weChat`, `qq`, `bio`, `college`, `classes`) VALUES (1, 'admin', '$2a$10$qJKu6uYGy38.Hg2caSS4w.JWqX7vwOL4cDiipjcXhs4Yw1st.kR8m', '2021402030600', NULL, NULL, NULL, NULL, NULL, 'admin', 'admin');
COMMIT;

-- ----------------------------
-- Table structure for user_student
-- ----------------------------
DROP TABLE IF EXISTS `user_student`;
CREATE TABLE `user_student`  (
  `userId` int NOT NULL AUTO_INCREMENT COMMENT '用户ID，唯一标识用户',
  `userName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `passWord` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码，用于登录验证',
  `studentId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学号或账号，唯一标识，用于登录',
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话号码',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电子邮件地址',
  `weChat` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '微信账号',
  `qq` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'QQ号码',
  `bio` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '用户简介',
  `college` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属学院',
  `classes` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '班级',
  PRIMARY KEY (`userId`) USING BTREE,
  INDEX `idx_StudentID`(`studentId` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_student
-- ----------------------------
BEGIN;
INSERT INTO `user_student` (`userId`, `userName`, `passWord`, `studentId`, `phone`, `email`, `weChat`, `qq`, `bio`, `college`, `classes`) VALUES (1, '陈雅文', '$2a$10$qJKu6uYGy38.Hg2caSS4w.JWqX7vwOL4cDiipjcXhs4Yw1st.kR8m', '2021402030601', '13086621842', '1664674134@qq.com', 'wechar1313', '16424248', 'I am a handsome student.', 'Computer Science', '创智'), (2, '林悠然', '$2a$10$qJKu6uYGy38.Hg2caSS4w.JWqX7vwOL4cDiipjcXhs4Yw1st.kR8m', '2021402030602', '', '', '1', '0', '', 'Literature and Arts', '创智'), (3, '黄心怡', '$2a$10$qJKu6uYGy38.Hg2caSS4w.JWqX7vwOL4cDiipjcXhs4Yw1st.kR8m', '2021402030603', '13555555555', 'professorx@example.com', 'wechat789', 'qq123789', 'Teaching and researching at ABC College.', 'Education', '创智'), (5, '朱明辉', '$2a$10$qJKu6uYGy38.Hg2caSS4w.JWqX7vwOL4cDiipjcXhs4Yw1st.kR8m', '2021402030605', '13712345678', 'sarahbrown@example.com', 'wechat234', 'qq567890', 'An enthusiast for academic research.', 'Mathematics and Statistics', '数据和科学'), (6, '徐雨萌', '$2a$10$qJKu6uYGy38.Hg2caSS4w.JWqX7vwOL4cDiipjcXhs4Yw1st.kR8m', '2021402030606', '13666666666', 'professory@example.com', 'wechat567', 'qq890123', 'Educating future leaders.', 'Law School', '数据和科学'), (7, '马天宇', '$2a$10$qJKu6uYGy38.Hg2caSS4w.JWqX7vwOL4cDiipjcXhs4Yw1st.kR8m', '2021402030607', '13933333333', 'davidwhite@example.com', 'wechat890', 'qq123456', 'I love pushing my limits.', 'Chemistry and Biology', '数据和科学'), (8, '宋思源', '$2a$10$qJKu6uYGy38.Hg2caSS4w.JWqX7vwOL4cDiipjcXhs4Yw1st.kR8m', '2021402030608', '13599999999', 'oliviagreen@example.com', 'wechat678', 'qq345678', 'Dedicated to social activities and volunteer work.', 'Social Sciences', '计算机网络班'), (9, '刘欣妍', '$2a$10$qJKu6uYGy38.Hg2caSS4w.JWqX7vwOL4cDiipjcXhs4Yw1st.kR8m', '2021402030609', '13844444444', 'christaylor@example.com', 'wechat345', 'qq789012', 'Passionate about sports and fitness.', 'Sports and Health Sciences', '计算机网络班');
COMMIT;

-- ----------------------------
-- Table structure for user_teacher
-- ----------------------------
DROP TABLE IF EXISTS `user_teacher`;
CREATE TABLE `user_teacher`  (
  `userId` int NOT NULL AUTO_INCREMENT COMMENT '用户ID，唯一标识用户',
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `passWord` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码，用于登录验证',
  `teacherId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '工号',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话号码',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电子邮件地址',
  `weChat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '微信账号',
  `qq` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'QQ号码',
  `bio` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '用户简介',
  `college` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属学院',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_teacher
-- ----------------------------
BEGIN;
INSERT INTO `user_teacher` (`userId`, `userName`, `passWord`, `teacherId`, `phone`, `email`, `weChat`, `qq`, `bio`, `college`) VALUES (1, '李永建', '$2a$10$mutzIdubWN.htdh/aTj19.Bd5idEw2DS1GuUmSrjYeQpmsgW3bgHC', '2021402030611', '', '1', '1', '', '', 'Computer Science'), (2, '王丽', '$2a$10$mutzIdubWN.htdh/aTj19.Bd5idEw2DS1GuUmSrjYeQpmsgW3bgHC', '2021402030612', '13922222222', 'wangli@example.com', 'wechat234', 'qq222222', 'Enthusiastic about networking and security.', 'Computer Science'), (3, '赵鑫', '$2a$10$mutzIdubWN.htdh/aTj19.Bd5idEw2DS1GuUmSrjYeQpmsgW3bgHC', '2021402030613', '13933333333', 'zhaoxin@example.com', 'wechat345', 'qq333333', 'Passionate about web development.', 'Computer Science'), (4, '张明', '$2a$10$mutzIdubWN.htdh/aTj19.Bd5idEw2DS1GuUmSrjYeQpmsgW3bgHC', '2021402030614', '13944444444', 'zhangming@example.com', 'wechat456', 'qq444444', 'Fascinated by algorithms and data structures.', 'Computer Science'), (5, '陈晓', '$2a$10$mutzIdubWN.htdh/aTj19.Bd5idEw2DS1GuUmSrjYeQpmsgW3bgHC', '2021402030615', '13955555555', 'chenxiao@example.com', 'wechat567', 'qq555555', 'Excited about the future of artificial intelligence.', 'Computer Science'), (6, '刘磊', '$2a$10$mutzIdubWN.htdh/aTj19.Bd5idEw2DS1GuUmSrjYeQpmsgW3bgHC', '2021402030616', '13966666666', 'liulei@example.com', 'wechat678', 'qq666666', 'Passionate about software engineering practices.', 'Computer Science'), (7, '吴艳', '$2a$10$mutzIdubWN.htdh/aTj19.Bd5idEw2DS1GuUmSrjYeQpmsgW3bgHC', '2021402030618', '13988888888', 'wuyan@example.com', 'wechat890', 'qq888888', 'Passionate about big data analytics.', 'Computer Science');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
