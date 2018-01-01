/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : ace

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2018-01-01 10:43:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单编号',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `p_menu_id` bigint(20) DEFAULT NULL COMMENT '父菜单id',
  `menu_order` int(11) DEFAULT '0' COMMENT '菜单排序',
  `menu_url` varchar(255) DEFAULT NULL COMMENT '菜单链接地址',
  `menu_icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `menu_type` varchar(100) NOT NULL DEFAULT 'console' COMMENT '菜单类型，哪部分的菜单。console:控制台',
  `menu_level` int(11) DEFAULT '1' COMMENT '菜单层级',
  `state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '记录状态：-1不用，0初始创建，1审核通过正常使用，2审核不通过',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注说明',
  `reason` varchar(500) DEFAULT NULL COMMENT '审核失败原因',
  PRIMARY KEY (`menu_id`),
  KEY `menu_index` (`menu_name`,`menu_type`) COMMENT '菜单基本索引'
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='菜单信息保存表';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '仪表面板', null, '0', 'aceChinaTemplate/index', 'fa-tachometer', 'console', '1', '1', null, null);
INSERT INTO `menu` VALUES ('2', 'UI &amp; 元素', null, '1', null, 'fa-desktop', 'console', '1', '1', null, null);
INSERT INTO `menu` VALUES ('3', '布局', '2', '0', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('4', '顶部菜单', '3', '0', null, 'fa-caret-right', 'console', '3', '1', null, null);
INSERT INTO `menu` VALUES ('5', '双菜单 1', '3', '1', null, 'fa-caret-right', 'console', '3', '1', null, null);
INSERT INTO `menu` VALUES ('6', '双菜单2', '3', '2', null, 'fa-caret-right', 'console', '3', '1', null, null);
INSERT INTO `menu` VALUES ('7', '默认手机版菜单', '3', '3', null, 'fa-caret-right', 'console', '3', '1', null, null);
INSERT INTO `menu` VALUES ('8', '手机版菜单2', '3', '4', null, 'fa-caret-right', 'console', '3', '1', null, null);
INSERT INTO `menu` VALUES ('9', '手机版菜单3', '3', '5', null, 'fa-caret-right', 'console', '3', '1', null, null);
INSERT INTO `menu` VALUES ('10', '排版', '2', '1', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('11', '元素', '2', '2', null, 'fa-caret-right', 'console', '2', '1', '', null);
INSERT INTO `menu` VALUES ('12', '按钮 &amp; 图标', '2', '3', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('13', '滚动内容', '2', '4', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('14', '树形图', '2', '5', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('15', 'jQuery UI', '2', '6', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('16', '嵌套的列表', '2', '7', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('17', '三级菜单', '2', '8', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('18', '项目 #1', '17', '0', null, 'fa-leaf green', 'console', '3', '1', null, null);
INSERT INTO `menu` VALUES ('19', '第四级', '17', '1', null, 'fa-pencil orange', 'console', '3', '1', null, null);
INSERT INTO `menu` VALUES ('20', '添加产品', '19', '0', null, 'fa-plus purple', 'console', '4', '1', null, null);
INSERT INTO `menu` VALUES ('21', '查看产品', '19', '1', null, 'fa-eye pink', 'console', '4', '1', null, null);
INSERT INTO `menu` VALUES ('22', '表格', null, '2', null, 'fa-list', 'console', '1', '1', null, null);
INSERT INTO `menu` VALUES ('23', '简单 &amp; 动态', '22', '0', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('24', 'jqGrid插件', '22', '1', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('25', '表单', null, '3', null, 'fa-pencil-square-o', 'console', '1', '1', null, null);
INSERT INTO `menu` VALUES ('26', '表单元素', '25', '0', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('27', '表单元素2', '25', '1', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('28', '向导 &amp; 验证', '25', '2', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('29', 'Wysiwyg &amp; Markdown', '25', '3', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('30', '文件拖拽上传', '25', '4', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('31', '小部件', null, '4', null, 'fa-list-alt', 'console', '1', '1', null, null);
INSERT INTO `menu` VALUES ('32', '日历', null, '5', null, 'fa-calendar', 'console', '1', '1', null, null);
INSERT INTO `menu` VALUES ('33', '图库', null, '6', null, 'fa-picture-o', 'console', '1', '1', null, null);
INSERT INTO `menu` VALUES ('34', '更多页面', null, '7', null, 'fa-tag', 'console', '1', '1', null, null);
INSERT INTO `menu` VALUES ('35', '用户简介', '34', '0', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('36', '收件箱', '34', '1', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('37', '定价表', '34', '2', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('38', '发货单', '34', '3', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('39', '时间轴', '34', '4', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('40', '搜索结果', '34', '5', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('41', '邮件模板', '34', '6', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('42', '登录&amp; 注册', '34', '7', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('43', '其他页面', null, '8', null, 'fa-file-o', 'console', '1', '1', null, null);
INSERT INTO `menu` VALUES ('44', '常见问题解答', '43', '0', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('45', '404错误', '43', '1', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('46', '500错误', '43', '2', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('47', '网格', '43', '3', null, 'fa-caret-right', 'console', '2', '1', null, null);
INSERT INTO `menu` VALUES ('48', '空白页', '43', '4', null, 'fa-caret-right', 'console', '2', '1', null, null);
