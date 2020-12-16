package com.projects.projectManagementSystem.repository;

import com.projects.projectManagementSystem.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Long>
{
}
