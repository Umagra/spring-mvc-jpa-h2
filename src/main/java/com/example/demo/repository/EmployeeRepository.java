package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT CONCAT(COALESCE(e.first_Name,''), ' ', COALESCE(e.last_Name,'')) FROM EMPLOYEE e", nativeQuery = true)
    List<String> findAllManager();

}
