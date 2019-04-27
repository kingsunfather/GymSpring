## GymSpringboot
使用springboot实现gym
## 文件夹说明
1. jpa_demo是springboot工程文件的根目录  
2. sqlFile是需要用到的Mysql数据库两个数据源的sql文件，两个数据源的名字分别是sql文件的名字
3. JDBC连接Mysql的用户名为root，密码为123456，详情请见yaml配置文件
4. 运行环境是Java8，IDE使用Intellij，需要在Intellij里面下载lombok插件
## 技术说明
1. 使用Jpa技术，实现多表查询，分页查询，配置druid多数据源
2. 使用Cache缓存
3. 使用thymeleaf构建页面
4. 使用swagger生成restful接口界面，默认的api界面地址在http://localhost:8080/swagger-ui.html#/  
