package com.projects.projectManagementSystem.controller;

import com.projects.projectManagementSystem.domain.BranchManager;
import com.projects.projectManagementSystem.domain.Employee;
import com.projects.projectManagementSystem.domain.EmployeeDependent;
import com.projects.projectManagementSystem.domain.EmployeeDependent;
import com.projects.projectManagementSystem.repository.BranchManagerRepo;
import com.projects.projectManagementSystem.repository.BranchRepo;
import com.projects.projectManagementSystem.repository.EmployeeDependentRepo;
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
@RequestMapping("/employeeDependents/")
public class EmployeeDependentController
{

	private final EmployeeRepo employeeRepo;
	private final EmployeeDependentRepo employeeDependentRepo;


	@Autowired
	public EmployeeDependentController( EmployeeRepo employeeRepo, EmployeeDependentRepo employeeDependentRepo )
	{
		this.employeeRepo = employeeRepo;
		this.employeeDependentRepo = employeeDependentRepo;
	}

	@GetMapping("signup")
	public String showSignUpForm( EmployeeDependent employeeDependent, Model model )
	{
		List<Employee> employeeList = employeeRepo.findAll();
		model.addAttribute( "employeeList", employeeList );

		return "add-employee-dependent";
	}

	@GetMapping("list")
	public String showUpdateForm( Model model )
	{
		model.addAttribute( "employeeDependents", employeeDependentRepo.findAll() );
		return "employee-dependent-home";
	}

	@PostMapping("add")
	public String addBranchManager( EmployeeDependent employeeDependent, BindingResult result, Model model )
	{
		if ( result.hasErrors() )
		{
			return "add-employee-dependent";
		}

		employeeDependentRepo.save( employeeDependent );
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm( @PathVariable("id") long id, Model model )
	{
		EmployeeDependent employeeDependent = employeeDependentRepo.findById( id )
				.orElseThrow( () -> new IllegalArgumentException( "Invalid Branch Id:" + id ) );
		model.addAttribute( "employeeDependent", employeeDependent );

		List<Employee> employeeList = employeeRepo.findAll();
		model.addAttribute( "employeeList", employeeList );

		return "update-employee-dependent";
	}

	@PostMapping("update/{id}")
	public String updateBranch( @PathVariable("id") long id, EmployeeDependent employeeDependent, BindingResult result,
			Model model )
	{
		if ( result.hasErrors() )
		{
			employeeDependent.setId( id );
			return "update-employee-dependent";
		}

		employeeDependentRepo.save( employeeDependent );
		model.addAttribute( "employeeDependents", employeeDependentRepo.findAll() );
		return "employee-dependent-home";
	}

	@GetMapping("delete/{id}")
	public String deleteBranch( @PathVariable("id") long id, Model model )
	{
		EmployeeDependent employeeDependent = employeeDependentRepo.findById( id )
				.orElseThrow( () -> new IllegalArgumentException( "Invalid Branch Id:" + id ) );
		employeeDependentRepo.delete( employeeDependent );
		model.addAttribute( "employeeDependents", employeeDependentRepo.findAll() );
		return "employee-dependent-home";
	}
}

