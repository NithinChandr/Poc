package com.employee.service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public Employee getEmployeeById(int id) {

        return employeeRepository.findById(id);
    }

    //save employee in database
    public Employee saveEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    //delete employee by id
    public void deleteEmployee(int id) {
        try {
            employeeRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
