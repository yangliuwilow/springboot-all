package com.mongo;

import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ZookeeperTests {

    private  ZooKeeper zkClient=null;

    @Before
    public void init() throws IOException {

        
        zkClient=new ZooKeeper("192.168.0.103:2181", 2000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }


    @Test
    public void createNode(){
        try {
            zkClient.create("/yangliu","I love you".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
