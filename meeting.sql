/*
 Navicat Premium Data Transfer

 Source Server         : xiaozhou
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : meeting

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 02/04/2024 08:27:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminid` int(0) NOT NULL AUTO_INCREMENT,
  `adminname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `adminpwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`adminid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '蒋老师', '123456');

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device`  (
  `deviceid` int(0) NOT NULL AUTO_INCREMENT,
  `devicename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `devicemeetroom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`deviceid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES (1, '投影仪1', '无');
INSERT INTO `device` VALUES (2, '投影仪2', '无');
INSERT INTO `device` VALUES (3, '投影仪3', '会议室8');
INSERT INTO `device` VALUES (4, '桌子1', '无');
INSERT INTO `device` VALUES (5, '桌子2', '无');
INSERT INTO `device` VALUES (6, '桌子3', '会议室8');
INSERT INTO `device` VALUES (7, '椅子1', '无');
INSERT INTO `device` VALUES (8, '椅子2', '无');
INSERT INTO `device` VALUES (9, '椅子3', '无');
INSERT INTO `device` VALUES (10, '椅子4', '无');
INSERT INTO `device` VALUES (11, '投影仪4', '无');

-- ----------------------------
-- Table structure for filee
-- ----------------------------
DROP TABLE IF EXISTS `filee`;
CREATE TABLE `filee`  (
  `fileid` int(0) NOT NULL AUTO_INCREMENT,
  `filename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `filepath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `meetname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `launchuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`fileid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of filee
-- ----------------------------
INSERT INTO `filee` VALUES (35, '图片1.jpg', 'D:\\大三 第一学期\\web\\webmvc_meeting\\out\\artifacts\\webmvc_meeting_war_exploded\\\\upload', '第一次会议（修改）', '周佳民');
INSERT INTO `filee` VALUES (36, '实验报告格式.doc', 'D:\\大三 第一学期\\web\\webmvc_meeting\\out\\artifacts\\webmvc_meeting_war_exploded\\\\upload', '第一次会议（修改）', '周佳民');

-- ----------------------------
-- Table structure for liuyan
-- ----------------------------
DROP TABLE IF EXISTS `liuyan`;
CREATE TABLE `liuyan`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `state` enum('启用','禁用') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of liuyan
-- ----------------------------
INSERT INTO `liuyan` VALUES (2, NULL, '交作业', '交作业', '2023-12-21 10:32:52');
INSERT INTO `liuyan` VALUES (3, NULL, '交作业了', '交作业了', '2023-12-22 20:50:22');
INSERT INTO `liuyan` VALUES (4, NULL, '交作业了', '交作业', '2023-12-22 20:51:55');
INSERT INTO `liuyan` VALUES (5, NULL, '需要交作业', '交作业', '2023-12-22 21:22:37');

-- ----------------------------
-- Table structure for meeting
-- ----------------------------
DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting`  (
  `meetid` int(0) NOT NULL AUTO_INCREMENT,
  `meetname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `meetroom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `starttime` datetime(0) NOT NULL,
  `endtime` datetime(0) NOT NULL,
  `state` enum('会议室申请中','会议室审核中','会议室审核被驳回重新申请中','会议室申请成功上传会议文件中','通知人员参会等待会议开始中','会议已完成','会议已取消') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '会议室申请中',
  `launchuser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `predictnumber` int(0) NOT NULL,
  `number` int(0) NOT NULL,
  PRIMARY KEY (`meetid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of meeting
-- ----------------------------
INSERT INTO `meeting` VALUES (98, '第一次会议（修改）', '会议室1', '2023-12-23 10:10:00', '2023-12-23 10:30:00', '会议已完成', '周佳民', 10, 2);
INSERT INTO `meeting` VALUES (99, '第二次会议', '会议室2', '2023-12-23 10:00:00', '2023-12-23 12:00:00', '会议室申请成功上传会议文件中', '周佳民', 5, 0);
INSERT INTO `meeting` VALUES (100, '第三次会议', '会议室1', '2023-12-23 15:00:00', '2023-12-23 17:00:00', '会议室申请成功上传会议文件中', '周佳民', 5, 0);
INSERT INTO `meeting` VALUES (101, '第四次会议', '会议室6', '2023-12-23 18:00:00', '2023-12-23 20:00:00', '会议已取消', '周佳民', 30, 0);

-- ----------------------------
-- Table structure for meetinginform
-- ----------------------------
DROP TABLE IF EXISTS `meetinginform`;
CREATE TABLE `meetinginform`  (
  `informid` int(0) NOT NULL AUTO_INCREMENT,
  `meetname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `meetroom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `starttime` datetime(0) NOT NULL,
  `endtime` datetime(0) NOT NULL,
  `launchname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `joincondition` enum('已拒绝参会','待确认参会','已确认参会','会议已结束未确认参会','会议已结束已确认参会','会议被取消') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '待确认参会',
  PRIMARY KEY (`informid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 142 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of meetinginform
-- ----------------------------
INSERT INTO `meetinginform` VALUES (137, '第一次会议（修改）', '会议室1', '2023-12-23 10:10:00', '2023-12-23 10:30:00', '周佳民', '周佳民', '会议已结束已确认参会');
INSERT INTO `meetinginform` VALUES (138, '第一次会议（修改）', '会议室1', '2023-12-23 10:10:00', '2023-12-23 10:30:00', '周佳民', '杨思琦', '会议已结束已确认参会');
INSERT INTO `meetinginform` VALUES (139, '第一次会议（修改）', '会议室1', '2023-12-23 10:10:00', '2023-12-23 10:30:00', '周佳民', '石浩正', '已拒绝参会');
INSERT INTO `meetinginform` VALUES (140, '第一次会议（修改）', '会议室1', '2023-12-23 10:10:00', '2023-12-23 10:30:00', '周佳民', '江文锴', '会议已结束未确认参会');
INSERT INTO `meetinginform` VALUES (141, '第一次会议（修改）', '会议室1', '2023-12-23 10:10:00', '2023-12-23 10:30:00', '周佳民', '彭俊斌', '会议已结束未确认参会');
INSERT INTO `meetinginform` VALUES (142, '第一次会议（修改）', '会议室1', '2023-12-23 10:10:00', '2023-12-23 10:30:00', '周佳民', '石浩正', '会议已结束未确认参会');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `roomid` int(0) NOT NULL AUTO_INCREMENT,
  `roomname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `hold` int(0) NOT NULL,
  PRIMARY KEY (`roomid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (1, '会议室1', 5);
INSERT INTO `room` VALUES (11, '会议室2', 10);
INSERT INTO `room` VALUES (12, '会议室3', 15);
INSERT INTO `room` VALUES (13, '会议室4', 20);
INSERT INTO `room` VALUES (14, '会议室5', 25);
INSERT INTO `room` VALUES (15, '会议室6', 30);
INSERT INTO `room` VALUES (16, '会议室7', 35);
INSERT INTO `room` VALUES (17, '会议室8', 40);

-- ----------------------------
-- Table structure for roomapply
-- ----------------------------
DROP TABLE IF EXISTS `roomapply`;
CREATE TABLE `roomapply`  (
  `applyid` int(0) NOT NULL AUTO_INCREMENT,
  `roomname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `meetname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `launchname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `starttime` datetime(0) NOT NULL,
  `endtime` datetime(0) NOT NULL,
  `roomtype` enum('预约被驳回','预约申请中','预约成功','预约取消') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '预约申请中',
  PRIMARY KEY (`applyid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roomapply
-- ----------------------------
INSERT INTO `roomapply` VALUES (61, '会议室1', '第一次会议（修改）', '周佳民', '2023-12-23 10:10:00', '2023-12-23 10:30:00', '预约成功');
INSERT INTO `roomapply` VALUES (62, '会议室2', '第二次会议', '周佳民', '2023-12-23 10:00:00', '2023-12-23 12:00:00', '预约成功');
INSERT INTO `roomapply` VALUES (63, '会议室1', '第三次会议', '周佳民', '2023-12-23 15:00:00', '2023-12-23 17:00:00', '预约成功');
INSERT INTO `roomapply` VALUES (64, '会议室6', '第四次会议', '周佳民', '2023-12-23 18:00:00', '2023-12-23 20:00:00', '预约被驳回');
INSERT INTO `roomapply` VALUES (65, '会议室6', '第四次会议', '周佳民', '2023-12-23 18:00:00', '2023-12-23 20:00:00', '预约取消');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userid` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userpwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `job` enum('员工','经理') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '员工',
  `department` enum('开发','运维','销售') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ability` enum('启用','禁用') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `joincondition` enum('无参加会议','有待确认会议','有参加会议') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '无参加会议',
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '周佳民', '123456', '员工', '运维', '启用', '无参加会议');
INSERT INTO `user` VALUES (2, '杨思琦', '654321', '经理', '开发', '启用', '无参加会议');
INSERT INTO `user` VALUES (3, '石浩正', '123456', '员工', '开发', '启用', '无参加会议');
INSERT INTO `user` VALUES (4, '江文锴', '123456', '员工', '开发', '启用', '无参加会议');
INSERT INTO `user` VALUES (5, '彭俊斌', '123456', '员工', '开发', '启用', '无参加会议');
INSERT INTO `user` VALUES (6, '王淳昕', '123456', '员工', '开发', '启用', '无参加会议');
INSERT INTO `user` VALUES (7, '苏至锋', '123456', '员工', '开发', '启用', '无参加会议');
INSERT INTO `user` VALUES (8, '柯俊峰', '123456', '员工', '开发', '启用', '无参加会议');
INSERT INTO `user` VALUES (9, '许荣园', '123456', '员工', '开发', '启用', '无参加会议');
INSERT INTO `user` VALUES (10, '叶耀琪', '123456', '员工', '开发', '启用', '无参加会议');
INSERT INTO `user` VALUES (11, '林祖豪', '123456', '员工', '开发', '启用', '无参加会议');
INSERT INTO `user` VALUES (12, '陈泽雨', '123456', '员工', '开发', '启用', '无参加会议');
INSERT INTO `user` VALUES (13, '柯柯', '123456', '经理', '运维', '启用', '无参加会议');
INSERT INTO `user` VALUES (15, '杨大琪', '123456', '员工', '开发', '启用', '无参加会议');

SET FOREIGN_KEY_CHECKS = 1;
