package com.java.nas.cassie.respository;

import com.java.nas.cassie.entity.Employee;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Utility class for handling all CRUD Operations.
 * @author Naser Ahmed
 * @version 1.0
 */
@Repository
public interface EmployeeRepository extends CassandraRepository<Employee, String> {

    @Query("SELECT * FROM employee WHERE id = ?0")
    Employee findOneById(int id);

    @Query("DELETE FROM employee WHERE id = ?0")
    Employee deleteOneById(int id);
}
