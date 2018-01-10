/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : kedacom

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-01-10 14:38:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(256) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `is_default` bit(1) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(256) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `pro_id` bigint(20) DEFAULT NULL,
  `sales` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', 'Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris ', 'http://themehall.com/preview/shopping/wp-content/uploads/sites/9/2013/06/poster_2_up-300x300.jpg', 'Flying Ninja1', '108.00', null, '666', '1000', '2');
INSERT INTO `goods` VALUES ('2', 'Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris ', 'http://themehall.com/preview/shopping/wp-content/uploads/sites/9/2013/06/T_7_front.jpg', 'Happy Ninja2', '128.00', null, '324', '658', '2');
INSERT INTO `goods` VALUES ('3', '情侣装秋装加厚加绒卫衣女2017新款韩版潮ulzzang学生宽松bf外套1', 'https://g-search1.alicdn.com/img/bao/uploaded/i4/imgextra/i3/124514802/TB2Kv7KawjN8KJjSZFgXXbjbVXa_!!0-saturn_solar.jpg_230x230.jpg', '秋装卫衣3', '69.00', null, '255', '123', '1');
INSERT INTO `goods` VALUES ('4', '休闲卫衣男2017加绒秋冬季男士社会外套装帅气衣服冬装运动两件套1', 'https://g-search2.alicdn.com/img/bao/uploaded/i4/i2/3073504930/TB1KA18c8LN8KJjSZFPXXXoLXXa_!!0-item_pic.jpg_230x230.jpg', '休闲卫衣4', '108.00', null, '245', '701', '1');
INSERT INTO `goods` VALUES ('5', 'Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris ', 'http://themehall.com/preview/shopping/wp-content/uploads/sites/9/2013/06/poster_2_up-300x300.jpg', 'Flying Ninja5', '108.00', null, '666', '1000', '2');
INSERT INTO `goods` VALUES ('6', 'Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris ', 'http://themehall.com/preview/shopping/wp-content/uploads/sites/9/2013/06/T_7_front.jpg', 'Happy Ninja6', '128.00', null, '324', '658', '2');
INSERT INTO `goods` VALUES ('7', '情侣装秋装加厚加绒卫衣女2017新款韩版潮ulzzang学生宽松bf外套2', 'https://g-search1.alicdn.com/img/bao/uploaded/i4/imgextra/i3/124514802/TB2Kv7KawjN8KJjSZFgXXbjbVXa_!!0-saturn_solar.jpg_230x230.jpg', '秋装卫衣7', '69.00', null, '255', '123', '1');
INSERT INTO `goods` VALUES ('8', '休闲卫衣男2017加绒秋冬季男士社会外套装帅气衣服冬装运动两件套2', 'https://g-search2.alicdn.com/img/bao/uploaded/i4/i2/3073504930/TB1KA18c8LN8KJjSZFPXXXoLXXa_!!0-item_pic.jpg_230x230.jpg', '休闲卫衣8', '108.00', null, '245', '701', '1');
INSERT INTO `goods` VALUES ('9', 'Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris ', 'http://themehall.com/preview/shopping/wp-content/uploads/sites/9/2013/06/poster_2_up-300x300.jpg', 'Flying Ninja9', '108.00', null, '666', '1000', '2');
INSERT INTO `goods` VALUES ('10', 'Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris ', 'http://themehall.com/preview/shopping/wp-content/uploads/sites/9/2013/06/T_7_front.jpg', 'Happy Ninja10', '128.00', null, '324', '658', '2');
INSERT INTO `goods` VALUES ('11', '情侣装秋装加厚加绒卫衣女2017新款韩版潮ulzzang学生宽松bf外套3', 'https://g-search1.alicdn.com/img/bao/uploaded/i4/imgextra/i3/124514802/TB2Kv7KawjN8KJjSZFgXXbjbVXa_!!0-saturn_solar.jpg_230x230.jpg', '秋装卫衣11', '69.00', null, '255', '123', '1');
INSERT INTO `goods` VALUES ('12', '休闲卫衣男2017加绒秋冬季男士社会外套装帅气衣服冬装运动两件套3', 'https://g-search2.alicdn.com/img/bao/uploaded/i4/i2/3073504930/TB1KA18c8LN8KJjSZFPXXXoLXXa_!!0-item_pic.jpg_230x230.jpg', '休闲卫衣12', '108.00', null, '245', '701', '1');
INSERT INTO `goods` VALUES ('13', 'Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris ', 'http://themehall.com/preview/shopping/wp-content/uploads/sites/9/2013/06/poster_2_up-300x300.jpg', 'Flying Ninja13', '108.00', null, '666', '1000', '2');
INSERT INTO `goods` VALUES ('14', 'Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris ', 'http://themehall.com/preview/shopping/wp-content/uploads/sites/9/2013/06/T_7_front.jpg', 'Happy Ninja14', '128.00', null, '324', '658', '2');
INSERT INTO `goods` VALUES ('15', '情侣装秋装加厚加绒卫衣女2017新款韩版潮ulzzang学生宽松bf外套4', 'https://g-search1.alicdn.com/img/bao/uploaded/i4/imgextra/i3/124514802/TB2Kv7KawjN8KJjSZFgXXbjbVXa_!!0-saturn_solar.jpg_230x230.jpg', '秋装卫衣15', '69.00', null, '255', '123', '1');
INSERT INTO `goods` VALUES ('16', '休闲卫衣男2017加绒秋冬季男士社会外套装帅气衣服冬装运动两件套4', 'https://g-search2.alicdn.com/img/bao/uploaded/i4/i2/3073504930/TB1KA18c8LN8KJjSZFPXXXoLXXa_!!0-item_pic.jpg_230x230.jpg', '休闲卫衣16', '108.00', null, '245', '701', '1');
INSERT INTO `goods` VALUES ('17', 'Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris ', 'http://themehall.com/preview/shopping/wp-content/uploads/sites/9/2013/06/T_7_front.jpg', 'Happy Ninja14', '128.00', null, '324', '658', '2');
INSERT INTO `goods` VALUES ('18', '情侣装秋装加厚加绒卫衣女2017新款韩版潮ulzzang学生宽松bf外套4', 'https://g-search1.alicdn.com/img/bao/uploaded/i4/imgextra/i3/124514802/TB2Kv7KawjN8KJjSZFgXXbjbVXa_!!0-saturn_solar.jpg_230x230.jpg', '秋装卫衣15', '69.00', null, '255', '123', '1');
INSERT INTO `goods` VALUES ('19', '休闲卫衣男2017加绒秋冬季男士社会外套装帅气衣服冬装运动两件套4', 'https://g-search2.alicdn.com/img/bao/uploaded/i4/i2/3073504930/TB1KA18c8LN8KJjSZFPXXXoLXXa_!!0-item_pic.jpg_230x230.jpg', '休闲卫衣16', '108.00', null, '245', '701', '1');

-- ----------------------------
-- Table structure for goods_type
-- ----------------------------
DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_type
-- ----------------------------
INSERT INTO `goods_type` VALUES ('1', '卫衣');
INSERT INTO `goods_type` VALUES ('2', 'T恤');
INSERT INTO `goods_type` VALUES ('3', '外套');
INSERT INTO `goods_type` VALUES ('4', '休闲裤');
INSERT INTO `goods_type` VALUES ('5', '牛仔裤');
INSERT INTO `goods_type` VALUES ('6', '配件');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(256) DEFAULT NULL,
  `order_amount` decimal(10,2) DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `order_state` int(11) DEFAULT NULL,
  `receive_date` datetime DEFAULT NULL,
  `send_date` datetime DEFAULT NULL,
  `user_phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('19', 'XXXX', '324.00', '2018-01-04 18:09:35', '3', '2018-01-08 10:19:10', '2018-01-04 18:09:35', '18361228129');
INSERT INTO `orders` VALUES ('20', 'XXXX', '108.00', '2018-01-04 18:16:04', '3', '2018-01-04 19:48:24', '2018-01-04 18:16:04', '18361228129');
INSERT INTO `orders` VALUES ('21', 'XXXX', '756.00', '2018-01-09 16:52:45', '3', '2018-01-09 18:37:36', '2018-01-09 16:52:45', '18361228129');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) DEFAULT NULL,
  `goods_price` decimal(10,2) DEFAULT NULL,
  `order_count` int(11) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('37', '5', '108.00', '1', '19');
INSERT INTO `order_detail` VALUES ('38', '1', '108.00', '2', '19');
INSERT INTO `order_detail` VALUES ('39', '8', '108.00', '1', '20');
INSERT INTO `order_detail` VALUES ('40', '1', '108.00', '2', '21');
INSERT INTO `order_detail` VALUES ('41', '13', '108.00', '4', '21');
INSERT INTO `order_detail` VALUES ('42', '9', '108.00', '1', '21');

-- ----------------------------
-- Table structure for producer
-- ----------------------------
DROP TABLE IF EXISTS `producer`;
CREATE TABLE `producer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(64) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `pro_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of producer
-- ----------------------------

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) DEFAULT NULL,
  `goods_price` decimal(10,2) DEFAULT NULL,
  `is_effective` bit(1) DEFAULT NULL,
  `order_count` int(11) DEFAULT NULL,
  `order_price` decimal(10,2) DEFAULT NULL,
  `order_time` datetime DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------
INSERT INTO `shopping_cart` VALUES ('1', '5', '108.00', '\0', '1', '108.00', '2018-01-04 15:01:02', '1');
INSERT INTO `shopping_cart` VALUES ('2', '1', '108.00', '\0', '2', '216.00', '2018-01-04 15:09:18', '1');
INSERT INTO `shopping_cart` VALUES ('3', '8', '108.00', '\0', '1', '108.00', '2018-01-04 18:15:40', '1');
INSERT INTO `shopping_cart` VALUES ('4', '1', '108.00', '\0', '2', '216.00', '2018-01-04 19:49:50', '1');
INSERT INTO `shopping_cart` VALUES ('5', '13', '108.00', '\0', '4', '432.00', '2018-01-09 14:57:22', '1');
INSERT INTO `shopping_cart` VALUES ('6', '9', '108.00', '\0', '1', '108.00', '2018-01-09 15:14:09', '1');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `url` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'ROLE_USER');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(64) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `reg_time` datetime DEFAULT NULL,
  `user_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_lqjrcobrh9jc8wpcar64q1bfh` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1905578063@qq.com', '$2a$10$f0DEGrkIpYyzcFrf/fTMSOAKl1Y/XHpKaijWdfiWnOOzGTEs8diLi', '18361228129', '2017-12-27 14:04:16', '马辉');
INSERT INTO `user` VALUES ('2', null, '$10$f0DEGrkIpYyzcFrf/fTMSOAKl1Y/XHpKaijWdfiWnOOzGTEs8diLi', '18361246696', '2017-12-27 14:04:44', '苏雄伟');
INSERT INTO `user` VALUES ('8', '123@1', '$2a$10$Zpdd/aEcCgnBpzuzRyyUfOg2A6tM0zERGHesRp1EZ85WWBDUSuN.K', '123122', '2018-01-05 13:19:34', null);
INSERT INTO `user` VALUES ('9', '123@1', '$2a$10$YayEhbZdd.b.dHM8DoCSxeYRsds3N2SgPwlHqyI76qwyZ3w.8zS02', '12121', '2018-01-05 13:45:58', '18361228129');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
