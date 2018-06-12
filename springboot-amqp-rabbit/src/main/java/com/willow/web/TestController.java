package com.willow.web;

import com.willow.amqp.RabbitSend;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/amqp")
public class TestController {
    private Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    RabbitSend rabbitSend;

    @RequestMapping("/sendMsg")
    @ResponseBody
    public String send(String name) throws Exception {
        String context = "hello " + name + " --" + new Date();
        String sendStr;
        for (int i = 1; i <= 100; i++) {
            sendStr = "第[" + i + "]个 hello  --" + new Date();
            logger.debug("HelloSender: " + sendStr);
            rabbitSend.sendMessage("myqueue", sendStr);
        }
        return context;
    }


}