# Spring Boot实践

## 目标

**掌握基于Spring Boot的微服务开发**

## 项目内容

**实现电商应用基础服务，包括用户服务，商品服务，订单服务**

**功能包括用户注册，用户鉴权，商品列表，商品详情，下单，查看订单列表，订单详情**

## 项目结构

![](/doc/img/structure.png)

## 架构

**SpringBoot+Spring Data JPA+SpringSecurity+zuul+thymeleaf+MySQL**

## 达成目标:

  - 1.使用`Spring Boot`, `Spring JPA`实现底层服务的CRUD
  - 2.单元测试，API测试
  - 3.符合`RESTFUL API`规范
  - 4.安全验证（`Spring Security`），服务器端保存用户会话session
  - 5.实现服务网关组件(`zuul`)
  - 6.实现服务的高可用
## V1.0 版本说明

* 前后端未分离，页面使用[thymeleaf](http://www.thymeleaf.org/) 模板引擎（不推荐JSP,就连Spring Boot 官方都嫌弃了）； 
* 采用有状态的会话，用户登陆后，用户信息保存在服务器端；
* 使用实现服务网关组件(`zuul`)

## 详细配置
- [整合Spring Security](SpringSecurity.md)
- [整合服务网关Zuul](Zuul.md)
## 项目启动

首先启动web项目（项目主入口），项目启动在8090端口;接着启动服务网关组件gateway,项目启动在8080端口，访问`http://localhost:8080/shop`即可演示项目