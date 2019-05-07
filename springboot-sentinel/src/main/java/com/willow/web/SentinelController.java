package com.willow.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: hamer
 * @Date: 2019/5/7 17:42
 * @Description:
 */
@Controller
public class SentinelController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){

        return "hi ....";
    }
    @RequestMapping("/sentinel")
    @ResponseBody
    public String list(){

        return "list ....";
    }
}
