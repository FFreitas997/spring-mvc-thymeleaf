package com.example.springmvcthymeleaf.service;

import com.example.springmvcthymeleaf.entity.Employee;
import com.example.springmvcthymeleaf.repository.EmployeeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
    }

    public Employee getEmployeeById(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("Could not find employee"));
    }

    public Employee saveEmployee(Employee employee) {
        if (employee == null)
            throw new NullPointerException("Employee parameter cannot be null");
        return repository.save(employee);
    }

    public Employee deleteEmployeeById(Integer id) {
        Employee employeeToDelete = repository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("Could not find employee"));
        repository.deleteById(id);
        return employeeToDelete;
    }
}
