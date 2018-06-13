package com.willow;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class SpringbootActuatorAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootActuatorAdminApplication.class, args);
    }



     /*
      第一步：服务端添加POM
     <!-- 服务端：带UI界面 -->
        <dependency>
            <groupId>de.codecentric</groupId>
            <artifactId>spring-boot-admin-starter-server</artifactId>
            <version>1.5.7</version>
        </dependency>
     第二步：添加@EnableAdminServer

     第三步：客户端添加
        <!-- 客户端包 -->
       <!-- <dependency>
            <groupId>de.codecentric</groupId>
            <artifactId>spring-boot-admin-starter-client</artifactId>
            <version>2.0.1-SNAPSHOT</version>
        </dependency> -->

     第四步：客户端添加配置
     spring.boot.admin.url= http://localhost:8080
     management.security.enabled= false

     第五步：访问http://localhost:8080/

    */


}
