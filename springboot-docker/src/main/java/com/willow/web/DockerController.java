package com.willow.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "hello my docker "+name;
    }
}
