package com.ywzf.ainurse;

import com.ywzf.ainurse.util.StudentConfig;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;

@EnableDiscoveryClient //注册发现
@EnableFeignClients(basePackages = {"com.ywzf.ainurse.client"}) //微服务调用
@RestController
@EnableScheduling  //启用后，会定时拉取配置
@EnableConfigurationProperties({StudentConfig.class})//动态配置
@SpringBootApplication
public class SpringCloudAiNurseApplication {


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

//        Double dd = new Double("1591162791199");
//        String result = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dd);
//        try {
//
//
//        System.out.println("13位数的时间戳（毫秒）------------------->Date:" +  (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse("2020-01-01 00:00:00").getTime());
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        SpringApplication.run(SpringCloudAiNurseApplication.class, args);
    }

}
