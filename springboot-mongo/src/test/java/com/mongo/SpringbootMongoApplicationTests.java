package com.mongo;

import com.mongo.entity.User;
import com.mongo.service.DeptRepository;
import com.mongo.service.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMongoApplicationTests {
    @Autowired
    private UserRepository userRepository;


    /**
     * 保存
     * saveOrUpdate 方法更新一个已存在的文件或者插入一条数据,取决于一个文件中的一个字段。如果一个文件中不包含一个id，
     * 然后save（）方法直接调用insert（）方法和生成一个id；如果包含id就直接更新。
     */
    @Test
    public void save() {
        for(int i=0;i<100;i++) {
            User user = new User();
            user.setName("willow"+i);
            user.setPassword("123qwe");
            user.setRoleId(123L);
            user = userRepository.save(user);
            System.out.println("");
        }
    }

    /**
     * 删除
     */
    @Test
    public void mongoDelete() {
         String id="5d7c31b769304455280bb60f";
         userRepository.delete(id);
         System.out.println("");
    }
    /**
     * 查询
     */
    @Test
    public void query() {
        String name="杨柳";
        List<User> byName = userRepository.findByName(name);
        System.out.println("");
    }

    /**
     * 查询
     */
    @Test
    public void findOne() {
        String id="5d7c330b6930445144bf22aa";
        User  user = userRepository.findOne(id);
        System.out.println("");
    }
    /**
     * 分页查询
     */
    @Test
    public void findByPage() {
        Pageable pageable = new PageRequest(2,10);
        Page<User> all = userRepository.findAll(pageable);
        System.out.println(""+all.getContent());
    }
    @Test
    public void findAll(){
        User user = new User();
        user.setName("willow31");
        user.setRoleId(123);
        Example example = Example.of(user);
        Sort sort = new Sort(Sort.Direction.ASC,"name");
        List<User> result= userRepository.findAll(example,sort);
        System.out.println("###");
    }




}
