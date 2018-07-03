package com.willow;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by xx on 2017/4/26.
 */
@Controller
public class HelloController {



    @RequestMapping("/he")
    public String say(String name){
        return "hello";
    }
}
