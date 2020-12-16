package com.projects.projectManagementSystem.controller;

import com.projects.projectManagementSystem.domain.Branch;
import com.projects.projectManagementSystem.domain.BranchManager;
import com.projects.projectManagementSystem.domain.Employee;
import com.projects.projectManagementSystem.repository.BranchManagerRepo;
import com.projects.projectManagementSystem.repository.BranchRepo;
import com.projects.projectManagementSystem.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/branchManagers/")
public class BranchManagerController
{
	private final BranchRepo branchRepo;
	private final BranchManagerRepo managerRepo;
	private final EmployeeRepo employeeRepo;


	@Autowired
	public BranchManagerController( BranchRepo branchRepo, BranchManagerRepo managerRepo, EmployeeRepo employeeRepo )
	{
		this.branchRepo = branchRepo;
		this.managerRepo = managerRepo;
		this.employeeRepo = employeeRepo;
	}

	@GetMapping("signup")
	public String showSignUpForm( BranchManager branchManager, Model model )
	{
		List<Employee> employeeList = employeeRepo.findAll();
		model.addAttribute( "employeeList", employeeList );

		return "add-branch-manager";
	}

	@GetMapping("list")
	public String showUpdateForm( Model model )
	{
		model.addAttribute( "branchManagers", managerRepo.findAll() );
		return "branch-manager-home";
	}

	@PostMapping("add")
	public String addBranchManager( BranchManager branchManager, BindingResult result, Model model )
	{
		if ( result.hasErrors() )
		{
			return "add-branch-manager";
		}

		managerRepo.save( branchManager );
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm( @PathVariable("id") long id, Model model )
	{
		BranchManager branchManager = managerRepo.findById( id )
				.orElseThrow( () -> new IllegalArgumentException( "Invalid Branch Id:" + id ) );
		model.addAttribute( "branchManager", branchManager );

		List<Employee> employeeList = employeeRepo.findAll();
		model.addAttribute( "employeeList", employeeList );

		return "update-branch-manager";
	}

	@PostMapping("update/{id}")
	public String updateBranch( @PathVariable("id") long id, BranchManager branchManager, BindingResult result,
			Model model )
	{
		if ( result.hasErrors() )
		{
			branchManager.setId( id );
			return "update-branch-manager";
		}

		managerRepo.save( branchManager );
		model.addAttribute( "branchManagers", managerRepo.findAll() );
		return "branch-manager-home";
	}

	@GetMapping("delete/{id}")
	public String deleteBranch( @PathVariable("id") long id, Model model )
	{
		BranchManager branchManager = managerRepo.findById( id )
				.orElseThrow( () -> new IllegalArgumentException( "Invalid Branch Id:" + id ) );
		managerRepo.delete( branchManager );
		model.addAttribute( "branchManagers", managerRepo.findAll() );
		return "branch-manager-home";
	}
}

