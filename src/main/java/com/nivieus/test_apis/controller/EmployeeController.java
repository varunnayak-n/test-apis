package com.nivieus.test_apis.controller;


import com.nivieus.test_apis.entity.Employee;
import com.nivieus.test_apis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(){

        return  ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("employeeId") String employeeId){

        Optional<Employee> employee = employeeService.getEmployee(employeeId);

        return employee.isPresent()? ResponseEntity.ok(employee.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> postEmployee(@RequestBody  Employee employee){

        return  ResponseEntity.ok(employeeService.postEmployee(employee));
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<Void> postEmployee(@PathVariable("employeeId") String employeeId){

        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok().build();
    }
}
