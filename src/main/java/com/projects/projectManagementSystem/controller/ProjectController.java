package com.projects.projectManagementSystem.controller;

import com.projects.projectManagementSystem.domain.BranchManager;
import com.projects.projectManagementSystem.domain.Project;
import com.projects.projectManagementSystem.repository.BranchManagerRepo;
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
@RequestMapping("/projects/")
public class ProjectController
{
	private final ProjectRepo projectRepo;
	private final BranchManagerRepo managerRepo;

	public ProjectController( ProjectRepo projectRepo, BranchManagerRepo managerRepo )
	{
		this.projectRepo = projectRepo;
		this.managerRepo = managerRepo;
	}

	@GetMapping("signup")
	public String showSignUpForm( Project project, Model model )
	{
		List<BranchManager> branchManagers = managerRepo.findAll();
		model.addAttribute( "branchManagerList", branchManagers );

		return "add-project";
	}

	@GetMapping("list")
	public String showUpdateForm( Model model )
	{
		model.addAttribute( "projects", projectRepo.findAll() );
		return "project-home";
	}

	@PostMapping("add")
	public String addProject( Project project, BindingResult result, Model model )
	{
		if ( result.hasErrors() )
		{
			return "add-project";
		}
		projectRepo.save( project );
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm( @PathVariable("id") long id, Model model )
	{
		Project project = projectRepo.findById( id )
				.orElseThrow( () -> new IllegalArgumentException( "Invalid project Id:" + id ) );
		model.addAttribute( "project", project );

		List<BranchManager> branchManagers = managerRepo.findAll();
		model.addAttribute( "branchManagerList", branchManagers );

		return "update-project";
	}

	@PostMapping("update/{id}")
	public String updateproject( @PathVariable("id") long id, Project project, BindingResult result,
			Model model )
	{
		if ( result.hasErrors() )
		{
			project.setId( id );
			return "update-project";
		}

		projectRepo.save( project );
		model.addAttribute( "projects", projectRepo.findAll() );
		return "project-home";
	}

	@GetMapping("delete/{id}")
	public String deleteproject( @PathVariable("id") long id, Model model )
	{
		Project project = projectRepo.findById( id )
				.orElseThrow( () -> new IllegalArgumentException( "Invalid project Id:" + id ) );
		projectRepo.delete( project );
		model.addAttribute( "projects", projectRepo.findAll() );
		return "project-home";
	}
}

