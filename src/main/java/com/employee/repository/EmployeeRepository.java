package com.employee.repository;

import com.employee.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, String> {

    List<Employee> findAll();

    Employee findById(int id);

    // @Query(value = "DELETE FROM Employee WHERE id=?",nativeQuery = true)
    void deleteById(int id);
}
