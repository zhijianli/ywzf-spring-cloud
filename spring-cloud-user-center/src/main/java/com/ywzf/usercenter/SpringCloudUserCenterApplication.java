package com.ywzf.usercenter;

import com.ywzf.usercenter.util.StudentConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@EnableDiscoveryClient //注册发现
@EnableFeignClients(basePackages = {"com.ywzf.usercenter.client"}) //微服务调用
@RestController
@EnableScheduling  //启用后，会定时拉取配置
@EnableConfigurationProperties({StudentConfig.class})//动态配置
@SpringBootApplication
public class SpringCloudUserCenterApplication {


    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 获取所有服务
     */
    @RequestMapping("/services")
    public Object services() {
        return discoveryClient.getServices();
    }

    @RequestMapping("/home")
    public String home() {
        return "Hello World";
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringCloudUserCenterApplication.class, args);
    }

}
