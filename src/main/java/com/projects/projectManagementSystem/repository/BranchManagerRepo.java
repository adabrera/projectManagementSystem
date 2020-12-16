package com.projects.projectManagementSystem.repository;

import com.projects.projectManagementSystem.domain.BranchManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchManagerRepo extends JpaRepository<BranchManager, Long>
{
}
