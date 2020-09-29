/*
Navicat MySQL Data Transfer

Source Server         : deploy
Source Server Version : 50718
Source Host           : 47.93.253.78:3306
Source Database       : olalashop

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2020-09-02 17:14:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for C_BALANCE_LOG
-- ----------------------------
DROP TABLE IF EXISTS `C_BALANCE_LOG`;
CREATE TABLE `C_BALANCE_LOG` (
  `BALANCE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CUSTOMER_ID` varchar(15) NOT NULL COMMENT '用户ID',
  `SOURCE` tinyint(1) NOT NULL COMMENT '记录来源：1下订单，2退货单',
  `SOURCE_SN` varchar(50) DEFAULT NULL COMMENT '相关单据号',
  `AMOUNT` int(11) DEFAULT NULL COMMENT '变动余额',
  `FROZEN_MONEY` int(11) DEFAULT '0' COMMENT '被冻结的金额',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录生成时间',
  `CHANGE_DESC` varchar(200) DEFAULT NULL COMMENT '消费记录说明',
  PRIMARY KEY (`BALANCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户余额变动表';

-- ----------------------------
-- Records of C_BALANCE_LOG
-- ----------------------------

-- ----------------------------
-- Table structure for C_COLLECT
-- ----------------------------
DROP TABLE IF EXISTS `C_COLLECT`;
CREATE TABLE `C_COLLECT` (
  `COLLECT_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品收藏ID',
  `CUSTOMER_ID` varchar(15) NOT NULL COMMENT '消费者ID',
  `GOODS_ID` varchar(15) DEFAULT NULL COMMENT '商品主键ID',
  `BUSINESS_ID` varchar(15) DEFAULT NULL COMMENT '店铺主键ID',
  `ADD_TIME` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '收藏时间',
  `IS_EXPIRES` tinyint(1) DEFAULT '0' COMMENT '是否过期 0未过期 1过期',
  `EXPIRES_DATE` datetime DEFAULT NULL COMMENT '过期时间',
  `IS_CANCEL` tinyint(1) DEFAULT '0' COMMENT '是否取消收藏 0否 1是',
  `MODIFIED_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`COLLECT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='我的收藏表';

-- ----------------------------
-- Records of C_COLLECT
-- ----------------------------
INSERT INTO `C_COLLECT` VALUES ('1', '1598777623923', '1596677692', null, '2020-08-31 14:44:09', null, '2020-07-31 09:06:29', '0', '2020-08-30 09:06:29');
INSERT INTO `C_COLLECT` VALUES ('2', '1598777623923', '1597140661', null, '2020-08-31 01:39:10', null, '2020-07-31 17:33:22', '1', '2020-08-30 17:33:22');
INSERT INTO `C_COLLECT` VALUES ('3', '1598777623923', '1597196351', null, '2020-09-01 11:30:05', null, '2020-07-31 17:37:40', '1', '2020-08-30 17:37:40');
INSERT INTO `C_COLLECT` VALUES ('4', '1598777623923', '1597742452', null, '2020-08-31 01:39:10', null, '2020-07-31 17:37:40', '0', '2020-08-30 17:37:40');
INSERT INTO `C_COLLECT` VALUES ('5', '1598777623923', '1597821652', null, '2020-08-31 01:39:10', null, '2020-07-31 17:37:42', '0', '2020-08-30 17:37:42');
INSERT INTO `C_COLLECT` VALUES ('6', '1598777623923', '1598323329', null, '2020-09-01 11:46:42', null, '2020-07-31 17:37:52', '0', '2020-08-30 17:37:52');
INSERT INTO `C_COLLECT` VALUES ('8', '1598777623923', '1597196351', null, '2020-08-30 17:41:26', null, '2020-07-31 17:41:26', '1', '2020-08-30 17:41:26');
INSERT INTO `C_COLLECT` VALUES ('9', '1598777623923', '1596677566', null, '2020-09-01 11:28:43', null, '2020-07-31 17:47:27', '0', '2020-08-30 17:47:27');
INSERT INTO `C_COLLECT` VALUES ('10', '1598777623923', '1596677416', null, '2020-08-31 14:12:28', null, '2020-08-01 05:57:13', '1', '2020-08-31 05:57:13');
INSERT INTO `C_COLLECT` VALUES ('11', '1598777623923', '1596677455', null, '2020-09-01 00:32:23', null, '2020-08-01 09:11:12', '0', '2020-08-31 09:11:12');
INSERT INTO `C_COLLECT` VALUES ('12', '1598777623923', '1596677661', null, '2020-09-01 09:08:20', null, '2020-08-02 01:08:18', '0', '2020-09-01 01:08:18');
INSERT INTO `C_COLLECT` VALUES ('13', '1598777623923', '1596677386', null, '2020-09-02 03:07:22', null, '2020-08-03 03:07:22', '1', '2020-09-02 03:07:22');

-- ----------------------------
-- Table structure for C_CONSIGNEE
-- ----------------------------
DROP TABLE IF EXISTS `C_CONSIGNEE`;
CREATE TABLE `C_CONSIGNEE` (
  `CUSTOMER_ADDR_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `CUSTOMER_ID` varchar(15) NOT NULL COMMENT '消费者主键ID',
  `CUSTOMER_USERNAME` varchar(60) DEFAULT NULL COMMENT '客户名',
  `ZIP` varchar(10) DEFAULT NULL COMMENT '邮编',
  `PROVINCE` varchar(20) DEFAULT NULL COMMENT '省份',
  `CITY` varchar(20) DEFAULT NULL COMMENT '城市',
  `DISTRICT` varchar(20) DEFAULT NULL COMMENT '城市中的区域',
  `CUSTOMER_USERPHONE` varchar(20) DEFAULT NULL COMMENT '客户手机号',
  `ADDRESS` varchar(50) DEFAULT NULL COMMENT '地址 具体到门牌号',
  `IS_DEFAULT` tinyint(1) DEFAULT '0' COMMENT '是否默认 0否 1默认',
  `BACK_UP` varchar(255) DEFAULT NULL,
  `MODIFIED_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`CUSTOMER_ADDR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户地址表';

-- ----------------------------
-- Records of C_CONSIGNEE
-- ----------------------------
INSERT INTO `C_CONSIGNEE` VALUES ('1', '1598777623923', '燕子', '000000', '福建', '福州', '鼓楼', '15158854991', '祖庙商住楼3号楼', '0', '', '2020-09-01 10:43:33');
INSERT INTO `C_CONSIGNEE` VALUES ('2', '1598777623923', '燕子', '000000', '0', '01', '011', '15158854991', '祖庙商住楼3号楼707', '0', '', '2020-09-01 02:15:07');
INSERT INTO `C_CONSIGNEE` VALUES ('3', '1598777623923', '燕子', '000000', '福建省', '泉州市', '闽侯区', '15158854992', '茶亭国际24楼', '0', '', '2020-09-01 03:37:57');

-- ----------------------------
-- Table structure for C_CUSTOMER_INFO
-- ----------------------------
DROP TABLE IF EXISTS `C_CUSTOMER_INFO`;
CREATE TABLE `C_CUSTOMER_INFO` (
  `CUSTOMER_INF_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消费者信息详情主键ID',
  `CUSTOMER_ID` varchar(15) NOT NULL COMMENT '消费者主键ID',
  `CUSTOMER_NAME` varchar(20) NOT NULL COMMENT '消费者用户名',
  `REAL_NAME` varchar(20) DEFAULT NULL COMMENT '消费者真实姓名',
  `IDENTY_CARD_TYPE` int(11) DEFAULT NULL COMMENT '证件类型：1 身份证，2 军官证，3 护照',
  `IDENTY_CARD_NO` varchar(20) DEFAULT NULL COMMENT '证件号码',
  `USER_MOBILE` varchar(20) DEFAULT NULL COMMENT '手机号',
  `EMAIL` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `GENDER` int(11) DEFAULT '0' COMMENT '性别 0保密 1女 2男',
  `BIRTHDAY` varchar(20) DEFAULT NULL COMMENT '生日',
  `CITY` varchar(30) DEFAULT NULL COMMENT '所在城市',
  `USER_POINT` int(11) DEFAULT '0' COMMENT '用户积分',
  `REGISTER_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `IS_DEL` int(11) DEFAULT '0' COMMENT '是否删除 0否 1是',
  `CUSTOMER_STATUS` int(11) DEFAULT '1' COMMENT '0禁用 1正常',
  `CUSTOMER_LEVEL` int(11) DEFAULT '1' COMMENT '会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石',
  `USER_BALANCE` int(11) DEFAULT NULL COMMENT '用户余额（分）',
  `REMARK` varchar(200) DEFAULT NULL COMMENT '备注',
  `MODIFIED_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`CUSTOMER_INF_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of C_CUSTOMER_INFO
-- ----------------------------
INSERT INTO `C_CUSTOMER_INFO` VALUES ('1', '1595502205', 'zhaoy', '燕子', '1', '370124199802206001', '18105912201', '111@123.com', '1', '0106', '001', '0', '2020-08-11 10:28:28', '0', '1', '1', '0', null, '2020-08-11 10:28:28');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('2', '1595502223', 'yaowk', '凯宴', '1', '370124199802206002', '18960992202', '123@163.com', '2', '0420', '006', '0', '2020-08-19 20:06:44', '1', '0', '1', '0', null, '2020-08-19 20:06:44');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('3', '1595502211', 'zhaoy01', '燕子', '2', '370124199802206003', '18105912203', '111@123.com', '1', '0106', '003', '0', '2020-08-11 10:28:45', '0', '1', '1', '0', null, '2020-08-11 10:28:45');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('4', '1595502222', 'yaowk02', '凯燕', '1', '370124199802206004', '18960992204', '123@163.com', '0', '0420', '005', '0', '2020-08-11 10:28:42', '0', '1', '1', '0', null, '2020-08-11 10:28:42');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('5', '1595502205', 'zhaoy03', '燕子', '2', '370124199802206005', '18105912205', '111@123.com', '1', '0106', '003', '0', '2020-08-11 10:29:13', '1', '0', '1', '0', null, '2020-08-11 10:29:13');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('7', '1595502223', 'yaowk', '凯宴', '1', '370124199802206006', '18960992206', '123@163.com', '2', '0420', '002', '0', '2020-08-19 16:11:53', '0', '1', '1', '0', null, '2020-08-19 16:11:53');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('8', '1595502211', 'zhaoy01', '燕子', '2', '370124199802206007', '18105912207', '111@123.com', '1', '0106', '007', '0', '2020-08-27 17:52:19', '0', '0', '2', '0', null, '2020-08-27 17:52:19');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('9', '1595502222', 'yaowk02', '凯燕', '1', '370124199802206008', '18960992208', '123@163.com', '2', '0420', '006', '0', '2020-08-19 16:50:18', '0', '0', '1', '0', null, '2020-08-19 16:50:18');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('11', '1595502205', 'zhaoy', '燕子', '2', '370124199802206009', '18105912209', '111@123.com', '1', '0106', '001', '0', '2020-08-11 10:28:53', '0', '1', '1', '0', null, '2020-08-11 10:28:53');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('12', '1595502223', 'yaowk', '凯宴', '1', '370124199802206010', '18960992210', '123@163.com', '2', '0420', '006', '0', '2020-08-19 16:38:21', '0', '0', '1', '0', null, '2020-08-19 16:38:21');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('13', '1595502211', 'zhaoy01', '燕子', '2', '370124199802206011', '18105912211', '111@123.com', '1', '0106', '003', '0', '2020-08-11 10:28:53', '0', '1', '1', '0', null, '2020-08-11 10:28:53');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('15', '1595502205', 'zhaoy03', '燕子', '1', '370124199802206012', '18105912212', '111@123.com', '1', '0106', '005', '0', '2020-08-19 18:30:56', '0', '1', '2', '0', null, '2020-08-19 18:30:56');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('16', '1595502205', 'zhaoy', '燕子', '2', '370124199802206013', '18105912213', '111@123.com', '1', '0106', '001', '0', '2020-08-11 10:28:57', '1', '0', '1', '0', null, '2020-08-11 10:28:57');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('17', '1595502223', 'yaowk', '凯宴', '1', '370124199802206014', '18960992214', '123@163.com', '2', '0420', '006', '0', '2020-08-19 16:11:48', '0', '1', '1', '0', null, '2020-08-19 16:11:48');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('18', '1595502211', 'zhaoy01', '燕子', '1', '370124199802206015', '18105912015', '111@123.com', '1', '0106', '003', '0', '2020-08-11 10:28:57', '0', '1', '1', '0', null, '2020-08-11 10:28:57');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('19', '1595502222', 'yaowk02', '凯燕', '3', '370124199802206016', '18960992016', '123@163.com', '2', '0420', '003', '0', '2020-08-19 18:30:57', '1', '1', '2', '0', null, '2020-08-19 18:30:57');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('20', '1595502205', 'zhaoy03', '燕子', '1', '370124199802206017', '18105912020', '111@123.com', '1', '0106', '002', '0', '2020-08-11 10:29:25', '0', '1', '1', '0', null, '2020-08-11 10:29:25');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('23', '1595502211', 'zhaoy01', '燕子', '2', '370124199802206018', '18105912023', '111@123.com', '1', '0106', '007', '0', '2020-08-11 10:29:25', '0', '0', '1', '0', null, '2020-08-11 10:29:25');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('24', '1595502222', 'yaowk02', '凯燕', '1', '370124199802206019', '18960992036', '123@163.com', '0', '0420', '006', '0', '2020-08-19 18:30:59', '0', '1', '2', '0', null, '2020-08-19 18:30:59');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('27', '1596610321294', 'yanzi001', '燕子01', '2', '370124199802206020', '15158854990', '1332698394@qq.com', '0', '19980220', '001', '0', '2020-08-19 16:41:52', '0', '0', '1', '1', '说点什么吧', '2020-08-19 08:41:52');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('28', '1596619146587', 'yanzi002_test', '燕子02', '1', '370124199805126010', '15158854991', '1332698394@qq.com', '1', '19980512', '008', '0', '2020-08-19 16:39:18', '0', '0', '1', '1', '', '2020-08-19 08:39:18');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('29', '1596619465860', 'yanzi003', '燕子03', '2', '370124199802206110', '15158854993', '1332598394@qq.com', '1', '19980512', '003', '0', '2020-08-19 16:38:30', '0', '0', '1', '1', '', '2020-08-19 16:38:30');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('30', '1596622848466', 'yanzi003', '燕子04', '1', '370124199805126020', '15158854995', '1332698364@qq.com', '1', '19980513', '005', '0', '2020-08-19 20:06:48', '1', '0', '1', '0', '是多少DVD发布如果不', '2020-08-19 20:06:48');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('31', '1596701289424', 'zhaoy01_test', '燕子', '1', '370124199802203025', '18105355885', '111@123.com', '1', '0106', '001', '0', '2020-08-19 16:11:29', '0', '1', '1', '0', '', '2020-08-19 16:11:29');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('32', '1598521569751', 'test11', '测试11', '1', '370124199804253028', '15158854990', '123@163.com', '2', '1998-04-25', '015', '0', '2020-08-27 17:51:31', '0', '1', '1', '0', '测试新用户添加', '2020-08-27 09:51:31');
INSERT INTO `C_CUSTOMER_INFO` VALUES ('33', '1598777623923', 'zhaoy', null, '1', null, null, null, '0', null, null, '0', '2020-08-30 08:53:44', '0', '1', '1', null, null, '2020-08-30 08:53:44');

-- ----------------------------
-- Table structure for C_LEVEL_INFO
-- ----------------------------
DROP TABLE IF EXISTS `C_LEVEL_INFO`;
CREATE TABLE `C_LEVEL_INFO` (
  `CUSTOMER_LEVEL_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '会员级别ID',
  `LEVEL_NAME` varchar(50) DEFAULT NULL COMMENT '会员级别名称',
  `MIN_POINT` int(11) DEFAULT '50' COMMENT '该级别最低积分',
  `MAX_POINT` int(11) DEFAULT '100' COMMENT '该级别最高积分',
  `LEVEL_STATUS` tinyint(1) DEFAULT '1' COMMENT '是否有效 0，无效 1有效',
  `MODIFIED_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`CUSTOMER_LEVEL_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户级别信息表';

-- ----------------------------
-- Records of C_LEVEL_INFO
-- ----------------------------
INSERT INTO `C_LEVEL_INFO` VALUES ('1', '普通会员', '0', '20000', null, '2020-08-19 09:32:41');
INSERT INTO `C_LEVEL_INFO` VALUES ('2', '超级会员', '20000', '50000', '1', '2020-08-19 09:32:23');
INSERT INTO `C_LEVEL_INFO` VALUES ('3', 'VIP特级会员', '50000', '1000000', '1', '2020-08-19 09:33:30');

-- ----------------------------
-- Table structure for C_LOGIN
-- ----------------------------
DROP TABLE IF EXISTS `C_LOGIN`;
CREATE TABLE `C_LOGIN` (
  `CUSTOMER_ID` varchar(15) NOT NULL COMMENT '客户主键ID',
  `LOGIN_NAME` varchar(20) NOT NULL COMMENT '登录用户名',
  `PASSWORD` varchar(32) NOT NULL COMMENT '登录密码(加密）',
  `USER_STATUS` tinyint(1) DEFAULT '1' COMMENT '用户状态 0，未登录 1，已登陆',
  `MODIFIED_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登录表';

-- ----------------------------
-- Records of C_LOGIN
-- ----------------------------
INSERT INTO `C_LOGIN` VALUES ('1598426450215', '123@qq.com', '202cb962ac59075b964b07152d234b70', '1', '2020-08-26 07:20:50');
INSERT INTO `C_LOGIN` VALUES ('1598426475380', '321@qq.com', 'caf1a3dfb505ffed0d024130f58c5cfa', '1', '2020-08-26 07:21:15');
INSERT INTO `C_LOGIN` VALUES ('1598426812130', '1@qq.com', '202cb962ac59075b964b07152d234b70', '1', '2020-08-26 07:26:52');
INSERT INTO `C_LOGIN` VALUES ('1598521569751', 'test', '8ddcff3a80f4189ca1c9d4d902c3c909', '1', '2020-08-27 09:46:09');
INSERT INTO `C_LOGIN` VALUES ('1598777623923', 'zhaoy', '12db2135a2f978209600fbcb8f012460', '1', '2020-08-30 08:53:44');

-- ----------------------------
-- Table structure for C_LOGIN_LOG
-- ----------------------------
DROP TABLE IF EXISTS `C_LOGIN_LOG`;
CREATE TABLE `C_LOGIN_LOG` (
  `LOGIN_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '登录日志主键ID',
  `CUSTOMER_ID` varchar(15) NOT NULL COMMENT '消费者ID',
  `LOGIN_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '登陆时间',
  `LOGIN_IP` varchar(20) DEFAULT NULL COMMENT '登录IP',
  `LOGIN_TYPE` tinyint(1) DEFAULT '0' COMMENT '登陆状态 0未登陆成功 1登录成功',
  PRIMARY KEY (`LOGIN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8 COMMENT='客户登录日志表';

-- ----------------------------
-- Records of C_LOGIN_LOG
-- ----------------------------
INSERT INTO `C_LOGIN_LOG` VALUES ('127', '1598777623923', '2020-09-02 08:59:20', '121.204.51.68', '1');

-- ----------------------------
-- Table structure for C_POINT_LOG
-- ----------------------------
DROP TABLE IF EXISTS `C_POINT_LOG`;
CREATE TABLE `C_POINT_LOG` (
  `POINT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '积分记录主键ID',
  `CUSTOMER_ID` varchar(15) NOT NULL COMMENT '消费者主键ID',
  `SOURCE` tinyint(1) NOT NULL COMMENT '积分来源：0订单，1登陆，2活动',
  `REFER_NUM` varchar(30) DEFAULT NULL COMMENT '积分来源相关编号',
  `CHARGE_POINT` int(11) DEFAULT NULL COMMENT '变更积分数',
  `RANK_POINTS` int(11) DEFAULT '0' COMMENT '等级积分,跟消费积分是分开的',
  `PAY_POINTS` int(11) DEFAULT '0' COMMENT '消费积分,跟等级积分是分开的',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '积分日志生成时间',
  `CHANGE_DESC` varchar(200) DEFAULT NULL COMMENT '消费记录说明',
  PRIMARY KEY (`POINT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户积分日志表';

-- ----------------------------
-- Records of C_POINT_LOG
-- ----------------------------

-- ----------------------------
-- Table structure for C_SIGN_LOG
-- ----------------------------
DROP TABLE IF EXISTS `C_SIGN_LOG`;
CREATE TABLE `C_SIGN_LOG` (
  `SIGN_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '签到主键',
  `CUSTOMER_ID` varchar(15) NOT NULL COMMENT '用户id',
  `MARK` varchar(20) DEFAULT NULL COMMENT '签到信息',
  `SIGN_COUNT` int(5) DEFAULT NULL COMMENT '签到次数',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `CONTINUE_SIGN` int(11) DEFAULT NULL COMMENT '连续签到',
  `BANK_1` varchar(10) DEFAULT NULL COMMENT '备用字段',
  `BANL_2` varchar(10) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`SIGN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='用户签到表';

-- ----------------------------
-- Records of C_SIGN_LOG
-- ----------------------------
INSERT INTO `C_SIGN_LOG` VALUES ('1', '1598437360073', null, '1', '2020-08-28 03:40:17', '2020-08-28 03:40:17', '1', null, null);

-- ----------------------------
-- Table structure for G_ACTIVIT
-- ----------------------------
DROP TABLE IF EXISTS `G_ACTIVIT`;
CREATE TABLE `G_ACTIVIT` (
  `ACTIVIT_ID` smallint(6) NOT NULL AUTO_INCREMENT COMMENT '活动ID',
  `SLOGAN` varchar(50) DEFAULT NULL COMMENT '活动主题标语',
  `ACTIVIT_IMG` varchar(150) DEFAULT NULL COMMENT '活动图片',
  `ACTIVIT_CONTENT` varchar(200) DEFAULT NULL COMMENT '活动内容文字说明',
  `LINK_URL` varchar(100) DEFAULT NULL COMMENT '跳转链接地址',
  `SORT_ORDER` tinyint(4) DEFAULT NULL COMMENT '活动排序',
  `START_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '活动开始时间',
  `END_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '活动结束时间',
  `IS_FINISHED` tinyint(1) DEFAULT '0' COMMENT '活动是否结束，0未开始 1，结束；2，未结束 ',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_BY` varchar(30) DEFAULT NULL COMMENT '创建者',
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `UPDATE_BY` varchar(30) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`ACTIVIT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='商城热门活动表';

-- ----------------------------
-- Records of G_ACTIVIT
-- ----------------------------
INSERT INTO `G_ACTIVIT` VALUES ('1', '个人护理蝴蝶节', '/olalashop/file/images/row1.jpg', '个人护理蝴蝶节,最高满199减100', null, '0', '2020-08-25 17:19:20', '2020-08-25 17:19:20', '0', '2020-08-25 17:19:20', 'admin', '2020-08-25 17:19:20', 'admin');
INSERT INTO `G_ACTIVIT` VALUES ('2', '宠物选美季', '/olalashop/file/images/row2.jpg', '宠物选美季，每天一元秒', null, '1', '2020-08-25 17:19:11', '2020-08-25 17:19:11', '0', '2020-08-25 17:19:11', 'admin', '2020-08-25 17:19:11', 'admin');
INSERT INTO `G_ACTIVIT` VALUES ('3', '开学了', '/olalashop/file/images/row3.jpg', '开学了，吃点好吃的', null, '2', '2020-08-25 17:19:24', '2020-08-25 17:19:24', '0', '2020-08-25 17:19:24', 'admin', '2020-08-25 17:19:24', 'admin');
INSERT INTO `G_ACTIVIT` VALUES ('4', '保鲜专家', '/olalashop/file/images/row4.jpg', '保鲜专家，给家人购幸福', null, '3', '2020-08-25 17:19:26', '2020-08-25 17:19:26', '0', '2020-08-25 17:19:26', 'admin', '2020-08-25 17:19:26', 'admin');

-- ----------------------------
-- Table structure for G_ADVERS
-- ----------------------------
DROP TABLE IF EXISTS `G_ADVERS`;
CREATE TABLE `G_ADVERS` (
  `ADVER_ID` smallint(6) NOT NULL AUTO_INCREMENT COMMENT '广告ID',
  `TITLE` varchar(100) NOT NULL COMMENT '广告主题',
  `ADVER_TYPE` varchar(10) DEFAULT NULL COMMENT '广告类别',
  `ADVER_IMG` varchar(150) DEFAULT NULL COMMENT '轮播图片',
  `ADVER_CONTENT` varchar(200) DEFAULT NULL COMMENT '广告的文字内容',
  `LINK_URL` varchar(100) DEFAULT NULL COMMENT '跳转链接地址',
  `SORT_ORDER` tinyint(4) DEFAULT NULL COMMENT '轮播排序',
  `START_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '广告开始时间',
  `END_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '广告结束时间',
  `LINK_MAN` varchar(30) DEFAULT NULL COMMENT '广告联系人',
  `LINK_EMAIL` varchar(60) DEFAULT NULL COMMENT '广告联系人的邮箱',
  `LINK_PHONE` varchar(20) DEFAULT NULL COMMENT '广告联系人的电话',
  `CLICK_COUNT` mediumint(9) DEFAULT NULL COMMENT '该广告点击数',
  `IS_SHOW` tinyint(1) DEFAULT '1' COMMENT '是否展示 0不展示 1展示',
  `IS_ENABLED` tinyint(1) DEFAULT '1' COMMENT '是否有效  1有效 0 无效',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_BY` varchar(30) DEFAULT NULL COMMENT '创建者',
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `UPDATE_BY` varchar(30) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`ADVER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='网站广告轮播图表';

-- ----------------------------
-- Records of G_ADVERS
-- ----------------------------
INSERT INTO `G_ADVERS` VALUES ('1', '由内而外爱自己', '1', '/olalashop/file/images/ad5.jpg', '由内而外爱自己', 'goodsIndexApi/queryGoodsDetail.do?goodsId=1596677386', '0', '2020-08-28 16:32:30', '2020-08-28 16:32:30', null, null, null, null, '1', '1', '2020-08-28 16:32:30', 'admin', '2020-08-28 16:32:30', 'admin');
INSERT INTO `G_ADVERS` VALUES ('2', '吃货联盟，3.8折起', '1', '/olalashop/file/images/ad6.jpg', '吃货联盟，3.8折起', 'goodsIndexApi/queryGoodsDetail.do?goodsId=1596677386', '1', '2020-08-28 16:32:33', '2020-08-28 16:32:33', null, null, null, null, '1', '1', '2020-08-28 16:32:33', 'admin', '2020-08-28 16:32:33', 'admin');
INSERT INTO `G_ADVERS` VALUES ('3', '鲜货直达', '1', '/olalashop/file/images/ad7.jpg', '鲜货直达', 'goodsIndexApi/queryGoodsDetail.do?goodsId=1596677386', '2', '2020-08-28 16:32:33', '2020-08-28 16:32:33', null, null, null, null, '1', '1', '2020-08-28 16:32:33', 'admin', '2020-08-28 16:32:33', 'admin');
INSERT INTO `G_ADVERS` VALUES ('4', '以肉换肉，节后甩肉', '1', '/olalashop/file/images/ad8.jpg', '以肉换肉，节后甩肉', 'goodsIndexApi/queryGoodsDetail.do?goodsId=1596677386', '3', '2020-08-28 16:32:34', '2020-08-28 16:32:34', null, null, null, null, '1', '1', '2020-08-28 16:32:34', 'admin', '2020-08-28 16:32:34', 'admin');

-- ----------------------------
-- Table structure for G_ARTICLE
-- ----------------------------
DROP TABLE IF EXISTS `G_ARTICLE`;
CREATE TABLE `G_ARTICLE` (
  `ARTICLE_ID` smallint(6) NOT NULL AUTO_INCREMENT COMMENT '文章主键ID',
  `ARTICLE_TITLE` varchar(100) NOT NULL COMMENT '文章标题',
  `PREF_TITLE` varchar(200) DEFAULT NULL COMMENT '文章简要标题',
  `KEYWORDS` varchar(150) DEFAULT NULL COMMENT '关键字',
  `ABSTRACTS` text COMMENT '文章摘要',
  `AUTHOR` varchar(100) DEFAULT NULL COMMENT '作者',
  `ARTICLE_TYPE` int(11) DEFAULT NULL COMMENT '文章类别',
  `ARTICLE_COLUMN` int(11) DEFAULT NULL COMMENT '文章栏目',
  `ARTICLE_SORT` int(11) DEFAULT NULL COMMENT '文章排序',
  `SOURCE` varchar(150) DEFAULT NULL COMMENT '文章来源',
  `CONTENT` text COMMENT '文章内容',
  `LINK_URL` varchar(50) DEFAULT NULL COMMENT '文章链接地址',
  `ALLOW_COMMENTS` tinyint(1) DEFAULT '0' COMMENT '是否允许评论 0不允许 1允许',
  `COMMENT_BEGIN_TIME` datetime DEFAULT NULL COMMENT '评论开始时间',
  `COMMENT_END_TIME` datetime DEFAULT NULL COMMENT '评论结束时间',
  `CLICK_COUNT` int(11) DEFAULT '1' COMMENT '点击浏览次数',
  `REVIEW_STATUS` int(11) DEFAULT NULL COMMENT '审核状态 0，未审核 1，审核通过 2，审核未通过',
  `IS_ENABLED` tinyint(1) DEFAULT '1' COMMENT '是否发布  1发布 0 未发布',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_BY` varchar(30) DEFAULT NULL COMMENT '创建者',
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `UPDATE_BY` varchar(30) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`ARTICLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='商城头条新闻表';

-- ----------------------------
-- Records of G_ARTICLE
-- ----------------------------
INSERT INTO `G_ARTICLE` VALUES ('1', '<span>【特惠】</span>洋河年末大促，低至两件五折', '<span>【特惠】</span>洋河年末大促，低至两件五折', '年末大促,五折', '<span>【特惠】</span>洋河年末大促，低至两件五折', 'zhaoy', '0', '0', '0', 'JD.com', '洋河年末大促，低至两件五折', null, '0', '2020-08-21 18:47:43', '2020-10-16 18:47:50', '1245', '0', '1', '2020-09-02 10:18:30', 'admin', '2020-09-02 10:18:30', 'admin');
INSERT INTO `G_ARTICLE` VALUES ('2', '<span>【公告】</span>商城与广州市签署战略合作协议', '<span>【公告】</span>商城与广州市签署战略合作协议', '战略合作协议', '<span>【公告】</span>商城与广州市签署战略合作协议', 'zhaoy', '1', '0', '1', 'JD.com', '商城与广州市签署战略合作协议', null, '1', '2020-08-11 15:48:02', '2020-10-31 19:48:09', '1214', '0', '1', '2020-09-02 10:18:30', 'admin', '2020-09-02 10:18:30', 'admin');
INSERT INTO `G_ARTICLE` VALUES ('3', '<span>【特惠】</span>女生节商城爆品1分秒', '<span>【特惠】</span>女生节商城爆品1分秒', '女生节', '<span>【特惠】</span>女生节商城爆品1分秒', 'zhaoy', '0', '2', '2', 'JD.com', '女生节商城爆品1分秒', null, '0', '2020-08-06 18:48:17', '2020-11-05 12:48:25', '14545', '0', '1', '2020-09-02 10:18:30', 'admin', '2020-09-02 10:18:30', 'admin');
INSERT INTO `G_ARTICLE` VALUES ('4', '<span>【公告】</span>华北、华中部分地区配送延迟', '<span>【公告】</span>华北、华中部分地区配送延迟', '配送延迟', '<span>【公告】</span>华北、华中部分地区配送延迟', 'zhaoy01', '0', '0', '3', 'JD.com', '文章内容: 华北、华中部分地区配送延迟', null, '1', '2020-08-16 18:48:17', '2020-10-31 19:48:09', '10033', '1', '1', '2020-09-02 10:18:31', 'admin', '2020-09-02 10:18:31', 'system');
INSERT INTO `G_ARTICLE` VALUES ('5', '<span>【特惠】</span>家电狂欢千亿礼券 买1送1！', '<span>【特惠】</span>家电狂欢千亿礼券 买1送1！', '家电,狂欢', '<span>【特惠】</span>家电狂欢千亿礼券 买1送1！', 'zhaoy', '0', '1', '4', 'JD.com', '家电狂欢千亿礼券 买1送1！', null, '0', '2020-08-12 18:49:07', '2020-10-22 18:49:10', '5006', '2', '1', '2020-09-02 10:18:31', 'admin', '2020-09-02 10:18:31', 'admin');
INSERT INTO `G_ARTICLE` VALUES ('6', '<span>【特惠】</span>618购物狂欢，全场购物券通用', '<span>【特惠】</span>618购物狂欢，全场购物券通用', '618', '<span>【特惠】</span>618购物狂欢，全场购物券通用', 'zhaoy', '0', '2', '5', 'JD.com', '618购物狂欢，全场购物券通用', null, '0', '2020-09-18 18:49:19', '2020-11-20 18:49:25', '5467', '2', '1', '2020-09-02 10:18:31', 'admin', '2020-09-02 10:18:31', 'admin');
INSERT INTO `G_ARTICLE` VALUES ('7', '<span>【公告】</span>华北、华中部分地区配送延迟', '<span>【公告】</span>华北、华中部分地区配送延迟', '配送延迟', '<span>【公告】</span>华北、华中部分地区配送延迟', 'zhaoy', '0', '0', '3', 'JD.com', '文章内容：华北、华中部分地区配送延迟', null, '1', '2020-08-20 18:48:17', '2021-02-23 19:48:09', '1', '1', '1', '2020-09-02 10:18:31', 'system', '2020-09-02 10:18:31', 'system');

-- ----------------------------
-- Table structure for G_BUSI_COUP
-- ----------------------------
DROP TABLE IF EXISTS `G_BUSI_COUP`;
CREATE TABLE `G_BUSI_COUP` (
  `BUSI_RED_COUP_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `COUPON_ID` int(11) NOT NULL COMMENT '优惠券主键ID',
  `BUSINESS_ID` varchar(12) NOT NULL COMMENT '店铺主键ID',
  PRIMARY KEY (`BUSI_RED_COUP_ID`),
  KEY `FK_BUSINESSID_R` (`BUSINESS_ID`) USING BTREE,
  KEY `FK_REDPICKETID_B` (`COUPON_ID`) USING BTREE,
  CONSTRAINT `G_BUSI_COUP_ibfk_1` FOREIGN KEY (`BUSINESS_ID`) REFERENCES `G_BUSINESS` (`BUSINESS_ID`),
  CONSTRAINT `G_BUSI_COUP_ibfk_2` FOREIGN KEY (`COUPON_ID`) REFERENCES `G_COUPON` (`COUPON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺与优惠券关系表';

-- ----------------------------
-- Records of G_BUSI_COUP
-- ----------------------------

-- ----------------------------
-- Table structure for G_BUSINESS
-- ----------------------------
DROP TABLE IF EXISTS `G_BUSINESS`;
CREATE TABLE `G_BUSINESS` (
  `BUSINESS_ID` varchar(12) NOT NULL COMMENT '店铺ID',
  `BUSINESS_NAME` varchar(50) NOT NULL COMMENT '店铺名称',
  `BUSINESS_SN` varchar(60) DEFAULT NULL COMMENT '店铺代码',
  `ADDRESS` varchar(150) DEFAULT NULL COMMENT '店铺的地址',
  `SEND_RANGE` varchar(200) DEFAULT NULL COMMENT '配送范围',
  `FANS_COUNT` int(11) DEFAULT '0' COMMENT '店铺的粉丝数',
  `SCORE` int(11) DEFAULT NULL COMMENT '店铺评分 整存',
  `BUSINESS_LEVEL` tinyint(1) DEFAULT NULL COMMENT '店铺等级',
  `BUSINESS_TYPE` varchar(20) DEFAULT NULL COMMENT '店铺类型 ',
  `TERMINAL_CODE` varchar(50) DEFAULT NULL COMMENT '设备终端编码',
  `STATUS` tinyint(1) DEFAULT '1' COMMENT '店铺状态 0 暂停营业，1 营业',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_BY` varchar(30) DEFAULT NULL COMMENT '创建者',
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `UPDATE_BY` varchar(30) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`BUSINESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家店铺表';

-- ----------------------------
-- Records of G_BUSINESS
-- ----------------------------
INSERT INTO `G_BUSINESS` VALUES ('1598610345', '良品铺子旗舰店', '56789abcdefghijklmnopqrstuvCDEFGH', '广州', '全国', '300000', '45', '1', '1', null, '1', '2020-08-28 18:28:16', 'system', '2020-08-28 18:28:24', 'system');

-- ----------------------------
-- Table structure for G_CATEG_BUSI
-- ----------------------------
DROP TABLE IF EXISTS `G_CATEG_BUSI`;
CREATE TABLE `G_CATEG_BUSI` (
  `CATY_BUSI_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `BUSINESS_ID` varchar(12) DEFAULT NULL COMMENT '店铺主键ID',
  `CATEGORY_ID` int(11) DEFAULT NULL COMMENT '商品分类主键ID',
  `PARENT_CATEG_ID` int(11) DEFAULT NULL COMMENT '父级分类ID',
  PRIMARY KEY (`CATY_BUSI_ID`),
  KEY `FK_BUSINESSID_C` (`BUSINESS_ID`) USING BTREE,
  KEY `FK_CATEGORYID_B` (`CATEGORY_ID`) USING BTREE,
  CONSTRAINT `G_CATEG_BUSI_ibfk_1` FOREIGN KEY (`BUSINESS_ID`) REFERENCES `G_BUSINESS` (`BUSINESS_ID`),
  CONSTRAINT `G_CATEG_BUSI_ibfk_2` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `G_CATEGORY` (`CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺分类表';

-- ----------------------------
-- Records of G_CATEG_BUSI
-- ----------------------------

-- ----------------------------
-- Table structure for G_CATEGORY
-- ----------------------------
DROP TABLE IF EXISTS `G_CATEGORY`;
CREATE TABLE `G_CATEGORY` (
  `CATEGORY_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `CATEGORY_NAME` varchar(50) NOT NULL COMMENT '分类名称',
  `PARENT_ID` varchar(12) DEFAULT '0' COMMENT '分类父级ID   默认-1为一级分类',
  `KEYWORDS` varchar(50) DEFAULT NULL COMMENT '分类编码   名称简拼，用于快捷页面跳转',
  `CATY_DESC` varchar(150) DEFAULT NULL COMMENT '商品分类描述',
  `SORT_ORL` int(11) DEFAULT NULL COMMENT '商品分类排序',
  `IS_SHOW_IN_NAV` tinyint(1) DEFAULT '0' COMMENT '是否显示在导航栏,0不;1显示',
  `GRADE` tinyint(4) DEFAULT '1' COMMENT '该分类的最高和最低价之间的价格分级,当大于1时,会根据最大最小价格区间分成区间,会在页面显示价格范围,如0-300,300-600,600-900这种;',
  `FILTER_ATTR` varchar(50) DEFAULT NULL COMMENT '如果该字段有值,则该分类将还会按照该值对应在表goods_attr的goods_attr_id所对应的属性筛选，如，封面颜色下有红，黑分类筛选',
  `IS_SHOW` tinyint(1) DEFAULT '1' COMMENT '是否展示 0不显示 1显示',
  `IS_ENABLED` tinyint(1) DEFAULT '1' COMMENT '是否有效 0无效 1有效',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_BY` varchar(30) DEFAULT NULL COMMENT '创建者',
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `UPDATE_BY` varchar(30) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=349 DEFAULT CHARSET=utf8 COMMENT='商品分类表';

-- ----------------------------
-- Records of G_CATEGORY
-- ----------------------------
INSERT INTO `G_CATEGORY` VALUES ('1', '家用电器', '-1', 'jiayongdianqi', '/olalashop/file/images/nut.png', '1', '1', '1', '01a', '1', '1', '2020-08-30 11:20:51', 'admin', '2020-08-30 11:20:51', 'admin');
INSERT INTO `G_CATEGORY` VALUES ('2', '手机', '-1', 'shouji01', '/olalashop/file/images/bamboo.png', '2', '1', '1', '02a', '1', '1', '2020-08-30 11:21:08', 'admin', '2020-08-30 11:21:08', 'admin');
INSERT INTO `G_CATEGORY` VALUES ('3', '运营商', '-1', 'yunyingshang', '/olalashop/file/images/bamboo.png', '3', '1', '1', '02a', '1', '1', '2020-08-30 11:21:21', 'admin', '2020-08-30 11:21:21', 'admin');
INSERT INTO `G_CATEGORY` VALUES ('4', '数码', '-1', 'shuma', '/olalashop/file/images/bamboo.png', '4', '1', '1', '02a', '1', '1', '2020-08-30 11:21:22', 'admin', '2020-08-30 11:21:22', 'admin');
INSERT INTO `G_CATEGORY` VALUES ('5', '蛋糕', '-1', 'diannao', '/olalashop/file/images/cake.png', '5', '1', '1', '03a', '1', '1', '2020-08-30 11:22:44', 'admin', '2020-08-30 11:22:44', 'admin');
INSERT INTO `G_CATEGORY` VALUES ('6', '点心', '-1', 'bangong', '/olalashop/file/images/cake.png', '6', '1', '1', '03a', '1', '1', '2020-08-30 11:22:45', 'admin', '2020-08-30 11:22:45', 'admin');
INSERT INTO `G_CATEGORY` VALUES ('7', '熟食', '-1', 'jiaju01', '/olalashop/file/images/meat.png', '7', '1', '1', '04a', '1', '1', '2020-08-30 11:32:06', 'admin', '2020-08-30 11:32:06', 'admin');
INSERT INTO `G_CATEGORY` VALUES ('8', '肉类', '-1', 'jiaju02', '/olalashop/file/images/meat.png', '8', '1', '1', '04a', '1', '1', '2020-08-30 11:32:08', 'admin', '2020-08-30 11:32:08', 'admin');
INSERT INTO `G_CATEGORY` VALUES ('11', '饼干', '-1', 'nanzhuang', '/olalashop/file/images/cookies.png', '11', '1', '1', '05a', '1', '1', '2020-08-30 11:23:28', 'admin', '2020-08-30 11:23:28', 'admin');
INSERT INTO `G_CATEGORY` VALUES ('12', '膨化', '-1', 'nvzhuang', '/olalashop/file/images/cookies.png', '12', '1', '1', '05a', '1', '1', '2020-08-30 11:31:46', 'admin', '2020-08-30 11:31:46', 'admin');
INSERT INTO `G_CATEGORY` VALUES ('15', '素食', '-1', 'meizhuang', '/olalashop/file/images/bamboo.png', '15', '1', '1', '06a', '1', '1', '2020-08-30 11:35:18', 'admin', '2020-08-30 11:35:18', 'admin');
INSERT INTO `G_CATEGORY` VALUES ('16', '卤味', '-1', 'gehuqingjie', '/olalashop/file/images/bamboo.png', '16', '1', '1', '06a', '1', '1', '2020-08-30 11:35:20', 'admin', '2020-08-30 11:35:20', 'admin');
INSERT INTO `G_CATEGORY` VALUES ('17', '坚果', '-1', 'chongwu', '/olalashop/file/images/nut.png', '17', '1', '1', '07a', '1', '0', '2020-08-30 11:35:06', 'admin', '2020-08-30 11:35:06', 'admin');
INSERT INTO `G_CATEGORY` VALUES ('18', '炒货', '-1', 'nvxie', '/olalashop/file/images/nut.png', '18', '1', '1', '07a', '1', '0', '2020-08-30 11:35:04', 'admin', '2020-08-30 11:35:04', 'admin');
INSERT INTO `G_CATEGORY` VALUES ('23', '运动', '-1', 'yundong', '/olalashop/file/images/fish.png', '23', '1', '1', '08a', '1', '0', '2020-08-30 11:10:21', null, '2020-08-30 11:10:21', null);
INSERT INTO `G_CATEGORY` VALUES ('24', '户外', '-1', 'huwai', '/olalashop/file/images/fish.png', '24', '1', '1', '08a', '1', '0', '2020-08-30 11:10:21', null, '2020-08-30 11:10:21', null);
INSERT INTO `G_CATEGORY` VALUES ('25', '房产', '-1', 'fangchan', '/olalashop/file/images/tea.png', '25', '1', '1', '09a', '1', '0', '2020-08-30 11:10:35', null, '2020-08-30 11:10:35', null);
INSERT INTO `G_CATEGORY` VALUES ('26', '汽车', '-1', 'qiche', '/olalashop/file/images/tea.png', '26', '1', '1', '09a', '1', '0', '2020-08-30 11:10:46', null, '2020-08-30 11:10:46', null);
INSERT INTO `G_CATEGORY` VALUES ('28', '母婴', '-1', 'muying', '/olalashop/file/images/package.png', '28', '1', '1', '10a', '1', '0', '2020-08-30 11:11:02', null, '2020-08-30 11:11:02', null);
INSERT INTO `G_CATEGORY` VALUES ('29', '玩具乐器', '-1', 'wanjuyueqi', '/olalashop/file/images/package.png', '29', '1', '1', '10a', '1', '0', '2020-08-30 11:11:07', null, '2020-08-30 11:11:07', null);
INSERT INTO `G_CATEGORY` VALUES ('31', '酒类', '-1', 'jiulei', '/olalashop/file/images/cookies.png', '31', '1', '1', '11a', '1', '0', '2020-08-30 11:11:23', null, '2020-08-30 11:11:23', null);
INSERT INTO `G_CATEGORY` VALUES ('32', '生鲜', '-1', 'shengxian', '/olalashop/file/images/cookies.png', '32', '1', '1', '11a', '1', '0', '2020-08-30 11:11:24', null, '2020-08-30 11:11:24', null);
INSERT INTO `G_CATEGORY` VALUES ('33', '特产', '-1', 'techan', '/olalashop/file/images/cookies.png', '33', '1', '1', '11a', '1', '0', '2020-08-30 11:11:26', null, '2020-08-30 11:11:26', null);
INSERT INTO `G_CATEGORY` VALUES ('35', '鲜花', '-1', 'lipinxianhua', '/olalashop/file/images/meat.png', '35', '1', '1', '12a', '1', '0', '2020-08-30 14:15:22', null, '2020-08-30 14:15:22', null);
INSERT INTO `G_CATEGORY` VALUES ('36', '农资绿植', '-1', 'nongzilvzhi', '/olalashop/file/images/meat.png', '36', '1', '1', '12a', '1', '0', '2020-08-30 11:11:46', null, '2020-08-30 11:11:46', null);
INSERT INTO `G_CATEGORY` VALUES ('37', '医药保健', '-1', 'yiyaobaojian', '/olalashop/file/images/bamboo.png', '37', '1', '1', '13a', '1', '0', '2020-08-30 11:11:58', null, '2020-08-30 11:11:58', null);
INSERT INTO `G_CATEGORY` VALUES ('38', '计生', '-1', 'jishengqingque', '/olalashop/file/images/bamboo.png', '38', '1', '1', '13a', '1', '0', '2020-08-30 14:17:08', null, '2020-08-30 14:17:08', null);
INSERT INTO `G_CATEGORY` VALUES ('40', '文娱', '-1', 'wenyu', '/olalashop/file/images/nut.png', '40', '1', '1', '14a', '1', '0', '2020-08-30 11:13:49', null, '2020-08-30 11:13:49', null);
INSERT INTO `G_CATEGORY` VALUES ('41', '教育', '-1', 'jiaoyu', '/olalashop/file/images/nut.png', '41', '1', '1', '14a', '1', '0', '2020-08-30 11:13:49', null, '2020-08-30 11:13:49', null);
INSERT INTO `G_CATEGORY` VALUES ('43', '机票', '-1', 'jipiao', '/olalashop/file/images/candy.png', '43', '1', '1', '15a', '1', '0', '2020-08-30 11:13:42', null, '2020-08-30 11:13:42', null);
INSERT INTO `G_CATEGORY` VALUES ('44', '酒店', '-1', 'jiudian', '/olalashop/file/images/candy.png', '44', '1', '1', '15a', '1', '0', '2020-08-30 11:13:52', null, '2020-08-30 11:13:52', null);
INSERT INTO `G_CATEGORY` VALUES ('45', '旅游', '-1', 'lvyou', '/olalashop/file/images/candy.png', '45', '1', '1', '15a', '1', '0', '2020-08-30 11:13:54', null, '2020-08-30 11:13:54', null);
INSERT INTO `G_CATEGORY` VALUES ('47', '理财', '-1', 'licai', '/olalashop/file/images/chocolate.png', '47', '1', '1', '16a', '1', '0', '2020-08-30 11:13:40', null, '2020-08-30 11:13:40', null);
INSERT INTO `G_CATEGORY` VALUES ('49', '白条', '-1', 'baitiao', '/olalashop/file/images/chocolate.png', '49', '1', '1', '16a', '1', '0', '2020-08-30 11:14:01', null, '2020-08-30 11:14:01', null);
INSERT INTO `G_CATEGORY` VALUES ('50', '保险', '-1', 'baoxian', '/olalashop/file/images/chocolate.png', '50', '1', '1', '16a', '1', '0', '2020-08-30 11:14:05', null, '2020-08-30 11:14:05', null);
INSERT INTO `G_CATEGORY` VALUES ('56', '电视', '1', 'dianshi', '电视', '0', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('57', '空调', '1', 'kongtiao', '空调', '1', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('58', '洗衣机', '1', 'xiyiji', '洗衣机', '2', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('59', '冰箱', '1', 'bingxiang', '冰箱', '3', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('60', '厨卫大电', '1', 'chuweidadian', '厨卫大电', '4', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('61', '厨房小电', '1', 'chufangxiaodian', '厨房小电', '5', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('62', '生活电器', '1', 'shenghuodianqi', '生活电器', '6', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('63', '个护健康', '1', 'gehujiankang', '个护健康', '7', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('64', '视听影音', '1', 'shitingyingyin', '视听影音', '8', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('65', '超薄电视', '56', 'chaobaodianshi', '超薄电视', '0', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('66', '全面屏电视', '56', 'quanmianpingdianshi', '全面屏电视', '1', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('67', '智能电视', '56', 'zhinengdianshi', '智能电视', '2', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('68', '教育电视', '56', 'jiaoyudianshi', '教育电视', '3', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', 'system');
INSERT INTO `G_CATEGORY` VALUES ('69', 'OLED电视', '56', 'oleddianshi', 'OLED电视', '4', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('70', '智慧屏', '56', 'zhihuiping', '智慧屏0101', '5', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', 'system');
INSERT INTO `G_CATEGORY` VALUES ('71', '4K超清电视', '56', '4kchaoqingdianshi', '4K超清电视，照亮你的美', '6', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', 'system');
INSERT INTO `G_CATEGORY` VALUES ('72', '55英寸', '56', '55yingcun', '55英寸', '7', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('73', '65英寸', '56', '65yingcun', '65英寸电视机', '8', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', 'system');
INSERT INTO `G_CATEGORY` VALUES ('74', '电视配件', '56', 'dianshipeijian', '电视配件', '9', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('75', '空调挂机', '57', 'kongtiaoguaji', '空调挂机', '0', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('76', '空调柜机', '57', 'kongtiaoguiji', '空调柜机', '1', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('77', '中央空调', '57', 'zhongyangkongtiao', '中央空调', '2', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('78', '变频空调', '57', 'bianpinkongtiao', '变频空调', '3', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('79', '一级能效', '57', 'yijinengxiao', '一级能效', '4', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('80', '移动空调', '57', 'yidongkongtiao', '移动空调', '5', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('81', '以旧换新', '57', 'yijiuhuanxin', '以旧换新', '6', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('82', '滚筒洗衣机', '58', 'guntongxiyiji', '滚筒洗衣机', '0', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('83', '洗烘一体机', '58', 'xihongyitiji', '洗烘一体机', '1', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('84', '波轮洗衣机', '58', 'bolunxiyiji', '波轮洗衣机', '2', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('85', '迷你洗衣机', '58', 'minixiyiji', '迷你洗衣机', '3', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('86', '烘干机', '58', 'hongganji', '烘干机', '4', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('87', '洗衣机配件', '58', 'xiyijipeijian', '洗衣机配件', '5', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('88', '多门', '59', 'duomenbx', '多门', '0', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('89', '对开门', '59', 'duikaimenbx', '对开门', '1', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('90', '三门', '59', 'sanmenbx', '三门', '2', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('91', '双门', '59', 'shuangkaimenbx', '双门', '3', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('92', '冰柜/冰吧', '59', 'binggui&bingba', '冰柜/冰吧', '4', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('93', '酒柜', '59', 'jiujiu', '酒柜', '5', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('94', '冰箱配件', '59', 'bxpj', '冰箱配件', '6', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('95', '油烟机', '60', 'chouyanji', '油烟机', '0', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('96', '燃气灶', '60', 'ranqizao', '燃气灶', '1', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('97', '烟灶套装', '60', 'yanzaotaozhuang', '烟灶套装', '2', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('98', '集成灶', '60', 'jichengzao', '集成灶', '3', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('99', '消毒柜', '60', 'xiaodugui', '消毒柜', '4', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('100', '洗碗机', '60', 'xiwanji', '洗碗机', '5', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('101', '电热水器', '60', 'dianreshuiqi', '电热水器', '6', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('102', '燃气热水器', '60', 'ranqireshuiqi', '燃气热水器', '7', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('103', '空气能热水器', '60', 'kqnrsq', '空气能热水器', '8', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('104', '太阳能热水器', '60', 'tynrsq', '太阳能热水器', '9', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('105', '嵌入式厨电', '60', 'qianrushichudian', '嵌入式厨电', '10', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('106', '烟机灶具配件', '60', 'yjzjpj', '烟机灶具配件', '11', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('107', '破壁机', '61', 'pobiji', '破壁机', '0', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('108', '电烤箱', '61', 'diankaoxiang', '电烤箱', '1', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('109', '电饭煲', '61', 'dianfanbao', '电饭煲', '2', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('110', '电压力锅', '61', 'dianyaliguo', '电压力锅', '3', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('111', '电炖锅', '61', 'diandunguo', '电炖锅', '4', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('112', '豆浆机', '61', 'doujiangji', '豆浆机', '5', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('113', '料理机', '61', 'liaoliji', '料理机', '6', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('114', '咖啡机', '61', 'kafeiji', '咖啡机', '7', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('115', '电饼铛', '61', 'dianbingcheng', '电饼铛', '8', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('116', '榨汁机/原汁机', '61', 'zzj&yzj', '榨汁机/原汁机', '9', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('117', '电水壶/热水瓶', '61', 'dsh&rsp', '电水壶/热水瓶', '10', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('118', '微波炉', '61', 'weibolu', '微波炉', '11', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('119', '电热饭盒', '61', 'dianrefanhe', '电热饭盒', '12', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('120', '电火锅', '61', 'dianhuoguo', '电火锅', '13', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('121', '养生壶', '61', 'yangshenghu', '养生壶', '14', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('122', '电磁炉', '61', 'diancilu', '电磁炉', '15', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('123', '面包机', '61', 'mianboji', '面包机', '16', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('124', '空气炸锅', '61', 'kongqizhaguo', '空气炸锅', '17', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('125', '面条机', '61', 'miantiaoji', '面条机', '18', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('126', '电陶炉', '61', 'diantaolu', '电陶炉', '19', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('127', '煮蛋器', '61', 'zhudanqi', '煮蛋器', '20', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('128', '电烧烤炉', '61', 'dianshaokaolu', '电烧烤炉', '21', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('129', '电风扇', '62', 'dianfengshan', '电风扇', '0', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('130', '冷风扇', '62', 'lengfengshan', '冷风扇', '1', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('131', '空气净化器', '62', 'kqjhq', '空气净化器', '2', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('132', '吸尘器', '62', 'xichenqi', '吸尘器', '3', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('133', '除螨仪', '62', 'chumanyi', '除螨仪', '4', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('134', '扫地机器人', '62', 'sdjqr', '扫地机器人', '5', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('135', '除湿机', '62', 'chushiji', '除湿机', '6', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('136', '干衣机', '62', 'ganyiji', '干衣机', '7', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('137', '蒸汽拖把/拖地机', '62', 'zqtb&tdj', '蒸汽拖把/拖地机', '8', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('138', '挂烫机/熨斗', '62', 'gtj&yd', '挂烫机/熨斗', '9', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('139', '电话机', '62', 'dianhuaji', '电话机', '10', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('140', '饮水机', '62', 'yinshuiji', '饮水机', '11', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('141', '净水器', '62', 'jingshuiqi', '净水器', '12', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('142', '取暖器', '62', 'qunuanqi', '取暖器', '13', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('143', '加湿器', '62', 'jiashiqi', '加湿器', '14', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('144', '毛球修剪器', '62', 'mqxjq', '毛球修剪器', '15', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('145', '生活电器配件', '62', 'shdqpj', '生活电器配件', '16', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('146', '剃须刀', '63', 'tixudao', '剃须刀', '0', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('147', '电动牙刷', '63', 'diandongyashua', '电动牙刷', '1', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('148', '电吹风', '63', 'dianchuifeng', '电吹风', '2', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('149', '美容仪', '63', 'meirongyi', '美容仪', '3', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('150', '洁面仪', '63', 'jiemianyi', '洁面仪', '4', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('151', '按摩器', '63', 'anmoqi', '按摩器', '5', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('152', '健康秤', '63', 'jiankangcheng', '健康秤', '6', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('153', '卷/直发器', '63', 'juan&zhifaqi', '卷/直发器', '7', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('154', '剃/脱毛器', '63', 'ti&tuomaoqi', '剃/脱毛器', '8', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('155', '理发器', '63', 'lifaqi', '理发器', '9', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('156', '足浴盆', '63', 'zuyupen', '足浴盆', '10', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('157', '足疗机', '63', 'zuliaoji', '足疗机', '11', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('158', '按摩椅', '63', 'anmoyi', '按摩椅', '12', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('159', '家庭影院', '64', 'jiatingyingyuan', '家庭影院', '0', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('160', 'KTV音响', '64', 'ktvyinxiang', 'KTV音响', '1', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('161', '迷你音响', '64', 'miniyinxiang', '迷你音响', '2', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('162', 'DVD', '64', 'dvd', 'DVD', '3', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('163', '功放', '64', 'gongfang', '功放', '4', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('164', '回音壁', '64', 'huiyinbi', '回音壁', '5', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('165', '麦克风', '64', 'maikefeng', '麦克风', '6', '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('166', '手机通讯', '2', 'shoujitongxun', '手机通讯', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('167', '运营商', '2', 'yunyingshang', '运营商', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('168', '手机配件', '2', 'shoujipeijian', '手机配件', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('169', '摄影摄像', '2', 'sheyingshexiang', '摄影摄像', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('170', '数码配件', '2', 'shumapeijian', '数码配件', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('171', '影音娱乐', '2', 'yingyinyule', '影音娱乐', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('172', '智能设备', '2', 'zhinengshebei', '智能设备', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('173', '电子教育', '2', 'dianzijiaoyu', '电子教育', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('174', '手机', '166', 'shouji02', '手机', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('175', '游戏手机', '166', 'youxishouji', '游戏手机', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('176', '5G手机', '166', '5gshouji', '5G手机', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('177', '拍照手机', '166', 'paizhaoshouji', '拍照手机', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('178', '全面屏手机', '166', 'qmpshouji', '全面屏手机', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('179', '老人机', '166', 'laorenji', '老人机', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('180', '对讲机', '166', 'duijiangji', '对讲机', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('181', '以旧换新', '166', 'yijiuhuanxin', '以旧换新', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('182', '手机维修', '166', 'shoujiweixiu', '手机维修', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('183', '合约机', '167', 'heyueji', '合约机', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('184', '手机卡', '167', 'shoujika', '手机卡', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('185', '宽带', '167', 'kuandai', '宽带', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('186', '充话费/流量', '167', 'chf&liul', '充话费/流量', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('187', '中国电信', '167', 'zgdx', '中国电信', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('188', '中国移动', '167', 'zgyd', '中国移动', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('189', '中国联通', '167', 'zglt', '中国联通', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('190', '京东通信', '167', 'jdtx', '京东通信', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('191', '挑靓号', '167', 'tiaolianghao', '挑靓号', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('192', '手机壳', '168', 'shoujike', '手机壳', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('193', '贴膜', '168', 'tiemo', '贴膜', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('194', '手机存储卡', '168', 'shoujicunchuka', '手机存储卡', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('195', '数据线', '168', 'shujuxian', '数据线', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('196', '充电器', '168', 'chongdianqi', '充电器', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('197', '手机耳机', '168', 'shoujierji', '手机耳机', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('198', '创意配件', '168', 'chuangyipeijian', '创意配件', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('199', '手机饰品', '168', 'shoujishipin', '手机饰品', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('200', '手机电池', '168', 'shoujidianchi', '手机电池', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('201', '苹果周边', '168', 'pingguozhoubian', '苹果周边', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('202', '移动电源', '168', 'yidongdianyuan', '移动电源', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('203', '蓝牙耳机', '168', 'lanyaerji', '蓝牙耳机', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('204', '手机支架', '168', 'shoujizhijia', '手机支架', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('205', '拍照配件', '168', 'paizhaopeijian', '拍照配件', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('206', '数码相机', '169', 'shumaxj', '数码相机', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('207', '微单相机', '169', 'weidanxj', '微单相机', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('208', '单反相机', '169', 'danfanxj', '单反相机', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('209', '拍立得', '169', 'pailide', '拍立得', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('210', '运动相机', '169', 'yundongxiangji', '运动相机', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('211', '摄像机', '169', 'shexiangji', '摄像机', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('212', '镜头', '169', 'jingtou', '镜头', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('213', '户外器材', '169', 'huwaiqicai', '户外器材', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('214', '影棚器材', '169', 'yingpengqicai', '影棚器材', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('215', '冲印服务', '169', 'chongyinfuwu', '冲印服务', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('216', '数码相框', '169', 'shumaxiangkuang', '数码相框', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('217', '存储卡', '170', 'cunchuka', '存储卡', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('218', '三脚架/云台', '170', 'sanjiaojia&yuntai', '三脚架/云台', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('219', '相机包', '170', 'xiangjibao', '相机包', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('220', '滤镜', '170', 'lvjing', '滤镜', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('221', '闪光灯/手柄', '170', 'sgd&sb', '闪光灯/手柄', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('222', '相机清洁/贴膜', '170', 'xjqj&tm', '相机清洁/贴膜', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('223', '机身附件', '170', 'jishenfujian', '机身附件', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('224', '镜头附件', '170', 'jingtoufujian', '镜头附件', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('225', '读卡器', '170', 'dukaqi', '读卡器', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('226', '支架', '170', 'zhijia', '支架', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('227', '电池/充电器', '170', 'dc&cdq', '电池/充电器', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('228', '耳机/耳麦', '171', 'ej&em', '耳机/耳麦', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('229', '音箱/音响', '171', 'yx&yx', '音箱/音响', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('230', '智能音箱', '171', 'zhinengyinxiang', '智能音箱', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('231', '收音机', '171', 'shouyinji', '收音机', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('232', '麦克风', '171', 'maikefeng02', '麦克风', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('233', 'MP3/MP4', '171', 'mp3&mp4', 'MP3/MP4', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('234', '专业音频', '171', 'zhuanyeyinpin', '专业音频', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('235', '音频线', '171', 'yinpinxian', '音频线', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('236', '智能手环', '172', 'zhinengshouhuan', '智能手环', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('237', '智能手表', '172', 'zhinengshoubiao', '智能手表', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('238', '智能眼镜', '172', 'zhinengyanjing', '智能眼镜', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('239', '智能机器人', '172', 'znjqr', '智能机器人', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('240', '运动跟踪器', '172', 'ydgzq', '运动跟踪器', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('241', '健康监测', '172', 'jiankangjiance', '健康监测', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('242', '智能配饰', '172', 'zhinengpeishi', '智能配饰', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('243', '智能家居', '172', 'zhinengjiaju', '智能家居', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('244', '体感车', '172', 'tiganche', '体感车', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('245', '无人机', '172', 'wurenji', '无人机', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('246', '学生平板', '173', 'xuexipinban', '学生平板', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('247', '点读机/笔', '173', 'dianduji&bi', '点读机/笔', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('248', '早教益智', '173', 'zaojiaoyizhi', '早教益智', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('249', '录音笔', '173', 'luyinbi', '录音笔', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('250', '电纸书', '173', 'dianzhishu', '电纸书', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('251', '电子词典', '173', 'dianzicidian', '电子词典', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('252', '复读机', '173', 'fuduji', '复读机', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('253', '翻译机', '173', 'fanyiji', '翻译机', null, '0', '1', null, '1', '1', '2020-08-25 16:07:35', null, '2020-08-25 16:07:35', null);
INSERT INTO `G_CATEGORY` VALUES ('254', '蛋糕', '5', 'dangao', '蛋糕', '0', '0', '1', null, '1', '1', null, null, null, null);
INSERT INTO `G_CATEGORY` VALUES ('255', '点心', '6', 'dianxin', '点心', '1', '0', '1', null, '1', '1', '2020-08-30 11:45:25', null, '2020-08-30 11:45:25', null);
INSERT INTO `G_CATEGORY` VALUES ('256', '蒸蛋糕', '254', 'zhengdg', '蒸蛋糕', '0', '0', '1', null, '1', '1', '2020-08-30 11:45:29', null, '2020-08-30 11:45:29', null);
INSERT INTO `G_CATEGORY` VALUES ('257', '脱水蛋糕', '254', 'tuosdg', '脱水蛋糕', '1', '0', '1', null, '1', '1', '2020-08-30 11:45:30', null, '2020-08-30 11:45:30', null);
INSERT INTO `G_CATEGORY` VALUES ('258', '瑞士卷', '254', 'ruishij', '瑞士卷', '2', '0', '1', null, '1', '1', '2020-08-30 11:45:30', null, '2020-08-30 11:45:30', null);
INSERT INTO `G_CATEGORY` VALUES ('259', '软面包', '254', 'ruanmb', '软面包', '3', '0', '1', null, '1', '1', '2020-08-30 11:45:31', null, '2020-08-30 11:45:31', null);
INSERT INTO `G_CATEGORY` VALUES ('260', '马卡龙', '254', 'makalong', '马卡龙', '4', '0', '1', null, '1', '1', '2020-08-30 11:45:32', null, '2020-08-30 11:45:32', null);
INSERT INTO `G_CATEGORY` VALUES ('261', '千层饼', '254', 'qiancengb', '千层饼', '5', '0', '1', null, '1', '1', '2020-08-30 11:45:32', null, '2020-08-30 11:45:32', null);
INSERT INTO `G_CATEGORY` VALUES ('262', '甜甜圈', '254', 'ttquan', '甜甜圈', '6', '0', '1', null, '1', '1', '2020-08-30 11:45:34', null, '2020-08-30 11:45:34', null);
INSERT INTO `G_CATEGORY` VALUES ('263', '蒸三明治', '254', 'zsanmingzhi', '蒸三明治', '7', '0', '1', null, '1', '1', '2020-08-30 11:45:36', null, '2020-08-30 11:45:36', null);
INSERT INTO `G_CATEGORY` VALUES ('264', '铜锣烧', '254', 'tongluosaho', '铜锣烧', '8', '0', '1', null, '1', '1', '2020-08-30 11:45:40', null, '2020-08-30 11:45:40', null);
INSERT INTO `G_CATEGORY` VALUES ('265', '蒸蛋糕', '255', 'zhengdg', '蒸蛋糕', '0', '0', '1', null, '1', '1', '2020-08-30 11:45:43', null, '2020-08-30 11:45:43', null);
INSERT INTO `G_CATEGORY` VALUES ('266', '脱水蛋糕', '255', 'tuosdg', '脱水蛋糕', '1', '0', '1', null, '1', '1', '2020-08-30 11:45:44', null, '2020-08-30 11:45:44', null);
INSERT INTO `G_CATEGORY` VALUES ('267', '瑞士卷', '255', 'ruishij', '瑞士卷', '2', '0', '1', null, '1', '1', '2020-08-30 11:45:45', null, '2020-08-30 11:45:45', null);
INSERT INTO `G_CATEGORY` VALUES ('268', '软面包', '255', 'ruanmb', '软面包', '3', '0', '1', null, '1', '1', '2020-08-30 11:45:47', null, '2020-08-30 11:45:47', null);
INSERT INTO `G_CATEGORY` VALUES ('269', '马卡龙', '255', 'makalong', '马卡龙', '4', '0', '1', null, '1', '1', '2020-08-30 11:45:48', null, '2020-08-30 11:45:48', null);
INSERT INTO `G_CATEGORY` VALUES ('270', '千层饼', '255', 'qiancengb', '千层饼', '5', '0', '1', null, '1', '1', '2020-08-30 11:45:48', null, '2020-08-30 11:45:48', null);
INSERT INTO `G_CATEGORY` VALUES ('271', '甜甜圈', '255', 'ttquan', '甜甜圈', '6', '0', '1', null, '1', '1', '2020-08-30 11:45:49', null, '2020-08-30 11:45:49', null);
INSERT INTO `G_CATEGORY` VALUES ('272', '蒸三明治', '255', 'zsanmingzhi', '蒸三明治', '7', '0', '1', null, '1', '1', '2020-08-30 11:45:49', null, '2020-08-30 11:45:49', null);
INSERT INTO `G_CATEGORY` VALUES ('273', '铜锣烧', '255', 'tongluosaho', '铜锣烧', '8', '0', '1', null, '1', '1', '2020-08-30 11:45:50', null, '2020-08-30 11:45:50', null);
INSERT INTO `G_CATEGORY` VALUES ('274', '饼干', '11', 'binggan', '饼干', '0', '0', '1', null, '1', '1', '2020-08-30 11:45:57', null, '2020-08-30 11:45:57', null);
INSERT INTO `G_CATEGORY` VALUES ('275', '薯片', '12', 'shupian', '薯片', '1', '0', '1', null, '1', '1', '2020-08-30 11:46:08', null, '2020-08-30 11:46:08', null);
INSERT INTO `G_CATEGORY` VALUES ('276', '虾条', '11', 'xiatiao', '虾条', '2', '0', '1', null, '1', '1', '2020-08-30 11:46:11', null, '2020-08-30 11:46:11', null);
INSERT INTO `G_CATEGORY` VALUES ('277', '薄脆饼干', '274', 'baocuib', '薄脆饼干', '0', '0', '1', null, '1', '1', '2020-08-30 11:51:28', null, '2020-08-30 11:51:28', null);
INSERT INTO `G_CATEGORY` VALUES ('278', '肉松饼', '274', 'rousongb', '肉松饼', '1', '0', '1', null, '1', '1', '2020-08-30 11:51:28', null, '2020-08-30 11:51:28', null);
INSERT INTO `G_CATEGORY` VALUES ('279', '华夫饼', '274', 'huafub', '华夫饼', '2', '0', '1', null, '1', '1', '2020-08-30 11:51:28', null, '2020-08-30 11:51:28', null);
INSERT INTO `G_CATEGORY` VALUES ('280', '夹心饼干', '274', 'jxbg', '夹心饼干', '3', '0', '1', null, '1', '1', '2020-08-30 11:51:28', null, '2020-08-30 11:51:28', null);
INSERT INTO `G_CATEGORY` VALUES ('281', '曲奇', '274', 'quqi', '曲奇', '4', '0', '1', null, '1', '1', '2020-08-30 11:51:28', null, '2020-08-30 11:51:28', null);
INSERT INTO `G_CATEGORY` VALUES ('282', '乐事', '275', 'zhengdg', '乐事', '0', '0', '1', null, '1', '1', '2020-08-30 11:54:17', null, '2020-08-30 11:54:17', null);
INSERT INTO `G_CATEGORY` VALUES ('283', '可比克', '275', 'tuosdg', '可比克', '1', '0', '1', null, '1', '1', '2020-08-30 11:54:17', null, '2020-08-30 11:54:17', null);
INSERT INTO `G_CATEGORY` VALUES ('284', '薯愿', '275', 'ruishij', '薯愿', '2', '0', '1', null, '1', '1', '2020-08-30 11:54:17', null, '2020-08-30 11:54:17', null);
INSERT INTO `G_CATEGORY` VALUES ('285', 'Pringles', '275', 'pringles', 'Pringles', '3', '0', '1', null, '1', '1', '2020-08-30 11:54:40', null, '2020-08-30 11:54:40', null);
INSERT INTO `G_CATEGORY` VALUES ('286', 'Orion', '275', 'orion', 'Orion', '4', '0', '1', null, '1', '1', '2020-08-30 11:54:35', null, '2020-08-30 11:54:35', null);
INSERT INTO `G_CATEGORY` VALUES ('287', '阿婆家', '275', 'qiancengb', '阿婆家', '5', '0', '1', null, '1', '1', '2020-08-30 11:54:17', null, '2020-08-30 11:54:17', null);
INSERT INTO `G_CATEGORY` VALUES ('288', '星座薯片', '275', 'ttquan', '星座薯片', '6', '0', '1', null, '1', '1', '2020-08-30 11:54:17', null, '2020-08-30 11:54:17', null);
INSERT INTO `G_CATEGORY` VALUES ('289', 'Doritos', '275', 'doritos', 'Doritos', '7', '0', '1', null, '1', '1', '2020-08-30 11:54:30', null, '2020-08-30 11:54:30', null);
INSERT INTO `G_CATEGORY` VALUES ('291', '亲亲虾条', '276', 'qinqiqn', '亲亲虾条', '0', '0', '1', null, '1', '1', '2020-08-30 11:59:21', null, '2020-08-30 11:59:21', null);
INSERT INTO `G_CATEGORY` VALUES ('292', '咪咪', '276', 'mimixt', '咪咪虾条', '1', '0', '1', null, '1', '1', '2020-08-30 11:59:16', null, '2020-08-30 11:59:16', null);
INSERT INTO `G_CATEGORY` VALUES ('293', 'NONG SHIM', '276', 'nongxin', '农心', '2', '0', '1', null, '1', '1', '2020-08-30 11:59:10', null, '2020-08-30 11:59:10', null);
INSERT INTO `G_CATEGORY` VALUES ('294', '奇多', '276', 'qiduo', '奇多 虾片', '3', '0', '1', null, '1', '1', '2020-08-30 11:59:01', null, '2020-08-30 11:59:01', null);
INSERT INTO `G_CATEGORY` VALUES ('295', '来伊份', '276', 'laiyifen', '来伊份 虾条', '4', '0', '1', null, '1', '1', '2020-08-30 11:58:58', null, '2020-08-30 11:58:58', null);
INSERT INTO `G_CATEGORY` VALUES ('296', '啪啪通', '276', 'papatong', '印尼进口 啪啪通 虾片', '5', '0', '1', null, '1', '1', '2020-08-30 11:58:54', null, '2020-08-30 11:58:54', null);
INSERT INTO `G_CATEGORY` VALUES ('297', '上好佳', '276', 'shanghaojia', '上好佳鲜虾片', '6', '0', '1', null, '1', '1', '2020-08-30 11:58:49', null, '2020-08-30 11:58:49', null);
INSERT INTO `G_CATEGORY` VALUES ('298', '爱尚', '276', 'aishangmimi', '爱尚正宗咪咪虾条', '7', '0', '1', null, '1', '1', '2020-08-30 11:58:45', null, '2020-08-30 11:58:45', null);
INSERT INTO `G_CATEGORY` VALUES ('299', 'Calbee', '276', 'calbee', 'Calbee/卡乐比 泰国进口 薯片', '8', '0', '1', null, '1', '1', '2020-08-30 11:58:37', null, '2020-08-30 11:58:37', null);
INSERT INTO `G_CATEGORY` VALUES ('300', '猪肉脯', '7', 'zhuroupu', '猪肉脯', null, '0', '1', null, '1', '1', '2020-08-30 11:48:45', null, '2020-08-30 11:48:45', null);
INSERT INTO `G_CATEGORY` VALUES ('301', '牛肉丝', '8', 'niurousi', '牛肉丝', null, '0', '1', null, '1', '1', '2020-08-30 11:48:51', null, '2020-08-30 11:48:51', null);
INSERT INTO `G_CATEGORY` VALUES ('302', '小香肠', '8', 'xiaoxc', '小香肠', null, '0', '1', null, '1', '1', '2020-08-30 11:48:57', null, '2020-08-30 11:48:57', null);
INSERT INTO `G_CATEGORY` VALUES ('303', '良品铺子', '300', 'lpinpuzi', '良品铺子', null, '0', '1', null, '1', '1', '2020-08-30 12:01:05', null, '2020-08-30 12:01:05', null);
INSERT INTO `G_CATEGORY` VALUES ('304', '三只松鼠', '300', 'sanzss', '三只松鼠', null, '0', '1', null, '1', '1', '2020-08-30 12:01:05', null, '2020-08-30 12:01:05', null);
INSERT INTO `G_CATEGORY` VALUES ('305', '自然派', '300', 'ziranpai', '自然派', null, '0', '1', null, '1', '1', null, null, null, null);
INSERT INTO `G_CATEGORY` VALUES ('306', '百草味', '301', 'baicaowei', '百草味', null, '0', '1', null, '1', '1', null, null, null, null);
INSERT INTO `G_CATEGORY` VALUES ('307', '老川东', '301', 'laochuandong', '老川东 牛肉干小吃零食 灯影牛肉丝麻辣味13g*20袋/盒', null, '1', '1', null, '1', '1', '2020-08-30 12:16:06', null, '2020-08-30 12:16:06', null);
INSERT INTO `G_CATEGORY` VALUES ('308', '伊赛', '301', 'yisai', '伊赛 炒菜牛肉丝600g/套(150g*4袋)谷饲 生鲜牛肉', null, '2', '1', null, '1', '1', '2020-08-30 12:16:06', null, '2020-08-30 12:16:06', null);
INSERT INTO `G_CATEGORY` VALUES ('309', '好牛', '301', 'haoniu', '好牛 四川特产 休闲零食 牛肉干小吃 灯影牛肉丝 香辣味108g', null, '3', '1', null, '1', '1', '2020-08-30 12:16:07', null, '2020-08-30 12:16:07', null);
INSERT INTO `G_CATEGORY` VALUES ('310', '蜀道香', '301', 'shudaoxiang', '蜀道香 灯影牛肉丝150g 四川麻辣味休闲零食小吃特产牛肉干零食', null, '4', '1', null, '1', '1', '2020-08-30 12:16:07', null, '2020-08-30 12:16:07', null);
INSERT INTO `G_CATEGORY` VALUES ('311', '良品铺子', '302', 'lpinpuzi', '良品铺子迷你香肠碳烤味猪肉类零食肉干肉脯网红零食小吃休闲食品145g', null, '5', '1', null, '1', '1', '2020-08-30 12:16:08', null, '2020-08-30 12:16:08', null);
INSERT INTO `G_CATEGORY` VALUES ('312', '口水娃', '302', 'koushuiwa', '口水娃 小香肠肉枣熟食肉类零食小吃 原香味烤肠360g/袋', null, '6', '1', null, '1', '1', '2020-08-30 12:16:08', null, '2020-08-30 12:16:08', null);
INSERT INTO `G_CATEGORY` VALUES ('313', '三只松鼠', '302', 'sanzhiss', '三只松鼠滋滋炭烤肠 休闲零食 猪肉肠肉干肉脯腊肠小香肠黑胡椒味198g', null, '7', '1', null, '1', '1', '2020-08-30 12:16:09', null, '2020-08-30 12:16:09', null);
INSERT INTO `G_CATEGORY` VALUES ('314', '杨大爷', '302', 'yangdy', '杨大爷 广味腊肠甜味小香肠90g', null, '7', '1', null, '1', '1', '2020-08-30 12:16:09', null, '2020-08-30 12:16:09', null);
INSERT INTO `G_CATEGORY` VALUES ('315', '坚果', '17', 'jianguo', '坚果', null, '0', '1', null, '1', '1', '2020-08-30 12:08:27', null, '2020-08-30 12:08:27', null);
INSERT INTO `G_CATEGORY` VALUES ('316', '锅巴', '18', 'chaohuo', '锅巴', null, '1', '1', null, '1', '1', '2020-08-30 12:15:59', null, '2020-08-30 12:15:59', null);
INSERT INTO `G_CATEGORY` VALUES ('317', '良品铺子', '315', 'lpinpuzi', '良品铺子', null, '0', '1', null, '1', '1', null, null, null, null);
INSERT INTO `G_CATEGORY` VALUES ('318', '三只松鼠', '315', 'sanzss', '三只松鼠', null, '1', '1', null, '1', '1', '2020-08-30 12:15:42', null, '2020-08-30 12:15:42', null);
INSERT INTO `G_CATEGORY` VALUES ('319', '百草味', '315', 'baicaowei', '百草味', null, '2', '1', null, '1', '1', '2020-08-30 12:15:44', null, '2020-08-30 12:15:44', null);
INSERT INTO `G_CATEGORY` VALUES ('320', 'KINUS', '315', 'kinas', '中粮可兰纳斯KINUS', null, '3', '1', null, '1', '1', '2020-08-30 12:15:45', null, '2020-08-30 12:15:45', null);
INSERT INTO `G_CATEGORY` VALUES ('321', 'miguo', '315', 'miguo', '觅菓 miguo 混合坚果果仁原味什锦果仁1.05kg罐装', null, '4', '1', null, '1', '1', '2020-08-30 12:15:46', null, '2020-08-30 12:15:46', null);
INSERT INTO `G_CATEGORY` VALUES ('322', '太阳公公', '315', 'taiyanggg', '太阳公公 每日坚果干果礼盒', null, '5', '1', null, '1', '1', '2020-08-30 12:15:46', null, '2020-08-30 12:15:46', null);
INSERT INTO `G_CATEGORY` VALUES ('323', '中粮时怡', '315', 'zlshiyi', '中粮时怡 大罐优选高纤什锦果仁 ', null, '6', '1', null, '1', '1', '2020-08-30 12:15:47', null, '2020-08-30 12:15:47', null);
INSERT INTO `G_CATEGORY` VALUES ('324', '松川良品', '315', 'songchuanlp', '松川良品 休闲零食每日坚果炒货', null, '7', '1', null, '1', '1', '2020-08-30 12:15:47', null, '2020-08-30 12:15:47', null);
INSERT INTO `G_CATEGORY` VALUES ('325', '老街口', '316', 'laojiekou', '老街口牛肉味兰花豆500g坚果炒货', null, '8', '1', null, '1', '1', '2020-08-30 12:15:48', null, '2020-08-30 12:15:48', null);
INSERT INTO `G_CATEGORY` VALUES ('326', '甘源牌', '316', 'ganyuanpai', '甘源牌 休闲零食', null, '1', '1', null, '1', '1', '2020-08-30 12:15:28', null, '2020-08-30 12:15:28', null);
INSERT INTO `G_CATEGORY` VALUES ('327', '酷馨', '316', 'kuxin', '酷馨 炒黑豆500g*2袋特产熟黑豆即食零食炒货香酥大豆小吃干炒黑豆绿芯无油盐炒', null, '2', '1', null, '1', '1', '2020-08-30 12:15:29', null, '2020-08-30 12:15:29', null);
INSERT INTO `G_CATEGORY` VALUES ('328', '奶油花生', '316', 'naiyouhuasheng', '旺瓜 坚果炒货 休闲零食 奶油花生', null, '3', '1', null, '1', '1', '2020-08-30 12:15:31', null, '2020-08-30 12:15:31', null);
INSERT INTO `G_CATEGORY` VALUES ('329', '炒松子', '316', 'chaosongzi', '松子', null, '4', '1', null, '1', '1', '2020-08-30 12:15:32', null, '2020-08-30 12:15:32', null);
INSERT INTO `G_CATEGORY` VALUES ('330', '榛子', '316', 'zhenzi', '榛子', null, '5', '1', null, '1', '1', '2020-08-30 12:15:33', null, '2020-08-30 12:15:33', null);
INSERT INTO `G_CATEGORY` VALUES ('331', '夏威夷果', '316', 'xiaweiyiguo', '夏威夷果', null, '6', '1', null, '1', '1', '2020-08-30 12:15:37', null, '2020-08-30 12:15:37', null);
INSERT INTO `G_CATEGORY` VALUES ('332', '豆干', '16', 'dougan', '豆干', null, '0', '1', null, '1', '1', '2020-08-30 12:17:20', null, '2020-08-30 12:17:20', null);
INSERT INTO `G_CATEGORY` VALUES ('333', '干笋', '15', 'gansun', '干笋', null, '1', '1', null, '1', '1', '2020-08-30 12:30:30', null, '2020-08-30 12:30:30', null);
INSERT INTO `G_CATEGORY` VALUES ('334', '鸭脖', '16', 'yabo', '鸭脖', null, '2', '1', null, '1', '1', '2020-08-30 12:30:31', null, '2020-08-30 12:30:31', null);
INSERT INTO `G_CATEGORY` VALUES ('335', '好巴食', '332', 'haobashi', '好巴食 豆腐干 休闲零食', null, '0', '1', null, '1', '1', '2020-08-30 12:26:21', null, '2020-08-30 12:26:21', null);
INSERT INTO `G_CATEGORY` VALUES ('336', '鱼豆腐', '332', 'yudoufu', '亲亲 鱼豆腐', null, '1', '1', null, '1', '1', '2020-08-30 12:30:33', null, '2020-08-30 12:30:33', null);
INSERT INTO `G_CATEGORY` VALUES ('337', '长沙臭豆腐', '332', 'choudoufu', '长沙臭豆腐', null, '2', '1', null, '1', '1', '2020-08-30 12:30:33', null, '2020-08-30 12:30:33', null);
INSERT INTO `G_CATEGORY` VALUES ('338', '劲仔豆干', '332', 'jinzaidougan', '劲仔 休闲零食 豆干', null, '3', '1', null, '1', '1', '2020-08-30 12:30:34', null, '2020-08-30 12:30:34', null);
INSERT INTO `G_CATEGORY` VALUES ('339', '挑货佬', '333', 'tiaohuolao', '挑货佬 黄山毛笋片', null, '0', '1', null, '1', '1', '2020-08-30 12:30:47', null, '2020-08-30 12:30:47', null);
INSERT INTO `G_CATEGORY` VALUES ('340', '油焖烟笋', '333', 'youmengyans', '湖南特产烟笋油焖烟笋', null, '1', '1', null, '1', '1', '2020-08-30 12:30:51', null, '2020-08-30 12:30:51', null);
INSERT INTO `G_CATEGORY` VALUES ('341', '天马笋干', '333', 'tianmasung', '川珍南北干货竹笋干笋丝', null, '2', '1', null, '1', '1', '2020-08-30 12:30:52', null, '2020-08-30 12:30:52', null);
INSERT INTO `G_CATEGORY` VALUES ('342', '来凤馆', '333', 'laifengguan', '先疯农人【来凤馆】玉兰片', null, '3', '1', null, '1', '1', '2020-08-30 12:30:55', null, '2020-08-30 12:30:55', null);
INSERT INTO `G_CATEGORY` VALUES ('343', '周黑鸭', '334', 'zhouheiya', '武汉周黑鸭', null, '0', '1', null, '1', '1', '2020-08-30 12:30:11', null, '2020-08-30 12:30:11', null);
INSERT INTO `G_CATEGORY` VALUES ('344', '良品铺子', '334', 'liangpnpz', '烧烤鸭脖卤味肉干肉脯零食小吃', null, '1', '1', null, '1', '1', '2020-08-30 12:30:59', null, '2020-08-30 12:30:59', null);
INSERT INTO `G_CATEGORY` VALUES ('345', '百草味', '334', 'baicaowei', '百草味 鸭脖零食', null, '2', '1', null, '1', '1', '2020-08-30 12:31:00', null, '2020-08-30 12:31:00', null);
INSERT INTO `G_CATEGORY` VALUES ('346', '三只松鼠鸭肉', '334', 'sanzhiss', '三只松鼠鸭肉大礼包', null, '3', '1', null, '1', '1', '2020-08-30 12:31:37', null, '2020-08-30 12:31:37', null);
INSERT INTO `G_CATEGORY` VALUES ('347', '可可哥精武', '334', 'kekegjw', '可可哥精武鸭脖子', null, '0', '1', null, '1', '1', '2020-08-30 12:32:02', null, '2020-08-30 12:32:02', null);
INSERT INTO `G_CATEGORY` VALUES ('348', '绝艺鸭脖', '334', 'jueyiyab', '绝艺鸭脖麻辣零食 送女友', null, '0', '1', null, '1', '1', null, null, null, null);

-- ----------------------------
-- Table structure for G_COUPON
-- ----------------------------
DROP TABLE IF EXISTS `G_COUPON`;
CREATE TABLE `G_COUPON` (
  `COUPON_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '优惠券主键ID',
  `COUPON_SN` varchar(12) DEFAULT NULL COMMENT '优惠券编号',
  `TITLE` varchar(50) DEFAULT NULL COMMENT '优惠券主题',
  `FACE_VALUE` int(11) NOT NULL COMMENT '优惠券面值',
  `SEND_TYPE` tinyint(4) DEFAULT NULL COMMENT '优惠券发送类型0按用户如会员等级,会员名称发放;1按商品类别发送;2按订单金额所达到的额度发送;3线下发送',
  `MIN_AMOUNT` int(11) DEFAULT NULL COMMENT '如果按金额发送优惠券,需满足的最小金额,即只要购买超过该金额的商品都可以领到红包',
  `MAX_AMOUNT` int(11) DEFAULT NULL COMMENT '如果按金额发送优惠券,需满足的最大金额',
  `SEND_START_DATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '优惠券发送的开始时间',
  `SEND_END_DATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '优惠券发送的结束时间',
  `USE_START_DATE` datetime DEFAULT NULL COMMENT '优惠券可以使用的开始时间',
  `USE_END_DATE` datetime DEFAULT NULL COMMENT '优惠券可以使用的结束时间',
  `MIN_BUY_AMOUNT` int(11) DEFAULT NULL COMMENT '可以使用该优惠券的商品的最低价格,即只要达到该价格商品才可以使用红包',
  `COUNT` int(11) DEFAULT '0' COMMENT '优惠券总个数',
  `TAKED_COUNT` int(11) DEFAULT '0' COMMENT '已被领取的优惠券个数',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_BY` varchar(30) DEFAULT NULL COMMENT '创建者',
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `UPDATE_BY` varchar(30) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`COUPON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品/店铺优惠券表';

-- ----------------------------
-- Records of G_COUPON
-- ----------------------------

-- ----------------------------
-- Table structure for G_DISCOUNT
-- ----------------------------
DROP TABLE IF EXISTS `G_DISCOUNT`;
CREATE TABLE `G_DISCOUNT` (
  `DISCOUNT_ID` smallint(6) NOT NULL AUTO_INCREMENT COMMENT '折扣ID',
  `GOODS_ID` varchar(12) DEFAULT NULL COMMENT '商品ID',
  `BUSINESS_ID` varchar(12) DEFAULT NULL COMMENT '店铺ID',
  `USER_RANK` tinyint(4) DEFAULT NULL COMMENT '会员等级',
  `DISC_VALUE` int(11) DEFAULT NULL COMMENT '折扣',
  `MIN_AMOUNT` int(11) DEFAULT NULL COMMENT '如果按金额计算折扣,需满足的最小金额',
  `MAX_AMOUNT` int(11) DEFAULT NULL COMMENT '如果按金额计算折扣,需满足的最大金额',
  `MIN_BUY_COUNT` int(11) DEFAULT NULL COMMENT '如果按计件计算折扣,需满足的最小件数',
  `IS_ENABLED` tinyint(1) DEFAULT '1' COMMENT '是否生效 0无效 1生效 ',
  `ADD_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '插入时间',
  PRIMARY KEY (`DISCOUNT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品/店铺折扣表';

-- ----------------------------
-- Records of G_DISCOUNT
-- ----------------------------

-- ----------------------------
-- Table structure for G_GOODS
-- ----------------------------
DROP TABLE IF EXISTS `G_GOODS`;
CREATE TABLE `G_GOODS` (
  `GOODS_ID` varchar(12) NOT NULL COMMENT '商品ID',
  `GOODS_SN` varchar(60) DEFAULT NULL COMMENT '商品的唯一货号',
  `GOODS_NAME` varchar(150) NOT NULL COMMENT '商品名称',
  `GOODS_TITLE` varchar(200) DEFAULT NULL COMMENT '商品的简略标题',
  `KEYWORDS` varchar(50) DEFAULT NULL COMMENT '商品关键字，放在商品页的关键字中，为搜索引擎收录用',
  `CATY_ID` varchar(12) DEFAULT NULL COMMENT '商品分类ID',
  `CATY_SN` varchar(20) DEFAULT NULL COMMENT '商品分类编码',
  `BUSINESS_SN` varchar(60) NOT NULL COMMENT '所属店铺ID',
  `EFFECTIVE_DATE` datetime DEFAULT NULL COMMENT '生产日期',
  `EXPIRY_DAYS` int(11) DEFAULT '0' COMMENT '有效期(天)',
  `GOODS_BRIEF` varchar(200) DEFAULT NULL COMMENT '商品的简短描述',
  `GOODS_DESC` text COMMENT '商品的详细描述',
  `MARKET_PRICE` int(11) DEFAULT NULL COMMENT '市场售价(分)',
  `DISCOUNT` int(11) DEFAULT '100' COMMENT '折扣',
  `SHOP_PRICE` int(11) DEFAULT NULL COMMENT '本店售价(分)',
  `COST_PRICE` int(11) DEFAULT NULL COMMENT '成本价',
  `PROMOTE_PRICE` int(11) DEFAULT NULL COMMENT '促销价格（分）',
  `PROMOTE_START_DATE` datetime DEFAULT NULL COMMENT '促销开始时间',
  `PROMOTE_END_DATE` datetime DEFAULT NULL COMMENT '促销结束时间',
  `COUPON_SN` varchar(12) DEFAULT NULL COMMENT '优惠券编号',
  `IS_DEL` int(11) DEFAULT '0' COMMENT '是否删除 0否 1是',
  `IS_ONSALE` int(11) DEFAULT '1' COMMENT '是否开售 1是 0否',
  `IS_COMMENT` int(11) DEFAULT '0' COMMENT '是否允许评论 0否 1是',
  `SHIP_FEE` int(11) DEFAULT '0' COMMENT '快递费（分）',
  `SORT_ORL` int(11) DEFAULT NULL COMMENT '商品排序值',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '商品录入时间',
  `CREATE_BY` varchar(30) DEFAULT NULL COMMENT '创建者',
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '商品更新时间',
  `UPDATE_BY` varchar(30) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`GOODS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of G_GOODS
-- ----------------------------
INSERT INTO `G_GOODS` VALUES ('1596677386', '159667738603', '手剥松子218g 坚果炒货 巴西松子', '良品铺子 手剥松子218g 坚果炒货 巴西松子', 'lppuzisbsz', '280', 'ijklmnopqrs', '56789abcdefghijklmnopqrstuvCDEFGH', '2020-09-25 13:10:05', '90', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '3500', '80', '2960', '2260', '2705', '2020-09-18 08:00:52', '2020-09-26 23:59:59', null, '0', '1', '0', '800', '0', '2020-09-01 14:24:05', 'system', '2020-09-01 14:24:05', 'system');
INSERT INTO `G_GOODS` VALUES ('1596677416', '159667741604', '肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶', '良品铺子 肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶点380g', 'rsbgxxls', '280', 'abcdefgh', '56789abcdefghijklmnopqrstuvCDEFGH', '2020-10-30 12:30:30', '90', '良品铺子 肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶点380g', '良品铺子 肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶点380g', '2800', '100', '2800', '2100', '2545', '2020-11-11 10:30:06', '2020-11-16 23:59:59', null, '0', '1', '0', '0', '1', '2020-09-01 14:24:02', 'system', '2020-09-01 14:24:02', 'system');
INSERT INTO `G_GOODS` VALUES ('1596677426', '159667742602', '酥脆薄饼海苔味早餐饼干薯片儿童零食休闲零食网红食品小吃', '良品铺子酥脆薄饼海苔味早餐饼干薯片儿童零食休闲零食网红食品小吃小零食300g', 'scbbxcls', '280', 'ijklmnopqrs', '56789abcdefghijklmnopqrstuvCDEFGH', '2020-10-24 10:16:50', '60', '良品铺子酥脆薄饼海苔味早餐饼干薯片儿童零食休闲零食网红食品小吃小零食300g', '良品铺子酥脆薄饼海苔味早餐饼干薯片儿童零食休闲零食网红食品小吃小零食300g', '2100', '86', '1990', '1290', '1735', '2020-10-17 10:43:27', '2020-10-20 23:59:59', null, '0', '1', '0', '0', '2', '2020-09-01 14:23:58', 'system', '2020-09-01 14:23:58', 'system');
INSERT INTO `G_GOODS` VALUES ('1596677455', '159667745501', '半蒸芝士蛋糕糕点面包芝士味网红早餐下午茶休闲小吃零食 ', '良品铺子 半蒸芝士蛋糕糕点面包芝士味网红早餐下午茶休闲小吃零食 204g', 'zsdgxxls', '257', 'abcdefgh', '56789abcdefghijklmnopqrstuvCDEFGH', '2020-09-26 16:32:51', '90', '良品铺子 半蒸芝士蛋糕糕点面包芝士味网红早餐下午茶休闲小吃零食 204g', '良品铺子 半蒸芝士蛋糕糕点面包芝士味网红早餐下午茶休闲小吃零食 204g', '3600', '100', '3400', '2700', '3145', '2020-09-18 08:00:52', '2020-09-20 23:59:59', null, '0', '1', '0', '0', '3', '2020-09-01 14:24:19', 'system', '2020-09-01 14:24:19', 'system');
INSERT INTO `G_GOODS` VALUES ('1596677542', '159667754205', '良品铺子手撕面包1050g 2.1斤早餐小面包饼干蛋糕休闲零食办公室糕点点心整箱装礼盒', '手撕面包1050g 2.1斤早餐小面包饼干蛋糕休闲零食办公室糕点', 'ssmbgd', '277', 'ijklmnopqrs', '56789abcdefghijklmnopqrstuvCDEFGH', '2020-12-25 15:30:06', '50', '手撕面包1050g 2.1斤早餐小面包饼干蛋糕休闲零食办公室糕点', '手撕面包1050g 2.1斤早餐小面包饼干蛋糕休闲零食办公室糕点', '3500', '78', '3000', '2300', '2745', '2020-09-18 08:00:52', '2020-09-22 23:59:59', null, '0', '1', '0', '0', '4', '2020-09-01 14:23:49', 'system', '2020-09-01 14:23:49', 'system');
INSERT INTO `G_GOODS` VALUES ('1596677555', '159667755506', '手撕面包孕妇儿童零食早餐食品吃的休闲小吃糕点330g', '良品铺子 手撕面包孕妇儿童零食早餐食品吃的休闲小吃糕点330g', 'ssmbzjwh', '277', 'abcdefgh', '56789abcdefghijklmnopqrstuvCDEFGH', '2020-12-10 11:20:30', '90', '良品铺子 手撕面包孕妇儿童零食早餐食品吃的休闲小吃糕点330g', '良品铺子 手撕面包孕妇儿童零食早餐食品吃的休闲小吃糕点330g', '3500', '85', '3200', '2500', '2945', '2020-10-17 10:43:27', '2020-10-22 23:59:59', null, '0', '1', '0', '0', '5', '2020-09-01 14:23:45', 'system', '2020-09-01 14:23:45', 'system');
INSERT INTO `G_GOODS` VALUES ('1596677566', '159667756607', '酥脆薄饼300g 薄脆饼干独立小包装原味酱汁烧烤味海苔饼', '【300减210】良品铺子 酥脆薄饼300g 薄脆饼干独立小包装原味酱汁烧烤味海苔饼干 儿童休闲零食 海苔味', 'htetxxls', '277', 'ijklmnopqrs', '56789abcdefghijklmnopqrstuvCDEFGH', '2020-11-12 10:15:20', '120', '【300减210】良品铺子 酥脆薄饼300g 薄脆饼干独立小包装原味酱汁烧烤味海苔饼干 儿童休闲零食 海苔味', '【300减210】良品铺子 酥脆薄饼300g 薄脆饼干独立小包装原味酱汁烧烤味海苔饼干 儿童休闲零食 海苔味', '2800', '100', '2600', '1900', '2345', '2020-11-11 10:30:06', '2020-11-17 23:59:59', null, '0', '1', '0', '0', '6', '2020-09-01 14:23:43', 'system', '2020-09-01 14:23:43', 'system');
INSERT INTO `G_GOODS` VALUES ('1596677579', '159667757908', '活力吐司早餐营养面包休闲零食网红孕妇零食儿童零食饼干糕', '良品铺子 活力吐司早餐营养面包休闲零食网红孕妇零食儿童零食饼干糕点458g', 'tsmbzcet', '277', '789abcd', '56789abcdefghijklmnopqrstuvCDEFGH', '2020-10-13 15:30:10', '90', '良品铺子 活力吐司早餐营养面包休闲零食网红孕妇零食儿童零食饼干糕点458g', '良品铺子 活力吐司早餐营养面包休闲零食网红孕妇零食儿童零食饼干糕点458g', '2100', '80', '1800', '1100', '1545', '2020-10-17 10:43:27', '2020-10-23 23:59:59', null, '0', '1', '0', '0', '7', '2020-09-01 14:23:41', 'system', '2020-09-01 14:23:41', 'system');
INSERT INTO `G_GOODS` VALUES ('1596677621', '159667762109', '高端零食 威化饼干牛奶味 休闲零食办公室早餐下午茶小吃', ' 良品铺子 高端零食 威化饼干牛奶味 休闲零食办公室早餐下午茶小吃118g', 'xxxwcbgs', '259', 'opqrstuvCD', '56789abcdefghijklmnopqrstuvCDEFGH', '2020-09-18 18:40:02', '90', ' 良品铺子 高端零食 威化饼干牛奶味 休闲零食办公室早餐下午茶小吃118g', ' 良品铺子 高端零食 威化饼干牛奶味 休闲零食办公室早餐下午茶小吃118g', '3500', '100', '3200', '2500', '2945', '2020-09-18 08:00:52', '2020-09-22 23:59:59', null, '0', '1', '0', '0', '8', '2020-09-01 14:24:50', 'system', '2020-09-01 14:24:50', 'system');
INSERT INTO `G_GOODS` VALUES ('1596677629', '159667762910', '蛋黄酥6枚礼盒装糕点小吃日式雪媚娘饼干蛋糕早餐网红休闲', '良品铺子 蛋黄酥6枚礼盒装糕点小吃日式雪媚娘饼干蛋糕早餐网红休闲零食320g', 'dhsgd', '257', 'opqrstuvCD', '56789abcdefghijklmnopqrstuvCDEFGH', '2020-09-22 11:10:18', '150', '良品铺子 蛋黄酥6枚礼盒装糕点小吃日式雪媚娘饼干蛋糕早餐网红休闲零食320g', '良品铺子 蛋黄酥6枚礼盒装糕点小吃日式雪媚娘饼干蛋糕早餐网红休闲零食320g', '2800', '86', '2600', '1900', '2345', '2020-10-17 10:43:27', '2020-10-25 23:59:59', null, '0', '1', '0', '0', '10', '2020-09-01 14:24:24', 'system', '2020-09-01 14:24:24', 'system');
INSERT INTO `G_GOODS` VALUES ('1596677635', '159667763511', '芝士泡芙休闲零食星空泡芙球夹心饼干小吃60g ', '良品铺子 芝士泡芙休闲零食星空泡芙球夹心饼干小吃60g', 'zspfxxls', '259', 'ijklmnopqrs', '56789abcdefghijklmnopqrstuvCDEFGH', '2020-09-12 10:40:20', '90', '良品铺子 芝士泡芙休闲零食星空泡芙球夹心饼干小吃60g', '良品铺子 芝士泡芙休闲零食星空泡芙球夹心饼干小吃60g', '2100', '100', '1800', '1100', '1545', '2020-09-18 08:00:52', '2020-09-20 23:59:59', null, '0', '1', '0', '0', '9', '2020-09-01 14:24:43', 'system', '2020-09-01 14:24:43', 'system');
INSERT INTO `G_GOODS` VALUES ('1596677652', '159667765212', '肉肉海苔吐司 肉松小面包蛋糕手撕营养早餐代餐网红肉干肉脯', ' 良品铺子肉肉海苔吐司 肉松小面包蛋糕手撕营养早餐代餐网红肉干肉脯休闲零食办公室小吃520g', 'rplsbgs', '265', 'opqrstuvCD', '56789abcdefghijklmnopqrstuvCDEFGH', '2020-10-13 12:10:35', '30', ' 良品铺子肉肉海苔吐司 肉松小面包蛋糕手撕营养早餐代餐网红肉干肉脯休闲零食办公室小吃520g', ' 良品铺子肉肉海苔吐司 肉松小面包蛋糕手撕营养早餐代餐网红肉干肉脯休闲零食办公室小吃520g', '3600', '78', '3400', '2700', '3145', '2020-11-11 10:30:06', '2020-11-12 23:59:59', null, '0', '0', '0', '0', '11', '2020-09-01 14:25:13', 'system', '2020-09-01 14:25:13', 'system');
INSERT INTO `G_GOODS` VALUES ('1596677661', '159667766113', '紫米三明治吐司紫米面包糕点点心孕妇儿童网红营养早餐休闲', ' 良品铺子 紫米三明治吐司紫米面包糕点点心孕妇儿童网红营养早餐休闲零食整箱装555g', 'etzmsmz', '265', '789abcd', '56789abcdefghijklmnopqrstuvCDEFGH', '2020-09-20 19:50:13', '30', ' 良品铺子 紫米三明治吐司紫米面包糕点点心孕妇儿童网红营养早餐休闲零食整箱装555g', ' 良品铺子 紫米三明治吐司紫米面包糕点点心孕妇儿童网红营养早餐休闲零食整箱装555g', '3500', '85', '3200', '2500', '2945', '2020-10-17 10:43:27', '2020-10-21 23:59:59', null, '0', '0', '0', '0', '12', '2020-09-01 14:25:18', 'system', '2020-09-01 14:25:18', 'system');
INSERT INTO `G_GOODS` VALUES ('1596677676', '159667767614', '咸蛋黄麦芽饼干 面包蛋糕麦芽饼干网红休闲零食下午茶办公室小吃早餐代餐零食礼盒整箱装520g ', '良品铺子 咸蛋黄麦芽饼干 面包蛋糕麦芽饼干网红休闲零食下午茶办公室小吃早餐代餐零食礼盒整箱装520g', 'xdhmybg', '265', 'ijklmnopqrs', '56789abcdefghijklmnopqrstuvCDEFGH', '2020-11-05 18:10:38', '60', '良品铺子 咸蛋黄麦芽饼干 面包蛋糕麦芽饼干网红休闲零食下午茶办公室小吃早餐代餐零食礼盒整箱装520g', '良品铺子 咸蛋黄麦芽饼干 面包蛋糕麦芽饼干网红休闲零食下午茶办公室小吃早餐代餐零食礼盒整箱装520g', '3600', '100', '3400', '2700', '3145', '2020-09-18 08:00:52', '2020-09-20 23:59:59', null, '0', '1', '0', '0', '13', '2020-09-01 14:25:21', 'system', '2020-09-01 14:25:21', 'system');
INSERT INTO `G_GOODS` VALUES ('1596677684', '159667768415', '雪花酥什锦装108g 冻干雪花酥饼干 网红零食沙琪玛牛', '【300减210】良品铺子 雪花酥什锦装108g 冻干雪花酥饼干 网红零食沙琪玛牛轧糖休闲零食 雪花酥什锦装108g 1盒', 'xhssjbg', '257', 'opqrstuvCD', '56789abcdefghijklmnopqrstuvCDEFGH', '2020-09-06 20:03:44', '28', '【300减210】良品铺子 雪花酥什锦装108g 冻干雪花酥饼干 网红零食沙琪玛牛轧糖休闲零食 雪花酥什锦装108g 1盒', '【300减210】良品铺子 雪花酥什锦装108g 冻干雪花酥饼干 网红零食沙琪玛牛轧糖休闲零食 雪花酥什锦装108g 1盒', '3200', '78', '3000', '2300', '2745', '2020-11-11 10:30:06', '2020-11-13 23:59:59', null, '0', '1', '0', '0', '14', '2020-09-01 14:24:28', 'system', '2020-09-01 14:24:28', 'system');
INSERT INTO `G_GOODS` VALUES ('1596677692', '159667769216', '椰丝球面包 早餐糕点点心 零食甜点小吃300g', '良品铺子 椰丝球面包 早餐糕点点心 零食甜点小吃300g', 'ysqmbgd', '265', 'ijklmnopqrs', '56789abcdefghijklmnopqrstuvCDEFGH', '2020-10-20 08:18:50', '90', '良品铺子 椰丝球面包 早餐糕点点心 零食甜点小吃300g', '良品铺子 椰丝球面包 早餐糕点点心 零食甜点小吃300g', '2900', '100', '2600', '1900', '2345', '2020-11-11 10:30:06', '2020-11-12 23:59:59', null, '0', '1', '0', '0', '15', '2020-09-01 14:25:24', 'system', '2020-09-01 14:25:24', 'system');
INSERT INTO `G_GOODS` VALUES ('1597140661', 'seQiNfyaoqgR', '幼儿园识字必备教材 识字大王', '正版 识字大王看图识字书大全幼儿童早教图书3-6岁宝宝书认字卡片学拼音汉语启蒙书籍幼儿园学前大班教材', 'szdw', '257', 'ijklmnopqrs', '45ger85vg75fueri', '2020-10-20 08:18:50', '150', '正版 识字大王看图识字书大全幼儿童早教图书3-6岁宝宝书认字卡片学拼音汉语启蒙书籍幼儿园学前大班教材', '正版 识字大王看图识字书大全幼儿童早教图书3-6岁宝宝书认字卡片学拼音汉语启蒙书籍幼儿园学前大班教材', '3800', '80', '3600', '2900', '3345', '2020-08-11 08:06:32', '2020-08-20 08:37:27', null, '0', '1', '1', '0', '30', '2020-09-01 14:24:32', 'system', '2020-09-01 14:24:32', 'system');
INSERT INTO `G_GOODS` VALUES ('1597196351', 'RZbBqbNGDZoO', '上善若水 斗战胜佛之静思 纯铜齐天大圣', '上善若水《斗战胜佛之静思》纯铜美猴王齐天大圣孙悟空摆件新中式办公室桌面客厅家居酒柜装饰品铜猴子工艺品', 'ssrsct', '259', '789abcd', '324354657676', '2020-08-04 16:00:00', '10000000', '上善若水《斗战胜佛之静思》纯铜美猴王齐天大圣孙悟空摆件新中式办公室桌面客厅家居酒柜装饰品铜猴子工艺品', '上善若水《斗战胜佛之静思》纯铜美猴王齐天大圣孙悟空摆件新中式办公室桌面客厅家居酒柜装饰品铜猴子工艺品', '2800', '100', '2600', '1900', '2345', '2020-08-11 08:06:32', '2020-08-29 01:31:39', null, '0', '1', '1', '0', '31', '2020-09-01 14:24:55', 'system', '2020-09-01 14:24:55', 'system');
INSERT INTO `G_GOODS` VALUES ('1597742452', 'qzSooh9nNVjH', '幼儿园识字必备教材 识字大王 AAA', '正版 识字大王看图识字书大全幼儿童早教图书3-6岁宝宝书认字卡片学拼音汉语启蒙书籍幼儿园学前大班教材', 'yejy', '68', 'defghijkl', '324354657676', '2019-08-04 16:00:00', '10000', '正版 识字大王看图识字书大全幼儿童早教图书3-6岁宝宝书认字卡片学拼音汉语启蒙书籍幼儿园学前大班教材', '正版 识字大王看图识字书大全幼儿童早教图书3-6岁宝宝书认字卡片学拼音汉语启蒙书籍幼儿园学前大班教材', '2100', '86', '1900', '1200', '1645', '2020-08-13 09:20:30', '2020-10-30 09:20:34', null, '0', '1', '0', '0', '0', '2020-08-30 15:30:02', 'system', '2020-08-30 15:30:02', 'system');
INSERT INTO `G_GOODS` VALUES ('1597821652', 'sewE7zhRidNO', '华为LOK-350', '荣耀智慧屏X1 55英寸LOK-350 2G+16G ', 'rylok', '66', 'pqrstuv', 'honor0101', '2020-08-05 04:14:00', '10000', '荣耀智慧屏X1 55英寸LOK-350 2G+16G ', '荣耀智慧屏X1 55英寸LOK-350 2G+16G ', '3500', '100', '3100', '2400', '2845', '2020-08-11 08:06:32', '2020-11-19 07:10:00', null, '0', '1', '1', '0', '26', '2020-08-30 15:30:02', 'system', '2020-08-30 15:30:02', 'system');
INSERT INTO `G_GOODS` VALUES ('1598323329', 'aaYHQv0ckgCr', '格力KFR-35GW/(35592)FNhAa-A1(WIFI)', '格力（GREE）正1.5匹 品悦一级能效 变频冷暖 智能 壁挂式卧室空调挂机 KFR-35GW/(35592)FNhAa-A1线下同款', 'geliktgj', '80', 'ijklmnop', '45ger85vg75fueri', '2018-07-30 16:00:00', '1000', '格力（GREE）正1.5匹 品悦一级能效 变频冷暖 智能 壁挂式卧室空调挂机 KFR-35GW/(35592)FNhAa-A1线下同款', '格力（GREE）正1.5匹 品悦一级能效 变频冷暖 智能 壁挂式卧室空调挂机 KFR-35GW/(35592)FNhAa-A1线下同款', '2800', '78', '2600', '1900', '2345', '2020-08-19 02:52:18', '2020-10-22 03:22:53', null, '0', '1', '1', '0', '50', '2020-08-30 15:30:02', 'system', '2020-08-30 15:30:02', 'system');
INSERT INTO `G_GOODS` VALUES ('1598520905', '8Yjyn6YO0xx0', ' 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', 'ldgxxls', '254', '789abcd', '56789abcdefghijklmnopqrstuvCDEFGH', '2020-06-25 06:45:30', '10000', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '2100', '85', '1850', '1150', '1595', '2020-08-13 09:20:30', '2020-11-27 09:34:33', null, '0', '1', '1', '0', '50', '2020-08-30 15:30:02', 'system', '2020-08-30 15:30:02', 'system');

-- ----------------------------
-- Table structure for G_GOODS_BRAND
-- ----------------------------
DROP TABLE IF EXISTS `G_GOODS_BRAND`;
CREATE TABLE `G_GOODS_BRAND` (
  `BRAND_ID` smallint(6) NOT NULL AUTO_INCREMENT COMMENT '品牌ID',
  `BRAND_NAME` varchar(60) NOT NULL COMMENT '品牌名称',
  `CATEGORY_ID` int(11) DEFAULT NULL COMMENT '品牌类别ID',
  `BRAND_LOGO` varchar(80) DEFAULT NULL COMMENT '上传的该品牌Logo图片',
  `BRAND_DESC` text COMMENT '品牌描述',
  `BRAND_TYPE` int(11) DEFAULT NULL COMMENT '品牌类型',
  `SITE_URL` varchar(255) DEFAULT NULL COMMENT '品牌的网址',
  `SORT_ORL` tinyint(4) DEFAULT NULL COMMENT '品牌在前台页面的显示顺序,数字越大越靠后',
  `IS_SHOW` tinyint(4) DEFAULT '1' COMMENT '该品牌是否显示;0否1显示',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '商品录入时间',
  `CREATE_BY` varchar(30) DEFAULT NULL COMMENT '创建者',
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '商品更新时间',
  `UPDATE_BY` varchar(30) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`BRAND_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8 COMMENT='商品品牌信息表';

-- ----------------------------
-- Records of G_GOODS_BRAND
-- ----------------------------
INSERT INTO `G_GOODS_BRAND` VALUES ('1', 'UGG', '6', null, '国际大品牌', '2', 'https://mall.jd.com/index-50209.html%E3%80%80', '0', '1', '2020-08-30 12:06:04', 'system', '2020-08-30 12:06:04', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('2', 'ECCO', '7', null, '国际大品牌鞋', '2', 'https://mall.jd.com/index-59885.html', '1', '1', '2020-08-30 12:06:07', 'system', '2020-08-30 12:06:07', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('3', '斯凯奇', '8', null, '国内品牌鞋', '1', 'https://mall.jd.com/index-56083.html', '2', '1', '2020-08-30 12:06:09', 'system', '2020-08-30 12:06:09', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('4', '花颜巧语', '1', null, '花颜巧语', '1', 'https://mall.jd.com/index-59885.html', '0', '1', '2020-08-25 08:36:51', 'system', '2020-08-25 08:36:51', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('5', '糖衣小屋', '1', null, '糖衣小屋', '1', 'https://mall.jd.com/index-59885.html', '1', '1', '2020-08-25 08:37:06', 'system', '2020-08-25 08:37:06', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('6', '卡拉迪克', '1', null, '卡拉迪克', '1', 'https://mall.jd.com/index-59885.html', '2', '1', '2020-08-25 08:37:21', 'system', '2020-08-25 08:37:21', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('7', '暖春童话', '1', null, '暖春童话', '1', 'https://mall.jd.com/index-59885.html', '3', '1', '2020-08-25 08:37:37', 'system', '2020-08-25 08:37:37', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('8', '华盛童装批发行', '1', null, '华盛童装批发行', '1', 'https://mall.jd.com/index-59885.html', '5', '1', '2020-08-25 08:37:52', 'system', '2020-08-25 08:37:52', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('9', '奈仕华童装旗舰店', '1', null, '奈仕华童装旗舰店', '1', 'https://mall.jd.com/index-59885.html', '6', '1', '2020-08-25 08:38:04', 'system', '2020-08-25 08:38:04', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('10', '斑蒂尼BONDYNI', '1', null, '斑蒂尼BONDYNI', '1', 'https://mall.jd.com/index-59885.html', '0', '1', '2020-08-25 08:38:17', 'system', '2020-08-25 08:38:17', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('11', '猫儿朵朵', '1', null, '猫儿朵朵', '1', 'https://mall.jd.com/index-59885.html', '8', '1', '2020-08-25 08:38:32', 'system', '2020-08-25 08:38:32', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('12', '童衣阁', '1', null, '童衣阁', '1', 'https://mall.jd.com/index-59885.html', '7', '1', '2020-08-25 08:38:47', 'system', '2020-08-25 08:38:47', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('13', '呵呵嘿官方旗舰店', '2', null, '呵呵嘿官方旗舰店', '1', 'https://mall.jd.com/index-50209.html%E3%80%80', '5', '1', '2020-08-25 08:40:13', 'system', '2020-08-25 08:40:13', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('14', '格瑞旗舰店', '2', null, '格瑞旗舰店', '1', 'https://mall.jd.com/index-50209.html%E3%80%80', '2', '1', '2020-08-25 08:40:25', 'system', '2020-08-25 08:40:25', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('15', '红e·艾菲妮', '2', null, '红e·艾菲妮', '1', 'https://mall.jd.com/index-59885.html', '30', '1', '2020-08-25 08:40:57', 'system', '2020-08-25 08:40:57', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('16', '本真旗舰店', '2', null, '本真旗舰店', '1', 'https://mall.jd.com/index-50209.html%E3%80%80', '20', '1', '2020-08-25 08:41:12', 'system', '2020-08-25 08:41:12', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('17', '杭派女装批发网', '2', null, '杭派女装批发网', '1', 'https://mall.jd.com/index-59885.html', '15', '1', '2020-08-25 08:41:29', 'system', '2020-08-25 08:41:29', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('18', '独家折扣旗舰店', '2', null, '独家折扣旗舰店', '1', 'https://mall.jd.com/index-59885.html', '22', '1', '2020-08-25 08:41:56', 'system', '2020-08-25 08:41:56', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('19', '歌芙品牌旗舰店', '3', null, '歌芙品牌旗舰店', '1', 'https://mall.jd.com/index-59885.html', '1', '1', '2020-08-25 08:42:19', 'system', '2020-08-25 08:42:19', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('20', '爱丝蓝内衣厂', '3', null, '爱丝蓝内衣厂', '1', 'https://mall.jd.com/index-59885.html', '2', '1', '2020-08-25 08:42:31', 'system', '2020-08-25 08:42:31', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('21', '香港优蓓尔防辐射', '3', null, '香港优蓓尔防辐射', '1', 'https://mall.jd.com/index-59885.html', '6', '1', '2020-08-25 08:42:46', 'system', '2020-08-25 08:42:46', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('22', '蓉莉娜内衣批发', '3', null, '蓉莉娜内衣批发', '1', 'https://mall.jd.com/index-59885.html', '4', '1', '2020-08-25 08:43:01', 'system', '2020-08-25 08:43:01', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('23', 'YYKCLOT', '4', null, '国际大品牌', '2', 'https://mall.jd.com/index-50209.html%E3%80%80', '0', '1', '2020-08-25 16:35:23', 'system', '2020-08-25 16:35:23', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('24', '池氏品牌男装', '4', null, '国际大品牌鞋', '2', 'https://mall.jd.com/index-59885.html', '1', '1', '2020-08-25 16:35:26', 'system', '2020-08-25 16:35:26', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('25', '男装日志', '4', null, '国内品牌鞋', '1', 'https://mall.jd.com/index-56083.html', '2', '1', '2020-08-25 16:38:51', 'system', '2020-08-25 16:38:51', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('26', '索比诺官方旗舰店', '4', null, '花颜巧语', '1', 'https://mall.jd.com/index-59885.html', '0', '1', '2020-08-25 08:36:51', 'system', '2020-08-25 08:36:51', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('27', 'onTTno傲徒', '4', null, '糖衣小屋', '1', 'https://mall.jd.com/index-59885.html', '1', '1', '2020-08-25 08:37:06', 'system', '2020-08-25 08:37:06', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('28', '玛狮路男装旗舰店', '4', null, '卡拉迪克', '1', 'https://mall.jd.com/index-59885.html', '2', '1', '2020-08-25 08:37:21', 'system', '2020-08-25 08:37:21', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('29', '劳威特品牌男装', '4', null, '暖春童话', '1', 'https://mall.jd.com/index-59885.html', '3', '1', '2020-08-25 08:37:37', 'system', '2020-08-25 08:37:37', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('30', '卡斯郎世家批发城', '4', null, '华盛童装批发行', '1', 'https://mall.jd.com/index-59885.html', '5', '1', '2020-08-25 08:37:52', 'system', '2020-08-25 08:37:52', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('31', '歌芙品牌旗舰店', '5', null, '奈仕华童装旗舰店', '1', 'https://mall.jd.com/index-59885.html', '6', '1', '2020-08-25 08:38:04', 'system', '2020-08-25 08:38:04', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('32', '爱丝蓝内衣厂', '5', null, '斑蒂尼BONDYNI', '1', 'https://mall.jd.com/index-59885.html', '0', '1', '2020-08-25 08:38:17', 'system', '2020-08-25 08:38:17', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('33', '炫点服饰', '5', null, '猫儿朵朵', '1', 'https://mall.jd.com/index-59885.html', '8', '1', '2020-08-25 08:38:32', 'system', '2020-08-25 08:38:32', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('34', '雪茵美内衣厂批发', '5', null, '童衣阁', '1', 'https://mall.jd.com/index-59885.html', '7', '1', '2020-08-25 08:38:47', 'system', '2020-08-25 08:38:47', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('35', '金钻夫人', '5', null, '奈仕华童装旗舰店', '1', 'https://mall.jd.com/index-59885.html', '6', '1', '2020-08-25 08:38:04', 'system', '2020-08-25 08:38:04', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('36', '伊美莎内衣', '5', null, '斑蒂尼BONDYNI', '1', 'https://mall.jd.com/index-59885.html', '0', '1', '2020-08-25 08:38:17', 'system', '2020-08-25 08:38:17', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('37', '粉客内衣旗舰店', '5', null, '猫儿朵朵', '1', 'https://mall.jd.com/index-59885.html', '8', '1', '2020-08-25 08:38:32', 'system', '2020-08-25 08:38:32', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('38', '泽芳行旗舰店', '5', null, '童衣阁', '1', 'https://mall.jd.com/index-59885.html', '7', '1', '2020-08-25 08:38:47', 'system', '2020-08-25 08:38:47', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('39', '彩婷', '5', null, '奈仕华童装旗舰店', '1', 'https://mall.jd.com/index-59885.html', '6', '1', '2020-08-25 08:38:04', 'system', '2020-08-25 08:38:04', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('40', '黛兰希', '5', null, '斑蒂尼BONDYNI', '1', 'https://mall.jd.com/index-59885.html', '0', '1', '2020-08-25 08:38:17', 'system', '2020-08-25 08:38:17', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('41', '香港优蓓尔防辐射', '5', null, '猫儿朵朵', '1', 'https://mall.jd.com/index-59885.html', '8', '1', '2020-08-25 08:38:32', 'system', '2020-08-25 08:38:32', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('42', '蓉莉娜内衣批发', '5', null, '童衣阁', '1', 'https://mall.jd.com/index-59885.html', '7', '1', '2020-08-25 08:38:47', 'system', '2020-08-25 08:38:47', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('43', '今生只围你', '7', null, '国际大品牌', '2', 'https://mall.jd.com/index-50209.html%E3%80%80', '0', '1', '2020-08-25 16:35:23', 'system', '2020-08-25 16:35:23', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('44', '忆佳人', '7', null, '国际大品牌鞋', '2', 'https://mall.jd.com/index-59885.html', '1', '1', '2020-08-25 16:35:26', 'system', '2020-08-25 16:35:26', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('45', '斐洱普斯', '7', null, '国内品牌鞋', '1', 'https://mall.jd.com/index-56083.html', '2', '1', '2020-08-25 16:38:51', 'system', '2020-08-25 16:38:51', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('46', '聚百坊', '7', null, '花颜巧语', '1', 'https://mall.jd.com/index-59885.html', '0', '1', '2020-08-25 08:36:51', 'system', '2020-08-25 08:36:51', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('47', '朵朵棉织直营店', '7', null, '糖衣小屋', '1', 'https://mall.jd.com/index-59885.html', '1', '1', '2020-08-25 08:37:06', 'system', '2020-08-25 08:37:06', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('48', '琳琅鞋业', '8', null, '卡拉迪克', '1', 'https://mall.jd.com/index-59885.html', '2', '1', '2020-08-25 08:37:21', 'system', '2020-08-25 08:37:21', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('49', '宏利鞋业', '8', null, '暖春童话', '1', 'https://mall.jd.com/index-59885.html', '3', '1', '2020-08-25 08:37:37', 'system', '2020-08-25 08:37:37', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('50', '比爱靓点鞋业', '8', null, '华盛童装批发行', '1', 'https://mall.jd.com/index-59885.html', '5', '1', '2020-08-25 08:37:52', 'system', '2020-08-25 08:37:52', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('51', '浪人怪怪', '8', null, '奈仕华童装旗舰店', '1', 'https://mall.jd.com/index-59885.html', '6', '1', '2020-08-25 08:38:04', 'system', '2020-08-25 08:38:04', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('52', 'YYKCLOT', '9', null, '斑蒂尼BONDYNI', '1', 'https://mall.jd.com/index-59885.html', '0', '1', '2020-08-25 08:38:17', 'system', '2020-08-25 08:38:17', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('53', '池氏品牌男装', '9', null, '猫儿朵朵', '1', 'https://mall.jd.com/index-59885.html', '8', '1', '2020-08-25 08:38:32', 'system', '2020-08-25 08:38:32', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('54', '男装日志', '9', null, '童衣阁', '1', 'https://mall.jd.com/index-59885.html', '7', '1', '2020-08-25 08:38:47', 'system', '2020-08-25 08:38:47', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('55', '索比诺官方旗舰店', '9', null, '奈仕华童装旗舰店', '1', 'https://mall.jd.com/index-59885.html', '6', '1', '2020-08-25 08:38:04', 'system', '2020-08-25 08:38:04', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('56', 'onTTno傲徒', '9', null, '斑蒂尼BONDYNI', '1', 'https://mall.jd.com/index-59885.html', '0', '1', '2020-08-25 08:38:17', 'system', '2020-08-25 08:38:17', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('57', '玛狮路男装旗舰店', '9', null, '猫儿朵朵', '1', 'https://mall.jd.com/index-59885.html', '8', '1', '2020-08-25 08:38:32', 'system', '2020-08-25 08:38:32', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('58', '劳威特品牌男装', '9', null, '童衣阁', '1', 'https://mall.jd.com/index-59885.html', '7', '1', '2020-08-25 08:38:47', 'system', '2020-08-25 08:38:47', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('59', '卡斯郎世家批发城', '9', null, '奈仕华童装旗舰店', '1', 'https://mall.jd.com/index-59885.html', '6', '1', '2020-08-25 08:38:04', 'system', '2020-08-25 08:38:04', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('60', '花颜巧语', '10', null, '斑蒂尼BONDYNI', '1', 'https://mall.jd.com/index-59885.html', '0', '1', '2020-08-25 08:38:17', 'system', '2020-08-25 08:38:17', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('61', '糖衣小屋', '10', null, '猫儿朵朵', '1', 'https://mall.jd.com/index-59885.html', '8', '1', '2020-08-25 08:38:32', 'system', '2020-08-25 08:38:32', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('62', '卡拉迪克', '10', null, '童衣阁', '1', 'https://mall.jd.com/index-59885.html', '7', '1', '2020-08-25 08:38:47', 'system', '2020-08-25 08:38:47', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('63', '暖春童话', '10', null, '斑蒂尼BONDYNI', '1', 'https://mall.jd.com/index-59885.html', '0', '1', '2020-08-25 08:38:17', 'system', '2020-08-25 08:38:17', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('64', '奈仕华童装旗舰店', '10', null, '猫儿朵朵', '1', 'https://mall.jd.com/index-59885.html', '8', '1', '2020-08-25 08:38:32', 'system', '2020-08-25 08:38:32', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('65', '斑蒂尼BONDYNI', '10', null, '童衣阁', '1', 'https://mall.jd.com/index-59885.html', '7', '1', '2020-08-25 08:38:47', 'system', '2020-08-25 08:38:47', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('67', '良品铺子', '277', null, '良品铺子', '1', 'https://mall.jd.com/index-59885.html', '0', '1', '2020-09-01 14:26:03', 'system', '2020-09-01 14:26:03', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('68', '三只松鼠', '277', null, '三只松鼠', '1', 'https://mall.jd.com/index-59885.html', '1', '1', '2020-09-01 14:26:01', 'system', '2020-09-01 14:26:01', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('69', '稻香村', '277', null, '稻香村', '1', 'https://mall.jd.com/index-59885.html', '2', '1', '2020-09-01 14:26:01', 'system', '2020-09-01 14:26:01', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('70', '周黑鸭', '277', null, '周黑鸭', '1', 'https://mall.jd.com/index-59885.html', '3', '1', '2020-09-01 14:26:00', 'system', '2020-09-01 14:26:00', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('71', '百草味', '277', null, '百草味', '1', 'https://mall.jd.com/index-59885.html', '4', '1', '2020-09-01 14:25:58', 'system', '2020-09-01 14:25:58', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('72', '曲奇', '265', null, '曲奇', '1', 'https://mall.jd.com/index-59885.html', '5', '1', '2020-09-01 14:25:55', 'system', '2020-09-01 14:25:55', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('73', '乐事', '265', null, '乐事', '1', 'https://mall.jd.com/index-59885.html', '6', '1', '2020-09-01 14:25:54', 'system', '2020-09-01 14:25:54', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('74', '可比克', '265', null, '可比克', '1', 'https://mall.jd.com/index-59885.html', '7', '1', '2020-09-01 14:25:54', 'system', '2020-09-01 14:25:54', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('75', '薯愿', '265', null, '薯愿', '1', 'https://mall.jd.com/index-59885.html', '8', '1', '2020-09-01 14:25:53', 'system', '2020-09-01 14:25:53', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('76', 'Pringles', '265', null, 'Pringles', '1', 'https://mall.jd.com/index-59885.html', '10', '1', '2020-09-01 14:25:53', 'system', '2020-09-01 14:25:53', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('77', 'Orion', '265', null, 'Orion', '1', 'https://mall.jd.com/index-59885.html', '9', '1', '2020-09-01 14:25:52', 'system', '2020-09-01 14:25:52', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('78', '良品铺子', '265', null, '良品铺子', '1', 'https://mall.jd.com/index-59885.html', '0', '1', '2020-09-01 14:25:49', 'system', '2020-09-01 14:25:49', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('79', '三只松鼠', '257', null, '三只松鼠', '1', 'https://mall.jd.com/index-59885.html', '1', '1', '2020-09-01 14:26:20', 'system', '2020-09-01 14:26:20', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('80', '稻香村', '257', null, '稻香村', '1', 'https://mall.jd.com/index-59885.html', '2', '1', '2020-09-01 14:26:21', 'system', '2020-09-01 14:26:21', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('81', '百草味', '257', null, '百草味', '1', 'https://mall.jd.com/index-59885.html', '4', '1', '2020-09-01 14:26:21', 'system', '2020-09-01 14:26:21', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('82', '曲奇', '257', null, '曲奇', '1', 'https://mall.jd.com/index-59885.html', '5', '1', '2020-09-01 14:26:22', 'system', '2020-09-01 14:26:22', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('83', '乐事', '257', null, '乐事', '1', 'https://mall.jd.com/index-59885.html', '6', '1', '2020-09-01 14:26:22', 'system', '2020-09-01 14:26:22', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('84', '良品铺子', '315', null, '良品铺子', '1', 'https://mall.jd.com/index-59885.html', '0', '1', '2020-08-30 15:12:10', 'system', '2020-08-30 15:12:10', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('85', '三只松鼠', '315', null, '三只松鼠', '1', 'https://mall.jd.com/index-59885.html', '1', '1', '2020-08-30 15:12:10', 'system', '2020-08-30 15:12:10', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('86', '稻香村', '315', null, '稻香村', '1', 'https://mall.jd.com/index-59885.html', '2', '1', '2020-08-30 15:12:10', 'system', '2020-08-30 15:12:10', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('87', '周黑鸭', '315', null, '周黑鸭', '1', 'https://mall.jd.com/index-59885.html', '3', '1', '2020-08-30 15:12:10', 'system', '2020-08-30 15:12:10', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('88', '百草味', '315', null, '百草味', '1', 'https://mall.jd.com/index-59885.html', '4', '1', '2020-08-30 15:12:10', 'system', '2020-08-30 15:12:10', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('89', '曲奇', '315', null, '曲奇', '1', 'https://mall.jd.com/index-59885.html', '5', '1', '2020-08-30 15:12:10', 'system', '2020-08-30 15:12:10', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('90', '乐事', '315', null, '乐事', '1', 'https://mall.jd.com/index-59885.html', '6', '1', '2020-08-30 15:12:10', 'system', '2020-08-30 15:12:10', 'system');
INSERT INTO `G_GOODS_BRAND` VALUES ('92', '稻香村', '316', null, '稻香村', '1', null, '0', '1', '2020-09-01 09:06:52', null, '2020-09-01 09:06:52', null);
INSERT INTO `G_GOODS_BRAND` VALUES ('93', '百草味', '316', null, '百草味', '1', null, '1', '1', '2020-09-01 09:06:53', null, '2020-09-01 09:06:53', null);
INSERT INTO `G_GOODS_BRAND` VALUES ('94', '曲奇', '316', null, '曲奇', '1', null, '2', '1', '2020-09-01 09:06:53', null, '2020-09-01 09:06:53', null);
INSERT INTO `G_GOODS_BRAND` VALUES ('95', '乐事', '316', null, '乐事', '1', null, '3', '1', '2020-09-01 09:06:54', null, '2020-09-01 09:06:54', null);
INSERT INTO `G_GOODS_BRAND` VALUES ('96', '良品铺子', '316', null, '良品铺子', '1', null, '4', '1', '2020-09-01 09:06:55', null, '2020-09-01 09:06:55', null);
INSERT INTO `G_GOODS_BRAND` VALUES ('97', '三只松鼠', '68', null, '三只松鼠', '1', null, '5', '1', '2020-09-01 09:06:56', null, '2020-09-01 09:06:56', null);

-- ----------------------------
-- Table structure for G_GOODS_EXTENDS
-- ----------------------------
DROP TABLE IF EXISTS `G_GOODS_EXTENDS`;
CREATE TABLE `G_GOODS_EXTENDS` (
  `GOODS_ID` varchar(12) NOT NULL COMMENT '商品ID',
  `EXTEND1` varchar(150) DEFAULT NULL COMMENT '扩展字段1',
  `EXTEND2` varchar(150) DEFAULT NULL COMMENT '扩展字段2',
  `EXTEND3` varchar(150) DEFAULT NULL COMMENT '扩展字段3',
  `EXTEND4` varchar(150) DEFAULT NULL COMMENT '扩展字段1',
  `EXTEND5` varchar(150) DEFAULT NULL COMMENT '扩展字段5',
  `EXTEND6` varchar(150) DEFAULT NULL COMMENT '扩展字段6',
  KEY `FK_GOODS_E` (`GOODS_ID`) USING BTREE,
  CONSTRAINT `G_GOODS_EXTENDS_ibfk_1` FOREIGN KEY (`GOODS_ID`) REFERENCES `G_GOODS` (`GOODS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品属性扩展表';

-- ----------------------------
-- Records of G_GOODS_EXTENDS
-- ----------------------------

-- ----------------------------
-- Table structure for G_GOODS_PARAM
-- ----------------------------
DROP TABLE IF EXISTS `G_GOODS_PARAM`;
CREATE TABLE `G_GOODS_PARAM` (
  `GOODS_ID` varchar(12) NOT NULL COMMENT '商品ID',
  `BRAND_ID` smallint(6) DEFAULT NULL COMMENT '品牌ID',
  `FOOD_TASTE` varchar(50) DEFAULT NULL COMMENT '食物的口味',
  `WEIGHT` float(10,0) DEFAULT NULL COMMENT '商品重量',
  `LENGTH` float(10,0) DEFAULT NULL COMMENT '商品长度',
  `SIZE` varchar(10) DEFAULT NULL COMMENT '尺码',
  `COLOR` varchar(10) DEFAULT NULL COMMENT '颜色',
  `PACKAGE_TYPE` varchar(50) DEFAULT NULL COMMENT '包装',
  `STORAGE_TYPE` varchar(50) DEFAULT NULL COMMENT '储藏方式',
  `SOURCE_ADDR` varchar(50) DEFAULT NULL COMMENT '原料产地',
  `SOURCE_SUPPLIER` varchar(150) DEFAULT NULL COMMENT '原料供应商',
  `PRODUCE_ADDR` varchar(50) DEFAULT NULL COMMENT '产地',
  `INGREDIENTS` varchar(100) DEFAULT NULL COMMENT '配料、原料',
  `SPECS` varchar(10) DEFAULT NULL COMMENT '规格（g）',
  `PRO_STANDARD` varchar(20) DEFAULT NULL COMMENT '产品标准号',
  `PRO_LICENSE_NO` varchar(20) DEFAULT NULL COMMENT '生产许可证编号',
  `EAT_METHOD` varchar(50) DEFAULT NULL COMMENT '食用方法',
  `CLICK_COUNT` int(11) DEFAULT '0' COMMENT '商品的点击数',
  `IS_ALONE_SALE` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否能单独销售，1，是；0，否；如果不能单独销售，则只能作为某商品的配件或者赠品销售',
  `INTEGRAL` int(11) DEFAULT '0' COMMENT '购买该商品可以使用的积分数量',
  `IS_DELETE` tinyint(1) DEFAULT '0' COMMENT '是否已删除 0，否；1，已删除',
  `IS_BEST` tinyint(1) DEFAULT '0' COMMENT '是否精品 0，否；1，是',
  `IS_NEW` tinyint(1) DEFAULT '1' COMMENT '是否是新品 0否 1是',
  `IS_HOT` tinyint(1) DEFAULT '0' COMMENT '是否热销，0，否；1，是',
  `IS_PROMOTE` tinyint(1) DEFAULT '0' COMMENT '是否特价促销；0，否；1，是',
  `BONUS_TYPE_ID` int(11) DEFAULT NULL COMMENT '购买该商品所能领到的优惠券类型',
  `SELLER_NOTE` varchar(200) DEFAULT NULL COMMENT '商品的商家备注，仅商家可见',
  `GIVE_INTEGRAL` int(11) DEFAULT '-1' COMMENT '购买该商品时每笔成功交易赠送的积分数量',
  `EXTENDS_PARAM` text COMMENT '自定义扩展属性',
  KEY `FK_GOODSID_P` (`GOODS_ID`) USING BTREE,
  CONSTRAINT `G_GOODS_PARAM_ibfk_1` FOREIGN KEY (`GOODS_ID`) REFERENCES `G_GOODS` (`GOODS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品规格详情表';

-- ----------------------------
-- Records of G_GOODS_PARAM
-- ----------------------------
INSERT INTO `G_GOODS_PARAM` VALUES ('1597821652', null, null, '570', null, null, null, null, null, null, '京东自营', '广东省广州市揭阳县', '高精', '1', null, null, null, '0', '1', '0', '0', '0', '1', '1', '1', null, null, '-1', '{size:(50,55)}');
INSERT INTO `G_GOODS_PARAM` VALUES ('1598323329', null, null, '560', null, null, null, null, null, null, '福建省莆田市安阳县某厂', '广东省广州市揭阳县', '高精', '1', null, null, null, '0', '1', '0', '0', '0', '1', '1', '1', null, null, '-1', '{aa:100,bb:120,hh:230,cc:red}');
INSERT INTO `G_GOODS_PARAM` VALUES ('1597742452', null, null, '10000', null, null, null, null, null, null, '广州某厂', '广州某县', 'aaa', '2', null, null, null, '0', '1', '0', '0', '0', '1', '1', '1', null, null, '-1', '');
INSERT INTO `G_GOODS_PARAM` VALUES ('1596677416', null, null, '10000', null, null, null, null, null, null, '广州某厂商', '广州某县', 'aaa', '2', null, null, null, '0', '1', '0', '0', '0', '1', '1', '1', null, null, '-1', '{aa:100d,bb:13g}');
INSERT INTO `G_GOODS_PARAM` VALUES ('1598520905', null, null, '10000', null, null, null, null, null, null, '广州某厂商', '广州某县', 'aaa', '1', null, null, null, '0', '1', '0', '0', '0', '1', '1', '1', null, null, '-1', '{param1:10,param2:20}');

-- ----------------------------
-- Table structure for G_GOODS_REPORT
-- ----------------------------
DROP TABLE IF EXISTS `G_GOODS_REPORT`;
CREATE TABLE `G_GOODS_REPORT` (
  `GOODS_ID` varchar(12) NOT NULL COMMENT '商品主键ID',
  `MONTH_SALES` int(11) DEFAULT '0' COMMENT '月销量',
  `COUNT_SALES` int(11) DEFAULT '0' COMMENT '总销量',
  `COUNT_COMMS` int(11) DEFAULT '0' COMMENT '总评价数',
  `COMMEND_SCORE` int(11) DEFAULT '0' COMMENT '评分',
  PRIMARY KEY (`GOODS_ID`),
  CONSTRAINT `G_GOODS_REPORT_ibfk_1` FOREIGN KEY (`GOODS_ID`) REFERENCES `G_GOODS` (`GOODS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品汇总报表';

-- ----------------------------
-- Records of G_GOODS_REPORT
-- ----------------------------
INSERT INTO `G_GOODS_REPORT` VALUES ('1596677386', '1000', '3230', '646', '45');
INSERT INTO `G_GOODS_REPORT` VALUES ('1596677416', '200', '340', '520', '45');
INSERT INTO `G_GOODS_REPORT` VALUES ('1596677426', '236', '523', '130', '50');
INSERT INTO `G_GOODS_REPORT` VALUES ('1596677455', '200', '380', '150', '40');
INSERT INTO `G_GOODS_REPORT` VALUES ('1596677542', '321', '450', '342', '20');
INSERT INTO `G_GOODS_REPORT` VALUES ('1596677555', '763', '1075', '232', '35');
INSERT INTO `G_GOODS_REPORT` VALUES ('1596677566', '100', '2335', '232', '40');
INSERT INTO `G_GOODS_REPORT` VALUES ('1596677579', '150', '345', '212', '35');
INSERT INTO `G_GOODS_REPORT` VALUES ('1596677621', '120', '3435', '132', '20');
INSERT INTO `G_GOODS_REPORT` VALUES ('1596677635', '216', '4546', '186', '40');
INSERT INTO `G_GOODS_REPORT` VALUES ('1596677652', '510', '6875', '156', '25');
INSERT INTO `G_GOODS_REPORT` VALUES ('1596677676', '269', '345', '123', '20');
INSERT INTO `G_GOODS_REPORT` VALUES ('1596677684', '257', '4568', '243', '40');
INSERT INTO `G_GOODS_REPORT` VALUES ('1596677692', '158', '4357', '232', '35');
INSERT INTO `G_GOODS_REPORT` VALUES ('1597140661', '891', '3436', '122', '40');
INSERT INTO `G_GOODS_REPORT` VALUES ('1597196351', '587', '7879', '231', '35');
INSERT INTO `G_GOODS_REPORT` VALUES ('1597742452', '363', '4657', '124', '20');
INSERT INTO `G_GOODS_REPORT` VALUES ('1597821652', '410', '2434', '343', '35');
INSERT INTO `G_GOODS_REPORT` VALUES ('1598323329', '520', '3445', '214', '40');
INSERT INTO `G_GOODS_REPORT` VALUES ('1598520905', '360', '5657', '135', '35');

-- ----------------------------
-- Table structure for G_PICTURE
-- ----------------------------
DROP TABLE IF EXISTS `G_PICTURE`;
CREATE TABLE `G_PICTURE` (
  `PICTURE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图片主键ID',
  `PICTURE_TITLE` varchar(150) DEFAULT NULL COMMENT '图片标题',
  `PREF_TITLE` varchar(200) DEFAULT NULL COMMENT '简短标题',
  `KEYWORDS` varchar(60) DEFAULT NULL COMMENT '关键字',
  `RELATION_ID` varchar(12) DEFAULT NULL COMMENT '关系主体的主键ID',
  `PIC_CATEGORY` bigint(20) DEFAULT NULL COMMENT '图片所属类别',
  `RELATION_TYPE` int(11) DEFAULT NULL COMMENT '关系类型 0，商品 1，店铺 2，文章资讯 3，热门活动',
  `AUTHOR` varchar(100) DEFAULT NULL COMMENT '图片作者',
  `SOURCE` varchar(150) DEFAULT NULL COMMENT '图片来源',
  `IS_ALLOW_COMMENT` tinyint(1) DEFAULT '0' COMMENT '是否允许评论 0允许 1不允许',
  `ABSTRACTS` longtext COMMENT '摘要',
  `PIC_DESC` text COMMENT '图片描述',
  `THUMB_IMG` varchar(150) DEFAULT NULL COMMENT '商品在前台显示的微缩图片，如在分类筛选时显示的小图片',
  `REAL_IMG` varchar(150) NOT NULL COMMENT '商品的实际大小图片，如进入该商品页时介绍商品属性所显示的大图片',
  `ORIGINAL_IMG` varchar(150) DEFAULT NULL COMMENT '商品的原始图片',
  `LINK_URL` varchar(150) DEFAULT NULL COMMENT '图片超链接地址',
  `WIDTH` varchar(20) DEFAULT NULL COMMENT '图片宽度',
  `HEIGHT` varchar(20) DEFAULT NULL COMMENT '图片高度',
  `SORT_ORL` int(11) DEFAULT NULL COMMENT '图片排序',
  `STATUS` tinyint(1) DEFAULT '1' COMMENT '图片状态 0无效 1有效',
  `DEPLOY_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  `OUTLINE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '下线时间',
  `IS_MASTER` tinyint(1) DEFAULT '0' COMMENT '是否为主图 0否 1是',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_BY` varchar(30) DEFAULT NULL COMMENT '创建者',
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `UPDATE_BY` varchar(30) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`PICTURE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8 COMMENT='商品/店铺图片表';

-- ----------------------------
-- Records of G_PICTURE
-- ----------------------------
INSERT INTO `G_PICTURE` VALUES ('3', '图片3', null, null, '1597821652', null, '0', null, null, '0', null, '图片5', '/olalashop/file/images/1592360222.jpeg', '/olalashop/file/images/1592360222.jpeg', '/olalashop/file/images/1592360222.jpeg', null, null, null, null, '1', null, null, '1', '2020-08-25 14:39:31', 'system', '2020-08-25 14:39:31', 'system');
INSERT INTO `G_PICTURE` VALUES ('7', '图片3', null, null, '2', null, '2', null, null, '0', null, '图片3', '/olalashop/file/images/activity2.jpg', '/olalashop/file/images/activity2.jpg', '/olalashop/file/images/activity2.jpg', null, null, null, null, '1', null, null, '1', '2020-08-25 14:39:24', 'system', '2020-08-25 14:39:24', 'system');
INSERT INTO `G_PICTURE` VALUES ('8', '图片8', null, null, '1', null, '1', null, null, '0', null, '图片1', '/olalashop/business/images/556.png', '/olalashop/business/images/556.png', '/olalashop/business/images/556.png', null, null, null, null, '1', null, null, '1', '2020-08-25 14:37:22', 'system', '2020-08-25 14:37:22', 'system');
INSERT INTO `G_PICTURE` VALUES ('9', '图片9', null, null, '2', null, '2', null, null, '0', null, '图片2', '/olalashop/file/images/activity.jpg', '/olalashop/file/images/activity.jpg', '/olalashop/file/images/activity.jpg', null, null, null, null, '1', null, null, '1', '2020-08-25 14:39:21', 'system', '2020-08-25 14:39:21', 'system');
INSERT INTO `G_PICTURE` VALUES ('10', '图片10', null, null, '3', null, '2', null, null, '0', null, '图片3', '/olalashop/file/images/activity1.jpg', '/olalashop/file/images/activity1.jpg', '/olalashop/file/images/activity1.jpg', null, null, null, null, '1', null, null, '1', '2020-08-25 14:39:16', 'system', '2020-08-25 14:39:16', 'system');
INSERT INTO `G_PICTURE` VALUES ('11', '图片11', null, null, '1597821652', null, '0', null, null, '0', null, '图片4', '/olalashop/file/images/01_small.jpg', '/olalashop/file/images/03.jpg', '/olalashop/file/images/03_mid.jpg', null, null, null, null, '1', null, null, '1', '2020-08-25 14:39:13', 'system', '2020-08-25 14:39:13', 'system');
INSERT INTO `G_PICTURE` VALUES ('12', '图片4', null, null, '1598323329', null, '0', null, null, '0', null, '图片4', '/olalashop/file/images/02_small.jpg', '/olalashop/file/images/02.jpg', '/olalashop/file/images/02_mid.jpg', null, null, null, null, '1', null, null, '1', '2020-08-25 14:39:11', 'system', '2020-08-25 14:39:11', 'system');
INSERT INTO `G_PICTURE` VALUES ('13', '图片5', null, null, '1598323329', null, '0', null, null, '0', null, '图片5', '/olalashop/file/images/4.jpg', '/olalashop/file/images/4.jpg', '/olalashop/file/images/4.jpg', null, null, null, null, '1', null, null, '1', '2020-08-25 14:39:09', 'system', '2020-08-25 14:39:09', 'system');
INSERT INTO `G_PICTURE` VALUES ('14', '图片8', null, null, '1', null, '1', null, null, '0', null, '图片1', '/olalashop/business/images/556.png', '/olalashop/business/images/556.png', '/olalashop/business/images/556.png', null, null, null, null, '1', null, null, '1', '2020-08-25 14:37:22', 'system', '2020-08-25 14:37:22', 'system');
INSERT INTO `G_PICTURE` VALUES ('15', '图片3', null, null, '2', null, '2', null, null, '0', null, '图片3', '/olalashop/file/images/activity2.jpg', '/olalashop/file/images/activity2.jpg', '/olalashop/file/images/activity2.jpg', null, null, null, null, '1', null, null, '1', '2020-08-25 14:39:24', 'system', '2020-08-25 14:39:24', 'system');
INSERT INTO `G_PICTURE` VALUES ('16', '图片9', null, null, '2', null, '2', null, null, '0', null, '图片2', '/olalashop/file/images/activity.jpg', '/olalashop/file/images/activity.jpg', '/olalashop/file/images/activity.jpg', null, null, null, null, '1', null, null, '1', '2020-08-25 14:39:21', 'system', '2020-08-25 14:39:21', 'system');
INSERT INTO `G_PICTURE` VALUES ('17', '图片10', null, null, '3', null, '2', null, null, '0', null, '图片3', '/olalashop/file/images/activity1.jpg', '/olalashop/file/images/activity1.jpg', '/olalashop/file/images/activity1.jpg', null, null, null, null, '1', null, null, '1', '2020-08-25 14:39:16', 'system', '2020-08-25 14:39:16', 'system');
INSERT INTO `G_PICTURE` VALUES ('18', '图片11', null, null, '1597821652', null, '0', null, null, '0', null, '图片4', '/olalashop/file/images/01_small.jpg', '/olalashop/file/images/03.jpg', '/olalashop/file/images/03_mid.jpg', null, null, null, null, '1', null, null, '1', '2020-08-25 14:39:13', 'system', '2020-08-25 14:39:13', 'system');
INSERT INTO `G_PICTURE` VALUES ('19', '图片4', null, null, '1598323329', null, '0', null, null, '0', null, '图片4', '/olalashop/file/images/02_small.jpg', '/olalashop/file/images/02.jpg', '/olalashop/file/images/02_mid.jpg', null, null, null, null, '1', null, null, '1', '2020-08-25 14:39:11', 'system', '2020-08-25 14:39:11', 'system');
INSERT INTO `G_PICTURE` VALUES ('20', '图片5', null, null, '1598323329', null, '0', null, null, '0', null, '图片5', '/olalashop/file/images/4.jpg', '/olalashop/file/images/4.jpg', '/olalashop/file/images/4.jpg', null, null, null, null, '1', null, null, '1', '2020-08-25 14:39:09', 'system', '2020-08-25 14:39:09', 'system');
INSERT INTO `G_PICTURE` VALUES ('21', '测试新增图片', null, '测试，资讯', null, '11', '2', 'zhaoy', 'olalashop', '1', '测试新增图片-pref-title', null, '/mnt/myprogram/olalashop/file/images/20.jpg,/mnt/myprogram/olalashop/file/images/23.jpg', ',/mnt/myprogram/olalashop/file/images/20.jpg,/mnt/myprogram/olalashop/file/images/23.jpg', ',/mnt/myprogram/olalashop/file/images/20.jpg,/mnt/myprogram/olalashop/file/images/23.jpg', null, null, null, '20', '0', '2020-08-28 17:10:30', '2020-08-28 17:10:30', '1', '2020-08-28 17:10:30', 'system', '2020-08-28 17:10:30', 'system');
INSERT INTO `G_PICTURE` VALUES ('22', '测试新增图片AAA', null, '测试', null, '1', '2', 'zhaoy', 'olalashop', '1', '测试新增图片AAA-pref-title', '', '/mnt/myprogram/olalashop/file/images/23.jpg,/mnt/myprogram/olalashop/file/images/1592360277.jpeg', '/mnt/myprogram/olalashop/file/images/23.jpg,/mnt/myprogram/olalashop/file/images/1592360277.jpeg', '/mnt/myprogram/olalashop/file/images/23.jpg,/mnt/myprogram/olalashop/file/images/1592360277.jpeg', null, null, null, '20', '1', '2020-08-28 17:11:04', '2020-08-28 17:11:04', '1', '2020-08-28 17:11:04', 'system', '2020-08-28 17:11:04', 'system');
INSERT INTO `G_PICTURE` VALUES ('23', '测试新增图片NNN', null, 'sp04', null, '11', '2', 'zhaoy', 'olalashop', '1', '测试新增图片NNN-pref-title', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '/olalashop/file/images/22.jpg,/olalashop/file/images/23.jpg', '/olalashop/file/images/22.jpg,/olalashop/file/images/23.jpg', '/olalashop/file/images/22.jpg,/olalashop/file/images/23.jpg', null, null, null, '30', '0', '2020-08-28 17:11:01', '2020-08-28 17:11:01', '1', '2020-08-28 17:11:01', 'system', '2020-08-28 17:11:01', 'system');
INSERT INTO `G_PICTURE` VALUES ('24', '巴西松子图片', '良品铺子 手剥松子218g 坚果炒货 巴西松子', 'bxsz01', '1596677386', '315', '0', 'zhaoy', 'olalashop', '0', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '/olalashop/file/images/01_small.jpg', '/olalashop/file/images/01.jpg', '/olalashop/file/images/01_mid.jpg', null, null, null, '31', '1', '2020-08-30 14:29:42', '2020-08-30 14:29:42', '1', '2020-08-30 14:29:42', 'system', '2020-08-30 14:29:42', 'system');
INSERT INTO `G_PICTURE` VALUES ('25', '巴西松子图片', '良品铺子 手剥松子218g 坚果炒货 巴西松子', 'bxsz02', '1596677386', '315', '0', 'zhaoy', 'olalashop', '0', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '/olalashop/file/images/02_small.jpg', '/olalashop/file/images/02.jpg', '/olalashop/file/images/02_mid.jpg', null, null, null, '32', '1', '2020-08-30 14:29:44', '2020-08-30 14:29:44', '1', '2020-08-30 14:29:44', 'system', '2020-08-30 14:29:44', 'system');
INSERT INTO `G_PICTURE` VALUES ('26', '巴西松子图片', '良品铺子 手剥松子218g 坚果炒货 巴西松子', 'bxsz03', '1596677386', '315', '0', 'zhaoy', 'olalashop', '0', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '/olalashop/file/images/03_small.jpg', '/olalashop/file/images/03.jpg', '/olalashop/file/images/03_mid.jpg', null, null, null, '33', '1', '2020-08-30 14:29:45', '2020-08-30 14:29:45', '1', '2020-08-30 14:29:45', 'system', '2020-08-30 14:29:45', 'system');
INSERT INTO `G_PICTURE` VALUES ('27', '巴西松子主图片', '良品铺子 手剥松子218g 坚果炒货 巴西松子', 'bxsz04', '1596677386', '315', '0', 'zhaoy', 'olalashop', '0', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '/olalashop/file/images/01.jpg', '/olalashop/file/images/01.jpg', '/olalashop/file/images/01.jpg', null, null, null, '34', '1', '2020-08-30 14:29:45', '2020-08-30 14:29:45', '0', '2020-08-30 14:29:45', 'system', '2020-08-30 14:29:45', 'system');
INSERT INTO `G_PICTURE` VALUES ('28', '巴西松子主图片', '良品铺子 手剥松子218g 坚果炒货 巴西松子', 'bxsz04', '1596677386', '315', '0', 'zhaoy', 'olalashop', '0', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '/olalashop/file/images/02.jpg', '/olalashop/file/images/02.jpg', '/olalashop/file/images/02.jpg', null, null, null, '35', '1', '2020-08-30 14:29:46', '2020-08-30 14:29:46', '0', '2020-08-30 14:29:46', 'system', '2020-08-30 14:29:46', 'system');
INSERT INTO `G_PICTURE` VALUES ('29', '巴西松子主图片', '良品铺子 手剥松子218g 坚果炒货 巴西松子', 'bxsz04', '1596677386', '315', '0', 'zhaoy', 'olalashop', '0', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '/olalashop/file/images/03.jpg', '/olalashop/file/images/03.jpg', '/olalashop/file/images/03.jpg', null, null, null, '36', '1', '2020-08-30 14:29:46', '2020-08-30 14:29:46', '0', '2020-08-30 14:29:46', 'system', '2020-08-30 14:29:46', 'system');
INSERT INTO `G_PICTURE` VALUES ('30', '绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', 'ldglppz01', '1598520905', '254', '0', 'zhaoy', 'olalashop', '0', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '/olalashop/file/foodsImgs/7efa6debff5e6a9f.jpg', '/olalashop/file/foodsImgs/7efa6debff5e6a9f.jpg', '/olalashop/file/foodsImgs/7efa6debff5e6a9f.jpg', null, null, null, '37', '1', '2020-08-30 14:30:40', '2020-08-30 14:30:40', '0', '2020-08-30 14:30:40', 'system', '2020-08-30 14:30:40', 'system');
INSERT INTO `G_PICTURE` VALUES ('31', '绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', 'ldglppz02', '1598520905', '254', '0', 'zhaoy', 'olalashop', '0', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '/olalashop/file/foodsImgs/9265cb18a5129904.jpg', '/olalashop/file/foodsImgs/9265cb18a5129904.jpg', '/olalashop/file/foodsImgs/9265cb18a5129904.jpg', null, null, null, '38', '1', '2020-08-30 14:30:42', '2020-08-30 14:30:42', '0', '2020-08-30 14:30:42', 'system', '2020-08-30 14:30:42', 'system');
INSERT INTO `G_PICTURE` VALUES ('32', '绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', 'ldglppz03', '1598520905', '254', '0', 'zhaoy', 'olalashop', '0', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '/olalashop/file/foodsImgs/d17cdf6ec55be2ea.jpg', '/olalashop/file/foodsImgs/d17cdf6ec55be2ea.jpg', '/olalashop/file/foodsImgs/d17cdf6ec55be2ea.jpg', null, null, null, '39', '1', '2020-08-30 14:30:42', '2020-08-30 14:30:42', '0', '2020-08-30 14:30:42', 'system', '2020-08-30 14:30:42', 'system');
INSERT INTO `G_PICTURE` VALUES ('33', '绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', 'ldglppz04', '1598520905', '254', '0', 'zhaoy', 'olalashop', '0', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '/olalashop/file/foodsImgs/f5f497c0deacec0e.jpg', '/olalashop/file/foodsImgs/f5f497c0deacec0e.jpg', '/olalashop/file/foodsImgs/f5f497c0deacec0e.jpg', null, null, null, '40', '1', '2020-08-30 14:30:43', '2020-08-30 14:30:43', '0', '2020-08-30 14:30:43', 'system', '2020-08-30 14:30:43', 'system');
INSERT INTO `G_PICTURE` VALUES ('34', '绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', 'ldglppz05', '1598520905', '254', '0', 'zhaoy', 'olalashop', '0', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '/olalashop/file/foodsImgs/f966fa60a25fd133.jpg', '/olalashop/file/foodsImgs/f966fa60a25fd133.jpg', '/olalashop/file/foodsImgs/f966fa60a25fd133.jpg', null, null, null, '41', '1', '2020-08-30 14:30:43', '2020-08-30 14:30:43', '0', '2020-08-30 14:30:43', 'system', '2020-08-30 14:30:43', 'system');
INSERT INTO `G_PICTURE` VALUES ('35', '手剥松子218g 坚果炒货 巴西松子', '良品铺子 手剥松子218g 坚果炒货 巴西松子', 'lppuzisbsz', '1596677386', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', null, null, null, '42', '1', '2020-08-30 14:58:53', '2020-08-30 14:58:53', '2', '2020-08-30 14:58:53', 'system', '2020-08-30 14:58:53', 'system');
INSERT INTO `G_PICTURE` VALUES ('36', '肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶', '良品铺子 肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶点380g', 'rsbgxxls', '1596677416', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', null, null, null, '42', '1', '2020-08-31 01:32:44', '2020-08-31 01:32:44', '1', '2020-08-31 01:32:44', 'system', '2020-08-31 01:32:44', 'system');
INSERT INTO `G_PICTURE` VALUES ('37', '酥脆薄饼海苔味早餐饼干薯片儿童零食休闲零食网红食品小吃', '良品铺子酥脆薄饼海苔味早餐饼干薯片儿童零食休闲零食网红食品小吃小零食300g', 'scbbxcls', '1596677426', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', null, null, null, '42', '1', '2020-08-30 14:58:53', '2020-08-30 14:58:53', '2', '2020-08-30 14:58:53', 'system', '2020-08-30 14:58:53', 'system');
INSERT INTO `G_PICTURE` VALUES ('38', '半蒸芝士蛋糕糕点面包芝士味网红早餐下午茶休闲小吃零食 ', '良品铺子 半蒸芝士蛋糕糕点面包芝士味网红早餐下午茶休闲小吃零食 204g', 'zsdgxxls', '1596677455', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', null, null, null, '42', '1', '2020-08-30 14:58:53', '2020-08-30 14:58:53', '2', '2020-08-30 14:58:53', 'system', '2020-08-30 14:58:53', 'system');
INSERT INTO `G_PICTURE` VALUES ('39', '良品铺子手撕面包1050g 2.1斤早餐小面包饼干蛋糕休闲零食办公室糕点点心整箱装礼盒', '手撕面包1050g 2.1斤早餐小面包饼干蛋糕休闲零食办公室糕点', 'ssmbgd', '1596677542', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', null, null, null, '42', '1', '2020-08-30 14:58:53', '2020-08-30 14:58:53', '2', '2020-08-30 14:58:53', 'system', '2020-08-30 14:58:53', 'system');
INSERT INTO `G_PICTURE` VALUES ('40', '手撕面包孕妇儿童零食早餐食品吃的休闲小吃糕点330g', '良品铺子 手撕面包孕妇儿童零食早餐食品吃的休闲小吃糕点330g', 'ssmbzjwh', '1596677555', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', null, null, null, '42', '1', '2020-08-30 14:58:53', '2020-08-30 14:58:53', '2', '2020-08-30 14:58:53', 'system', '2020-08-30 14:58:53', 'system');
INSERT INTO `G_PICTURE` VALUES ('41', '酥脆薄饼300g 薄脆饼干独立小包装原味酱汁烧烤味海苔饼', '【300减210】良品铺子 酥脆薄饼300g 薄脆饼干独立小包装原味酱汁烧烤味海苔饼干 儿童休闲零食 海苔味', 'htetxxls', '1596677566', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', null, null, null, '42', '1', '2020-08-30 14:58:53', '2020-08-30 14:58:53', '2', '2020-08-30 14:58:53', 'system', '2020-08-30 14:58:53', 'system');
INSERT INTO `G_PICTURE` VALUES ('42', '活力吐司早餐营养面包休闲零食网红孕妇零食儿童零食饼干糕', '良品铺子 活力吐司早餐营养面包休闲零食网红孕妇零食儿童零食饼干糕点458g', 'tsmbzcet', '1596677579', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', null, null, null, '42', '1', '2020-08-30 14:58:53', '2020-08-30 14:58:53', '2', '2020-08-30 14:58:53', 'system', '2020-08-30 14:58:53', 'system');
INSERT INTO `G_PICTURE` VALUES ('43', '高端零食 威化饼干牛奶味 休闲零食办公室早餐下午茶小吃', ' 良品铺子 高端零食 威化饼干牛奶味 休闲零食办公室早餐下午茶小吃118g', 'xxxwcbgs', '1596677621', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', null, null, null, '42', '1', '2020-08-30 14:58:53', '2020-08-30 14:58:53', '2', '2020-08-30 14:58:53', 'system', '2020-08-30 14:58:53', 'system');
INSERT INTO `G_PICTURE` VALUES ('44', '蛋黄酥6枚礼盒装糕点小吃日式雪媚娘饼干蛋糕早餐网红休闲', '良品铺子 蛋黄酥6枚礼盒装糕点小吃日式雪媚娘饼干蛋糕早餐网红休闲零食320g', 'dhsgd', '1596677629', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', null, null, null, '42', '1', '2020-08-30 14:58:53', '2020-08-30 14:58:53', '2', '2020-08-30 14:58:53', 'system', '2020-08-30 14:58:53', 'system');
INSERT INTO `G_PICTURE` VALUES ('45', '芝士泡芙休闲零食星空泡芙球夹心饼干小吃60g ', '良品铺子 芝士泡芙休闲零食星空泡芙球夹心饼干小吃60g', 'zspfxxls', '1596677635', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', null, null, null, '42', '1', '2020-08-30 14:58:53', '2020-08-30 14:58:53', '2', '2020-08-30 14:58:53', 'system', '2020-08-30 14:58:53', 'system');
INSERT INTO `G_PICTURE` VALUES ('46', '肉肉海苔吐司 肉松小面包蛋糕手撕营养早餐代餐网红肉干肉脯', ' 良品铺子肉肉海苔吐司 肉松小面包蛋糕手撕营养早餐代餐网红肉干肉脯休闲零食办公室小吃520g', 'rplsbgs', '1596677652', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', null, null, null, '42', '1', '2020-08-30 14:58:53', '2020-08-30 14:58:53', '2', '2020-08-30 14:58:53', 'system', '2020-08-30 14:58:53', 'system');
INSERT INTO `G_PICTURE` VALUES ('47', '紫米三明治吐司紫米面包糕点点心孕妇儿童网红营养早餐休闲', ' 良品铺子 紫米三明治吐司紫米面包糕点点心孕妇儿童网红营养早餐休闲零食整箱装555g', 'etzmsmz', '1596677661', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', null, null, null, '42', '1', '2020-08-30 14:58:53', '2020-08-30 14:58:53', '2', '2020-08-30 14:58:53', 'system', '2020-08-30 14:58:53', 'system');
INSERT INTO `G_PICTURE` VALUES ('48', '咸蛋黄麦芽饼干 面包蛋糕麦芽饼干网红休闲零食下午茶办公室小吃早餐代餐零食礼盒整箱装520g ', '良品铺子 咸蛋黄麦芽饼干 面包蛋糕麦芽饼干网红休闲零食下午茶办公室小吃早餐代餐零食礼盒整箱装520g', 'xdhmybg', '1596677676', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/0-item_pic.jpg_220x220.jpg', '/olalashop/business/images/0-item_pic.jpg_220x220.jpg', '/olalashop/business/images/0-item_pic.jpg_220x220.jpg', null, null, null, '42', '1', '2020-08-30 20:12:36', '2020-08-30 20:12:36', '2', '2020-08-30 20:12:36', 'system', '2020-08-30 20:12:36', 'system');
INSERT INTO `G_PICTURE` VALUES ('49', '雪花酥什锦装108g 冻干雪花酥饼干 网红零食沙琪玛牛', '【300减210】良品铺子 雪花酥什锦装108g 冻干雪花酥饼干 网红零食沙琪玛牛轧糖休闲零食 雪花酥什锦装108g 1盒', 'xhssjbg', '1596677684', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', null, null, null, '42', '1', '2020-08-30 14:58:53', '2020-08-30 14:58:53', '2', '2020-08-30 14:58:53', 'system', '2020-08-30 14:58:53', 'system');
INSERT INTO `G_PICTURE` VALUES ('50', '椰丝球面包 早餐糕点点心 零食甜点小吃300g', '良品铺子 椰丝球面包 早餐糕点点心 零食甜点小吃300g', 'ysqmbgd', '1596677692', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', null, null, null, '42', '1', '2020-08-30 14:58:53', '2020-08-30 14:58:53', '2', '2020-08-30 14:58:53', 'system', '2020-08-30 14:58:53', 'system');
INSERT INTO `G_PICTURE` VALUES ('51', '幼儿园识字必备教材 识字大王', '正版 识字大王看图识字书大全幼儿童早教图书3-6岁宝宝书认字卡片学拼音汉语启蒙书籍幼儿园学前大班教材', 'szdw', '1597140661', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', null, null, null, '42', '1', '2020-08-30 14:59:03', '2020-08-30 14:59:03', '2', '2020-08-30 14:59:03', 'system', '2020-08-30 14:59:03', 'system');
INSERT INTO `G_PICTURE` VALUES ('52', '上善若水 斗战胜佛之静思 纯铜齐天大圣', '上善若水《斗战胜佛之静思》纯铜美猴王齐天大圣孙悟空摆件新中式办公室桌面客厅家居酒柜装饰品铜猴子工艺品', 'ssrsct', '1597196351', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/0-item_pic.jpg_220x220.jpg', '/olalashop/business/images/0-item_pic.jpg_220x220.jpg', '/olalashop/business/images/0-item_pic.jpg_220x220.jpg', null, null, null, '42', '1', '2020-08-30 20:12:31', '2020-08-30 20:12:31', '2', '2020-08-30 20:12:31', 'system', '2020-08-30 20:12:31', 'system');
INSERT INTO `G_PICTURE` VALUES ('53', '幼儿园识字必备教材 识字大王 AAA', '正版 识字大王看图识字书大全幼儿童早教图书3-6岁宝宝书认字卡片学拼音汉语启蒙书籍幼儿园学前大班教材', 'yejy', '1597742452', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', null, null, null, '42', '1', '2020-08-30 14:59:27', '2020-08-30 14:59:27', '2', '2020-08-30 14:59:27', 'system', '2020-08-30 14:59:27', 'system');
INSERT INTO `G_PICTURE` VALUES ('54', '华为LOK-350', '荣耀智慧屏X1 55英寸LOK-350 2G+16G ', 'rylok', '1597821652', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', null, null, null, '42', '1', '2020-08-30 14:59:35', '2020-08-30 14:59:35', '2', '2020-08-30 14:59:35', 'system', '2020-08-30 14:59:35', 'system');
INSERT INTO `G_PICTURE` VALUES ('55', '格力KFR-35GW/(35592)FNhAa-A1(WIFI)', '格力（GREE）正1.5匹 品悦一级能效 变频冷暖 智能 壁挂式卧室空调挂机 KFR-35GW/(35592)FNhAa-A1线下同款', 'geliktgj', '1598323329', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/0-item_pic.jpg_220x220.jpg', '/olalashop/business/images/0-item_pic.jpg_220x220.jpg', '/olalashop/business/images/0-item_pic.jpg_220x220.jpg', null, null, null, '42', '1', '2020-08-30 20:12:25', '2020-08-30 20:12:25', '2', '2020-08-30 20:12:25', 'system', '2020-08-30 20:12:25', 'system');
INSERT INTO `G_PICTURE` VALUES ('56', ' 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', 'ldgxxls', '1598520905', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', null, null, null, '42', '1', '2020-08-30 14:58:53', '2020-08-30 14:58:53', '2', '2020-08-30 14:58:53', 'system', '2020-08-30 14:58:53', 'system');
INSERT INTO `G_PICTURE` VALUES ('57', '肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶', '良品铺子 肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶点380g', 'rsbgxxls', '1596677416', '254', '0', 'zhaoy', 'olalashop', '0', '手剥松子', '手剥松子', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', '/olalashop/business/images/imgsearch1.jpg', null, null, null, '42', '1', '2020-08-30 14:56:06', '2020-08-30 14:56:06', '2', '2020-08-30 14:56:06', 'system', '2020-08-30 14:56:06', 'system');
INSERT INTO `G_PICTURE` VALUES ('59', '肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶', '良品铺子 肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶点380g', 'rsbgxxls', '1596677416', '315', '0', 'zhaoy', 'olalashop', '0', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '/olalashop/file/images/01_small.jpg', '/olalashop/file/images/01.jpg', '/olalashop/file/images/01_mid.jpg', null, null, null, '31', '1', '2020-08-30 15:32:34', '2020-08-30 15:32:34', '1', '2020-08-30 15:32:34', 'system', '2020-08-30 15:32:34', 'system');
INSERT INTO `G_PICTURE` VALUES ('60', '肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶', '良品铺子 肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶点380g', 'rsbgxxls', '1596677416', '315', '0', 'zhaoy', 'olalashop', '0', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '/olalashop/file/images/02_small.jpg', '/olalashop/file/images/02.jpg', '/olalashop/file/images/02_mid.jpg', null, null, null, '32', '1', '2020-08-30 15:32:38', '2020-08-30 15:32:38', '1', '2020-08-30 15:32:38', 'system', '2020-08-30 15:32:38', 'system');
INSERT INTO `G_PICTURE` VALUES ('61', '肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶', '良品铺子 肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶点380g', 'rsbgxxls', '1596677416', '315', '0', 'zhaoy', 'olalashop', '0', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '/olalashop/file/images/03_small.jpg', '/olalashop/file/images/03.jpg', '/olalashop/file/images/03_mid.jpg', null, null, null, '33', '1', '2020-08-30 15:32:40', '2020-08-30 15:32:40', '1', '2020-08-30 15:32:40', 'system', '2020-08-30 15:32:40', 'system');
INSERT INTO `G_PICTURE` VALUES ('62', '肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶', '良品铺子 肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶点380g', 'rsbgxxls', '1596677416', '315', '0', 'zhaoy', 'olalashop', '0', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '/olalashop/file/images/01.jpg', '/olalashop/file/images/01.jpg', '/olalashop/file/images/01.jpg', null, null, null, '34', '1', '2020-08-30 15:32:45', '2020-08-30 15:32:45', '0', '2020-08-30 15:32:45', 'system', '2020-08-30 15:32:45', 'system');
INSERT INTO `G_PICTURE` VALUES ('63', '肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶', '良品铺子 肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶点380g', 'rsbgxxls', '1596677416', '315', '0', 'zhaoy', 'olalashop', '0', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '/olalashop/file/images/02.jpg', '/olalashop/file/images/02.jpg', '/olalashop/file/images/02.jpg', null, null, null, '35', '1', '2020-08-30 15:33:48', '2020-08-30 15:33:48', '0', '2020-08-30 15:33:48', 'system', '2020-08-30 15:33:48', 'system');
INSERT INTO `G_PICTURE` VALUES ('64', '肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶', '良品铺子 肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶点380g', 'rsbgxxls', '1596677416', '315', '0', 'zhaoy', 'olalashop', '0', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '良品铺子 手剥松子218g 坚果炒货 巴西松子', '/olalashop/file/images/03.jpg', '/olalashop/file/images/03.jpg', '/olalashop/file/images/03.jpg', null, null, null, '36', '1', '2020-08-30 15:33:51', '2020-08-30 15:33:51', '0', '2020-08-30 15:33:51', 'system', '2020-08-30 15:33:51', 'system');
INSERT INTO `G_PICTURE` VALUES ('65', '绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', 'ldglppz01', '1596677416', '254', '0', 'zhaoy', 'olalashop', '0', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '/olalashop/file/foodsImgs/7efa6debff5e6a9f.jpg', '/olalashop/file/foodsImgs/7efa6debff5e6a9f.jpg', '/olalashop/file/foodsImgs/7efa6debff5e6a9f.jpg', null, null, null, '37', '1', '2020-08-30 14:30:40', '2020-08-30 14:30:40', '0', '2020-08-30 14:30:40', 'system', '2020-08-30 14:30:40', 'system');
INSERT INTO `G_PICTURE` VALUES ('66', '绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', 'ldglppz02', '1596677416', '254', '0', 'zhaoy', 'olalashop', '0', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '/olalashop/file/foodsImgs/9265cb18a5129904.jpg', '/olalashop/file/foodsImgs/9265cb18a5129904.jpg', '/olalashop/file/foodsImgs/9265cb18a5129904.jpg', null, null, null, '38', '1', '2020-08-30 14:30:42', '2020-08-30 14:30:42', '0', '2020-08-30 14:30:42', 'system', '2020-08-30 14:30:42', 'system');
INSERT INTO `G_PICTURE` VALUES ('67', '绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', 'ldglppz03', '1596677416', '254', '0', 'zhaoy', 'olalashop', '0', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '/olalashop/file/foodsImgs/d17cdf6ec55be2ea.jpg', '/olalashop/file/foodsImgs/d17cdf6ec55be2ea.jpg', '/olalashop/file/foodsImgs/d17cdf6ec55be2ea.jpg', null, null, null, '39', '1', '2020-08-30 14:30:42', '2020-08-30 14:30:42', '0', '2020-08-30 14:30:42', 'system', '2020-08-30 14:30:42', 'system');
INSERT INTO `G_PICTURE` VALUES ('68', '绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', 'ldglppz04', '1596677416', '254', '0', 'zhaoy', 'olalashop', '0', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '/olalashop/file/foodsImgs/f5f497c0deacec0e.jpg', '/olalashop/file/foodsImgs/f5f497c0deacec0e.jpg', '/olalashop/file/foodsImgs/f5f497c0deacec0e.jpg', null, null, null, '40', '1', '2020-08-30 14:30:43', '2020-08-30 14:30:43', '0', '2020-08-30 14:30:43', 'system', '2020-08-30 14:30:43', 'system');
INSERT INTO `G_PICTURE` VALUES ('69', '绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', 'ldglppz05', '1596677416', '254', '0', 'zhaoy', 'olalashop', '0', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '良品铺子 绿豆糕 糕点点心 休闲零食 小吃办公室下午茶流心麻薯绿豆糕160g', '/olalashop/file/foodsImgs/f966fa60a25fd133.jpg', '/olalashop/file/foodsImgs/f966fa60a25fd133.jpg', '/olalashop/file/foodsImgs/f966fa60a25fd133.jpg', null, null, null, '41', '1', '2020-08-30 14:30:43', '2020-08-30 14:30:43', '0', '2020-08-30 14:30:43', 'system', '2020-08-30 14:30:43', 'system');

-- ----------------------------
-- Table structure for G_SECOND_SALES
-- ----------------------------
DROP TABLE IF EXISTS `G_SECOND_SALES`;
CREATE TABLE `G_SECOND_SALES` (
  `SECOND_SALE_ID` smallint(6) NOT NULL AUTO_INCREMENT COMMENT '秒杀活动主键ID',
  `GOODS_ID` varchar(12) DEFAULT NULL COMMENT '商品主键ID',
  `MAX_SEC` int(11) DEFAULT '300' COMMENT '秒杀时长（s）',
  `SALE_COUNT` int(11) DEFAULT '0' COMMENT '已售数量',
  `MAX_COUNT` int(11) DEFAULT '0' COMMENT '秒杀数量',
  `SALE_PRICE` int(11) DEFAULT NULL COMMENT '秒杀价格(分)',
  `IS_OPEN_SALE` tinyint(1) DEFAULT '0' COMMENT '是否开始秒杀 0未开始 1 开始  2结束',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_BY` varchar(30) DEFAULT NULL COMMENT '创建者',
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `UPDATE_BY` varchar(30) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`SECOND_SALE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品秒杀特卖表';

-- ----------------------------
-- Records of G_SECOND_SALES
-- ----------------------------

-- ----------------------------
-- Table structure for O_COMMENT
-- ----------------------------
DROP TABLE IF EXISTS `O_COMMENT`;
CREATE TABLE `O_COMMENT` (
  `COMMENT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论主键ID',
  `COMMENT_TYPE` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户评论的类型; 0评论的是商品,1评论的是文章',
  `ID_VALUE` varchar(12) NOT NULL COMMENT '商品/文章主键ID',
  `ORDER_ID` bigint(20) DEFAULT NULL COMMENT '订单ID',
  `USER_ID` varchar(20) DEFAULT NULL COMMENT '用户ID',
  `USER_NAME` varchar(60) DEFAULT NULL COMMENT '用户名',
  `EMAIL` varchar(60) DEFAULT NULL COMMENT '评论者邮箱',
  `TITLE` varchar(50) NOT NULL COMMENT '评论主题',
  `CONTENT` text NOT NULL COMMENT '评论内容',
  `COMMENT_RANK` tinyint(1) DEFAULT NULL COMMENT '该文章或者商品的重星级;只有1到5星;由数字代替;其中5代表5星',
  `ADD_TIME` datetime DEFAULT NULL COMMENT '评论时间',
  `IP_ADDR` varchar(15) DEFAULT NULL COMMENT '评论者的IP地址',
  `PARENT_ID` int(11) DEFAULT NULL COMMENT '评论的父节点,取值该表的comment_id字段,如果该字段为0,则是一个普通评论,否则该条评论就是该字段的值所对应的评论的回复',
  `AUDIT_STATUS` tinyint(1) DEFAULT '0' COMMENT '是否被管理员批准显示;1是; 0未批准显示',
  `AUDIT_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '审核时间',
  `MODIFIED_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`COMMENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品订单评论表';

-- ----------------------------
-- Records of O_COMMENT
-- ----------------------------
INSERT INTO `O_COMMENT` VALUES ('1', '1', '12', '13345', '12223', 'zhaoy', '133@163.com', '评论一', '评论内容呢', null, '2020-08-17 18:57:46', '192.168.0.123', '12', '1', '2020-08-17 18:58:01', '2020-08-17 18:58:04');

-- ----------------------------
-- Table structure for O_DELIVERY
-- ----------------------------
DROP TABLE IF EXISTS `O_DELIVERY`;
CREATE TABLE `O_DELIVERY` (
  `DELIV_NO` int(11) NOT NULL AUTO_INCREMENT COMMENT '配送单编码',
  `SHIP_SN` varchar(50) DEFAULT NULL COMMENT '快递单号',
  `SHIP_COMP_NAME` varchar(20) DEFAULT NULL COMMENT '快递公司名称',
  `CUSTOMER_ID` varchar(20) NOT NULL COMMENT '客户主键ID',
  `ORDER_SN` varchar(12) NOT NULL COMMENT '订单编号',
  `GOODS_ID` varchar(12) NOT NULL COMMENT '商品主键ID',
  `QUANTITY` int(11) DEFAULT NULL COMMENT '商品数量',
  `UNIT_PRICE` int(11) DEFAULT NULL COMMENT '商品单价',
  `TOTAL_PRICE` int(11) DEFAULT NULL COMMENT '订单总价',
  `DELIV_FEE` int(11) DEFAULT NULL COMMENT '配送费用（分）',
  `CUST_NAME` varchar(20) DEFAULT NULL COMMENT '收件人姓名',
  `ZIP` char(6) DEFAULT NULL COMMENT '收货地址邮编',
  `PROVINCE` varchar(20) DEFAULT NULL COMMENT '省份',
  `CITY` varchar(20) DEFAULT NULL COMMENT '城市',
  `DISTRICT` varchar(20) DEFAULT NULL COMMENT '城市中的区域',
  `ADDRESS` varchar(50) DEFAULT NULL COMMENT '收货地址',
  `TEL_NO` char(12) DEFAULT NULL COMMENT '收货人联系方式',
  `DELIV_DATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '配送日期',
  PRIMARY KEY (`DELIV_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品配送单表';

-- ----------------------------
-- Records of O_DELIVERY
-- ----------------------------

-- ----------------------------
-- Table structure for O_ORDER_DETAIL
-- ----------------------------
DROP TABLE IF EXISTS `O_ORDER_DETAIL`;
CREATE TABLE `O_ORDER_DETAIL` (
  `ORDER_DETAIL_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单详情表ID',
  `ORDER_ID` int(11) NOT NULL COMMENT '订单表ID',
  `GOODS_ID` varchar(20) NOT NULL COMMENT '订单商品ID',
  `GOODS_NAME` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `GOODS_CNT` int(11) DEFAULT NULL COMMENT '购买商品数量',
  `GOODS_PRICE` int(11) DEFAULT NULL COMMENT '购买商品单价（分）',
  `AVERAGE_COST` int(11) DEFAULT NULL COMMENT '平均成本价格（分）',
  `WEIGHT` float DEFAULT NULL COMMENT '商品重量',
  `DISTRICT_MONEY` int(11) DEFAULT NULL COMMENT '优惠分摊金额（分）',
  `WHID` int(11) DEFAULT NULL COMMENT '仓库ID',
  `MODIFIED_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`ORDER_DETAIL_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='订单详情表';

-- ----------------------------
-- Records of O_ORDER_DETAIL
-- ----------------------------
INSERT INTO `O_ORDER_DETAIL` VALUES ('15', '23', '1596677416', '肉松饼营养早餐面包糕点点心饼干办公室休闲零食特色小吃茶', '2', '2800', null, null, null, null, '2020-08-30 17:20:40');
INSERT INTO `O_ORDER_DETAIL` VALUES ('16', '24', '1596677566', '酥脆薄饼300g 薄脆饼干独立小包装原味酱汁烧烤味海苔饼', '2', '2600', null, null, null, null, '2020-08-30 17:37:22');
INSERT INTO `O_ORDER_DETAIL` VALUES ('17', '25', '1597196351', '上善若水 斗战胜佛之静思 纯铜齐天大圣', '2', '2600', null, null, null, null, '2020-08-30 17:48:26');
INSERT INTO `O_ORDER_DETAIL` VALUES ('18', '27', '1596677455', '半蒸芝士蛋糕糕点面包芝士味网红早餐下午茶休闲小吃零食 ', '1', '3400', '2700', null, null, null, '2020-08-31 16:32:34');
INSERT INTO `O_ORDER_DETAIL` VALUES ('19', '28', '1596677692', '椰丝球面包 早餐糕点点心 零食甜点小吃300g', '2', '2345', '1900', null, null, null, '2020-08-31 17:04:21');
INSERT INTO `O_ORDER_DETAIL` VALUES ('20', '28', '1596677455', '半蒸芝士蛋糕糕点面包芝士味网红早餐下午茶休闲小吃零食 ', '1', '3145', '2700', null, null, null, '2020-08-31 17:04:21');
INSERT INTO `O_ORDER_DETAIL` VALUES ('21', '29', '1596677661', '紫米三明治吐司紫米面包糕点点心孕妇儿童网红营养早餐休闲', '1', '2945', '2500', null, null, null, '2020-09-01 02:01:45');
INSERT INTO `O_ORDER_DETAIL` VALUES ('22', '30', '1598323329', '格力KFR-35GW/(35592)FNhAa-A1(WIFI)', '1', '2345', '1900', null, null, null, '2020-09-01 02:49:30');

-- ----------------------------
-- Table structure for O_ORDER_MASTER
-- ----------------------------
DROP TABLE IF EXISTS `O_ORDER_MASTER`;
CREATE TABLE `O_ORDER_MASTER` (
  `ORDER_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `ORDER_SN` varchar(32) NOT NULL COMMENT '订单编号',
  `TRANSATION_NO` varchar(20) DEFAULT NULL COMMENT '交易流水号',
  `CUSTOMER_ID` varchar(30) NOT NULL COMMENT '客户ID',
  `PAY_TYPE` tinyint(1) DEFAULT NULL COMMENT '支付方式：1现金，2余额，3网银，4支付宝，5微信',
  `PAY_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '支付时间',
  `ORDER_MONEY` int(11) DEFAULT NULL COMMENT '订单金额（分）',
  `DISTRICT_MONEY` int(11) DEFAULT NULL COMMENT '优惠金额（分）',
  `PAY_MONEY` int(11) DEFAULT NULL COMMENT '支付金额（分）',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  `RECEIVE_TIME` datetime DEFAULT NULL COMMENT '收货时间',
  `ORDER_STATUS` tinyint(4) DEFAULT '0' COMMENT '订单状态 0未支付 1已支付 2已完成 3待退款 4已退款 5已关闭',
  `ORDER_POINT` int(11) DEFAULT NULL COMMENT '订单积分',
  `INVOICE_TITLE` varchar(100) DEFAULT NULL COMMENT '发票抬头',
  `INVOICE_NO` varchar(50) DEFAULT NULL COMMENT '发票单号',
  `MODIFIED_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`ORDER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='订单主表';

-- ----------------------------
-- Records of O_ORDER_MASTER
-- ----------------------------
INSERT INTO `O_ORDER_MASTER` VALUES ('23', 'c31a7d043c3f44749cb616f0a5a39da4', 'b79915332f05441398', '1598777623923', '1', '2020-08-30 17:20:40', '5600', '0', '5600', '2020-08-30 17:20:40', null, '0', '0', null, null, '2020-08-30 17:20:40');
INSERT INTO `O_ORDER_MASTER` VALUES ('24', '3985a962331a4b4bb9e5d64183e898e5', 'c1631a607d254ab387', '1598777623923', '1', '2020-08-30 17:37:22', '5200', '0', '5200', '2020-08-30 17:37:22', null, '0', '0', null, null, '2020-08-30 17:37:22');
INSERT INTO `O_ORDER_MASTER` VALUES ('25', '47056cc513144e90a5f145ebdafc0ee0', 'a748b68da27443cca4', '1598777623923', '1', '2020-08-30 17:48:26', '5200', '0', '5200', '2020-08-30 17:48:26', null, '0', '0', null, null, '2020-08-30 17:48:26');
INSERT INTO `O_ORDER_MASTER` VALUES ('27', '2b6ed09f52ae46b68feb1fdf479abd1c', 'a4fa37956b284c1fbb', '1598777623923', '1', '2020-09-01 01:09:50', '3400', '0', '340000', '2020-09-01 01:09:50', null, '0', '0', null, null, '2020-09-01 01:09:50');
INSERT INTO `O_ORDER_MASTER` VALUES ('28', '04b182853fa04283bedc469af2eba369', 'a2d918cf82074d17be', '1598777623923', '1', '2020-09-01 01:09:31', '7835', '0', '783500', '2020-09-01 01:09:31', null, '0', '0', null, null, '2020-09-01 01:09:31');
INSERT INTO `O_ORDER_MASTER` VALUES ('29', '7fec9fa1817845d09b5b195aaf7785f2', '7010056ef88a48178c', '1598777623923', '1', '2020-09-01 02:01:45', '2945', '0', '2945', '2020-09-01 02:01:45', null, '0', '0', null, null, '2020-09-01 02:01:45');
INSERT INTO `O_ORDER_MASTER` VALUES ('30', 'a5c2f4a64c1b4960a75e7cc2ec7d1ff3', 'b83c43eb5650435b86', '1598777623923', '1', '2020-09-01 02:49:30', '2345', '0', '2345', '2020-09-01 02:49:30', null, '0', '0', null, null, '2020-09-01 02:49:30');

-- ----------------------------
-- Table structure for O_REFUND_ORDER
-- ----------------------------
DROP TABLE IF EXISTS `O_REFUND_ORDER`;
CREATE TABLE `O_REFUND_ORDER` (
  `REFUND_ORDER_ID` varchar(12) NOT NULL COMMENT '退货单编号',
  `CUSTOMER_ID` varchar(20) NOT NULL COMMENT '客户ID',
  `ORDER_ID` int(11) NOT NULL COMMENT '原始订单ID',
  `TRANSATION_NO` varchar(20) DEFAULT NULL COMMENT '交易流水号',
  `DELIV_FEE` int(11) DEFAULT NULL COMMENT '配送费用（分）',
  `DELIV_DATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '配送日期',
  `REFUND_REASON` varchar(150) DEFAULT NULL COMMENT '退货原因',
  `GOODS_ID` varchar(12) DEFAULT NULL COMMENT '商品ID',
  `QUANTITY` int(11) DEFAULT NULL COMMENT '商品数量',
  `CUST_NAME` varchar(20) DEFAULT NULL COMMENT '退货人',
  `REFUND_DATE` datetime DEFAULT NULL COMMENT '退货时间',
  `REFUND_STATUS` tinyint(1) DEFAULT '0' COMMENT '退货状态 0已提交审核 1审核通过，同意退货 2退货中 3退货完成',
  `MODIFIED_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`REFUND_ORDER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品退货单表';

-- ----------------------------
-- Records of O_REFUND_ORDER
-- ----------------------------

-- ----------------------------
-- Table structure for O_SHOP_CART
-- ----------------------------
DROP TABLE IF EXISTS `O_SHOP_CART`;
CREATE TABLE `O_SHOP_CART` (
  `SHOP_CART_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `CUSTOMER_ID` varchar(30) NOT NULL COMMENT '消费者主键ID',
  `SESSION_ID` char(32) DEFAULT NULL COMMENT '如果该用户退出,该Session_id对应的购物车中所有记录都将被删除',
  `GOODS_ID` varchar(30) NOT NULL COMMENT '商品ID',
  `GOODS_SN` varchar(60) DEFAULT NULL COMMENT '商品的唯一货号',
  `GOODS_NAME` varchar(50) NOT NULL COMMENT '商品名称',
  `CART_TYPE` tinyint(1) DEFAULT '0' COMMENT '购物车商品类型;0普通;1团够;2拍卖;3夺宝奇兵',
  `GOODS_ATTR` text COMMENT '商品属性,JSON形式',
  `GOODS_AMOUNT` int(11) DEFAULT NULL COMMENT '加入购物车商品数量',
  `MARKET_PRICE` int(11) DEFAULT NULL COMMENT '市场价(分)',
  `SHOP_PRICE` int(11) DEFAULT NULL COMMENT '本店价(分)',
  `REAL_BUY_PRICE` int(11) NOT NULL COMMENT '实际购买价格(分)',
  `IS_OPEN_SALE` tinyint(1) DEFAULT '0' COMMENT '是否开售 1是 0否',
  `PARENT_GOODS_ID` varchar(30) DEFAULT NULL COMMENT '该商品的父商品ID,没有该值为0,有的话那该商品就是该id的配件',
  `IS_GIFT` smallint(6) DEFAULT NULL COMMENT '是否赠品 0否;1其他(参与活动的活动ID等)',
  `CAN_HANDLE` tinyint(1) DEFAULT '0' COMMENT '能否处理 0可以 1不可以',
  `ADD_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '加入购物车时间',
  `MODIFIED_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`SHOP_CART_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='购物车表';

-- ----------------------------
-- Records of O_SHOP_CART
-- ----------------------------
INSERT INTO `O_SHOP_CART` VALUES ('13', '1598777623923', null, '1596677566', '159667756607', '酥脆薄饼300g 薄脆饼干独立小包装原味酱汁烧烤味海苔饼', '0', null, '3', '2800', '2600', '2345', '1', null, '0', '0', '2020-09-01 03:17:22', '2020-09-01 03:17:22');
INSERT INTO `O_SHOP_CART` VALUES ('15', '1598777623923', null, '1598323329', 'aaYHQv0ckgCr', '格力KFR-35GW/(35592)FNhAa-A1(WIFI)', '0', null, '2', '2800', '2600', '2345', '1', null, '0', '0', '2020-09-01 03:37:12', '2020-09-01 03:37:12');

-- ----------------------------
-- Table structure for SYS_CITY
-- ----------------------------
DROP TABLE IF EXISTS `SYS_CITY`;
CREATE TABLE `SYS_CITY` (
  `CITY_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `CITY_CODE` varchar(40) DEFAULT NULL COMMENT '城市code',
  `CITY_NAME` varchar(30) DEFAULT NULL COMMENT '城市名',
  PRIMARY KEY (`CITY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of SYS_CITY
-- ----------------------------
INSERT INTO `SYS_CITY` VALUES ('1', '001', '北京');
INSERT INTO `SYS_CITY` VALUES ('2', '002', '广州');
INSERT INTO `SYS_CITY` VALUES ('3', '003', '上海');
INSERT INTO `SYS_CITY` VALUES ('4', '004', '深圳');
INSERT INTO `SYS_CITY` VALUES ('5', '005', '福州');
INSERT INTO `SYS_CITY` VALUES ('6', '006', '厦门');
INSERT INTO `SYS_CITY` VALUES ('7', '007', '泉州');
INSERT INTO `SYS_CITY` VALUES ('8', '008', '成都');
INSERT INTO `SYS_CITY` VALUES ('9', '009', '漳州');
INSERT INTO `SYS_CITY` VALUES ('10', '010', '南昌');
INSERT INTO `SYS_CITY` VALUES ('11', '011', '济南');
INSERT INTO `SYS_CITY` VALUES ('12', '012', '青岛');
INSERT INTO `SYS_CITY` VALUES ('13', '013', '烟台');
INSERT INTO `SYS_CITY` VALUES ('14', '014', '淄博');
INSERT INTO `SYS_CITY` VALUES ('15', '015', '日照');
INSERT INTO `SYS_CITY` VALUES ('16', '016', '三明');
INSERT INTO `SYS_CITY` VALUES ('17', '018', '贵阳');

-- ----------------------------
-- Table structure for SYS_DICT
-- ----------------------------
DROP TABLE IF EXISTS `SYS_DICT`;
CREATE TABLE `SYS_DICT` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `VALUE` varchar(150) NOT NULL COMMENT '字典值',
  `KEYWORD` varchar(150) NOT NULL COMMENT '类型（KEY)',
  `UP_ID` int(11) DEFAULT NULL COMMENT '上级ID根节点默认-1',
  `DIC_TYPE` varchar(50) NOT NULL COMMENT '字典类型',
  `STATUS` int(11) DEFAULT '1' COMMENT '状态 0无效1有效',
  `OPERATOR_ID` varchar(40) DEFAULT NULL COMMENT '操作人ID',
  `OPERATOR_NAME` varchar(40) DEFAULT NULL COMMENT '操作人名称',
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `KEY_TYPE` (`KEYWORD`,`DIC_TYPE`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of SYS_DICT
-- ----------------------------

-- ----------------------------
-- Table structure for SYS_MENU
-- ----------------------------
DROP TABLE IF EXISTS `SYS_MENU`;
CREATE TABLE `SYS_MENU` (
  `MENU_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `PARENT_ID` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `MENU_NAME` varchar(50) NOT NULL COMMENT '菜单名称',
  `URL` varchar(50) DEFAULT NULL COMMENT '菜单URL',
  `PERMS` varchar(150) DEFAULT NULL COMMENT '授权(多个用逗号分隔)',
  `TYPE` int(11) DEFAULT NULL COMMENT '类型 0：目录 1：菜单 2：按钮',
  `ICON` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `ORDER_NUM` int(11) DEFAULT NULL COMMENT '排序',
  `REMARK` varchar(150) DEFAULT NULL COMMENT '菜单备注',
  `ROUTER_NAME` varchar(50) DEFAULT NULL COMMENT '路由名称',
  `ROUTER_PATH` varchar(80) DEFAULT NULL COMMENT '路由路径',
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of SYS_MENU
-- ----------------------------
INSERT INTO `SYS_MENU` VALUES ('1', '-1', '资讯管理', null, 'all', '0', 'menu-article,&#xe616;', '0', '资讯管理[一级目录]', null, null);
INSERT INTO `SYS_MENU` VALUES ('2', '-1', '图片管理', null, 'all', '0', 'menu-picture,&#xe613;', '1', '图片管理[一级目录]', null, null);
INSERT INTO `SYS_MENU` VALUES ('3', '-1', '商品管理', null, 'all', '0', 'menu-product,&#xe620;', '2', '商品管理[一级目录]', null, null);
INSERT INTO `SYS_MENU` VALUES ('4', '-1', '订单管理', null, 'all', '0', 'menu-order,&#xe620;', '3', '订单管理[一级目录]', null, null);
INSERT INTO `SYS_MENU` VALUES ('5', '-1', '评论管理', null, 'all', '0', 'menu-comments,&#xe622;', '4', '评论管理[一级目录]', null, null);
INSERT INTO `SYS_MENU` VALUES ('6', '-1', '会员管理', null, 'all', '0', 'menu-member,&#xe60d;', '5', '会员管理[一级目录]', null, null);
INSERT INTO `SYS_MENU` VALUES ('7', '-1', '管理员管理', null, 'all', '0', 'menu-admin,&#xe62d;', '6', '管理员管理[一级目录]', null, null);
INSERT INTO `SYS_MENU` VALUES ('8', '-1', '系统管理', null, 'all', '0', 'menu-system,&#xe62e;', '7', '系统管理[一级目录]', null, null);
INSERT INTO `SYS_MENU` VALUES ('9', '-1', '系统统计', null, 'all', '0', 'menu-tongji,&#xe61a;', '8', '系统统计[一级目录]', null, null);
INSERT INTO `SYS_MENU` VALUES ('10', '1', '资讯管理', 'article-list.html', 'all', '1', null, '0', '资讯管理[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('11', '2', '图片管理', 'picture-list.html', 'all', '1', null, '0', '图片管理[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('12', '3', '品牌管理', 'product-brand.html', 'all', '1', null, '0', '品牌管理[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('13', '3', '分类管理', 'product-category.html', 'all', '1', null, '1', '商品分类管理[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('14', '3', '商品管理', 'product-list.html', 'all', '1', null, '2', '商品管理[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('15', '4', '订单管理', 'order-list.html', 'all', '1', null, '0', '订单管理[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('16', '5', '评论列表', 'comment-list.html', 'all', '1', null, '1', '评论列表[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('17', '5', '意见反馈', 'feedback-list.html', 'all', '1', null, '1', '意见反馈[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('18', '6', '会员列表', 'member-list.html', 'all', '1', null, '0', '会员列表[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('19', '6', '删除的会员', 'member-del.html', 'all', '1', null, '1', '删除的会员[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('20', '6', '会员等级', 'member-level.html', 'all', '1', null, '2', '会员等级管理[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('21', '6', '登录日志', 'member-record-login.html', 'all', '1', null, '3', '登录日志管理[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('22', '6', '积分记录', 'member-scoreoperation.html', 'all', '1', null, '4', '会员积分管理[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('23', '6', '浏览记录', 'member-record-browse.html', 'all', '1', null, '5', '浏览记录[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('24', '6', '下载记录', 'member-record-download.html', 'all', '1', null, '6', '下载记录[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('25', '6', '分享记录', 'member-record-share.html', 'all', '1', null, '7', '分享记录[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('26', '7', '角色管理', 'admin-role.html', 'all', '1', null, '0', '角色管理[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('27', '7', '菜单管理', 'admin-menu.html', 'all', '1', null, '1', '菜单管理[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('28', '7', '管理员列表', 'admin-list.html', 'all', '1', null, '2', '管理员列表[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('29', '9', '折线图', 'charts-1.html', 'all', '1', null, '0', '折线图[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('30', '9', '时间轴折线图', 'charts-2.html', 'all', '1', null, '1', '时间轴折线图[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('31', '9', '区域图', 'charts-3.html', 'all', '1', null, '2', '区域图[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('32', '9', '柱状图', 'charts-4.html', 'all', '1', null, '3', '柱状图[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('33', '9', '饼状图', 'charts-5.html', 'all', '1', null, '4', '饼状图[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('34', '9', '3D柱状图', 'charts-6.html', 'all', '1', null, '5', '3D柱状图[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('35', '9', '3D饼状图', 'charts-7.html', 'all', '1', null, '6', '3D饼状图[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('36', '8', '系统设置', 'system-base.html', 'all', '1', null, '0', '系统设置[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('37', '8', '栏目管理', 'system-category.html', 'all', '1', null, '1', '栏目管理[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('38', '8', '数据字典', 'system-data.html', 'all', '1', null, '2', '数据字典[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('39', '8', '屏蔽词', 'system-shielding.html', 'all', '1', null, '3', '屏蔽词[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('40', '8', '系统日志', 'system-log.html', 'all', '1', null, '4', '系统日志[菜单]', null, null);
INSERT INTO `SYS_MENU` VALUES ('41', '10', '查询列表', null, 'article:query:queryAll', '2', null, '0', '资讯管理-查询所有资讯列表集合', null, null);
INSERT INTO `SYS_MENU` VALUES ('42', '10', '新增', null, 'article:add:addArticle', '2', null, '1', '资讯管理-新增资讯信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('43', '10', '删除', null, 'article:delete:deleteById', '2', null, '2', '资讯管理-删除资讯信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('44', '10', '修改', null, 'article:update:updateById', '2', null, '3', '资讯管理-修改资讯信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('45', '10', '查询详情', null, 'article:query:queryDetailById', '2', null, '4', '资讯管理-查询资讯详情', null, null);
INSERT INTO `SYS_MENU` VALUES ('46', '11', '查询列表', null, 'picture:query:queryAll', '2', null, '0', '图片管理-查询所有图片列表集合', null, null);
INSERT INTO `SYS_MENU` VALUES ('47', '11', '新增', null, 'picture:add:addArticle', '2', null, '1', '图片管理-新增图片信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('48', '11', '删除', null, 'picture:delete:deleteById', '2', null, '2', '图片管理-删除图片信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('49', '11', '修改', null, 'picture:update:updateById', '2', null, '3', '图片管理-修改图片信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('50', '11', '查询详情', null, 'picture:query:queryDetailById', '2', null, '4', '图片管理-查询图片详情', null, null);
INSERT INTO `SYS_MENU` VALUES ('51', '12', '查询列表', null, 'brand:query:queryAll', '2', null, '0', '品牌管理-查询所有品牌列表集合', null, null);
INSERT INTO `SYS_MENU` VALUES ('52', '12', '新增', null, 'brand:add:addArticle', '2', null, '1', '品牌管理-新增品牌信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('53', '12', '删除', null, 'brand:delete:deleteById', '2', null, '2', '品牌管理-删除品牌信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('54', '12', '修改', null, 'brand:update:updateById', '2', null, '3', '品牌管理-修改品牌信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('55', '12', '查询详情', null, 'brand:query:queryDetailById', '2', null, '4', '品牌管理-查询品牌详情', null, null);
INSERT INTO `SYS_MENU` VALUES ('56', '14', '查询列表', null, 'product:query:queryAll', '2', null, '0', '商品管理-查询所有商品列表集合', null, null);
INSERT INTO `SYS_MENU` VALUES ('57', '14', '新增', null, 'product:add:addArticle', '2', null, '1', '商品管理-新增商品信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('58', '14', '删除', null, 'product:delete:deleteById', '2', null, '2', '商品管理-删除商品信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('59', '14', '修改', null, 'product:update:updateById', '2', null, '3', '商品管理-修改商品信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('60', '14', '查询详情', null, 'product:query:queryDetailById', '2', null, '4', '商品管理-查询商品详情', null, null);
INSERT INTO `SYS_MENU` VALUES ('61', '13', '查询列表', null, 'category:query:queryAll', '2', null, '0', '商品分类管理-查询所有商品分类列表集合', null, null);
INSERT INTO `SYS_MENU` VALUES ('64', '13', '修改', null, 'category:update:updateById', '2', null, '3', '商品分类管理-修改商品分类信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('65', '13', '查询详情', null, 'category:query:queryDetailById', '2', null, '4', '商品分类管理-查询商品分类详情', null, null);
INSERT INTO `SYS_MENU` VALUES ('66', '15', '查询列表', null, 'order:query:queryAll', '2', null, '0', '订单管理-查询所有列表集合', null, null);
INSERT INTO `SYS_MENU` VALUES ('67', '15', '查询详情', null, 'order:query:queryDetailById', '2', null, '1', '订单管理-查询订单详情', null, null);
INSERT INTO `SYS_MENU` VALUES ('68', '18', '查询列表', null, 'member:query:queryAll', '2', null, '0', '会员列表-查询所有会员列表集合', null, null);
INSERT INTO `SYS_MENU` VALUES ('69', '18', '新增', null, 'member:add:addArticle', '2', null, '1', '会员列表-新增会员信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('70', '18', '删除', null, 'member:delete:deleteById', '2', null, '2', '会员列表-删除会员信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('71', '18', '修改', null, 'member:update:updateById', '2', null, '3', '会员列表-修改会员信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('72', '18', '查询详情', null, 'member:query:queryDetailById', '2', null, '4', '会员列表-查询会员详情', null, null);
INSERT INTO `SYS_MENU` VALUES ('73', '16', '查询列表', null, 'comment:query:queryAll', '2', null, '0', '评论列表-查询所有评论列表集合', null, null);
INSERT INTO `SYS_MENU` VALUES ('74', '16', '修改', null, 'comment:update:updateById', '2', null, '3', '评论列表-修评论信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('75', '16', '查询详情', null, 'comment:query:queryDetailById', '2', null, '4', '评论列表-查询评论详情', null, null);
INSERT INTO `SYS_MENU` VALUES ('76', '17', '查询列表', null, 'feedback:query:queryAll', '2', null, '0', '意见反馈-查询所有列表集合', null, null);
INSERT INTO `SYS_MENU` VALUES ('77', '17', '修改', null, 'feedback:update:updateById', '2', null, '3', '意见反馈-修改意见反馈信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('78', '17', '查询详情', null, 'feedback:query:queryDetailById', '2', null, '4', '意见反馈-查询意见反馈详情', null, null);
INSERT INTO `SYS_MENU` VALUES ('79', '19', '查询列表', null, 'delmember:query:queryAll', '2', null, '0', '删除的会员列表-查询所有会员列表集合', null, null);
INSERT INTO `SYS_MENU` VALUES ('80', '19', '彻底删除', null, 'delmember:delete:deleteById', '2', null, '2', '删除的会员列表-删除', null, null);
INSERT INTO `SYS_MENU` VALUES ('81', '19', '还原', null, 'delmember:update:updateById', '2', null, '3', '删除的会员列表-还原', null, null);
INSERT INTO `SYS_MENU` VALUES ('82', '19', '查询详情', null, 'delmember:query:queryDetailById', '2', null, '4', '删除的会员列表-查询会员详情', null, null);
INSERT INTO `SYS_MENU` VALUES ('83', '20', '查询列表', null, 'level:query:queryAll', '2', null, '0', '会员等级-查询所有会员等级列表集合', null, null);
INSERT INTO `SYS_MENU` VALUES ('84', '20', '新增', null, 'level:add:addArticle', '2', null, '1', '会员等级-新增会员等级信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('85', '20', '删除', null, 'level:delete:deleteById', '2', null, '2', '会员等级-删除会员等级信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('86', '20', '修改', null, 'level:update:updateById', '2', null, '3', '会员等级-修改会员等级信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('87', '20', '查询详情', null, 'level:query:queryDetailById', '2', null, '4', '会员等级-查询会员等级详情', null, null);
INSERT INTO `SYS_MENU` VALUES ('88', '21', '查询列表', null, 'loginlog:query:queryAll', '2', null, '0', '登录日志-查询所有登录日志列表集合', null, null);
INSERT INTO `SYS_MENU` VALUES ('89', '21', '查询详情', null, 'loginlog:query:queryDetailById', '2', null, '4', '登录日志-查询登录日志详情', null, null);
INSERT INTO `SYS_MENU` VALUES ('90', '26', '查询列表', null, 'role:query:queryAll', '2', null, '0', '角色管理-查询所有角色列表集合', null, null);
INSERT INTO `SYS_MENU` VALUES ('91', '26', '新增', null, 'role:add:addArticle', '2', null, '1', '角色管理-新增角色信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('92', '26', '删除', null, 'role:delete:deleteById', '2', null, '2', '角色管理-删除角色信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('93', '26', '修改', null, 'role:update:updateById', '2', null, '3', '角色管理-修改角色信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('94', '26', '查询详情', null, 'role:query:queryDetailById', '2', null, '4', '角色管理-查询角色详情', null, null);
INSERT INTO `SYS_MENU` VALUES ('95', '27', '查询列表', null, 'menu:query:queryAll', '2', null, '0', '菜单管理-查询所有菜单列表集合', null, null);
INSERT INTO `SYS_MENU` VALUES ('96', '27', '新增', null, 'menu:add:addArticle', '2', null, '1', '菜单管理-新增菜单信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('97', '27', '删除', null, 'menu:delete:deleteById', '2', null, '2', '菜单管理-删除菜单信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('98', '27', '修改', null, 'menu:update:updateById', '2', null, '3', '菜单管理-修改菜单信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('99', '27', '查询详情', null, 'menu:query:queryDetailById', '2', null, '4', '菜单管理-查询菜单详情', null, null);
INSERT INTO `SYS_MENU` VALUES ('100', '28', '查询列表', null, 'account:query:queryAll', '2', null, '0', '账号管理-查询所有账号列表集合', null, null);
INSERT INTO `SYS_MENU` VALUES ('101', '28', '新增', null, 'account:add:addArticle', '2', null, '1', '账号管理-新增账号信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('102', '28', '删除', null, 'account:delete:deleteById', '2', null, '2', '账号管理-删除账号信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('103', '28', '修改', null, 'account:update:updateById', '2', null, '3', '账号管理-修改账号信息', null, null);
INSERT INTO `SYS_MENU` VALUES ('104', '28', '查询详情', null, 'account:query:queryDetailById', '2', null, '4', '账号管理-查询账号详情', null, null);

-- ----------------------------
-- Table structure for SYS_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `SYS_ROLE`;
CREATE TABLE `SYS_ROLE` (
  `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `REMARK` varchar(100) DEFAULT NULL COMMENT '备注',
  `DEPT_NAME` varchar(30) DEFAULT NULL COMMENT '所属部门',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_BY` varchar(20) NOT NULL COMMENT '创建者',
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `UPDATE_BY` varchar(20) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of SYS_ROLE
-- ----------------------------
INSERT INTO `SYS_ROLE` VALUES ('1', '超级管理员', '超级管理员', '总经办', '2020-08-22 14:20:11', 'system', '2020-08-22 14:20:11', 'system');
INSERT INTO `SYS_ROLE` VALUES ('2', '总监', '总监', '总监', '2020-08-27 18:25:38', 'system', '2020-08-27 10:25:38', 'system');
INSERT INTO `SYS_ROLE` VALUES ('4', '栏目主辑', '栏目主辑', '编辑部', '2020-08-22 15:04:20', 'system', '2020-08-22 15:04:20', 'system');
INSERT INTO `SYS_ROLE` VALUES ('5', '栏目编辑', '栏目编辑', '编辑部', '2020-08-22 15:04:20', 'system', '2020-08-22 15:04:20', 'system');
INSERT INTO `SYS_ROLE` VALUES ('6', '普通管理员', '普通管理员', '总经办', '2020-08-22 15:06:01', 'system', '2020-08-22 15:06:01', 'system');
INSERT INTO `SYS_ROLE` VALUES ('7', '总编', '总编', '编辑部', '2020-08-22 10:00:53', 'system', '2020-08-22 10:00:53', 'system');

-- ----------------------------
-- Table structure for SYS_ROLE_MENU
-- ----------------------------
DROP TABLE IF EXISTS `SYS_ROLE_MENU`;
CREATE TABLE `SYS_ROLE_MENU` (
  `RM_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `MENU_ID` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`RM_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=334 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of SYS_ROLE_MENU
-- ----------------------------
INSERT INTO `SYS_ROLE_MENU` VALUES ('1', '6', '1');
INSERT INTO `SYS_ROLE_MENU` VALUES ('2', '6', '2');
INSERT INTO `SYS_ROLE_MENU` VALUES ('3', '6', '3');
INSERT INTO `SYS_ROLE_MENU` VALUES ('4', '6', '4');
INSERT INTO `SYS_ROLE_MENU` VALUES ('5', '6', '5');
INSERT INTO `SYS_ROLE_MENU` VALUES ('6', '6', '6');
INSERT INTO `SYS_ROLE_MENU` VALUES ('7', '6', '7');
INSERT INTO `SYS_ROLE_MENU` VALUES ('8', '6', '8');
INSERT INTO `SYS_ROLE_MENU` VALUES ('9', '6', '9');
INSERT INTO `SYS_ROLE_MENU` VALUES ('10', '6', '10');
INSERT INTO `SYS_ROLE_MENU` VALUES ('11', '6', '11');
INSERT INTO `SYS_ROLE_MENU` VALUES ('12', '6', '12');
INSERT INTO `SYS_ROLE_MENU` VALUES ('13', '6', '13');
INSERT INTO `SYS_ROLE_MENU` VALUES ('14', '6', '14');
INSERT INTO `SYS_ROLE_MENU` VALUES ('15', '6', '15');
INSERT INTO `SYS_ROLE_MENU` VALUES ('16', '6', '16');
INSERT INTO `SYS_ROLE_MENU` VALUES ('17', '6', '17');
INSERT INTO `SYS_ROLE_MENU` VALUES ('18', '6', '18');
INSERT INTO `SYS_ROLE_MENU` VALUES ('19', '6', '19');
INSERT INTO `SYS_ROLE_MENU` VALUES ('20', '6', '20');
INSERT INTO `SYS_ROLE_MENU` VALUES ('21', '6', '21');
INSERT INTO `SYS_ROLE_MENU` VALUES ('22', '6', '22');
INSERT INTO `SYS_ROLE_MENU` VALUES ('23', '6', '23');
INSERT INTO `SYS_ROLE_MENU` VALUES ('24', '6', '24');
INSERT INTO `SYS_ROLE_MENU` VALUES ('25', '6', '25');
INSERT INTO `SYS_ROLE_MENU` VALUES ('26', '6', '26');
INSERT INTO `SYS_ROLE_MENU` VALUES ('27', '6', '27');
INSERT INTO `SYS_ROLE_MENU` VALUES ('28', '6', '28');
INSERT INTO `SYS_ROLE_MENU` VALUES ('29', '6', '36');
INSERT INTO `SYS_ROLE_MENU` VALUES ('30', '6', '37');
INSERT INTO `SYS_ROLE_MENU` VALUES ('31', '6', '38');
INSERT INTO `SYS_ROLE_MENU` VALUES ('32', '6', '39');
INSERT INTO `SYS_ROLE_MENU` VALUES ('33', '6', '40');
INSERT INTO `SYS_ROLE_MENU` VALUES ('34', '6', '29');
INSERT INTO `SYS_ROLE_MENU` VALUES ('35', '6', '30');
INSERT INTO `SYS_ROLE_MENU` VALUES ('36', '6', '31');
INSERT INTO `SYS_ROLE_MENU` VALUES ('37', '6', '32');
INSERT INTO `SYS_ROLE_MENU` VALUES ('38', '6', '33');
INSERT INTO `SYS_ROLE_MENU` VALUES ('39', '6', '34');
INSERT INTO `SYS_ROLE_MENU` VALUES ('40', '6', '35');
INSERT INTO `SYS_ROLE_MENU` VALUES ('41', '6', '41');
INSERT INTO `SYS_ROLE_MENU` VALUES ('42', '6', '42');
INSERT INTO `SYS_ROLE_MENU` VALUES ('43', '6', '43');
INSERT INTO `SYS_ROLE_MENU` VALUES ('44', '6', '44');
INSERT INTO `SYS_ROLE_MENU` VALUES ('45', '6', '45');
INSERT INTO `SYS_ROLE_MENU` VALUES ('46', '6', '46');
INSERT INTO `SYS_ROLE_MENU` VALUES ('47', '6', '47');
INSERT INTO `SYS_ROLE_MENU` VALUES ('48', '6', '48');
INSERT INTO `SYS_ROLE_MENU` VALUES ('49', '6', '49');
INSERT INTO `SYS_ROLE_MENU` VALUES ('50', '6', '50');
INSERT INTO `SYS_ROLE_MENU` VALUES ('51', '6', '51');
INSERT INTO `SYS_ROLE_MENU` VALUES ('52', '6', '52');
INSERT INTO `SYS_ROLE_MENU` VALUES ('53', '6', '53');
INSERT INTO `SYS_ROLE_MENU` VALUES ('54', '6', '54');
INSERT INTO `SYS_ROLE_MENU` VALUES ('55', '6', '55');
INSERT INTO `SYS_ROLE_MENU` VALUES ('56', '6', '61');
INSERT INTO `SYS_ROLE_MENU` VALUES ('57', '6', '64');
INSERT INTO `SYS_ROLE_MENU` VALUES ('58', '6', '65');
INSERT INTO `SYS_ROLE_MENU` VALUES ('59', '6', '56');
INSERT INTO `SYS_ROLE_MENU` VALUES ('60', '6', '57');
INSERT INTO `SYS_ROLE_MENU` VALUES ('61', '6', '58');
INSERT INTO `SYS_ROLE_MENU` VALUES ('62', '6', '59');
INSERT INTO `SYS_ROLE_MENU` VALUES ('63', '6', '60');
INSERT INTO `SYS_ROLE_MENU` VALUES ('64', '6', '66');
INSERT INTO `SYS_ROLE_MENU` VALUES ('65', '6', '67');
INSERT INTO `SYS_ROLE_MENU` VALUES ('66', '6', '73');
INSERT INTO `SYS_ROLE_MENU` VALUES ('67', '6', '74');
INSERT INTO `SYS_ROLE_MENU` VALUES ('68', '6', '75');
INSERT INTO `SYS_ROLE_MENU` VALUES ('69', '6', '76');
INSERT INTO `SYS_ROLE_MENU` VALUES ('70', '6', '77');
INSERT INTO `SYS_ROLE_MENU` VALUES ('71', '6', '78');
INSERT INTO `SYS_ROLE_MENU` VALUES ('72', '6', '68');
INSERT INTO `SYS_ROLE_MENU` VALUES ('73', '6', '69');
INSERT INTO `SYS_ROLE_MENU` VALUES ('74', '6', '70');
INSERT INTO `SYS_ROLE_MENU` VALUES ('75', '6', '71');
INSERT INTO `SYS_ROLE_MENU` VALUES ('76', '6', '72');
INSERT INTO `SYS_ROLE_MENU` VALUES ('77', '6', '79');
INSERT INTO `SYS_ROLE_MENU` VALUES ('78', '6', '80');
INSERT INTO `SYS_ROLE_MENU` VALUES ('79', '6', '81');
INSERT INTO `SYS_ROLE_MENU` VALUES ('80', '6', '82');
INSERT INTO `SYS_ROLE_MENU` VALUES ('81', '6', '83');
INSERT INTO `SYS_ROLE_MENU` VALUES ('82', '6', '84');
INSERT INTO `SYS_ROLE_MENU` VALUES ('83', '6', '85');
INSERT INTO `SYS_ROLE_MENU` VALUES ('84', '6', '86');
INSERT INTO `SYS_ROLE_MENU` VALUES ('85', '6', '87');
INSERT INTO `SYS_ROLE_MENU` VALUES ('86', '6', '88');
INSERT INTO `SYS_ROLE_MENU` VALUES ('87', '6', '89');
INSERT INTO `SYS_ROLE_MENU` VALUES ('88', '6', '90');
INSERT INTO `SYS_ROLE_MENU` VALUES ('89', '6', '91');
INSERT INTO `SYS_ROLE_MENU` VALUES ('90', '6', '92');
INSERT INTO `SYS_ROLE_MENU` VALUES ('91', '6', '93');
INSERT INTO `SYS_ROLE_MENU` VALUES ('92', '6', '94');
INSERT INTO `SYS_ROLE_MENU` VALUES ('93', '6', '95');
INSERT INTO `SYS_ROLE_MENU` VALUES ('94', '6', '96');
INSERT INTO `SYS_ROLE_MENU` VALUES ('95', '6', '97');
INSERT INTO `SYS_ROLE_MENU` VALUES ('96', '6', '98');
INSERT INTO `SYS_ROLE_MENU` VALUES ('97', '6', '99');
INSERT INTO `SYS_ROLE_MENU` VALUES ('98', '6', '100');
INSERT INTO `SYS_ROLE_MENU` VALUES ('99', '6', '101');
INSERT INTO `SYS_ROLE_MENU` VALUES ('100', '6', '102');
INSERT INTO `SYS_ROLE_MENU` VALUES ('101', '6', '103');
INSERT INTO `SYS_ROLE_MENU` VALUES ('102', '6', '104');
INSERT INTO `SYS_ROLE_MENU` VALUES ('103', '1', '1');
INSERT INTO `SYS_ROLE_MENU` VALUES ('104', '1', '2');
INSERT INTO `SYS_ROLE_MENU` VALUES ('105', '1', '3');
INSERT INTO `SYS_ROLE_MENU` VALUES ('106', '1', '4');
INSERT INTO `SYS_ROLE_MENU` VALUES ('107', '1', '5');
INSERT INTO `SYS_ROLE_MENU` VALUES ('108', '1', '6');
INSERT INTO `SYS_ROLE_MENU` VALUES ('109', '1', '7');
INSERT INTO `SYS_ROLE_MENU` VALUES ('110', '1', '8');
INSERT INTO `SYS_ROLE_MENU` VALUES ('111', '1', '9');
INSERT INTO `SYS_ROLE_MENU` VALUES ('112', '1', '10');
INSERT INTO `SYS_ROLE_MENU` VALUES ('113', '1', '11');
INSERT INTO `SYS_ROLE_MENU` VALUES ('114', '1', '12');
INSERT INTO `SYS_ROLE_MENU` VALUES ('115', '1', '13');
INSERT INTO `SYS_ROLE_MENU` VALUES ('116', '1', '14');
INSERT INTO `SYS_ROLE_MENU` VALUES ('117', '1', '15');
INSERT INTO `SYS_ROLE_MENU` VALUES ('118', '1', '16');
INSERT INTO `SYS_ROLE_MENU` VALUES ('119', '1', '17');
INSERT INTO `SYS_ROLE_MENU` VALUES ('120', '1', '18');
INSERT INTO `SYS_ROLE_MENU` VALUES ('121', '1', '19');
INSERT INTO `SYS_ROLE_MENU` VALUES ('122', '1', '20');
INSERT INTO `SYS_ROLE_MENU` VALUES ('123', '1', '21');
INSERT INTO `SYS_ROLE_MENU` VALUES ('124', '1', '22');
INSERT INTO `SYS_ROLE_MENU` VALUES ('125', '1', '23');
INSERT INTO `SYS_ROLE_MENU` VALUES ('126', '1', '24');
INSERT INTO `SYS_ROLE_MENU` VALUES ('127', '1', '25');
INSERT INTO `SYS_ROLE_MENU` VALUES ('128', '1', '26');
INSERT INTO `SYS_ROLE_MENU` VALUES ('129', '1', '27');
INSERT INTO `SYS_ROLE_MENU` VALUES ('130', '1', '28');
INSERT INTO `SYS_ROLE_MENU` VALUES ('131', '1', '36');
INSERT INTO `SYS_ROLE_MENU` VALUES ('132', '1', '37');
INSERT INTO `SYS_ROLE_MENU` VALUES ('133', '1', '38');
INSERT INTO `SYS_ROLE_MENU` VALUES ('134', '1', '39');
INSERT INTO `SYS_ROLE_MENU` VALUES ('135', '1', '40');
INSERT INTO `SYS_ROLE_MENU` VALUES ('136', '1', '29');
INSERT INTO `SYS_ROLE_MENU` VALUES ('137', '1', '30');
INSERT INTO `SYS_ROLE_MENU` VALUES ('138', '1', '31');
INSERT INTO `SYS_ROLE_MENU` VALUES ('139', '1', '32');
INSERT INTO `SYS_ROLE_MENU` VALUES ('140', '1', '33');
INSERT INTO `SYS_ROLE_MENU` VALUES ('141', '1', '34');
INSERT INTO `SYS_ROLE_MENU` VALUES ('142', '1', '35');
INSERT INTO `SYS_ROLE_MENU` VALUES ('143', '1', '41');
INSERT INTO `SYS_ROLE_MENU` VALUES ('144', '1', '42');
INSERT INTO `SYS_ROLE_MENU` VALUES ('145', '1', '43');
INSERT INTO `SYS_ROLE_MENU` VALUES ('146', '1', '44');
INSERT INTO `SYS_ROLE_MENU` VALUES ('147', '1', '45');
INSERT INTO `SYS_ROLE_MENU` VALUES ('148', '1', '46');
INSERT INTO `SYS_ROLE_MENU` VALUES ('149', '1', '47');
INSERT INTO `SYS_ROLE_MENU` VALUES ('150', '1', '48');
INSERT INTO `SYS_ROLE_MENU` VALUES ('151', '1', '49');
INSERT INTO `SYS_ROLE_MENU` VALUES ('152', '1', '50');
INSERT INTO `SYS_ROLE_MENU` VALUES ('153', '1', '51');
INSERT INTO `SYS_ROLE_MENU` VALUES ('154', '1', '52');
INSERT INTO `SYS_ROLE_MENU` VALUES ('155', '1', '53');
INSERT INTO `SYS_ROLE_MENU` VALUES ('156', '1', '54');
INSERT INTO `SYS_ROLE_MENU` VALUES ('157', '1', '55');
INSERT INTO `SYS_ROLE_MENU` VALUES ('158', '1', '61');
INSERT INTO `SYS_ROLE_MENU` VALUES ('159', '1', '64');
INSERT INTO `SYS_ROLE_MENU` VALUES ('160', '1', '65');
INSERT INTO `SYS_ROLE_MENU` VALUES ('161', '1', '56');
INSERT INTO `SYS_ROLE_MENU` VALUES ('162', '1', '57');
INSERT INTO `SYS_ROLE_MENU` VALUES ('163', '1', '58');
INSERT INTO `SYS_ROLE_MENU` VALUES ('164', '1', '59');
INSERT INTO `SYS_ROLE_MENU` VALUES ('165', '1', '60');
INSERT INTO `SYS_ROLE_MENU` VALUES ('166', '1', '66');
INSERT INTO `SYS_ROLE_MENU` VALUES ('167', '1', '67');
INSERT INTO `SYS_ROLE_MENU` VALUES ('168', '1', '73');
INSERT INTO `SYS_ROLE_MENU` VALUES ('169', '1', '74');
INSERT INTO `SYS_ROLE_MENU` VALUES ('170', '1', '75');
INSERT INTO `SYS_ROLE_MENU` VALUES ('171', '1', '76');
INSERT INTO `SYS_ROLE_MENU` VALUES ('172', '1', '77');
INSERT INTO `SYS_ROLE_MENU` VALUES ('173', '1', '78');
INSERT INTO `SYS_ROLE_MENU` VALUES ('174', '1', '68');
INSERT INTO `SYS_ROLE_MENU` VALUES ('175', '1', '69');
INSERT INTO `SYS_ROLE_MENU` VALUES ('176', '1', '70');
INSERT INTO `SYS_ROLE_MENU` VALUES ('177', '1', '71');
INSERT INTO `SYS_ROLE_MENU` VALUES ('178', '1', '72');
INSERT INTO `SYS_ROLE_MENU` VALUES ('179', '1', '79');
INSERT INTO `SYS_ROLE_MENU` VALUES ('180', '1', '80');
INSERT INTO `SYS_ROLE_MENU` VALUES ('181', '1', '81');
INSERT INTO `SYS_ROLE_MENU` VALUES ('182', '1', '82');
INSERT INTO `SYS_ROLE_MENU` VALUES ('183', '1', '83');
INSERT INTO `SYS_ROLE_MENU` VALUES ('184', '1', '84');
INSERT INTO `SYS_ROLE_MENU` VALUES ('185', '1', '85');
INSERT INTO `SYS_ROLE_MENU` VALUES ('186', '1', '86');
INSERT INTO `SYS_ROLE_MENU` VALUES ('187', '1', '87');
INSERT INTO `SYS_ROLE_MENU` VALUES ('188', '1', '88');
INSERT INTO `SYS_ROLE_MENU` VALUES ('189', '1', '89');
INSERT INTO `SYS_ROLE_MENU` VALUES ('190', '1', '90');
INSERT INTO `SYS_ROLE_MENU` VALUES ('191', '1', '91');
INSERT INTO `SYS_ROLE_MENU` VALUES ('192', '1', '92');
INSERT INTO `SYS_ROLE_MENU` VALUES ('193', '1', '93');
INSERT INTO `SYS_ROLE_MENU` VALUES ('194', '1', '94');
INSERT INTO `SYS_ROLE_MENU` VALUES ('195', '1', '95');
INSERT INTO `SYS_ROLE_MENU` VALUES ('196', '1', '96');
INSERT INTO `SYS_ROLE_MENU` VALUES ('197', '1', '97');
INSERT INTO `SYS_ROLE_MENU` VALUES ('198', '1', '98');
INSERT INTO `SYS_ROLE_MENU` VALUES ('199', '1', '99');
INSERT INTO `SYS_ROLE_MENU` VALUES ('200', '1', '100');
INSERT INTO `SYS_ROLE_MENU` VALUES ('201', '1', '101');
INSERT INTO `SYS_ROLE_MENU` VALUES ('202', '1', '102');
INSERT INTO `SYS_ROLE_MENU` VALUES ('203', '1', '103');
INSERT INTO `SYS_ROLE_MENU` VALUES ('204', '1', '104');
INSERT INTO `SYS_ROLE_MENU` VALUES ('299', '2', '1');
INSERT INTO `SYS_ROLE_MENU` VALUES ('300', '2', '2');
INSERT INTO `SYS_ROLE_MENU` VALUES ('301', '2', '3');
INSERT INTO `SYS_ROLE_MENU` VALUES ('302', '2', '4');
INSERT INTO `SYS_ROLE_MENU` VALUES ('303', '2', '10');
INSERT INTO `SYS_ROLE_MENU` VALUES ('304', '2', '11');
INSERT INTO `SYS_ROLE_MENU` VALUES ('305', '2', '12');
INSERT INTO `SYS_ROLE_MENU` VALUES ('306', '2', '13');
INSERT INTO `SYS_ROLE_MENU` VALUES ('307', '2', '14');
INSERT INTO `SYS_ROLE_MENU` VALUES ('308', '2', '15');
INSERT INTO `SYS_ROLE_MENU` VALUES ('309', '2', '41');
INSERT INTO `SYS_ROLE_MENU` VALUES ('310', '2', '42');
INSERT INTO `SYS_ROLE_MENU` VALUES ('311', '2', '43');
INSERT INTO `SYS_ROLE_MENU` VALUES ('312', '2', '44');
INSERT INTO `SYS_ROLE_MENU` VALUES ('313', '2', '45');
INSERT INTO `SYS_ROLE_MENU` VALUES ('314', '2', '46');
INSERT INTO `SYS_ROLE_MENU` VALUES ('315', '2', '47');
INSERT INTO `SYS_ROLE_MENU` VALUES ('316', '2', '48');
INSERT INTO `SYS_ROLE_MENU` VALUES ('317', '2', '49');
INSERT INTO `SYS_ROLE_MENU` VALUES ('318', '2', '50');
INSERT INTO `SYS_ROLE_MENU` VALUES ('319', '2', '51');
INSERT INTO `SYS_ROLE_MENU` VALUES ('320', '2', '52');
INSERT INTO `SYS_ROLE_MENU` VALUES ('321', '2', '53');
INSERT INTO `SYS_ROLE_MENU` VALUES ('322', '2', '54');
INSERT INTO `SYS_ROLE_MENU` VALUES ('323', '2', '55');
INSERT INTO `SYS_ROLE_MENU` VALUES ('324', '2', '61');
INSERT INTO `SYS_ROLE_MENU` VALUES ('325', '2', '64');
INSERT INTO `SYS_ROLE_MENU` VALUES ('326', '2', '65');
INSERT INTO `SYS_ROLE_MENU` VALUES ('327', '2', '56');
INSERT INTO `SYS_ROLE_MENU` VALUES ('328', '2', '57');
INSERT INTO `SYS_ROLE_MENU` VALUES ('329', '2', '58');
INSERT INTO `SYS_ROLE_MENU` VALUES ('330', '2', '59');
INSERT INTO `SYS_ROLE_MENU` VALUES ('331', '2', '60');
INSERT INTO `SYS_ROLE_MENU` VALUES ('332', '2', '66');
INSERT INTO `SYS_ROLE_MENU` VALUES ('333', '2', '67');

-- ----------------------------
-- Table structure for SYS_USER
-- ----------------------------
DROP TABLE IF EXISTS `SYS_USER`;
CREATE TABLE `SYS_USER` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '后台用户主键ID',
  `USER_NAME` varchar(20) NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(16) DEFAULT NULL COMMENT '密码',
  `REAL_NAME` varchar(50) DEFAULT NULL COMMENT '用户真实姓名',
  `SALT` varchar(20) DEFAULT NULL COMMENT '加密盐',
  `EMAIL` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `MOBILE` varchar(25) DEFAULT NULL COMMENT '手机号',
  `STATUS` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态  0：禁用   1：正常',
  `DEPT_NAME` varchar(20) DEFAULT NULL COMMENT '所属部门',
  `REMARK` varchar(150) DEFAULT NULL COMMENT '账号备注',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_BY` varchar(20) NOT NULL COMMENT '创建者',
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `UPDATE_BY` varchar(20) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='后台管理系统用户表';

-- ----------------------------
-- Records of SYS_USER
-- ----------------------------
INSERT INTO `SYS_USER` VALUES ('1', 'zhaoy', 'zhaoy123', '燕子', 'zhaoy', '1332698394@qq.com', '18105910331', '1', '总经办', '超级管理员', '2020-08-25 09:39:10', 'admin', '2020-08-25 01:39:10', 'system');
INSERT INTO `SYS_USER` VALUES ('2', 'admin', 'admin123', '燕子001', 'admin', '1332698394@qq.com', '15858854990', '1', '总经办', '超级系统管理员', '2020-08-25 09:38:09', 'system', '2020-08-25 01:38:09', 'system');
INSERT INTO `SYS_USER` VALUES ('3', 'zjadmin', 'zjadmin', '总监管理员', 'zjadmin', '111@123.com', '15858854990', '1', '总经办', '总监管理员', '2020-08-25 09:30:06', 'system', '2020-08-25 01:30:06', 'system');
INSERT INTO `SYS_USER` VALUES ('4', 'test', 'test01', '测试', 'test', '123@163.com', '15158854990', '0', null, 'test测试管理员添加', '2020-08-27 19:01:42', 'system', '2020-08-27 19:01:42', 'system');
INSERT INTO `SYS_USER` VALUES ('7', 'test01', 'test01', '测试01', 'test01', '123@qq.com', '18158854991', '1', null, 'ceshiinsert', '2020-08-27 11:11:54', 'system', '2020-08-27 11:11:54', 'system');

-- ----------------------------
-- Table structure for SYS_USER_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `SYS_USER_ROLE`;
CREATE TABLE `SYS_USER_ROLE` (
  `UR_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `ROLE_ID` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`UR_ID`),
  KEY `IDX_USERID_ROLEID` (`USER_ID`,`ROLE_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of SYS_USER_ROLE
-- ----------------------------
INSERT INTO `SYS_USER_ROLE` VALUES ('14', '1', '6');
INSERT INTO `SYS_USER_ROLE` VALUES ('8', '2', '1');
INSERT INTO `SYS_USER_ROLE` VALUES ('7', '3', '2');
INSERT INTO `SYS_USER_ROLE` VALUES ('11', '4', '6');
INSERT INTO `SYS_USER_ROLE` VALUES ('13', '5', '5');
INSERT INTO `SYS_USER_ROLE` VALUES ('15', '7', '5');

-- ----------------------------
-- Table structure for W_GOODS
-- ----------------------------
DROP TABLE IF EXISTS `W_GOODS`;
CREATE TABLE `W_GOODS` (
  `WP_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
  `GOODS_ID` varchar(12) NOT NULL COMMENT '商品ID',
  `WH_ID` int(11) NOT NULL COMMENT '仓库ID',
  `CURRENT_CNT` int(11) DEFAULT '1' COMMENT '当前商品数量',
  `LOCK_CNT` int(11) DEFAULT '1' COMMENT '当前占用数量',
  `INTRANSIT_CNT` int(11) DEFAULT '0' COMMENT '在途数量',
  `AVERAGE_COST` int(11) DEFAULT '0' COMMENT '移动加权成本',
  `MODIFIED_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`WP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品库存表';

-- ----------------------------
-- Records of W_GOODS
-- ----------------------------

-- ----------------------------
-- Table structure for W_SHIP_INFO
-- ----------------------------
DROP TABLE IF EXISTS `W_SHIP_INFO`;
CREATE TABLE `W_SHIP_INFO` (
  `SHIP_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `SHIP_NAME` varchar(20) NOT NULL COMMENT '物流公司名称',
  `SHIP_CONTACT` varchar(20) DEFAULT NULL COMMENT '物流公司联系人',
  `TELPHONE` varchar(20) DEFAULT NULL COMMENT '物流公司联系电话',
  `PRICE` int(11) DEFAULT NULL COMMENT '配送价格（分）',
  `MODIFIED_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`SHIP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物流公司信息表';

-- ----------------------------
-- Records of W_SHIP_INFO
-- ----------------------------

-- ----------------------------
-- Table structure for W_WAREHOUSE_INFO
-- ----------------------------
DROP TABLE IF EXISTS `W_WAREHOUSE_INFO`;
CREATE TABLE `W_WAREHOUSE_INFO` (
  `WH_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '仓库ID',
  `WH_SN` char(5) DEFAULT NULL COMMENT '仓库编码',
  `WH_NAME` varchar(10) DEFAULT NULL COMMENT '仓库名称',
  `WH_PHONE` varchar(20) DEFAULT NULL COMMENT '仓库联系电话',
  `CONTACT` varchar(10) DEFAULT NULL COMMENT '仓库联系人',
  `PROVINCE` varchar(20) DEFAULT NULL COMMENT '省份',
  `CITY` varchar(20) DEFAULT NULL COMMENT '城市',
  `DISTRICT` varchar(20) DEFAULT NULL COMMENT '城市中的区域',
  `ADDRESS` varchar(50) DEFAULT NULL COMMENT '仓库地址',
  `WH_STATUS` tinyint(1) DEFAULT '1' COMMENT '仓库状态：0禁用，1启用',
  `MODIFIED_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`WH_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='仓库信息表';

-- ----------------------------
-- Records of W_WAREHOUSE_INFO
-- ----------------------------
