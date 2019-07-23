package com.java.nas.cassie.service;

import java.util.List;

import com.java.nas.cassie.entity.Employee;

/**
 * Service interface for Employee to perform CRUD operation.
 * @author Naser Ahmed
 * @version 1.0
 */
public interface EmployeeService {
    /**
     * Used to Create the Employee Information
     * @param employee
     * @return {@link Employee}
     */
    Employee createEmployee(Employee employee);

    /**
     * Getting the Employee Information using Id
     * @param id
     * @return {@link Employee}
     */
    Employee getEmployee(int id);

    /**
     * Used to Update the Employee Information
     * @param employee
     * @return {@link Employee}
     */

    void updateEmployee(int id, Employee employee);

    /**
     * Deleting the Employee Information using Id
     * @param id
     */
    void deleteEmployee(int id);

    /**
     * Getting the All Employees information
     * @return
     */
    List<Employee> getAllEmployees();
}
