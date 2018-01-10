package com.github.mahui53541.kedacom.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:服务消费组件
 * @author: MaHui
 * @created: 2018/1/10 15:38
 * @version:1.0.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
