/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50151
Source Host           : 127.0.0.1:3306
Source Database       : pasystem

Target Server Type    : MYSQL
Target Server Version : 50151
File Encoding         : 65001

Date: 2014-09-26 14:41:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(50) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

Maven最佳实践：划分模块    请参考http://juvenshun.iteye.com/blog/305865

所有用Maven管理的真实的项目都应该是分模块的，每个模块都对应着一个pom.xml。
它们之间通过继承和聚合（也称作多模块，multi-module）相互关联。
那么，为什么要这么做呢？我们明明在开发一个项目，划分模块后，导入Eclipse变成了N个项目，这会带来复杂度，给开发带来不便。
 
为了解释原因，假设有这样一个项目，很常见的Java Web应用。在这个应用中，我们分了几层：
Dao层负责数据库交互，封装了Hibernate交互的类。
Service层处理业务逻辑，放一些Service接口和实现相关的Bean。
Web层负责与客户端交互，主要有一些Structs的Action类。
对应的，在一个项目中，我们会看到一些包名：

org.myorg.app.dao
org.myorg.app.service
org.myorg.app.web
org.myorg.app.util

这样整个项目的框架就清晰了，但随着项目的进行，你可能会遇到如下问题：
这个应用可能需要有一个前台和一个后台管理端（web或者swing），你发现大部分dao，一些service，
和大部分util是在两个应用中可。这样的问题，你一周内遇到了好几次。
pom.xml中的依赖列表越来越长以重用的，但是，由于目前只有一个项目（WAR），

你不得不新建一个项目依赖这个WAR，这变得非常的恶心，因为在Maven中配置对WAR的依赖远不如依赖JAR那样简单明了，
而且你根本不需要org.myorg.app.web。有人修改了dao，提交到svn并且不小心导致build失败了，你在编写service的代码，
发现编译不过，只能等那人把dao修复了，你才能继续进行，很多人都在修改，到后来你根本就不清楚哪个依赖是谁需要的，渐渐的，
很多不必要的依赖被引入。甚至出现了一个依赖有多个版本存在。

build整个项目的时间越来越长，尽管你只是一直在web层工作，但你不得不build整个项目。
某个模块，比如util，你只想让一些经验丰富的人来维护，可是，现在这种情况，每个开发者都能修改，这导致关键模块的代码质量不能达到你的要求。
我们会发现，其实这里实际上没有遵守一个设计模式原则：“高内聚，低耦合”。虽然我们通过包名划分了层次，并且你还会说，
这些包的依赖都是单向的，没有包的环依赖。这很好，但还不够，因为就构建层次来说，所有东西都被耦合在一起了。
因此我们需要使用Maven划分模块。
