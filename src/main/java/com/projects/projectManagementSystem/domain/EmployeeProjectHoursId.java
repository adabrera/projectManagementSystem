package com.projects.projectManagementSystem.domain;

import java.io.Serializable;

public class EmployeeProjectHoursId implements Serializable
{
	private Long project;
	private Long employee;

	public Long getProject()
	{
		return project;
	}

	public void setProject( Long project )
	{
		this.project = project;
	}

	public Long getEmployee()
	{
		return employee;
	}

	public void setEmployee( Long employee )
	{
		this.employee = employee;
	}

	@Override
	public boolean equals( Object o )
	{

		if ( this == o )
			return true;
		if ( o == null || getClass() != o.getClass() )
			return false;

		EmployeeProjectHoursId that = ( EmployeeProjectHoursId ) o;

		if ( project != null ? !project.equals( that.project ) : that.project != null )
			return false;
		return employee != null ? employee.equals( that.employee ) : that.employee == null;
	}

	@Override
	public int hashCode()
	{
		int result = project != null ? project.hashCode() : 0;
		result = 31 * result + ( employee != null ? employee.hashCode() : 0 );
		return result;
	}
}
