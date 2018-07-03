package com.willow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootWebApplication {

    //运行方式
    // D:\study\springboot-all\springboot-web\target>java -jar springboot-web-0.0.1-SNAPSHOT.war
    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebApplication.class, args);
    }


}
