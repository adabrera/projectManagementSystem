package com.projects.projectManagementSystem.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PROJECTS")
public class Project
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "PROJECT_NAME")
	private String projectName;

	@Column(name = "PROJECT_DESCRIPTION")
	private String projectDescription;

	@OneToOne
	@JoinColumn(name = "BRANCH_MANAGER_ID")
	private BranchManager branchManager;

	@OneToMany(mappedBy = "project")
	private Set<EmployeeProjectHours> projectHours;

	public Project()
	{
	}

	public Long getId()
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}

	public String getProjectName()
	{
		return projectName;
	}

	public void setProjectName( String projectName )
	{
		this.projectName = projectName;
	}

	public BranchManager getBranchManager()
	{
		return branchManager;
	}

	public void setBranchManager( BranchManager branchManager )
	{
		this.branchManager = branchManager;
	}

	public String getProjectDescription()
	{
		return projectDescription;
	}

	public void setProjectDescription( String projectDescription )
	{
		this.projectDescription = projectDescription;
	}

	public Set<EmployeeProjectHours> getProjectHours()
	{
		return projectHours;
	}

	public void setProjectHours( Set<EmployeeProjectHours> projectHours )
	{
		this.projectHours = projectHours;
	}

	@Override
	public boolean equals( Object o )
	{
		if ( this == o )
			return true;
		if ( o == null || getClass() != o.getClass() )
			return false;

		Project project = ( Project ) o;

		if ( id != null ? !id.equals( project.id ) : project.id != null )
			return false;
		if ( projectName != null ? !projectName.equals( project.projectName ) : project.projectName != null )
			return false;
		if ( projectDescription != null ? !projectDescription.equals( project.projectDescription ) : project.projectDescription != null )
			return false;
		if ( branchManager != null ? !branchManager.equals( project.branchManager ) : project.branchManager != null )
			return false;
		return projectHours != null ? projectHours.equals( project.projectHours ) : project.projectHours == null;
	}

	@Override
	public int hashCode()
	{
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + ( projectName != null ? projectName.hashCode() : 0 );
		result = 31 * result + ( projectDescription != null ? projectDescription.hashCode() : 0 );
		result = 31 * result + ( branchManager != null ? branchManager.hashCode() : 0 );
		result = 31 * result + ( projectHours != null ? projectHours.hashCode() : 0 );
		return result;
	}
}
