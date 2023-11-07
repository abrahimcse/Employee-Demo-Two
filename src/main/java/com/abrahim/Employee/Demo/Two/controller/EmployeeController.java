package com.abrahim.Employee.Demo.Two.controller;


import com.abrahim.Employee.Demo.Two.entity.Employee;
import com.abrahim.Employee.Demo.Two.service.EmployeeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    public EmployeeService service;

    @PostMapping("/save")
    public Employee addEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }
    @PostMapping("/saveList")
    public List<Employee> addListEmployee(@RequestBody List<Employee> employees){
        return service.saveListEmployee(employees);
    }

    @GetMapping("/List")
    public List<Employee> showEmployee(){
        return service.getEmployee();
    }

    @GetMapping
    public List<Employee> showEmployeeList( @RequestParam (value = "name", required = false) String name,
                                            @RequestParam (value = "designation", required = false) String designation,
                                            @RequestParam (value = "gender" , required = false) String gender,
                                            @RequestParam (value = "age", required = false) int [] age


    ){
        return service.getEmployeeList(name, designation, gender, age);
    }


}
