package com.projects.projectManagementSystem.controller;

import com.projects.projectManagementSystem.domain.Branch;
import com.projects.projectManagementSystem.domain.Employee;
import com.projects.projectManagementSystem.domain.Employee;
import com.projects.projectManagementSystem.repository.EmployeeRepo;
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
@RequestMapping("/employees/")
public class EmployeeController
{
	private final BranchRepo branchRepo;
	private final EmployeeRepo employeeRepo;


	@Autowired
	public EmployeeController( BranchRepo branchRepo, EmployeeRepo employeeRepo )
	{
		this.branchRepo = branchRepo;
		this.employeeRepo = employeeRepo;
	}

	@GetMapping("signup")
	public String showSignUpForm( Employee employee, Model model )
	{
		List<Branch> branchList = branchRepo.findAll();
		model.addAttribute( "branchList", branchList );

		return "add-employee";
	}

	@GetMapping("list")
	public String showUpdateForm( Model model )
	{
		model.addAttribute( "employees", employeeRepo.findAll() );
		return "employee-home";
	}

	@PostMapping("add")
	public String addEmployee( Employee employee, BindingResult result, Model model )
	{
		if ( result.hasErrors() )
		{
			return "add-employee";
		}

		employeeRepo.save( employee );
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm( @PathVariable("id") long id, Model model )
	{
		Employee employee = employeeRepo.findById( id )
				.orElseThrow( () -> new IllegalArgumentException( "Invalid Branch Id:" + id ) );
		model.addAttribute( "employee", employee );

		List<Branch> branchList = branchRepo.findAll();
		model.addAttribute( "branchList", branchList );

		return "update-employee";
	}

	@PostMapping("update/{id}")
	public String updateBranch( @PathVariable("id") long id, Employee employee, BindingResult result,
			Model model )
	{
		if ( result.hasErrors() )
		{
			employee.setId( id );
			return "update-employee";
		}

		employeeRepo.save( employee );
		model.addAttribute( "employees", employeeRepo.findAll() );
		return "employee-home";
	}

	@GetMapping("delete/{id}")
	public String deleteBranch( @PathVariable("id") long id, Model model )
	{
		Employee employee = employeeRepo.findById( id )
				.orElseThrow( () -> new IllegalArgumentException( "Invalid Employee Id:" + id ) );
		employeeRepo.delete( employee );
		model.addAttribute( "employees", employeeRepo.findAll() );
		return "employee-home";
	}
}

