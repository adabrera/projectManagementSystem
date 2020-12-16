package com.projects.projectManagementSystem.controller;

import com.projects.projectManagementSystem.domain.Branch;
import com.projects.projectManagementSystem.domain.BranchManager;
import com.projects.projectManagementSystem.domain.Employee;
import com.projects.projectManagementSystem.repository.BranchManagerRepo;
import com.projects.projectManagementSystem.repository.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/branches/")
public class BranchController
{
	private final BranchRepo branchRepo;
	private final BranchManagerRepo managerRepo;

	@Autowired
	public BranchController( BranchRepo branchRepo, BranchManagerRepo managerRepo )
	{
		this.branchRepo = branchRepo;
		this.managerRepo = managerRepo;
	}

	@GetMapping("signup")
	public String showSignUpForm( Branch branch, Model model )
	{
		List<BranchManager> branchManagers = managerRepo.findAll();
		model.addAttribute( "branchManagerList", branchManagers );

		return "add-branch";
	}

	@GetMapping("list")
	public String showUpdateForm( Model model )
	{
		model.addAttribute( "branches", branchRepo.findAll() );
		return "branch-home";
	}

	@PostMapping("add")
	public String addBranch( Branch branch, BindingResult result, Model model )
	{
		if ( result.hasErrors() )
		{
			return "add-branch";
		}
		branch.setStartDate( new Date() );

//		Employee branchManagerEmployee = branchRepo.findById( branch.getId() ).get().getBranchManager().getEmployee();
//
//		if(branchManagerEmployee!= null && branchManagerEmployee.getBranch())


			branchRepo.save( branch );
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm( @PathVariable("id") long id, Model model )
	{
		Branch branch = branchRepo.findById( id )
				.orElseThrow( () -> new IllegalArgumentException( "Invalid Branch Id:" + id ) );
		model.addAttribute( "branch", branch );

		List<BranchManager> branchManagers = managerRepo.findAll();
		model.addAttribute( "branchManagerList", branchManagers );

		return "update-branch";
	}

	@PostMapping("update/{id}")
	public String updateBranch( @PathVariable("id") long id, Branch branch, BindingResult result,
			Model model )
	{
		if ( result.hasErrors() )
		{
			branch.setId( id );
			return "update-branch";
		}

		if ( branch.getBranchManager() != branchRepo.findById( id ).get().getBranchManager() )
			branch.setStartDate( new Date() );

		branchRepo.save( branch );
		model.addAttribute( "branches", branchRepo.findAll() );
		return "branch-home";
	}

	@GetMapping("delete/{id}")
	public String deleteBranch( @PathVariable("id") long id, Model model )
	{
		Branch branch = branchRepo.findById( id )
				.orElseThrow( () -> new IllegalArgumentException( "Invalid Branch Id:" + id ) );
		branchRepo.delete( branch );
		model.addAttribute( "branches", branchRepo.findAll() );
		return "branch-home";
	}
}

