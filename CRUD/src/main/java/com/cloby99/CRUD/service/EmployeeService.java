package com.cloby99.CRUD.service;

import com.cloby99.CRUD.entity.Employee;
import com.cloby99.CRUD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees(){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public Employee getEmployees(Integer employeeId){
        return employeeRepository.findById(employeeId).orElseThrow();
    }

    public void deleteEmployee(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public Employee updateEmployee(Employee employee) {
        employeeRepository.findById(employee.getEmployeeId()).orElseThrow();
        return employeeRepository.save(employee);
    }
}
