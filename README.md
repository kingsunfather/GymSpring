# GymSpringboot

使用 springboot 实现 gym

# 组员

-   刘如日 16301157
-   龙灏天 16301158

# 项目说明

1. jpa_demo 是 springboot 工程文件的根目录
2. JDBC 连接 Mysql 的用户名为 root，密码为 123456，详情请见 yaml 配置文件
3. 运行环境是 Java8，IDE 使用 Intellij，需要在 Intellij 里面下载 lombok 插件
4. 启动的时候会自动在 Mysql 数据库生成表，两个数据源的名称分别为 spring_study 与 spring_study2，因为在 yaml 配置里面写了 jpa.properties.hibernate.hbm2ddl.auto=update
5. 在用户登录成功的时候会自动向数据库插入测试数据

<!-- TOC -->

# 第一次作业说明

-   [1.基础要求](#1基础要求)
    -   [1.1 数据库设计](#11数据库设计)
    -   [1.2 UML 设计类图](#12UML设计类图)
    -   [1.3 系统功能](#13系统功能)
-   [2.JPA 细化要求](#2JPA细化要求)
    -   [2.1 多表联查](#21多表联查)
    -   [2.2 多数据库源 DruiDB](#22多数据库源DruiDB)
    -   [2.3 分页查询](#23分页查询)
    -   [2.4 审计](#24审计)
-   [3.Cache 细化要求](#3Cache细化要求)
    -   [3.1 实现缓存加速功能](#31实现缓存加速功能)
    -   [3.2 浏览器协商缓存功能](#32浏览器协商缓存功能)
-   [4.Thymeleaf 构建页面](#4Thymeleaf构建页面)
-   [5.集成 Swagger 文档](#5集成Swagger文档)
      <!-- /TOC -->

## 1基础要求

### 1.1数据库设计

![](/docImage/GymSpringERModel.png)

总共有三个实体分别为 Gym User Trainer

-   Gym 和 User 的关系为 manyToMany
-   Gym 和 Trainer 的关系为 OneToMany
-   Trainer 和 Gym 的关系为 ManyToOne

数据库表结构为

-   USER(**ID**,AGE,CREATE_AT,MOBILE,NAME,PASSWORD,SEX,SEX,UPDATE_AT)
-   GYM（**ID**,LOCATION,CREATE_AT,NAME,UPDATE_AT,PHONE）
-   USER_GYM(**USER_ID**,**GYM_ID**)
-   TRAINER（**ID**,AGE,CREATE_AT,HEADPIC,INTRODUCTION,NAME,PHONE,UPDATE_AT,GYM_ID）

### 1.2UML设计类图

**Controller 设计**
controller 只负责 View 层的操作，负责处理 Http 的 Request 与 Response  
![](/docImage/controllerDesign.png) . 

**Service 设计**
所有的业务逻辑都写在 Service(接口，ServiceImp（实现）)层里面  
![](/docImage/serviceDesign.png) . 

**Repository 设计**
继承 Jpa 的 Repo，根据需求重写一些方法
![](/docImage/repoDesign.png) . 

### 1.3系统功能

-   登陆 -
    ![](/docImage/loginPage.png) . 
    点击网址可以进入登陆页面，有两个输入框，分别输入账号(注册完账户后会自动跳转到登录界面并分配用户 id)，输入密码即可以登陆。
-   注册 -
    ![](/docImage/registerPage.png) . 
    在密码输入框下方有一个“注册”小字，用户点击即可以弹出注册的悬浮框，用户填写相关信息后即可以成功注册，注册完账户后会自动跳转到登录界面并分配用户 id。
-   查看体育馆信息 -
    ![](/docImage/mainPage.png) . 
    点击登陆按钮后就会跳转到主页，显示用户在注册的时候所填写的信息，右侧有个课程列表是用户所订阅的课程的简要信息。

## 2.JPA细化要求

### 2.1多表联查

-   多表联查主要体现在 Gym 实体与其他实体之间

-   gym 实体实现 trainer 与 gym 为 ManyToOne

![](/docImage/gym_trainer.png) . 

![](/docImage/trainer_gym.png) . 

-   user 实体实现 gym 与 user 为 ManyToMany

![](/docImage/gym_user.png) . 

![](/docImage/user_gym.png) . 

### 2.2多数据库源 DruiDB

使用两个基于 MySQL 的数据库源 application.yaml 配置如下

    spring:
      datasource:
        primary:
          url: jdbc:mysql://localhost:3306/spring_study?useSSL=false
          username: root
          password: 123456
          driver-class-name: com.mysql.jdbc.Driver


        secondary:
          url: jdbc:mysql://localhost:3306/spring_study2?useSSL=false
          username: root
          password: 123456
          driver-class-name: com.mysql.jdbc.Driver
        platform: mysql

并且在配置文件中配置相应启动项

![](docImage/mutil_datasource.png)

### 2.3分页查询

api 设计时候加入 pageSize 和 pageNum 选项

    @PostMapping("/gym/{pageSize}/{pageNum}")
    public JSONObject findAll(@PathVariable Integer pageSize,@PathVariable Integer pageNum){
            System.out.println("pageSize: " + pageSize);
            System.out.println("pageNum: " + pageNum);
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(pageNum, pageSize, sort);
            return gymService.findAll(pageable);

使用 Postman 测试的结果如下

![](docImage/postmanTestPageQuery.png)

### 2.4审计

-   使用了 JPA 的审计功能，通过注解，此功能可以自动记录数据库每条记录创建和修改的时间戳。

## 3.Cache细化要求

### 3.1实现缓存加速功能

-   查看体育馆详情
    在函数前添加注解

```java
    @GetMapping("/gym/all")
    @Cacheable(key = "targetClass + methodName")
    public JSONObject getAllGym(){
    JSONObject res=new JSONObject();
    res.put("data",gymService.getallGym());
    return res;
    }
```

### 3.2浏览器协商缓存功能

-   查看体育馆列表

通过修改返回的结果值为`ResponseEntity<>`类，可以对 RESTFul 的接口的返回形式进行细粒度的调整。

在返回的时候，使用如下方式开启强制缓存：

```java
JSONObject res = new JSONObject();
res.put("data", gymService.getallGym());
// 额外增加CacheControl头部，开启强缓存
return ResponseEntity.ok().cacheControl(CacheControl.maxAge(86400, TimeUnit.SECONDS)).body(res);
```

完成设置后，浏览器将缓存该数据一天。

在浏览器请求的时候，服务器返回的 Header 中将带有以下头域：

```text

Cache-Control: max-age=86400

```

## 4.使用thymeleaf构建页面

## 5.集成Swagger文档

使用 swagger 生成 restful 接口界面，默认的 api 界面地址在http://localhost:8080/swagger-ui.html#/
