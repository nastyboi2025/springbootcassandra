package com.java.nas.cassie.service.impl;

import com.java.nas.cassie.entity.Employee;
import com.java.nas.cassie.service.EmployeeService;
import com.java.nas.cassie.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Impl class for Employee to perform CRUD operation.
 * @author Naser Ahmed
 * @version 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository repo;

    /**
     * Default Constructor
     */
    public EmployeeServiceImpl() {
        super();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return repo.findOneById(id);
    }

    @Override
    public void updateEmployee(int id, Employee employee) {

        if (employee.getAge() != 0 && employee.getName() != null) {

            Employee employee1 = repo.findOneById(id);
            employee1.setName(employee.getName());
            employee1.setAge(employee.getAge());
            employee1.setSalary(employee.getSalary());
            repo.save(employee1);
        }
    }

    @Override
    public void deleteEmployee(int id) {
        repo.deleteOneById(id);

    }

    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

}

