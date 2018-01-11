# 服务注册与发现（Eureka）

使用Spring Cloud Eureka来实现服务治理。

## 创建“服务注册中心”
在原有项目基础上创建一个子模块，命名为eureka-server，并在pom.xml中引入需要的依赖内容：
```
<parent>
    <artifactId>kedacom</artifactId>
    <groupId>com.github.mahui53541.kedacom</groupId>
    <version>1.2</version>
</parent>
<modelVersion>4.0.0</modelVersion>

<artifactId>eureka-server</artifactId>

<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-eureka-server</artifactId>
    </dependency>
</dependencies>

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Edgware.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```
通过`@EnableEurekaServer`注解启动一个服务注册中心提供给其他应用进行对话。

```java
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
```
增加配置文件`application.yml`,并加入如下配置

```
spring:
  application:
    name: eureka-server

#端口号
server:
  port: 8761

#在默认设置下，该服务注册中心也会将自己作为客户端来尝试注册它自己，所以我们需要禁用它的客户端注册行为
eureka:
  client:
    fetch-registry: false
    register-with-eureka: false
```
启动工程后，访问：http://localhost:8761/，可以看到下面的页面，其中还没有发现任何服务。
![](/doc/img/eureka.png)

## 创建“服务提供方”

下面我们创建提供服务的客户端，并向服务注册中心注册自己。
首先，创建一个子模块。命名为eureka-client，在pom.xml中，加入如下配置：

```
<parent>
    <artifactId>kedacom</artifactId>
    <groupId>com.github.mahui53541.kedacom</groupId>
    <version>1.2</version>
</parent>
<modelVersion>4.0.0</modelVersion>

<artifactId>eureka-client</artifactId>

<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-eureka</artifactId>
    </dependency>
</dependencies>

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Edgware.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```
在配置文件application.yml加入如下配置

```
spring:
  application:
    name: shop
server:
  port: 9001
#指定服务注册中心的位置
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

在web模块中引入该模块，并在主类中加入`@EnableDiscoveryClient`注解，启动web项目
再次访问：http://localhost:8761/。可以如下图内容，我们定义的服务被成功注册了。
![](/doc/img/eureka2.png)

## 参考自
[Spring Cloud构建微服务架构：服务注册与发现（Eureka、Consul）](https://www.jianshu.com/p/7a96dae18901)