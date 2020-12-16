package com.projects.projectManagementSystem.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE_PROJECT_HOURS")
@IdClass(EmployeeProjectHoursId.class)
public class EmployeeProjectHours
{
	@Id
	@ManyToOne
	@JoinColumn(name = "PROJECT_ID", referencedColumnName = "id")
	private Project project;

	@Id
	@ManyToOne
	@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "id")
	private Employee employee;

	@Column(name = "LOGGED_DATE")
	@Temporal(TemporalType.DATE)
	private Date loggedDate;

	@Column(name = "HOURS")
	private double hours;

	public Employee getEmployee()
	{
		return employee;
	}

	public void setEmployee( Employee employee )
	{
		this.employee = employee;
	}

	public Project getProject()
	{
		return project;
	}

	public void setProject( Project project )
	{
		this.project = project;
	}

	public Date getLoggedDate()
	{
		return loggedDate;
	}

	public void setLoggedDate( Date loggedDate )
	{
		this.loggedDate = loggedDate;
	}

	public double getHours()
	{
		return hours;
	}

	public void setHours( double hours )
	{
		this.hours = hours;
	}
}
