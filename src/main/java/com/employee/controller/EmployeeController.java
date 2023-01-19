package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class EmployeeController {

   private final EmployeeService employeeService;

   @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employees")
    public List<Employee> getAllEmployees() {
        System.out.println("test");
        return employeeService.getAllEmployees();
    }

    @PostMapping(value = "/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping(value = "/employee/{employeeID}")
    public Employee findEmployee(@PathVariable("employeeID") int employeeID) {
        return employeeService.getEmployeeById(employeeID);
    }

    @PutMapping(value = "/update-employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
      Employee emp = employeeService.getEmployeeById(employee.getId());
      emp.setEmail(employee.getEmail());
      emp.setName(employee.getName());
      emp.setPosition(employee.getPosition());
        return employeeService.saveEmployee(emp);
    }

    @DeleteMapping(value = "/delete-employee")
    public void deleteEmployee(@RequestParam("employeeId") int employeeId) {
        employeeService.deleteEmployee(employeeId);
    }


}
