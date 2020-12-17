package com.projects.projectManagementSystem.controller;

import com.projects.projectManagementSystem.domain.Employee;
import com.projects.projectManagementSystem.domain.EmployeeProjectHours;
import com.projects.projectManagementSystem.domain.Project;
import com.projects.projectManagementSystem.repository.EmployeeProjectHoursRepo;
import com.projects.projectManagementSystem.repository.EmployeeRepo;
import com.projects.projectManagementSystem.repository.ProjectRepo;
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
@RequestMapping("/employeeProjectHoursList/")
public class EmployeeProjectHoursController
{
	private final EmployeeProjectHoursRepo employeeProjectHoursRepo;
	private final ProjectRepo projectRepo;
	private final EmployeeRepo employeeRepo;

	public EmployeeProjectHoursController( EmployeeProjectHoursRepo employeeProjectHoursRepo, ProjectRepo projectRepo, EmployeeRepo employeeRepo )
	{
		this.employeeProjectHoursRepo = employeeProjectHoursRepo;
		this.projectRepo = projectRepo;
		this.employeeRepo = employeeRepo;
	}

	@GetMapping("signup")
	public String showSignUpForm( Model model )
	{
		List<Project> projectList = projectRepo.findAll();
		model.addAttribute( "projectList", projectList );

		List<Employee> employeeList = employeeRepo.findAll();
		model.addAttribute( "employeeList", employeeList );

		return "add-employee-project-hours";
	}

	@GetMapping("list")
	public String showUpdateForm( Model model )
	{
		model.addAttribute( "employeeProjectHoursList", employeeProjectHoursRepo.findAll() );
		return "employee-project-hours-home";
	}

	@PostMapping("add")
	public String addBranch( EmployeeProjectHours employeeProjectHours, BindingResult result, Model model )
	{
		if ( result.hasErrors() )
		{
			return "add-employee-project-hours";
		}
		employeeProjectHours.setLoggedDate( new Date() );
		employeeProjectHoursRepo.save( employeeProjectHours );
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm( @PathVariable("id") long id, Model model )
	{
		EmployeeProjectHours employeeProjectHours = employeeProjectHoursRepo.findById( id )
				.orElseThrow( () -> new IllegalArgumentException( "Invalid EmployeeProjectHours Id:" + id ) );
		model.addAttribute( "employeeProjectHours", employeeProjectHours );

		List<Project> projectList = projectRepo.findAll();
		model.addAttribute( "projectList", projectList );

		List<Employee> employeeList = employeeRepo.findAll();
		model.addAttribute( "employeeList", employeeList );

		return "update-employee-project-hours";
	}

	@PostMapping("update/{id}")
	public String updateBranch( @PathVariable("id") Long id, EmployeeProjectHours employeeProjectHours, BindingResult result,
			Model model )
	{
		if ( result.hasErrors() )
		{
			employeeProjectHours.setId( id );
			return "update-employee-project-hours";
		}

		employeeProjectHoursRepo.save( employeeProjectHours );
		model.addAttribute( "employeeProjectHoursList", employeeProjectHoursRepo.findAll() );
		return "employee-project-hours-home";
	}

	@GetMapping("delete/{id}")
	public String deleteBranch( @PathVariable("id") long id, Model model )
	{
		EmployeeProjectHours employeeProjectHours = employeeProjectHoursRepo.findById( id )
				.orElseThrow( () -> new IllegalArgumentException( "Invalid EmployeeProjectHours Id:" + id ) );
		employeeProjectHoursRepo.delete( employeeProjectHours );
		model.addAttribute( "employeeProjectHoursList", employeeProjectHoursRepo.findAll() );
		return "employee-project-hours-home";
	}
}

