## mysql-sharding-jdbc
```yaml
spring:
  application:
    name: mysql-sharding-jdbc
  # 配置真实数据源
  shardingsphere:
    datasource:
      names: ds-master-0,ds-master-1
      # 配置第1个数据源
      ds-master-0:
        # 数据库连接池类名称
        type: com.zaxxer.hikari.HikariDataSource
        driver-class-name: com.mysql.cj.jdbc.Driver
        # 数据库url连接
        jdbcUrl: jdbc:mysql://localhost:3306/sharding-test1?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai
        #数据库用户名
        username: root
        # 数据库密码
        password: root
        hikari:
          minimum-idle: 5
          max-lifetime: 1800000
          maximum-pool-size: 15
          auto-commit: true
          idle-timeout: 30000
          pool-name: DatebookHikariCP
          connection-timeout: 30000
      # 配置第2个数据源
      ds-master-1:
        # 数据库连接池类名称
        type: com.zaxxer.hikari.HikariDataSource
        driver-class-name: com.mysql.cj.jdbc.Driver
        # 数据库url连接
        jdbcUrl: jdbc:mysql://localhost:3306/sharding-test2?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai
        #数据库用户名
        username: root
        # 数据库密码
        password: root
        hikari:
          minimum-idle: 5
          max-lifetime: 1800000
          maximum-pool-size: 15
          auto-commit: true
          idle-timeout: 30000
          pool-name: DatebookHikariCP
          connection-timeout: 30000
    # 配置 user 表规则
    sharding:
      tables:
        test_user:
          actual-data-nodes: ds-master-$->{0..1}.test_user_$->{0..1}
          # 配置分表策略 主键取模 0在0表 1在1表
          table-strategy:
            inline:
              #分片列名称
              sharding-column: id
              #分片算法行表达式
              algorithm-expression: test_user_$->{id % 2}
          # 主键策略 雪花算法
          key-generator:
            column: id
            type: SNOWFLAKE
      # 配置分库策略 主键取模0在0库 1在1库
      default-database-strategy:
        inline:
          sharding-column: id
          #分片算法行表达式
          algorithm-expression: ds-master-$->{id % 2}
    # 打开sql控制台输出日志
    props:
      sql:
        show: true

  jpa:
    hibernate:
      ddl-auto: none
    show-sql: true
```
