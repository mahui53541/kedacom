# 服务消费组件（Feign）

使用Spring Cloud Feign来实现服务消费。

## Spring Cloud Feign

Spring Cloud Feign是一套基于Netflix Feign实现的声明式服务调用客户端。
它使得编写Web服务客户端变得更加简单。
我们只需要通过创建接口并用注解来配置它既可完成对Web服务接口的绑定。
它具备可插拔的注解支持，包括Feign注解、JAX-RS注解。它也支持可插拔的编码器和解码器。
Spring Cloud Feign还扩展了对Spring MVC注解的支持，
同时还整合了Ribbon和Eureka来提供均衡负载的HTTP客户端实现。


## 创建“服务消费”

- 在原有项目基础上创建一个独立子模块，命名为eureka-consumer，并在pom.xml中引入需要的依赖内容：
```
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-feign</artifactId>
        </dependency>
    </dependencies>
```

- 修改应用主类。通过@EnableFeignClients注解开启扫描Spring Cloud Feign客户端的功能：

```java
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
```
- 增加配置文件`application.yml`,并加入如下配置

```
spring:
  application:
    name: eureka-consumer
server:
  port: 9100
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

- 创建一个Feign客户端接口（以登录为例）。
使用@FeignClient注解来指定这个接口所要调用的服务名称，
接口中定义的各个函数使用Spring MVC的注解就可以来绑定服务提供方的REST接口，
比如下面就是绑定shop服务的/auth/login接口：

```java
@FeignClient("shop")
public interface AuthClient {

    /**
     * 登录
     * @param authenticationRequest
     * @return
     */
    @PostMapping("/auth/login")
    JsonNode createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest);

    /**
     * 用户注册
     * @return
     */
    @PostMapping("/auth/register")
    JsonNode doRegister(@RequestBody UserVO user);

}
```
- 新建AuthController。通过定义的Feign客户端来调用服务提供方的接口：

```java
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthClient authClient;
    /**
     * 登录
     * @param authenticationRequest
     * @return
     */
    @PostMapping(value = "/login")
    JsonNode createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest){
        return authClient.createAuthenticationToken(authenticationRequest);
    }

    /**
     * 用户注册
     * @return
     */
    @PostMapping("/register")
    JsonNode doRegister(@RequestBody UserVO user){
        return authClient.doRegister(user);
    }
}

```
## 参考自
[Spring Cloud构建微服务架构：服务消费（Feign）【Dalston版】](https://www.jianshu.com/p/4070dd376978)