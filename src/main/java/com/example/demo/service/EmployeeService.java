package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(int id, Employee employee) {
        validateEmployeeBody(employee);
        Employee updatedEmployee = employeeRepository.findById(id).orElse(null);
        updatedEmployee.setFirstName(employee.getFirstName());
        updatedEmployee.setLastName(employee.getLastName());
        updatedEmployee.setDob(employee.getDob());
        updatedEmployee.setDepartments(employee.getDepartments());
        updatedEmployee.setManager(employee.getManager());
        updatedEmployee.setSalary(employee.getSalary());
        return employeeRepository.save(updatedEmployee);
    }

    private void validateEmployeeBody(Employee employee) {
        if(employee.getFirstName()==null || employee.getFirstName().isEmpty())
            throw new NullPointerException("First name is being updated as null or empty");
        if(employee.getLastName()==null  || employee.getLastName().isEmpty())
            throw new NullPointerException("Last Name is being updated as null or empty");
        if(employee.getDob()==null  || employee.getDob().isEmpty())
            throw new NullPointerException("Dob is being updated as null or empty");
        if(employee.getDepartments()==null  || employee.getDepartments().isEmpty())
            throw new NullPointerException("Department is being updated as null or empty");
        if(employee.getSalary()==null)
            throw new NullPointerException("Salary is being updated as null or empty");
    }

    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }



}
