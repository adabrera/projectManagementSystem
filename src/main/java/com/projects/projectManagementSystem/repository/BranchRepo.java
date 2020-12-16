package com.projects.projectManagementSystem.repository;

import com.projects.projectManagementSystem.domain.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepo extends JpaRepository<Branch, Long>
{
	List<Branch> findByUniqueName(String uniqueName);

}
