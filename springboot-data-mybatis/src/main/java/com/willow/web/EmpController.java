package com.willow.web;

import com.willow.entity.Department;
import com.willow.entity.Employee;
import com.willow.mapper.DepartmentMapper;
import com.willow.mapper.EmployeeMapper;
import com.willow.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
    private Logger logger=LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private DepartmentService departmentService;

    // 访问 ：http://localhost:8080/emp/getId/1
    @RequestMapping("/emp/getId/{id}")
    public Employee getEmpById(@PathVariable Integer id ){
       return  employeeMapper.getEmpById(id);
    }
    // 访问http://localhost:8080/emp/addEmp?lastName=yl1&gender=2&email=3343@qq.com&dId=1
    @RequestMapping("/emp/addEmp")
    public void addEmp(Employee employee){
        employeeMapper.insertEmp(employee);
    }


    //http://localhost:8080/dept/getByid/1
    @RequestMapping("/dept/getByid/{id}")
    public Department getDetpById(@PathVariable Integer id){
        System.out.println("#####getDetpById");
        Department department= departmentService.getDeptById(id);
        for (int i = 0; i <100 ; i++) {
            logger.info("#######"+department);
            if(i==50){
                int x=100/(i-50);
            }
        }
        return department;
    }


    //http://localhost:8080/dept/addDept?departmentName=1
    @RequestMapping("/dept/addDept")
    public void addDept(Department department){
        departmentMapper.insertDept(department);
    }








}
