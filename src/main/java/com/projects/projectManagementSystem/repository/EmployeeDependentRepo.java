package com.projects.projectManagementSystem.repository;

import com.projects.projectManagementSystem.domain.EmployeeDependent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDependentRepo extends JpaRepository<EmployeeDependent, Long>
{
}
