/*
 Navicat Premium Data Transfer

 Source Server         : html
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 01/07/2019 11:15:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `article_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增字段',
  `category_id` int(4) NOT NULL COMMENT '文章类别id',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章标题',
  `content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章内容',
  `user_id` int(11) UNSIGNED NOT NULL COMMENT '文章作者id',
  `issue_time` datetime(0) NOT NULL COMMENT '发布时间',
  `scan_num` int(11) NULL DEFAULT 0 COMMENT '浏览量',
  `img_path` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '缩略图路径',
  `summary` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '摘要',
  PRIMARY KEY (`article_id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `article_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, 1, '大数据时代', '??', 8, '2019-06-29 23:01:18', 0, 'http://localhost:8080/upload/image/20190627094838145.jpg', '大是大非');
INSERT INTO `article` VALUES (2, 1, '大虎山', '大大发', 1, '2019-06-29 23:01:12', 0, 'http://localhost:8080/upload/image/20190627094838145.jpg', '大大发');
INSERT INTO `article` VALUES (3, 1, 'web的开发', '发达大动干戈', 4, '2019-06-18 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '的热认为');
INSERT INTO `article` VALUES (4, 2, 'web的发', '发达大动干戈', 4, '2019-06-17 00:00:00', 0, 'http://localhost:8080/upload/image/20190624230956624.jpg', '的热认为');
INSERT INTO `article` VALUES (5, 2, 'web开发', '发达大动干戈', 1, '2019-06-17 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '的热认为');
INSERT INTO `article` VALUES (6, 3, 'wb的开发', '发达大动干戈', 8, '2019-06-17 00:00:00', 0, 'http://localhost:8080/upload/image/20190624230956624.jpg', '的热认为');
INSERT INTO `article` VALUES (7, 1, 'web的开发', '发达大动干戈', 1, '2019-06-17 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '的热认为');
INSERT INTO `article` VALUES (8, 5, 'web的开发', '发达大动干戈', 8, '2019-06-14 00:00:00', 0, 'http://localhost:8080/upload/image/20190624230956624.jpg', '的热认为');
INSERT INTO `article` VALUES (9, 2, 'web的开发', '发达大动干戈', 1, '2019-06-14 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '的热认为');
INSERT INTO `article` VALUES (12, 4, 'web的开发', '发达大动干戈', 8, '2019-06-13 00:00:00', 0, 'http://localhost:8080/upload/image/20190624231000249.jpg\"', '的热认为');
INSERT INTO `article` VALUES (13, 4, 'web的开发', '发达大动干戈', 1, '2019-06-19 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '的热认为');
INSERT INTO `article` VALUES (14, 3, 'web的开发', '发达大动干戈', 1, '2019-06-19 00:00:00', 0, 'http://localhost:8080/upload/image/20190624231000249.jpg\"', '的热认为');
INSERT INTO `article` VALUES (15, 2, 'web的开发', '发达大动干戈', 1, '2019-06-19 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '的热认为');
INSERT INTO `article` VALUES (16, 1, 'web的开发', '发达大动干戈', 1, '2019-06-19 00:00:00', 0, 'http://localhost:8080/upload/image/20190624231000249.jpg\"', '的热认为');
INSERT INTO `article` VALUES (17, 1, 'web的开发', '发达大动干戈', 1, '2019-06-11 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '的热认为');
INSERT INTO `article` VALUES (18, 2, 'web的开发', '发达大动干戈', 8, '2019-06-11 00:00:00', 0, 'http://localhost:8080/upload/image/20190624231000249.jpg\"', '的热认为');
INSERT INTO `article` VALUES (19, 2, 'web的开发', '发达大动干戈', 4, '2019-06-20 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '的热认为');
INSERT INTO `article` VALUES (20, 3, 'web的开发', '发达大动干戈', 4, '2019-06-20 00:00:00', 0, 'http://localhost:8080/upload/image/20190624231000249.jpg\"', '的热认为');
INSERT INTO `article` VALUES (21, 4, 'web的开发', '发达大动干戈', 4, '2019-06-20 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '的热认为');
INSERT INTO `article` VALUES (22, 1, 'web的开发', '发达大动干戈', 4, '2019-06-20 00:00:00', 0, 'http://localhost:8080/upload/image/20190624231000249.jpg\"', '的热认为');
INSERT INTO `article` VALUES (23, 1, 'web的开发', '发达大动干戈', 4, '2019-06-21 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '的热认为');
INSERT INTO `article` VALUES (24, 1, 'web的开发', '发达大动干戈', 1, '2019-06-21 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '的热认为');
INSERT INTO `article` VALUES (25, 1, 'web的开发', '发达大动干戈', 1, '2019-06-22 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '的热认为');
INSERT INTO `article` VALUES (26, 1, 'web的开发', '发达大动干戈', 4, '2019-06-22 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '的热认为');
INSERT INTO `article` VALUES (28, 1, 'web的开发', '发达大动干戈', 1, '2019-06-23 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '的热认为');
INSERT INTO `article` VALUES (29, 1, '放眼看世界', '在我看来，这里山清水秀，非常适合养老和游山玩水，我有一个我选择了这里，你看看这里<src img=\"http://localhost:8080\">', 1, '2019-06-19 00:00:00', 0, 'http://localhost:8080/upload/image/20190624231000249.jpg\"', '放眼看世界在我看来，这里山清水');
INSERT INTO `article` VALUES (32, 1, '21322312143', '<p>dfadfads<br></p>', 1, '2019-06-21 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '21322312143<p>dfadfad');
INSERT INTO `article` VALUES (33, 1, '21322312143', '<p>dfadfads<br></p>', 1, '2019-06-21 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '21322312143<p>dfadfad');
INSERT INTO `article` VALUES (34, 1, '放眼看世界', '在我看来，这里山清水秀，非常适合养老和游山玩水，我有一个我选择了这里，你看看这里<src img=\"http://localhost:8080\">', 1, '2019-06-23 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '放眼看世界在我看来，这里山清水');
INSERT INTO `article` VALUES (35, 1, '放眼看世界', '在我看来，这里山清水秀，非常适合养老和游山玩水，我有一个我选择了这里，你看看这里<src img=\"http://localhost:8080\">', 1, '2019-06-23 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '放眼看世界在我看来，这里山清水');
INSERT INTO `article` VALUES (36, 1, '放眼看世界', '在我看来，这里山清水秀，非常适合养老和游山玩水，我有一个我选择了这里，你看看这里<src img=\"http://localhost:8080\">', 1, '2019-06-23 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '放眼看世界在我看来，这里山清水');
INSERT INTO `article` VALUES (37, 1, '放眼看世界', '在我看来，这里山清水秀，非常适合养老和游山玩水，我有一个我选择了这里，你看看这里<src img=\"http://localhost:8080\">', 1, '2019-06-23 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '放眼看世界在我看来，这里山清水');
INSERT INTO `article` VALUES (38, 1, '放眼看世界', '在我看来，这里山清水秀，非常适合养老和游山玩水，我有一个我选择了这里，你看看这里<src img=\"http://localhost:8080\">', 1, '2019-06-23 00:00:00', 0, 'http://localhost:8080/upload/image/20190624231003455.jpg', '放眼看世界在我看来，这里山清水');
INSERT INTO `article` VALUES (39, 1, '放眼看世界', '在我看来，这里山清水秀，非常适合养老和游山玩水，我有一个我选择了这里，你看看这里<src img=\"http://localhost:8080\">', 1, '2019-06-23 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', '放眼看世界在我看来，这里山清水');
INSERT INTO `article` VALUES (40, 1, 'fasdfa', '<p>fasdf</p>', 1, '2019-06-23 00:00:00', 0, 'http://localhost:8080/upload/image/20190623135944625.jpg', 'fasdfa<p>fasdf</');
INSERT INTO `article` VALUES (41, 4, '33213121223', '<p><img src=\"http://localhost:8080/upload/image/20190623135944625.jpg\" style=\"max-width:100%;\"><br></p><p>546556464565</p>', 1, '2019-06-23 00:00:00', 0, 'http://localhost:8080/upload/image/20190624231003455.jpg', '33213121223<p><img sr');
INSERT INTO `article` VALUES (42, 1, '', '<p><img src=\"http://localhost:8080/upload/image/20190624230956624.jpg\" style=\"max-width:100%;\"><img src=\"http://localhost:8080/upload/image/20190624231000249.jpg\" style=\"max-width: 100%;\"><img src=\"http://localhost:8080/upload/image/20190624231003455.jpg\" style=\"max-width: 100%;\"><br></p>', 1, '2019-06-24 00:00:00', 0, 'http://localhost:8080/upload/image/20190624231003455.jpg', '<p><img sr');
INSERT INTO `article` VALUES (43, 1, '3221312', '<p><img src=\"http://localhost:8080/upload/image/20190626094317706.jpg\" style=\"max-width:100%;\"><br></p><p>wqerwqrqw21332321</p>', 1, '2019-06-26 00:00:00', 0, 'http://localhost:8080/upload/image/20190626094317706.jpg', '3221312<p><img sr');
INSERT INTO `article` VALUES (44, 4, '实训', '<p><img src=\"http://localhost:8080/upload/image/20190626202350619.jpg\" style=\"max-width:100%;\"><br></p><p>实训1</p><p><img src=\"http://localhost:8080/upload/image/20190626202408599.jpg\" style=\"max-width:100%;\"><br></p>', 1, '2019-06-26 00:00:00', 0, 'http://localhost:8080/upload/image/20190626202350619.jpg', '实训<p><img sr');
INSERT INTO `article` VALUES (45, 1, '前端 UI 工程师的困境与破局', '<p style=\"margin-top: 0px; color: rgb(63, 63, 63); font-family: &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;; font-size: 16px; text-align: justify; background-color: rgb(255, 255, 255);\">早在 2000 年的时候我接触 PhotoShop 6.0，2003 年的时候我靠摸索做出了第一个网页，这也奠定了我的美工“出身”。我的职业生涯中有 3.5 年的时间在做 UI 相关的工作，对于这份工作优势劣势，困境与难处有些自己的见解。</p><p style=\"margin-top: 0px; color: rgb(63, 63, 63); font-family: &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;; font-size: 16px; text-align: justify; background-color: rgb(255, 255, 255);\">最近几年，在各种 JS 框架风生水起的大环境下，更是没有太多人愿意关注 UI 方面的东西，关注前端行业里这些对像素有特殊偏好的人了。我自己也有这样的趋势，当接触了更全面的研发流程之后，就很难保持对 UI 细节以及曾经追求的极致用户体验的关注度了。这或许也恰恰说明，对于某些类型的产品或某些阶段的产品来说，UI 细节没那么重要。而对于重视用户体验的用户体验设计部来说，隶属于设计部的编码人员也较难受到重视和提拔。</p><p style=\"margin-top: 0px; color: rgb(63, 63, 63); font-family: &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;; font-size: 16px; text-align: justify; background-color: rgb(255, 255, 255);\"><img src=\"http://localhost:8080/upload/image/20190626214652399.jpg\" style=\"max-width:100%;\"><br></p><p style=\"margin-top: 0px; color: rgb(63, 63, 63); font-family: &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;; font-size: 16px; text-align: justify; background-color: rgb(255, 255, 255);\">这就是 UI 工程师的困境。我会在 2 周之内产出一篇 5000 字以上的文章，来与你共同探讨 UI 工程的困境和可能的改变方向，以及如何走出第一步的问题。</p><p style=\"margin-top: 0px; color: rgb(63, 63, 63); font-family: &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;; font-size: 16px; text-align: justify; background-color: rgb(255, 255, 255);\"><span style=\"font-weight: 700;\">实录提要：</span></p><ul style=\"margin-top: 0px; color: rgb(63, 63, 63); font-family: &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;; font-size: 16px; text-align: justify; background-color: rgb(255, 255, 255);\"><li>前端的发展太快了，应该怎么去追求深度学习而不是一味追求广度？</li><li>当讨论前端 UI 工程师困境的时候，会立足以个体为主，还是以这个岗位群体为主？</li><li>这次 512 的比特币勒索病毒会不会对前端浏览器兼容产生影响？</li><li>怎么更好的学习应用基础布局及响应式布局？</li><li>样式表现有问题如何调试？需要根据某些浏览器 hack，具体处理时除了经验还有什么好办法？</li><li>后端开发者需要掌握哪些前端知识或技能？</li><li>公司或者 leader 应该如何衡量一个偏科前端的价值呢？有比较合理的衡量标准吗？</li><li>国内外 UI 方面有何差距？如何判断一套 UI 系统/框架的优劣？</li><li>如何根据自身情况来针对某些东西做总结或计划？</li><li>美的开发团队的工作方式是什么？</li></ul>', 1, '2019-06-26 00:00:00', 0, 'http://localhost:8080/upload/image/20190626214652399.jpg', '前端 UI 工程师的困境与破局<p style=\"');
INSERT INTO `article` VALUES (46, 1, '前端 UI 工程师的困境与破局', '<p style=\"margin-top: 0px; color: rgb(63, 63, 63); font-family: &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;; font-size: 16px; text-align: justify; background-color: rgb(255, 255, 255);\">早在 2000 年的时候我接触 PhotoShop 6.0，2003 年的时候我靠摸索做出了第一个网页，这也奠定了我的美工“出身”。我的职业生涯中有 3.5 年的时间在做 UI 相关的工作，对于这份工作优势劣势，困境与难处有些自己的见解。</p><p style=\"margin-top: 0px; color: rgb(63, 63, 63); font-family: &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;; font-size: 16px; text-align: justify; background-color: rgb(255, 255, 255);\">最近几年，在各种 JS 框架风生水起的大环境下，更是没有太多人愿意关注 UI 方面的东西，关注前端行业里这些对像素有特殊偏好的人了。我自己也有这样的趋势，当接触了更全面的研发流程之后，就很难保持对 UI 细节以及曾经追求的极致用户体验的关注度了。这或许也恰恰说明，对于某些类型的产品或某些阶段的产品来说，UI 细节没那么重要。而对于重视用户体验的用户体验设计部来说，隶属于设计部的编码人员也较难受到重视和提拔。</p><p style=\"margin-top: 0px; color: rgb(63, 63, 63); font-family: &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;; font-size: 16px; text-align: justify; background-color: rgb(255, 255, 255);\"><img src=\"http://localhost:8080/upload/image/20190626214652399.jpg\" style=\"max-width:100%;\"><br></p><p style=\"margin-top: 0px; color: rgb(63, 63, 63); font-family: &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;; font-size: 16px; text-align: justify; background-color: rgb(255, 255, 255);\">这就是 UI 工程师的困境。我会在 2 周之内产出一篇 5000 字以上的文章，来与你共同探讨 UI 工程的困境和可能的改变方向，以及如何走出第一步的问题。</p><p style=\"margin-top: 0px; color: rgb(63, 63, 63); font-family: &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;; font-size: 16px; text-align: justify; background-color: rgb(255, 255, 255);\"><span style=\"font-weight: 700;\">实录提要：</span></p><ul style=\"margin-top: 0px; color: rgb(63, 63, 63); font-family: &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;; font-size: 16px; text-align: justify; background-color: rgb(255, 255, 255);\"><li>前端的发展太快了，应该怎么去追求深度学习而不是一味追求广度？</li><li>当讨论前端 UI 工程师困境的时候，会立足以个体为主，还是以这个岗位群体为主？</li><li>这次 512 的比特币勒索病毒会不会对前端浏览器兼容产生影响？</li><li>怎么更好的学习应用基础布局及响应式布局？</li><li>样式表现有问题如何调试？需要根据某些浏览器 hack，具体处理时除了经验还有什么好办法？</li><li>后端开发者需要掌握哪些前端知识或技能？</li><li>公司或者 leader 应该如何衡量一个偏科前端的价值呢？有比较合理的衡量标准吗？</li><li>国内外 UI 方面有何差距？如何判断一套 UI 系统/框架的优劣？</li><li>如何根据自身情况来针对某些东西做总结或计划？</li><li>美的开发团队的工作方式是什么？</li></ul>', 1, '2019-06-26 00:00:00', 0, 'http://localhost:8080/upload/image/20190626214652399.jpg', '前端 UI 工程师的困境与破局<p style=\"');
INSERT INTO `article` VALUES (47, 3, 'weewqwqeweq', '<p><img src=\"http://localhost:8080/upload/image/20190627094838145.jpg\" style=\"max-width:100%;\"><br></p><p>weqeqwwe</p>', 1, '2019-06-27 00:00:00', 0, 'http://localhost:8080/upload/image/20190627094838145.jpg', 'weewqwqeweq<p><img sr');
INSERT INTO `article` VALUES (48, 5, 'qiqiqiqiqiqiq', '<p><img src=\"http://localhost:8080/upload/image/20190627150454381.jpg\" style=\"max-width:100%;\"><br></p><p>11sdafkcbjajabcjjc</p><p>jbasbfbjasbjsbj</p><p>asjbbdjsadbsjkadas</p><p>sadjbasbjsjbkasj</p><p>sjbakddbsjdsjbkdsajb</p>', 1, '2019-06-27 00:00:00', 0, 'http://localhost:8080/upload/image/20190627150454381.jpg', 'qiqiqiqiqiqiq<p><img sr');
INSERT INTO `article` VALUES (49, 3, '2133221313', '<p>213333333333ewrrrrrrrrrrrrrrrrr</p><p>gfffffffffffffffffff</p><p>fggggggggggd</p><p>fggggggggggggd<img src=\"http://localhost:8080/upload/image/20190627154845394.jpg\" style=\"max-width: 100%;\"></p><p>qweeeeeeeeeeeee</p><p>qweeeeeeeeeee</p><p>qewwwwwwwwwww</p><p>qweeeeeeeee</p><p>qweeeeeee</p>', 8, '2019-06-27 00:00:00', 0, 'http://localhost:8080/upload/image/20190627154845394.jpg', '2133221313<p>2133333');
INSERT INTO `article` VALUES (50, 3, '2131223321', '<p style=\"text-align: center;\"><img src=\"http://localhost:8080/upload/image/20190627155019878.jpg\" style=\"max-width:100%;\"><br></p><p style=\"text-align: center;\">wqeee</p><p style=\"text-align: center;\">weqqweqew</p>', 8, '2019-06-27 00:00:00', 0, 'http://localhost:8080/upload/image/20190627155019878.jpg', '2131223321<p style=\"');
INSERT INTO `article` VALUES (51, 4, 'wqeqwew', '<p>qweeeeeeeeeeeeeeeeeeee</p><p>wqeeeeeeeeeeeeeeee</p>', 8, '2019-06-27 00:00:00', 0, NULL, 'wqeqwew<p>qweeeee');
INSERT INTO `article` VALUES (52, 5, '121232', '<p><img src=\"http://localhost:8080/upload/image/20190701095331093.jpg\" style=\"max-width:100%;\"><br></p><p>jsfjndjnjdvkjdvjs</p><p>jkskfdjdsjksvjvb</p><p><br></p><p><br></p><p>dvjskvsdjkdbdvjbkdv</p><p>dsjvdjvdjbdsjk</p><p>vdnsvdvdjsk<img src=\"http://localhost:8080/upload/image/20190701095347479.jpg\" style=\"max-width: 100%;\"></p>', 8, '2019-07-01 00:00:00', 0, 'http://localhost:8080/upload/image/20190701095331093.jpg', '121232<p><img sr');
INSERT INTO `article` VALUES (53, 4, '123qweqewwe', '<p><img src=\"http://localhost:8080/upload/image/20190701100033894.jpg\" style=\"max-width:100%;\"><br></p><p>21332121321231223</p><p>23122222321232</p>', 8, '2019-07-01 00:00:00', 0, 'http://localhost:8080/upload/image/20190701100033894.jpg', '123qweqewwe<p><img sr');

-- ----------------------------
-- Table structure for article_tag
-- ----------------------------
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag`  (
  `article_tag_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '连接两个表的主键id',
  `article_id` int(11) UNSIGNED NOT NULL COMMENT '文章id',
  `tag_id` int(11) UNSIGNED NOT NULL COMMENT '标签外键',
  PRIMARY KEY (`article_tag_id`) USING BTREE,
  INDEX `tag_id`(`tag_id`) USING BTREE,
  INDEX `article_tag_ibfk_2`(`article_id`) USING BTREE,
  CONSTRAINT `article_tag_ibfk_1` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `article_tag_ibfk_2` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_tag
-- ----------------------------
INSERT INTO `article_tag` VALUES (1, 1, 2);
INSERT INTO `article_tag` VALUES (2, 1, 5);
INSERT INTO `article_tag` VALUES (3, 2, 2);
INSERT INTO `article_tag` VALUES (4, 2, 5);
INSERT INTO `article_tag` VALUES (5, 29, 2);
INSERT INTO `article_tag` VALUES (6, 32, 5);
INSERT INTO `article_tag` VALUES (7, 32, 10);
INSERT INTO `article_tag` VALUES (8, 32, 15);
INSERT INTO `article_tag` VALUES (9, 33, 5);
INSERT INTO `article_tag` VALUES (10, 33, 10);
INSERT INTO `article_tag` VALUES (11, 33, 15);
INSERT INTO `article_tag` VALUES (12, 34, 2);
INSERT INTO `article_tag` VALUES (13, 35, 2);
INSERT INTO `article_tag` VALUES (14, 36, 2);
INSERT INTO `article_tag` VALUES (15, 37, 2);
INSERT INTO `article_tag` VALUES (16, 38, 2);
INSERT INTO `article_tag` VALUES (17, 39, 2);
INSERT INTO `article_tag` VALUES (18, 40, 4);
INSERT INTO `article_tag` VALUES (19, 40, 9);
INSERT INTO `article_tag` VALUES (20, 40, 14);
INSERT INTO `article_tag` VALUES (21, 41, 5);
INSERT INTO `article_tag` VALUES (22, 41, 10);
INSERT INTO `article_tag` VALUES (23, 41, 12);
INSERT INTO `article_tag` VALUES (24, 41, 17);
INSERT INTO `article_tag` VALUES (25, 2, 6);
INSERT INTO `article_tag` VALUES (26, 43, 6);
INSERT INTO `article_tag` VALUES (27, 43, 9);
INSERT INTO `article_tag` VALUES (28, 44, 17);
INSERT INTO `article_tag` VALUES (29, 44, 22);
INSERT INTO `article_tag` VALUES (30, 45, 4);
INSERT INTO `article_tag` VALUES (31, 45, 8);
INSERT INTO `article_tag` VALUES (32, 45, 9);
INSERT INTO `article_tag` VALUES (33, 45, 10);
INSERT INTO `article_tag` VALUES (34, 45, 18);
INSERT INTO `article_tag` VALUES (35, 46, 4);
INSERT INTO `article_tag` VALUES (36, 46, 8);
INSERT INTO `article_tag` VALUES (37, 46, 9);
INSERT INTO `article_tag` VALUES (38, 46, 10);
INSERT INTO `article_tag` VALUES (39, 46, 18);
INSERT INTO `article_tag` VALUES (40, 47, 4);
INSERT INTO `article_tag` VALUES (41, 47, 9);
INSERT INTO `article_tag` VALUES (42, 48, 5);
INSERT INTO `article_tag` VALUES (43, 48, 10);
INSERT INTO `article_tag` VALUES (44, 48, 12);
INSERT INTO `article_tag` VALUES (45, 49, 5);
INSERT INTO `article_tag` VALUES (46, 49, 10);
INSERT INTO `article_tag` VALUES (47, 49, 21);
INSERT INTO `article_tag` VALUES (48, 50, 13);
INSERT INTO `article_tag` VALUES (49, 50, 18);
INSERT INTO `article_tag` VALUES (50, 51, 4);
INSERT INTO `article_tag` VALUES (51, 51, 9);
INSERT INTO `article_tag` VALUES (52, 52, 20);
INSERT INTO `article_tag` VALUES (53, 53, 19);
INSERT INTO `article_tag` VALUES (54, 53, 20);
INSERT INTO `article_tag` VALUES (55, 53, 21);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '类别id',
  `category_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类名称',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '产品动态');
INSERT INTO `category` VALUES (2, '客户案例');
INSERT INTO `category` VALUES (3, '数据分析方法');
INSERT INTO `category` VALUES (4, '市场活动');
INSERT INTO `category` VALUES (5, '资料下载');

-- ----------------------------
-- Table structure for issue
-- ----------------------------
DROP TABLE IF EXISTS `issue`;
CREATE TABLE `issue`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '评论的id号',
  `user_id` int(11) UNSIGNED NOT NULL COMMENT '评论的用户id号',
  `article_id` int(11) UNSIGNED NOT NULL COMMENT '文章的id号码',
  `content` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论的内容',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `article_id`(`article_id`) USING BTREE,
  CONSTRAINT `issue_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `issue_ibfk_2` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of issue
-- ----------------------------
INSERT INTO `issue` VALUES (1, 1, 1, '我是你大爷');
INSERT INTO `issue` VALUES (2, 1, 1, '我去你大爷的');
INSERT INTO `issue` VALUES (3, 1, 1, '你奶奶个锤子的');
INSERT INTO `issue` VALUES (4, 1, 1, '我去你大爷的');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `tag_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '标签编号',
  `tag_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名',
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (2, 'APP运营');
INSERT INTO `tag` VALUES (4, '互联网金融');
INSERT INTO `tag` VALUES (5, '转化漏斗');
INSERT INTO `tag` VALUES (6, '大数据');
INSERT INTO `tag` VALUES (7, '精确营销');
INSERT INTO `tag` VALUES (8, '产品运营');
INSERT INTO `tag` VALUES (9, '产品经理');
INSERT INTO `tag` VALUES (10, '数据分析');
INSERT INTO `tag` VALUES (11, '电商');
INSERT INTO `tag` VALUES (12, '精细化运营');
INSERT INTO `tag` VALUES (13, 'argo');
INSERT INTO `tag` VALUES (14, '用户增长');
INSERT INTO `tag` VALUES (15, '用户运营');
INSERT INTO `tag` VALUES (16, '数据驱动');
INSERT INTO `tag` VALUES (17, '智能路径');
INSERT INTO `tag` VALUES (18, '开发者沙龙');
INSERT INTO `tag` VALUES (19, '用户画像');
INSERT INTO `tag` VALUES (20, '用户召回');
INSERT INTO `tag` VALUES (21, '用户体验');
INSERT INTO `tag` VALUES (22, '平台运营');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户的电话号码',
  `email` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户的邮箱',
  `grant_level` int(11) NOT NULL COMMENT '用户的权限，1是普通用户，2是管理员',
  `create_time` date NOT NULL COMMENT '用户的注册时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '陈波', 'ad031a3faee1bf9e498d0267936f41b9', '15164792853', '1136637924@qq.com', 1, '2019-06-11');
INSERT INTO `user` VALUES (2, '陈小宝', '81737e04bb512985eafd824441e244bc', '15197587253', '1354957@qq.com', 0, '2019-06-10');
INSERT INTO `user` VALUES (4, 'ces2', 'ad031a3faee1bf9e498d0267936f41b9', '15127587254', '25549897@qq.com', 1, '2019-06-10');
INSERT INTO `user` VALUES (8, '范鹏', '0976b7b91ca5e39a21d1a32dc780c3ba', '18174429647', '438123081@qq.com', 1, '2019-06-27');
INSERT INTO `user` VALUES (9, '123456', '96e79218965eb72c92a549dd5a330112', '18111111113', '212321112@qq.com', 1, '2019-06-27');

SET FOREIGN_KEY_CHECKS = 1;
