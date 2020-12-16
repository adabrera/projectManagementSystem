package com.projects.projectManagementSystem.repository;

import com.projects.projectManagementSystem.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>
{
}
