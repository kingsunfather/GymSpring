# 第四次作业说明

<!-- TOC -->

-   [1. Basic](#1-basic)
    -   [1.1 WebFlux结构设计](#11-WebFlux结构设计)
    -   [1.2 数据库设计](#12-数据库设计)
    -   [1.3 系统功能](#13-系统功能)
    -   [1.4 设计类图](#14-设计类图)
    -   [1.5 RestFul接口](#14-restful接口设计)
-   [2. Persisting data reactively](#2-持久化数据集成)
    -   [2.1 添加依赖](#21-添加依赖)
    -   [2.2 Repo的构建](#22-Repo的构建)
-   [3. Oauth集成](#3-oauth集成)
-   [4. postman测试截图](#4-postman测试截图)

<!-- /TOC -->

## 1. Basic

### 1.1 WebFlux结构设计

![](/docImage/WebFlux.png)

### 1.2 数据库设计

![](/docImage/GymSpringERModel.png)

总共有三个实体分别为 Gym User Trainer

### 1.3 系统功能

1.3.1实现User与Trainer与Gym的 增删改查

### 1.4 设计类图

**Handler 设计**
handler 负责 View 层的操作，负责处理 Http 的 Request 与 Response  
![](/docImage/handlerDesign.png) . 

**Router 设计**
三个Router类里面分别增加了三个router bean的实例
![](/docImage/routerDesign.png) . 

**Service 设计**
所有的业务逻辑都写在 Service(接口，ServiceImp（实现）)层里面  
![](/docImage/serviceDesignWebFlux.png) . 

**Repository 设计**
继承 ReactiveMongoRepository
![](/docImage/repoDesignWebFlux.png) . 

### 1.5 restful接口设计
![](/docImage/RestfulAPIWebFlux1.png) . 
![](/docImage/RestfulAPIWebFlux2.png) . 
![](/docImage/RestfulAPIWebFlux3.png) . 



## 2. 持久化数据集成


### 2.1 添加依赖
在pom.xml里面加入对内存形的MongoDB支持
    <dependency>
          <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>

在项目里面增加MongoDB的配置

spring.data.mongodb.uri=mongodb://name:pass@localhost:27017/dbname

### 2.2 Repo的构建
实体的Repo继承 ReactiveMongoRepository

## 3. oauth集成

+ 对Trainer进行Token验证，如果用户没有从Oauth服务器获得Token，那么将无法访问资源；Oauth服务器的实现在文件夹/oauth下面

## 4. postman测试截图
通过Postman先向GymRouter里面的/gym发送请求，增加一个gym，服务器收到如下图
![](/docImage/user_get.png) 

然后通过Postman再向GymRouter里面的/gyms进行查询，放回的消息如下
![](/docImage/user_add.png) 

