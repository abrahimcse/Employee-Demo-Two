package com.abrahim.Employee.Demo.Two.service;


import com.abrahim.Employee.Demo.Two.entity.Employee;
import com.abrahim.Employee.Demo.Two.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    public EmployeeRepository repository;

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> saveListEmployee(List<Employee> employees) {
        return repository.saveAll(employees);
    }

    public List<Employee> getEmployee() {
        return repository.findAll();
    }

    public List<Employee> getEmployeeList(String name, String designation, String gender, int[] age) {
        List<Employee> employees = repository.findAll();
        return employees.stream()
                .filter(e -> (name == null || e.getName().toLowerCase().contains(name.toLowerCase()))
                        && (designation == null || e.getDesignation().toLowerCase().contains(designation.toLowerCase()))
                        && (gender == null || e.getGender().toLowerCase().contains(gender.toLowerCase()))
                        && (age == null || (e.getAge() >= age[0] && e.getAge() <= age[1]))
                ).collect(Collectors.toList());
    }


}


