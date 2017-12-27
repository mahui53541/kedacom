package com.github.mahui53541.kedacom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

/**
 * @description:
 * @author: MaHui
 * @created: 2017/12/25 16:55
 * @version:1.0.0
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableDiscoveryClient
public class SampleTomcatJspApplication extends SpringBootServletInitializer{

    private static final Logger logger = LoggerFactory
            .getLogger(SampleTomcatJspApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SampleTomcatJspApplication.class);
    }


    @PostConstruct
    public void logSomething() {
        logger.debug("Sample Debug Message");
        logger.trace("Sample Trace Message");
    }
    public static void main(String[] args) {
        SpringApplication.run(SampleTomcatJspApplication.class, args);
    }
}
