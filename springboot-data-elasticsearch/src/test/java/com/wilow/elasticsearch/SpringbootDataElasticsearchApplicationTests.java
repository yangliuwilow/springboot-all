package com.wilow.elasticsearch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDataElasticsearchApplicationTests {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void findByAge(){
        List<Employee> list= employeeRepository.findByAge(35);
        System.out.println("####"+list.size());
    }

    @Test
    public void findByLastnameLike(){
        List<Employee> list= employeeRepository.findByLastnameLike("Smith");
        for(Employee emp:list)
        System.out.println("####"+emp.toString());
    }

    @Test
    public void saveEmp(){
        Employee employee=new Employee();
        employee.setId(4);
        employee.setAge(23);
        employee.setFirstname("yangliu");
        employee.setLastname("willow");
        employee.setInterests(new String[]{"abc","oper"});
        employee.setAbout("bei jing come on ");
        employeeRepository.save(employee);
    }
    @Test
    public void findByAgeBetween(){
        List<Employee> list= employeeRepository.findByAgeBetween(10,32);
        for(Employee emp:list)
            System.out.println("####"+emp.toString());
    }

}
