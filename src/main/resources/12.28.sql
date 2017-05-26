-- --------------------------------------------------------
-- 主机:                           10.20.11.71
-- 服务器版本:                        5.6.23 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 weixin.sys_dict 结构
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE IF NOT EXISTS `sys_dict` (
  `id` bigint(64) NOT NULL COMMENT '编号',
  `value` varchar(100) NOT NULL COMMENT '字典值',
  `name` varchar(100) NOT NULL COMMENT '字典名称',
  `type` varchar(100) NOT NULL COMMENT '类型',
  `type_desc` varchar(100) NOT NULL COMMENT '类型描述',
  `sort` decimal(10,0) NOT NULL COMMENT '排序（升序）',
  `create_by` bigint(64) NOT NULL COMMENT '创建者',
  `create_time` bigint(64) NOT NULL COMMENT '创建时间',
  `update_by` bigint(64) NOT NULL COMMENT '更新者',
  `update_time` bigint(64) NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `status` char(10) NOT NULL DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `sys_dict_type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

-- 正在导出表  weixin.sys_dict 的数据：~31 rows (大约)
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
INSERT INTO `sys_dict` (`id`, `value`, `name`, `type`, `type_desc`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `remarks`, `status`) VALUES
	(1, '0', '停用', 'on_off', '系统状态', 11, 1, 20161108094637, 1, 20170516185357, '', '1'),
	(2, '2', '普通', 'sys_role_type', '角色类型', 11, 1, 20161201104318, 1, 20161201104318, '', '1'),
	(3, '6', '仅本人数据', 'sys_data_scope', '数据范围', 15, 1, 20161201102424, 1, 20161201102424, '', '1'),
	(4, '1', '启用', 'on_off', '系统状态', 9, 1, 20161108094621, 1, 20170524092422, '', '1'),
	(5, '1', '管理员', 'sys_role_type', '角色类型', 10, 1, 20161201100014, 1, 20161201104233, '', '1'),
	(6, '5', '所在部门数据', 'sys_data_scope', '数据范围', 14, 1, 20161201102407, 1, 20161212092734, '', '1'),
	(7, '3', '所在公司数据', 'sys_data_scope', '数据范围', 12, 1, 20161201102321, 1, 20161201102321, '', '1'),
	(8, '9', '按明细设置', 'sys_data_scope', '数据范围', 19, 1, 20161201102516, 1, 20161201102516, '', '1'),
	(9, '2', '所在公司及以下数据', 'sys_data_scope', '数据范围', 11, 1, 20161201102257, 1, 20161201102257, '', '1'),
	(10, '4', '所在部门及以下数据', 'sys_data_scope', '数据范围', 13, 1, 20161201102341, 1, 20161201102341, '', '1'),
	(11, '1', '所有数据', 'sys_data_scope', '数据范围', 10, 1, 20161201100218, 1, 20161201100218, '', '1'),
	(12, '1', '公司', 'sys_org_type', '组织类型', 10, 1, 20161108094517, 1, 20161129164832, '', '1'),
	(13, '1', '功能', 'menu_type', '菜单类型', 11, 1, 20161108094821, 1, 20170516161016, '测试', '1'),
	(14, '2', '部门', 'sys_org_type', '组织类型', 12, 1, 20161108094534, 1, 20161108094534, '', '1'),
	(15, '0', '模块', 'menu_type', '菜单类型', 10, 1, 20161108094757, 1, 20161205134726, '', '1'),
	(16, '3', '其它', 'sys_role_type', '角色类型', 12, 1, 20161201104332, 1, 20161201104332, '', '1'),
	(320720001, 'C', 'C.高中', 'degree', '学历', 12, 0, 20170519, 3229236357758977, 20170526171338, '11', '1'),
	(320720002, 'E', 'E.专科', 'degree', '学历', 12, 0, 20170519, 1, 20170519, '0', '1'),
	(320720003, 'E', 'E.企业的普通办公室职员/业务员', 'workNo', '职业', 0, 0, 20170519, 1, 20170519, '0', '1'),
	(320720004, 'G', 'G.司机', 'workNo', '职业', 0, 0, 20170519, 1, 20170519, '0', '1'),
	(320720005, 'B', 'B.企业中高层管理人员', 'workNo', '职业', 0, 0, 20170519, 1, 20170519, '0', '1'),
	(320720006, 'N', 'N.其他', 'workNo', '职业', 0, 0, 20170519, 1, 20170519, '0', '1'),
	(320720007, 'C', 'C.3000-3999元', 'incomeCode', '收入水平', 0, 0, 20170519, 1, 20170519, '0', '1'),
	(320720008, 'D', 'D.4000-4999元', 'incomeCode', '收入水平', 0, 0, 20170519, 1, 20170519, '0', '1'),
	(320720009, 'E', 'E.5000-6999元', 'incomeCode', '收入水平', 0, 0, 20170519, 1, 20170519, '0', '1'),
	(320720010, 'B', 'B.0.5-1包/天（含）', 'consumerRate', '消费频率', 0, 0, 20170519, 3229236357758977, 20170526184546, '0', '1'),
	(320720011, 'C', 'C.1-1.5包/天（含）', 'consumerRate', '消费频率', 0, 0, 20170519, 3229236357758977, 20170526165317, '0', '1'),
	(320720012, 'D', 'D.1.5-2包/天（含）', 'consumerRate', '消费频率', 0, 0, 20170519, 1, 20170526110453, '0', '1'),
	(320720013, 'D', 'D.10.00-12.00元/包', 'consumerGrade', '消费档次', 0, 0, 20170519, 1, 20170519, '0', '1'),
	(320720014, 'E', 'E.13.00-16.00元/包', 'consumerGrade', '消费档次', 0, 0, 20170519, 1, 20170519, '0', '1'),
	(320720015, 'F', 'F.18.00-23.00元/包', 'consumerGrade', '消费档次', 0, 0, 20170519, 1, 20170519, '0', '1');
/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;


-- 导出  表 weixin.sys_menu 结构
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE IF NOT EXISTS `sys_menu` (
  `id` bigint(64) NOT NULL COMMENT '编号',
  `parent_id` bigint(64) NOT NULL COMMENT '父级编号',
  `parent_tree` varchar(2000) DEFAULT NULL COMMENT '父id集合 树形表格必须',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `target` varchar(2000) DEFAULT NULL COMMENT '链接',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `type` char(1) NOT NULL COMMENT '0:模块 1:功能',
  `permission` varchar(200) DEFAULT NULL COMMENT '权限标识',
  `create_by` bigint(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '1启用 0停用',
  PRIMARY KEY (`id`),
  KEY `sys_menu_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- 正在导出表  weixin.sys_menu 的数据：~26 rows (大约)
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` (`id`, `parent_id`, `parent_tree`, `name`, `sort`, `target`, `icon`, `type`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `status`) VALUES
	(3230174917165069, 3230174917165089, '7-3230174917165089', '角色管理', 14, 'pages/system/role/role-list', 'iconfont icon-lock', '0', '', 1, '2016-12-02 10:30:21', 1, '2016-12-02 10:30:21', 'dc92c9ac3f6f4a0f83c625826737a969', '1'),
	(3230174917165081, 3230174917165089, '7-3230174917165089', '组织机构', 13, 'pages/system/org/org-list', 'fa fa-bank', '0', '', 1, '2016-12-02 10:29:59', 1, '2016-12-02 10:29:59', 'cc43262a8e074581b87b65eac4fa3b81', '1'),
	(3230174917165085, 3230174917165089, '7-3230174917165089', '字典数据', 12, 'pages/system/dict/dict-list', 'fa fa-cogs', '0', '', 1, '2016-12-02 10:29:31', 1, '2016-12-02 10:29:31', '1b9b9c3eecf64e5ba3f6606d80646269', '1'),
	(3230174917165086, 3230174917165089, '7-3230174917165089', '菜单管理', 11, 'pages/system/menu/menu-list', 'fa fa-tasks', '0', '', 1, '2016-12-02 10:29:02', 1, '2016-12-05 09:32:27', '5a6df78f7b794d03bb8f865761e230ad', '1'),
	(3230174917165087, 3230174917165088, '7-3230174917165089,10-3230174917165088', '新增用户', 10, '', 'iconfont icon-qdao', '1', 'sys:user:add', 1, '2016-12-02 10:31:17', 3229236357758977, '2017-05-26 16:57:45', NULL, '1'),
	(3230174917165088, 3230174917165089, '7-3230174917165089', '用户管理', 10, 'pages/system/user/user-list', 'iconfont icon-users', '0', '', 1, '2016-12-02 10:28:00', 1, '2017-05-24 15:44:59', 'f745cde0e9bd4ac2ad2a2c4664849ba8', '1'),
	(3230174917165089, -1, '', '系统管理', 7, '#', 'iconfont icon-calendarfull', '0', '', 1, '2016-10-20 14:04:39', 1, '2016-12-05 09:32:02', '13371bbe5f3d401882cf910114526b70', '1'),
	(3230174917165090, 3230174921359360, '2-3230174921359360', '新增礼品', 2, '#', '-1', '1', 'weixin:gift:add', 1, '2017-05-24 15:41:58', 3229236357758977, '2017-05-26 18:51:09', NULL, '1'),
	(3230174921359360, -1, '', '礼品管理', 2, 'pages/weixin/gift/gift-list', 'iconfont icon-magicwand', '0', '', 1, '2017-05-23 10:42:38', 3229236357758977, '2017-05-26 15:22:15', NULL, '1'),
	(3230174921359361, -1, '', '主页', 0, 'pages/home', 'iconfont icon-home', '0', '', 1, '2016-10-20 14:01:56', 1, '2017-05-16 16:10:05', '13ce47a730f549a09ffbd3b0d165cb53', '1'),
	(3239234018213888, 3230174917165069, '7-3230174917165089,14-3230174917165069', '新增角色', 10, '', 'iconfont icon-qdao', '1', 'sys:role:add', 1, '2016-12-02 10:34:21', 1, '2016-12-02 10:34:21', '55c43f38b12f49d587595d88240f5704', '1'),
	(3239234022408192, 3230174917165081, '7-3230174917165089,13-3230174917165081', '新增组织', 10, '', '-1', '1', 'sys:org:add', 1, '2016-12-07 10:05:26', 1, '2016-12-07 10:05:26', 'b5345339ee1a4e0ea2a5ad5609e3bbf2', '1'),
	(3239234022408193, 3230174917165085, '7-3230174917165089,12-3230174917165085', '新增字典', 10, '', 'iconfont icon-qdao', '1', 'sys:dict:add', 1, '2016-12-02 10:37:50', 1, '2016-12-02 10:37:50', 'cea9da411296420fb432645149c78d8d', '1'),
	(3239234022408194, 3230174917165086, '7-3230174917165089,11-3230174917165086', '新增菜单', 10, '', 'iconfont icon-qdao', '1', 'sys:menu:add', 1, '2016-12-02 10:32:52', 1, '2016-12-02 10:32:52', '49c2ed2715a344cfacd1597ff71e24cf', '1'),
	(3239234022408195, 3230174917165069, '7-3230174917165089,14-3230174917165069', '角色修改', 11, '', 'iconfont icon-qdao', '1', 'sys:role:save', 1, '2016-12-02 10:34:49', 1, '2016-12-02 10:34:49', 'd1333635d17042f498c16aa44a24e27e', '1'),
	(3239234022408196, 3230174917165081, '7-3230174917165089,13-3230174917165081', '修改组织', 11, '', '-1', '1', 'sys:org:save', 1, '2016-12-07 10:05:52', 1, '2016-12-07 10:05:52', '00f92fbc5ec24a3995a7125a4d22a248', '1'),
	(3239234022408197, 3230174917165085, '7-3230174917165089,12-3230174917165085', '修改字典', 11, '', 'iconfont icon-qdao', '1', 'sys:dict:save', 1, '2016-12-02 10:38:51', 1, '2016-12-02 10:38:51', '73fde810d4854472b79d85a07bcf4726', '1'),
	(3239234026602496, 3230174917165086, '7-3230174917165089,11-3230174917165086', '修改菜单', 11, '', 'iconfont icon-qdao', '1', 'sys:menu:save', 1, '2016-12-02 10:33:15', 1, '2016-12-02 10:33:15', 'd36e413f267f4a2998f0fd265eb36d30', '1'),
	(3239234026602497, 3230174917165088, '7-3230174917165089,10-3230174917165088', '修改用户', 11, '', 'iconfont icon-qdao', '1', 'sys:user:save', 1, '2016-12-02 10:31:54', 1, '2016-12-02 10:31:54', 'ab96b9a08cfc43f080a42b11baa4d090', '1'),
	(3239234026602498, 3230174917165081, '7-3230174917165089,13-3230174917165081', '删除组织', 12, '', '-1', '1', 'sys:org:delete', 1, '2016-12-07 10:06:10', 1, '2016-12-07 10:06:10', 'c74b1350a9af4b9cb391ac884ee72a76', '1'),
	(3239234026602499, 3230174917165085, '7-3230174917165089,12-3230174917165085', '删除字典', 12, '', 'iconfont icon-qdao', '1', 'sys:dict:delete', 1, '2016-12-02 10:39:19', 1, '2016-12-02 10:39:19', '2c1c253e59f240fd96629cb20ef749f7', '1'),
	(3239234026602500, 3230174917165086, '7-3230174917165089,11-3230174917165086', '删除菜单', 12, '', 'iconfont icon-qdao', '1', 'sys:menu:delete', 1, '2016-12-02 10:33:42', 1, '2016-12-02 10:33:42', '81681ae2706c43c08d1ed8fd7b3ffba9', '1'),
	(3239234026602501, 3230174917165088, '7-3230174917165089,10-3230174917165088', '删除用户', 12, '', 'iconfont icon-qdao', '1', 'sys:user:delete', 1, '2016-12-02 10:32:22', 1, '2016-12-02 10:32:22', '4a2c26f29a92410c92e343ba7b40d4f2', '1'),
	(3239234026602502, 3230174917165069, '7-3230174917165089,14-3230174917165069', '角色删除', 13, '', 'iconfont icon-qdao', '1', 'sys:role:delete', 1, '2016-12-02 10:35:12', 1, '2016-12-02 10:35:12', 'f4be70047dbf407184cb21874dfbe9da', '1'),
	(3239234026602503, 3230174917165069, '7-3230174917165089,14-3230174917165069', '角色分配', 15, '', 'iconfont icon-qdao', '1', 'sys:role:assignRole', 1, '2016-12-02 10:35:44', 1, '2016-12-02 10:35:44', 'cb8d0e3cb2824081a3537f531c1676ae', '1'),
	(3239234026602504, 3230174917165069, '7-3230174917165089,14-3230174917165069', '角色授权', 21, '', 'fa fa-language', '1', 'sys:role:permissionRole', 1, '2016-12-07 09:32:58', 1, '2016-12-07 09:32:58', 'd9639a0feb13415d86a76124d8a04618', '1');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;


-- 导出  表 weixin.sys_org 结构
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE IF NOT EXISTS `sys_org` (
  `id` bigint(64) NOT NULL COMMENT '编号',
  `parent_id` bigint(64) NOT NULL COMMENT '父级编号',
  `parent_tree` varchar(2000) DEFAULT NULL COMMENT '父id集合 树形表格必须',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `type` char(1) NOT NULL COMMENT '机构类型,1公司 2部门',
  `addr` varchar(255) DEFAULT NULL COMMENT '地址',
  `master_id` varchar(64) DEFAULT NULL COMMENT '负责人ID',
  `sort` decimal(10,0) NOT NULL DEFAULT '10' COMMENT '排序',
  `create_by` bigint(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `sys_org_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织机构表';

-- 正在导出表  weixin.sys_org 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `sys_org` DISABLE KEYS */;
INSERT INTO `sys_org` (`id`, `parent_id`, `parent_tree`, `name`, `type`, `addr`, `master_id`, `sort`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `status`) VALUES
	(3266892194119680, -1, '', 'X省公司', '1', 'X路Y号', '3229236357758977', 10, 3229236357758977, '2017-05-26 15:22:49', 3229236357758977, '2017-05-26 15:22:49', NULL, '1'),
	(3268996539351040, 3266892194119680, '10-3266892194119680', 'X省公司Y部', '2', 'X路Y号', '3229236357758977', 10, 3229236357758977, '2017-05-26 15:31:10', 3229236357758977, '2017-05-26 15:31:10', NULL, '1'),
	(3269184737771520, 3266892194119680, '10-3266892194119680', 'X省公司M部', '2', 'Y路X号', '3229236357758977', 10, 3229236357758977, '2017-05-26 15:31:55', 3229236357758977, '2017-05-26 15:31:55', NULL, '1'),
	(3269317722374144, -1, '', 'Z省公司', '1', 'Z路B号', '3229236357758977', 10, 3229236357758977, '2017-05-26 15:32:27', 3229236357758977, '2017-05-26 15:32:27', NULL, '1'),
	(3269592587698176, 3269317722374144, '10-3269317722374144', 'Z省公司H部', '2', '', '3229236357758977', 10, 3229236357758977, '2017-05-26 15:33:32', 3229236357758977, '2017-05-26 15:33:47', NULL, '1');
/*!40000 ALTER TABLE `sys_org` ENABLE KEYS */;


-- 导出  表 weixin.sys_role 结构
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` bigint(64) NOT NULL COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `enname` varchar(255) DEFAULT NULL COMMENT '英文名称',
  `role_type` varchar(64) DEFAULT NULL COMMENT '角色类型',
  `data_scope` char(1) DEFAULT NULL COMMENT '数据范围',
  `create_by` bigint(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `sys_role_enname` (`enname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- 正在导出表  weixin.sys_role 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`id`, `name`, `enname`, `role_type`, `data_scope`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `status`) VALUES
	(3230174904582144, '公司领导', 'role_leader', '2', '2', 1, '2016-12-01 14:33:38', 1, '2016-12-06 14:25:31', 'e20dbdbe8599472598c6039f57adf0e6', '1'),
	(3230174904582145, '测试1', 'test', '3', '6', 1, '2017-05-24 14:20:24', 1, '2017-05-26 10:24:33', 'dbce4bf042ae424bb05f18c3756b3c6c', '1'),
	(3230174904582146, '部门领导', 'role_dept', '2', '4', 1, '2016-12-01 14:34:16', 1, '2017-05-24 09:59:24', '7cee60ff4f844ec09830e81c2513f95f', '1'),
	(3230174908776448, '系统管理员', 'role_admin', '1', '1', 1, '2016-12-01 10:59:23', 1, '2017-05-17 12:49:53', '48d9ab7d01d44578a5c6906d42ed0ff0', '1');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;


-- 导出  表 weixin.sys_role_menu 结构
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE IF NOT EXISTS `sys_role_menu` (
  `role_id` bigint(64) NOT NULL COMMENT '角色id',
  `menu_id` bigint(64) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单对应';

-- 正在导出表  weixin.sys_role_menu 的数据：~26 rows (大约)
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES
	(3230174908776448, 3230174917165069),
	(3230174908776448, 3230174917165081),
	(3230174908776448, 3230174917165085),
	(3230174908776448, 3230174917165086),
	(3230174908776448, 3230174917165087),
	(3230174908776448, 3230174917165088),
	(3230174908776448, 3230174917165089),
	(3230174908776448, 3230174917165090),
	(3230174908776448, 3230174921359360),
	(3230174908776448, 3230174921359361),
	(3230174908776448, 3239234018213888),
	(3230174908776448, 3239234022408192),
	(3230174908776448, 3239234022408193),
	(3230174908776448, 3239234022408194),
	(3230174908776448, 3239234022408195),
	(3230174908776448, 3239234022408196),
	(3230174908776448, 3239234022408197),
	(3230174908776448, 3239234026602496),
	(3230174908776448, 3239234026602497),
	(3230174908776448, 3239234026602498),
	(3230174908776448, 3239234026602499),
	(3230174908776448, 3239234026602500),
	(3230174908776448, 3239234026602501),
	(3230174908776448, 3239234026602502),
	(3230174908776448, 3239234026602503),
	(3230174908776448, 3239234026602504);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;


-- 导出  表 weixin.sys_role_user 结构
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE IF NOT EXISTS `sys_role_user` (
  `role_id` bigint(64) NOT NULL COMMENT '角色id',
  `user_id` bigint(64) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`role_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-用户对应';

-- 正在导出表  weixin.sys_role_user 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `sys_role_user` DISABLE KEYS */;
INSERT INTO `sys_role_user` (`role_id`, `user_id`) VALUES
	(3230174904582144, 3229236357758977),
	(3230174904582146, 3229236357758976),
	(3230174908776448, 3229236357758977),
	(3230174908776448, 3229236357758978);
/*!40000 ALTER TABLE `sys_role_user` ENABLE KEYS */;


-- 导出  表 weixin.sys_user 结构
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` bigint(62) NOT NULL COMMENT '编号',
  `company_id` varchar(64) NOT NULL COMMENT '归属公司',
  `dept_id` varchar(64) NOT NULL COMMENT '归属部门',
  `login_name` varchar(100) NOT NULL COMMENT '登录名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `no` varchar(100) DEFAULT NULL COMMENT '工号',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(200) DEFAULT NULL COMMENT '手机',
  `user_type` char(1) DEFAULT NULL COMMENT '用户类型',
  `photo` varchar(1000) DEFAULT NULL COMMENT '用户头像',
  `login_ip` varchar(100) DEFAULT NULL COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `login_flag` varchar(64) DEFAULT NULL COMMENT '是否可登录',
  `create_by` bigint(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `sys_user_dept_id` (`dept_id`),
  KEY `sys_user_login_name` (`login_name`),
  KEY `sys_user_company_id` (`company_id`),
  KEY `sys_user_update_date` (`update_date`),
  KEY `sys_user_del_flag` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 正在导出表  weixin.sys_user 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`id`, `company_id`, `dept_id`, `login_name`, `password`, `no`, `name`, `email`, `phone`, `mobile`, `user_type`, `photo`, `login_ip`, `login_date`, `login_flag`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `status`) VALUES
	(3229236357758977, '3266892194119680', '3268996539351040', 'bcm', '02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032', '134', '系统管理员', 'bcm@163.com', '', '8675', NULL, NULL, '0:0:0:0:0:0:0:1', '2016-05-12 12:46:09', '1', 1, '2013-05-27 08:00:00', 3229236357758977, '2017-05-26 15:34:05', '1', '1'),
	(3229236357758978, '3269317722374144', '3269592587698176', '123', 'b7a7922173b5d1adedbbecdf0a24540eb95108da227c8f6df88d29dc', '22', '123', '', '', '', NULL, NULL, NULL, NULL, '1', 1, '2017-05-17 14:35:28', 3229236357758977, '2017-05-26 16:57:34', '35662785d2ee495bb42c8ebed7c6649b', '1');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
