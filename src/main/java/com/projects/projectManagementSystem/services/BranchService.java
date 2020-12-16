package com.projects.projectManagementSystem.services;

import com.projects.projectManagementSystem.domain.Branch;

import java.util.List;

public interface BranchService
{
	public void addBranch( Branch p );

	public List<Branch> listBranches();
}
