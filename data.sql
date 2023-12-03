/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80019 (8.0.19)
 Source Host           : localhost:3306
 Source Schema         : PBL

 Target Server Type    : MySQL
 Target Server Version : 80019 (8.0.19)
 File Encoding         : 65001

 Date: 03/12/2023 10:02:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Course
-- ----------------------------
DROP TABLE IF EXISTS `Course`;
CREATE TABLE `Course`  (
  `courseid` int NOT NULL AUTO_INCREMENT COMMENT '课程ID，唯一标识课程',
  `coursename` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '课程名称',
  `location` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '课程地点',
  `coursetime` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '课程时间',
  `maxcapacity` int NULL DEFAULT NULL COMMENT '课程人数上限',
  `description` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '课程简介',
  `credits` int NULL DEFAULT NULL COMMENT '学分',
  `teacher` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '授课老师',
  PRIMARY KEY (`courseid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_bin;

-- ----------------------------
-- Records of Course
-- ----------------------------
BEGIN;
INSERT INTO `Course` (`courseid`, `coursename`, `location`, `coursetime`, `maxcapacity`, `description`, `credits`, `teacher`) VALUES (1, '数据库设计与管理', '东A324', '周三 1-2', 50, '教授数据库设计与管理的知识1', 4, '李永建'), (2, '计算机网络', '西B201', '周四 2-3', 40, '深入理解计算机网络的基本概念与原理', 3, '王丽'), (3, 'Web开发入门', '东A101', '周五 9-10', 25, '学习基本的Web开发技术', 2, '赵鑫'), (4, '算法与数据结构', '北C301', '周一 2-3', 30, '深入学习算法和数据结构的基本原理', 4, '张明'), (5, '人工智能导论', '西B301', '周二 3-4', 35, '介绍人工智能的基本概念和发展趋势', 3, '陈晓'), (6, '软件工程实践', '东A201', '周三 10-11', 20, '实践软件工程的基本方法和流程', 3, '刘磊'), (7, '操作系统原理', '北C101', '周四 11-12', 45, '深入了解操作系统的基本原理与设计', 4, '周文'), (8, '大数据分析', '西B401', '周五 2-3', 30, '学习大数据分析的基本技术和工具', 3, '吴艳'), (9, '软件工程实践', '西B301', '周二 3-4', 50, '介绍人工智能的基本概念和发展趋势', 3, '陈晓'), (11, '软件工程实践', '西B301', '2023-11-20T12:00:00', 50, '介绍人工智能的基本概念和发展趋势', 3, '陈晓');
COMMIT;

-- ----------------------------
-- Table structure for Enrollment
-- ----------------------------
DROP TABLE IF EXISTS `Enrollment`;
CREATE TABLE `Enrollment`  (
  `enrollmentid` int NOT NULL AUTO_INCREMENT COMMENT '选课ID，唯一标识选课记录',
  `studentid` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学生ID，关联到User表的UserID',
  `courseid` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '课程ID，关联到Course表的CourseID',
  `enrollmentdate` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '选课日期',
  `grade` int NULL DEFAULT NULL COMMENT '成绩',
  `Status` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '选课状态',
  PRIMARY KEY (`enrollmentid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_bin;

-- ----------------------------
-- Records of Enrollment
-- ----------------------------
BEGIN;
INSERT INTO `Enrollment` (`enrollmentid`, `studentid`, `courseid`, `enrollmentdate`, `grade`, `Status`) VALUES (3, '2021402030603', '1', '2023-11-20 13:26:41', 4, '已选课'), (4, '2021402030604', '2', '2023-11-20 13:26:41', 4, '等待'), (5, '2021402030605', '3', '2023-11-20 13:26:41', 4, '等待'), (6, '2021402030606', '4', '2023-11-20 13:26:41', 4, '已选课'), (7, '2021402030607', '5', '2023-11-20 13:26:41', 4, '等待'), (8, '2021402030608', '6', '2023-11-20 13:26:41', 4, '已选课'), (9, '2021402030609', '7', '2023-11-20 13:26:41', 4, '等待'), (10, '2021402030610', '8', '2023-11-20 13:26:41', 4, '等待'), (12, '2021402030612', '9', '2023-11-20 14:16:21', 3, '已选课'), (18, '2021402030601', '11', '2023-11-21 17:07:09', 4, '等待'), (19, '2021402030614', '7', '2023-12-02 22:24:10', 3, '等待');
COMMIT;

-- ----------------------------
-- Table structure for Resource
-- ----------------------------
DROP TABLE IF EXISTS `Resource`;
CREATE TABLE `Resource`  (
  `ResourceID` int NOT NULL AUTO_INCREMENT COMMENT '资源ID，唯一标识资源',
  `FileName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '文件名字',
  `Uploader` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '上传人',
  `UploadTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
  `FileType` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '文件类型',
  `FileSize` int NULL DEFAULT NULL COMMENT '文件大小 (字节数)',
  PRIMARY KEY (`ResourceID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin;

-- ----------------------------
-- Records of Resource
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`  (
  `userid` int NOT NULL AUTO_INCREMENT COMMENT '用户ID，唯一标识用户',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户名，用于登录',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '密码，用于登录验证',
  `studentID` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '学号或账号，唯一标识',
  `Identification` int NOT NULL COMMENT '身份标示，1为学生，0为教职工',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '联系电话号码',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电子邮件地址',
  `wechat` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '微信账号',
  `qq` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'QQ号码',
  `bio` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '用户简介',
  `college` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '所属学院',
  `classes` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '班级',
  PRIMARY KEY (`userid`) USING BTREE,
  UNIQUE INDEX `unique_name`(`username` ASC) USING BTREE,
  UNIQUE INDEX `unique_email`(`email` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_bin;

-- ----------------------------
-- Records of User
-- ----------------------------
BEGIN;
INSERT INTO `User` (`userid`, `username`, `password`, `studentID`, `Identification`, `phone`, `email`, `wechat`, `qq`, `bio`, `college`, `classes`) VALUES (1, 'JohnDoe', '$2a$10$PPvyKAj2Le55yZAE1.8bkeklXxDAM8lK5EnVWIRUONzKbaILcn9tC', '2021402030601', 1, '13611111111', NULL, NULL, NULL, 'I am a dedicated student.', 'Computer Science', '创智'), (2, 'JaneSmith', '$2a$10$PPvyKAj2Le55yZAE1.8bkeklXxDAM8lK5EnVWIRUONzKbaILcn9tC', '2021402030602', 1, '13998765432', 'janesmith@example.com', 'wechat456', 'qq987654', 'Passionate about research and learning.', 'Literature and Arts', '创智'), (3, 'ProfessorX', '$2a$10$PPvyKAj2Le55yZAE1.8bkeklXxDAM8lK5EnVWIRUONzKbaILcn9tC', '2021402030603', 1, '13555555555', 'professorx@example.com', 'wechat789', 'qq123789', 'Teaching and researching at ABC College.', 'Education', '创智'), (5, 'SarahBrown', '$2a$10$PPvyKAj2Le55yZAE1.8bkeklXxDAM8lK5EnVWIRUONzKbaILcn9tC', '2021402030605', 1, '13712345678', 'sarahbrown@example.com', 'wechat234', 'qq567890', 'An enthusiast for academic research.', 'Mathematics and Statistics', '数据和科学'), (6, 'ProfessorY', '$2a$10$PPvyKAj2Le55yZAE1.8bkeklXxDAM8lK5EnVWIRUONzKbaILcn9tC', '2021402030606', 0, '13666666666', 'professory@example.com', 'wechat567', 'qq890123', 'Educating future leaders.', 'Law School', ''), (7, 'DavidWhite', '$2a$10$PPvyKAj2Le55yZAE1.8bkeklXxDAM8lK5EnVWIRUONzKbaILcn9tC', '2021402030607', 1, '13933333333', 'davidwhite@example.com', 'wechat890', 'qq123456', 'I love pushing my limits.', 'Chemistry and Biology', '数据和科学'), (8, 'OliviaGreen', '$2a$10$PPvyKAj2Le55yZAE1.8bkeklXxDAM8lK5EnVWIRUONzKbaILcn9tC', '2021402030608', 1, '13599999999', 'oliviagreen@example.com', 'wechat678', 'qq345678', 'Dedicated to social activities and volunteer work.', 'Social Sciences', '计算机网络班'), (9, 'ChrisTaylor', '$2a$10$PPvyKAj2Le55yZAE1.8bkeklXxDAM8lK5EnVWIRUONzKbaILcn9tC', '2021402030609', 0, '13844444444', 'christaylor@example.com', 'wechat345', 'qq789012', 'Passionate about sports and fitness.', 'Sports and Health Sciences', ''), (10, 'AdminUser2', '$2a$10$PPvyKAj2Le55yZAE1.8bkeklXxDAM8lK5EnVWIRUONzKbaILcn9tC', '2021402030610', 2, '13777777777', 'adminuser2@example.com', 'wechat222', 'qq999', 'Managing the second part of the system.', 'Management and Economics', '数据和科学'), (33, '李永建', '$2a$10$PPvyKAj2Le55yZAE1.8bkeklXxDAM8lK5EnVWIRUONzKbaILcn9tC', '2021402030611', 1, '13911111111', 'liyongjian@example.com', 'wechat123', 'qq111111', 'Passionate about databases and programming.', 'Computer Science', '计算机网络班'), (34, '王丽', '$2a$10$PPvyKAj2Le55yZAE1.8bkeklXxDAM8lK5EnVWIRUONzKbaILcn9tC', '2021402030612', 0, '13922222222', 'wangli@example.com', 'wechat234', 'qq222222', 'Enthusiastic about networking and security.', 'Computer Science', ''), (35, '赵鑫', '$2a$10$PPvyKAj2Le55yZAE1.8bkeklXxDAM8lK5EnVWIRUONzKbaILcn9tC', '2021402030613', 1, '13933333333', 'zhaoxin@example.com', 'wechat345', 'qq333333', 'Passionate about web development.', 'Computer Science', '数据和科学'), (36, '张明', '$2a$10$PPvyKAj2Le55yZAE1.8bkeklXxDAM8lK5EnVWIRUONzKbaILcn9tC', '2021402030614', 1, '13944444444', 'zhangming@example.com', 'wechat456', 'qq444444', 'Fascinated by algorithms and data structures.', 'Computer Science', '计算机网络班'), (37, '陈晓', '$2a$10$PPvyKAj2Le55yZAE1.8bkeklXxDAM8lK5EnVWIRUONzKbaILcn9tC', '2021402030615', 0, '13955555555', 'chenxiao@example.com', 'wechat567', 'qq555555', 'Excited about the future of artificial intelligence.', 'Computer Science', ''), (38, '刘磊', '$2a$10$PPvyKAj2Le55yZAE1.8bkeklXxDAM8lK5EnVWIRUONzKbaILcn9tC', '2021402030616', 1, '13966666666', 'liulei@example.com', 'wechat678', 'qq666666', 'Passionate about software engineering practices.', 'Computer Science', '数据和科学'), (39, '周文', '$2a$10$PPvyKAj2Le55yZAE1.8bkeklXxDAM8lK5EnVWIRUONzKbaILcn9tC', '2021402030617', 0, '13977777777', 'zhouwen@example.com', 'wechat789', 'qq777777', 'Fascinated by operating systems principles.', 'Computer Science', ''), (40, '吴艳', '$2a$10$PPvyKAj2Le55yZAE1.8bkeklXxDAM8lK5EnVWIRUONzKbaILcn9tC', '2021402030618', 1, '13988888888', 'wuyan@example.com', 'wechat890', 'qq888888', 'Passionate about big data analytics.', 'Computer Science', '计算机网络班');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
