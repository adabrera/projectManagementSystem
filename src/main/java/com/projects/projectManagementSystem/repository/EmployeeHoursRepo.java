package com.projects.projectManagementSystem.repository;

import com.projects.projectManagementSystem.domain.EmployeeProjectHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeHoursRepo extends JpaRepository<EmployeeProjectHours, Long>
{
}
