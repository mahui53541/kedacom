package com.github.mahui53541.kedacom.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description:服务注册中心
 * @author: MaHui
 * @created: 2018/1/10 14:47
 * @version:1.0.0
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
