# GymSpringboot

使用 springboot 实现 gym

# 组员

- 刘如日 16301157
- 龙灏天 16301158

# 项目说明

1. jpa_demo 是 springboot 工程文件的根目录
2. JDBC 连接 Mysql 的用户名为 root，密码为 123456，详情请见 yaml 配置文件
3. 运行环境是 Java8，IDE 使用 Intellij，需要在 Intellij 里面下载 lombok 插件
4. 启动的时候会自动在 Mysql 数据库生成表，两个数据源的名称分别为 spring_study 与 spring_study2，因为在 yaml 配置里面写了 jpa.properties.hibernate.hbm2ddl.auto=update
5. 在用户登录成功的时候会自动向数据库插入测试数据
6. Oauth 服务器在 oauth 文件夹下面

## 作业报告

- [第一次报告](report1.md)
- [第二次报告](report2.md)
- [第三次报告](report3.md)
