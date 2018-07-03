package com.willow.web;

import com.willow.config.StockJobConfig;
import com.willow.config.StockSimpleJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ElasticJobController {

    @Autowired
    StockJobConfig stockJobConfig;

    @Autowired
    StockSimpleJob stockSimpleJob;

    @RequestMapping("/addJob")
    @ResponseBody
    public String add (final StockSimpleJob stockSimpleJob,
                       @Value("${stockJob.cron}") final String cron,
                       @Value("${stockJob.shardingTotalCount}") final int shardingTotalCount,
                       @Value("${stockJob.shardingItemParameters}") final String shardingItemParameters){
        stockJobConfig.addSimpleJobScheduler(stockSimpleJob.getClass(),cron,shardingTotalCount,shardingItemParameters);
        return "add job ok";
    }
}
