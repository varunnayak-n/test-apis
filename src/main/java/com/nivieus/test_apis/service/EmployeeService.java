package com.nivieus.test_apis.service;


import com.nivieus.test_apis.entity.Employee;
import com.nivieus.test_apis.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){

        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployee(String employeeId){

        return employeeRepository.findById(employeeId);
    }

    public Employee postEmployee(Employee employee){

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(String employeeId){

        employeeRepository.deleteById(employeeId);
    }

}
