package com.java.nas.cassie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.nas.cassie.entity.Employee;
import com.java.nas.cassie.service.EmployeeService;

import javax.validation.Valid;

/**
 * @author Naser Ahmed
 * @version 1.0
 * @since Jul 03, 2018
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController() {
        System.out.println("EmployeeController()");
    }

    @RequestMapping(value = "/employee/add", method = RequestMethod.POST)
    ResponseEntity create(@Valid @RequestBody Employee employee) {
        employeeService.createEmployee(employee);

        return new ResponseEntity("New record Added" , HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    ResponseEntity delete(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);

        return new ResponseEntity("Deleted record" , HttpStatus.GONE);
    }

    @RequestMapping(value="/employee", method = RequestMethod.GET)
    ResponseEntity findAll() {

        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity(employees, HttpStatus.FOUND);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    ResponseEntity findById(@PathVariable("id") int id) {

       Employee employee = employeeService.getEmployee(id);

        return new ResponseEntity(employee, HttpStatus.FOUND);
    }

    @RequestMapping(value = "/employee/update/{id}", method = RequestMethod.PUT)
    ResponseEntity update(@PathVariable int id, @RequestBody Employee employee) {
         employeeService.updateEmployee(id, employee);

        return new ResponseEntity("Record Updated" , HttpStatus.ACCEPTED);
    }
}
