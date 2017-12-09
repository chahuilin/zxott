# 框架demo

集成了spring boot+mybatis，支持多数据源

加入了mybatis generator,可以自动生成持久层代码

加入spring boot 下单元测试方法

注解缓存demo

# 在项目中配置多套环境的配置方法

项目启动的时候也可以设置 
    
    Java -jar xxxxxx.jar --spring.profiles.actiove=production

也可以
直接修改application.yml文件中的

    spring:
      profiles:
          active: production
