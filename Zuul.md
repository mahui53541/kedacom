# 整合Zuul
Zuul相关配置在gateway模块下

## 添加依赖
在pom.xml中添加如下配置，引入对Zuul的依赖
```
<dependencies>
    ...
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-zuul</artifactId>
    </dependency>
    ...
</dependencies>
```
## 修改配置文件

修改`web/src/main/resources/application.properties`添加如下配置:
```
spring.application.name=shop
server.port=8090
```
修改`gateway/src/main/resources/application.properties`加入如下配置:
```
zuul.routes.shop.url=http://localhost:8090

zuul.routes.shop.path=/**

#不过滤Cookie,Authorization，否则服务端接收不到Cookie，造成无法登陆
zuul.routes.shop.customSensitiveHeaders=true
zuul.routes.shop.sensitiveHeaders={Cookie,Authorization}

server.port=8080
```
- Spring Cloud Netflix Zuul使用Netflix的Ribbon执行客户端负载均衡，默认情况下，
Ribbon将使用Netflix Eureka进行服务发现。但目前项目中未使用Eureka组件，
所以设置`ribbon.eureka.enabled`为`false`
- 由于加入Zuul过滤器会默认过滤请求Header中的Cookie等字段，造成登录无效，所以配置不过滤的字段

## 添加自定义过滤器

Zuul有四种标准的过滤器类型：

- pre filters:在路由请求之前执行预过滤器,

- route filters:处理请求的实际路由,

- post filters: 在请求被路由后执行

- error filters:如果在处理请求的过程中发生错误，则执行

新建SimpleFilter.java类

```java
public class SimpleFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);

    //返回过滤器类型
    @Override
    public String filterType() {
        return "pre";
    }

    //返回这个过滤器相对于其他过滤器的执行顺序。
    @Override
    public int filterOrder() {
        return 0;
    }

    //返回确定何时执行此过滤器的逻辑（此处过滤器将始终执行）
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器的功能实现
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("accessToken");
//        if(accessToken == null) {
//            log.warn("access token is empty");
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            return null;
//        }
        log.info("access token ok");
        return null;
    }
}
```

## 新建启动文件

```java
@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(GatewayApplication.class, args);
  }

  @Bean
  public SimpleFilter simpleFilter() {
    return new SimpleFilter();
  }

}
```